package com.example.wncsbackend.service;


import com.example.wncsbackend.domain.MemberAiText;
import com.example.wncsbackend.repository.MemberAiTextRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberAiTextService {

    private final MemberAiTextRepository memberAiTextRepository;

    public String insertAiText(String aiText){
        MemberAiText memberAiText = new MemberAiText(aiText);
        memberAiTextRepository.save(memberAiText);
        return "Ai 텍스트 저장 완료";
    }
}
