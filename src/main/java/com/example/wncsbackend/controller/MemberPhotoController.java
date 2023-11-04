package com.example.wncsbackend.controller;


import com.example.wncsbackend.domain.MemberPhoto.dto.MemberPhotoRequestDto.MemberPhotoInfo;
import com.example.wncsbackend.domain.MemberPhoto.dto.MemberPhotoResultDto.MemberPhotoRes;
import com.example.wncsbackend.service.MemberPhotoService;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
public class MemberPhotoController {

    private final MemberPhotoService memberPhotoService;


    /**
     * S3에 사진 입력
     */
    @PostMapping("/photo")
    public ResponseEntity<String> insertPhoto(@RequestPart(value = "images") List<MultipartFile> multipartFile,
                                              @RequestPart(value = "memberPhotoInfo") MemberPhotoInfo memberPhotoInfo) {
        return ResponseEntity.ok(memberPhotoService.insertPhoto(multipartFile, memberPhotoInfo));
    }

    /**
     * IPFS에 사진 저장
     */
    @PostMapping("/photo/ipfs")
    public ResponseEntity<String> insertIpfsPhoto(@RequestParam Long memberPhotoId) throws IOException {
        return ResponseEntity.ok(memberPhotoService.insertIpfs(memberPhotoId));
    }

    /**
     * 자신이 저장한 사진 모두 조회
     */
    @GetMapping("/photos")
    public ResponseEntity<List<MemberPhotoRes>> selectAllPhotos() {
        return ResponseEntity.ok(memberPhotoService.selectAllPhoto());
    }

}
