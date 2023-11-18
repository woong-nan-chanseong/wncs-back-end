package com.example.wncsbackend.domain.MemberPhoto.dto;

import com.example.wncsbackend.domain.MemberAiText.MemberAiText;
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
        private int nftCount;
        private String lora;
        private String prompt;
        private String seed;

        public MemberPhotoRes(Long id, String name, String description, String imgUrl, boolean registrationNFT, int nftCount,
                              MemberAiText memberAiText) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.imgUrl = imgUrl;
            this.registrationNFT = registrationNFT;
            this.nftCount = nftCount;
            this.lora = memberAiText.getLora();
            this.prompt = memberAiText.getPrompt();
            this.seed = memberAiText.getSeed();
        }
    }
}
