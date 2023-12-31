package com.example.wncsbackend.service;


import com.example.wncsbackend.domain.Member;
import com.example.wncsbackend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public String insertMember(String walletAddress) {
        Member member = new Member(walletAddress);
        memberRepository.save(member);
        return "유저 등록 완료";
    }

    @Transactional
    public String subscribeMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow();
        member.setSubscribe();
        return "구독 완료";
    }

    public String getWalletAddress(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow();
        return member.getWalletAddress();
    }

    public boolean getSubscribeMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow();
        return member.isSubscribe();
    }
}
