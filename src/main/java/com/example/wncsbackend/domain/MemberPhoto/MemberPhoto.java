package com.example.wncsbackend.domain.MemberPhoto;

import com.example.wncsbackend.domain.Member;
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
import org.springframework.transaction.annotation.Transactional;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class MemberPhoto extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String imageUrl;

    private boolean registrationNFT;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    public MemberPhoto(String name, String description, String imageUrl, Member member) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.member = member;
    }

    @Transactional
    public void modifyRegistrationNFT(){
        this.registrationNFT = true;
    }

}
