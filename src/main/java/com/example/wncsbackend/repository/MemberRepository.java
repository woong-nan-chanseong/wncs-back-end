package com.example.wncsbackend.repository;


import com.example.wncsbackend.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findMemberByWalletAddress(String walletAddress);
}
