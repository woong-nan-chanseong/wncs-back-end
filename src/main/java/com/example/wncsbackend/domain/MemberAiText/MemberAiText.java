package com.example.wncsbackend.domain.MemberAiText;

import com.example.wncsbackend.domain.MemberPhoto.MemberPhoto;
import com.example.wncsbackend.global.common.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class MemberAiText extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seed;
    private String prompt;
    private String lora;

    @ManyToOne(fetch = FetchType.LAZY)
    private MemberPhoto memberPhoto;

    public MemberAiText(String seed, String prompt, String lora, MemberPhoto memberPhoto) {
        this.seed = seed;
        this.prompt = prompt;
        this.lora = lora;
        this.memberPhoto = memberPhoto;
    }

}
