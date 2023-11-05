package com.example.wncsbackend.controller;

import com.example.wncsbackend.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;


    /**
     * 지갑 주소 저장
     */
    @PostMapping("/member")
    public ResponseEntity<String> insertMember(@RequestParam String walletAddress) {
        return ResponseEntity.ok(memberService.insertMember(walletAddress));
    }

    /**
     * 구독하기
     */
    @PostMapping("/member/subscribe")
    public ResponseEntity<String> subscribeMember(@RequestParam Long memberId) {
        return ResponseEntity.ok(memberService.subscribeMember(memberId));
    }
}
