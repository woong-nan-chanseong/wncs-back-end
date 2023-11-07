package com.example.wncsbackend.service;


import com.example.wncsbackend.domain.Member;
import com.example.wncsbackend.domain.MemberAiText.MemberAiText;
import com.example.wncsbackend.domain.MemberAiText.dto.MemberAiTextRequestDto.MemberAiTextInfo;
import com.example.wncsbackend.repository.MemberAiTextRepository;
import com.example.wncsbackend.repository.MemberRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberAiTextService {

    private final MemberAiTextRepository memberAiTextRepository;
    private final MemberRepository memberRepository;

    public String insertAiText(MemberAiTextInfo memberAiTextInfo) {
        Member member = memberRepository.findById(memberAiTextInfo.getMemberId()).orElseThrow();
        MemberAiText memberAiText = new MemberAiText(memberAiTextInfo.getSeed(), memberAiTextInfo.getPrompt(),
                memberAiTextInfo.getLora(), member);
        memberAiTextRepository.save(memberAiText);
        return "Ai 텍스트 저장 완료";
    }
}
