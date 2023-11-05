package com.example.wncsbackend.service;

import com.example.wncsbackend.domain.Member;
import com.example.wncsbackend.domain.MemberPhoto.MemberPhoto;
import com.example.wncsbackend.domain.MemberPhoto.dto.MemberPhotoRequestDto.MemberPhotoInfo;
import com.example.wncsbackend.domain.MemberPhoto.dto.MemberPhotoResultDto.MemberPhotoRes;
import com.example.wncsbackend.global.s3.S3Service;
import com.example.wncsbackend.global.s3.dto.S3Result;
import com.example.wncsbackend.repository.MemberPhotoRepository;
import com.example.wncsbackend.repository.MemberRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class MemberPhotoService {

    @Value("${pinata.JWT}")
    private String PINATA_JWT;

    private final MemberRepository memberRepository;
    private final MemberPhotoRepository memberPhotoRepository;
    private final S3Service s3Service;

    public String insertPhoto(List<MultipartFile> multipartFiles, MemberPhotoInfo memberPhotoInfo) {
        List<S3Result> s3Results = s3Service.uploadFile(multipartFiles);
        Member member = memberRepository.findById(memberPhotoInfo.getMemberId()).orElseThrow();
        MemberPhoto memberPhoto = new MemberPhoto(memberPhotoInfo.getName(), memberPhotoInfo.getDescription(), s3Results.get(0).getImgUrl(), member);
        memberPhotoRepository.save(memberPhoto);
        return memberPhoto.getImageUrl();
    }

    public String insertIpfs(Long memberPhotoId) throws IOException {
        MemberPhoto memberPhoto = memberPhotoRepository.findById(memberPhotoId).orElseThrow();

        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"pinataContent\":{\"name\": \"" +memberPhoto.getName() + "\""
                   + ",\"description\":\"" + memberPhoto.getDescription() + "\",\"image\":\"" + memberPhoto.getImageUrl() + "\"}}");

        Request request = new Request.Builder()
                .url("https://api.pinata.cloud/pinning/pinJSONToIPFS")
                .post(body)
                .addHeader("Authorization", PINATA_JWT)
                .addHeader("accept", "application/json")
                .addHeader("content-type", "application/json")
                .build();

        ResponseBody responsebody = client.newCall(request).execute().body();
        ObjectMapper mapper = new ObjectMapper();
        assert responsebody != null;
        JsonNode jsonNode = mapper.readTree(responsebody.byteStream());
        return jsonNode.get("IpfsHash").asText();
    }

    public List<MemberPhotoRes> selectAllPhoto(){
        List<MemberPhoto> memberPhotos = memberPhotoRepository.findAll();

        return memberPhotos.stream()
                .map(mp -> new MemberPhotoRes(mp.getId(), mp.getName(), mp.getDescription(), mp.getImageUrl(), mp.isRegistrationNFT()))
                .collect(Collectors.toList());
    }
}
