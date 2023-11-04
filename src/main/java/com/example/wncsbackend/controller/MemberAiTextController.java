package com.example.wncsbackend.controller;


import com.example.wncsbackend.service.MemberAiTextService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberAiTextController {

    private final MemberAiTextService memberAiTextService;

    @PostMapping("aitext")
    public ResponseEntity<String> insertAiText(@RequestParam String aiText){
        return ResponseEntity.ok(memberAiTextService.insertAiText(aiText));
    }

}
