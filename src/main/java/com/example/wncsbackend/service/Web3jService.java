package com.example.wncsbackend.service;

import com.example.wncsbackend.contract.NFT;
import com.example.wncsbackend.contract.dto.NFTRequestDto.MemberNFTInfo;
import com.example.wncsbackend.domain.MemberPhoto.MemberPhoto;
import com.example.wncsbackend.repository.MemberPhotoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

@Slf4j
@RequiredArgsConstructor
@Service("web3jService")
public class Web3jService {

    private final NFT nft;
    private final MemberPhotoRepository memberPhotoRepository;

    @Transactional
    public TransactionReceipt nftCreate(MemberNFTInfo memberNFTInfo) throws Exception {
        MemberPhoto memberPhoto  = memberPhotoRepository.findById(memberNFTInfo.getMemberPhotoId()).orElseThrow();
        memberPhoto.modifyRegistrationNFT();
        memberPhoto.modifyNtfCount(memberNFTInfo.getNftCount());

        return nft.create(memberNFTInfo.getWalletAddress(), "ipfs://" + memberNFTInfo.getIpfsUrl())
                .sendAsync()
                .get();
    }

}
