package com.example.wncsbackend.controller;


import com.example.wncsbackend.domain.MemberAiText.dto.MemberAiTextRequestDto.MemberAiTextInfo;
import com.example.wncsbackend.service.MemberAiTextService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberAiTextController {

    private final MemberAiTextService memberAiTextService;

    @PostMapping("aiText")
    public ResponseEntity<String> insertAiText(@RequestBody MemberAiTextInfo memberAiTextInfo){
        return ResponseEntity.ok(memberAiTextService.insertAiText(memberAiTextInfo));
    }

}
