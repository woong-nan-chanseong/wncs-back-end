package com.example.wncsbackend.domain.MemberPhoto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MemberPhotoResultDto {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberPhotoRes {
        private Long id;
        private String name;
        private String description;
        private String imgUrl;
        private boolean registrationNFT;
    }
}
