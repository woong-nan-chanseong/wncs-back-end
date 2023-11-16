package com.example.wncsbackend.controller;

import com.example.wncsbackend.contract.dto.NFTRequestDto.MemberNFTInfo;
import com.example.wncsbackend.service.Web3jService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.web3j.protocol.core.methods.response.TransactionReceipt;

@RequiredArgsConstructor
@RestController
public class Web3jController {
    private final Web3jService web3jService;

    @PostMapping("/create")
    public TransactionReceipt nftCreate(@RequestBody MemberNFTInfo memberNFTInfo) throws Exception {
        return web3jService.nftCreate(memberNFTInfo);
    }

}
