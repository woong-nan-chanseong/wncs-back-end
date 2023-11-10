package com.example.wncsbackend.domain.MemberPhoto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MemberPhotoRequestDto {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberPhotoInfo {
        private String base64;
        private String name;
        private String description;
        private Long memberId;
    }
}
