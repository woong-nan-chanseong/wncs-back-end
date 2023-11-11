package com.example.wncsbackend.domain.MemberAiText.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MemberAiTextRequestDto {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberAiTextInfo {
        private String seed;
        private String prompt;
        private String lora;
        private Long memberPhotoId;
    }
}
