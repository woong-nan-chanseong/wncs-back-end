package com.example.wncsbackend.repository;


import com.example.wncsbackend.domain.MemberPhoto.MemberPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberPhotoRepository extends JpaRepository<MemberPhoto, Long> {
}
