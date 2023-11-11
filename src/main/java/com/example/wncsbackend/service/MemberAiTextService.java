package com.example.wncsbackend.service;


import com.example.wncsbackend.domain.Member;
import com.example.wncsbackend.domain.MemberAiText.MemberAiText;
import com.example.wncsbackend.domain.MemberAiText.dto.MemberAiTextRequestDto.MemberAiTextInfo;
import com.example.wncsbackend.domain.MemberPhoto.MemberPhoto;
import com.example.wncsbackend.repository.MemberAiTextRepository;
import com.example.wncsbackend.repository.MemberPhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberAiTextService {

    private final MemberAiTextRepository memberAiTextRepository;
    private final MemberPhotoRepository memberPhotoRepository;

    public String insertAiText(MemberAiTextInfo memberAiTextInfo) {
        MemberPhoto memberPhoto = memberPhotoRepository.findById(memberAiTextInfo.getMemberPhotoId()).orElseThrow();
        MemberAiText memberAiText = new MemberAiText(memberAiTextInfo.getSeed(), memberAiTextInfo.getPrompt(),
                memberAiTextInfo.getLora(), memberPhoto);
        memberAiTextRepository.save(memberAiText);
        return "Ai 텍스트 저장 완료";
    }
}
