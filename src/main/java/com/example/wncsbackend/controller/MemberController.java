package com.example.wncsbackend.controller;

import com.example.wncsbackend.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    /**
     * 지갑 주소 리턴
     */
    @GetMapping("/member/walletaddress")
    public ResponseEntity<String> getWalletAddress(@RequestParam Long memberId) {
        return ResponseEntity.ok(memberService.getWalletAddress(memberId));
    }

    /**
     * 유저 구독
     */
    @GetMapping("/member/subscribe")
    public ResponseEntity<Boolean> isSubscribe(@RequestParam Long memberId) {
        return ResponseEntity.ok(memberService.getSubscribeMember(memberId));
    }
}
