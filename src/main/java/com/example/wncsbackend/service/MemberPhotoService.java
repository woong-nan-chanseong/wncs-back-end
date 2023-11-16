package com.example.wncsbackend.service;

import com.example.wncsbackend.domain.Member;
import com.example.wncsbackend.domain.MemberPhoto.MemberPhoto;
import com.example.wncsbackend.domain.MemberPhoto.dto.MemberPhotoRequestDto.MemberPhotoBase64;
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
    private final Base64DecodeService base64DecodeService;

    public String insertBase64Photo(MemberPhotoBase64 memberPhotoBase64) throws IOException {
        MultipartFile multipartFile = base64DecodeService.decodeBase64ToImage(memberPhotoBase64.getBase64());
        S3Result s3Result = s3Service.uploadFile(multipartFile);
        return  s3Result.getImgUrl();
    }

    public String insertMemberPhotoInfo(MemberPhotoInfo memberPhotoInfo) throws IOException {
        Member member = memberRepository.findById(memberPhotoInfo.getMemberId()).orElseThrow();
        MemberPhoto memberPhoto = new MemberPhoto(memberPhotoInfo.getName(), memberPhotoInfo.getDescription(), memberPhotoInfo.getImgUrl(), member);
        memberPhotoRepository.save(memberPhoto);
        return "유저 사진 정보 저장 완료";
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
                .map(mp -> new MemberPhotoRes(mp.getId(), mp.getName(), mp.getDescription(), mp.getImageUrl(), mp.isRegistrationNFT(), mp.getNftCount()))
                .collect(Collectors.toList());
    }
}
