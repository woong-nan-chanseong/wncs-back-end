package com.example.wncsbackend.service;


import com.example.wncsbackend.domain.Member;
import com.example.wncsbackend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public String insertMember(String walletAddress) {
        Member member = new Member(walletAddress);
        memberRepository.save(member);
        return "유저 등록 완료";
    }

    public String subscribeMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow();
        member.setSubscribe();;
        return "구독 완료";
    }
}
