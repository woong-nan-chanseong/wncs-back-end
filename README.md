## WNCS

저희 프로젝트의 핵심 개발 목표는 ‘새로운 기술을 낮은 접근성으로 경험할 수 있는 서비스 제공’입니다. 
두 가지의 기술, ‘블록체인’과 ‘생성형 AI’를 새로운 기술로서 제공하고, 기존에 제공되고 있는 서비스들의 단점인 좋지 않은 접근성에 초점을 맞춰 개선된 서비스를 제공하는 것이 최종 목표입니다.
<br>

## 핵심 기능 소개
### 1. Stable diffusion을 사용하여 이미지 생성
<p align="center">
  <img src="https://github.com/woong-nan-chanseong/wncs-back-end/assets/49395754/de5099c7-ab04-4424-8860-eb2a81aded5f" alt="image 1" width="400"/>
  <img src="https://github.com/woong-nan-chanseong/wncs-back-end/assets/49395754/757fa81a-9c0f-4537-a2a0-c28d2820d59b" alt="image 2" width="340"/>
</p>
 - Stable diffusion을 선정한 이유는 GAN방식 대비 고화질의 사진을 생성할 수 있고 오픈소스를 통해 모델이 공개되어 있어 직접 대용량의 모델을 학습시키지 않아도 된다는 장점이 있습니다.
 -  프롬프트와 시드와 LoRA만으로 이미지를 생성할 수 있도록 방향을 잡았습니다.
 -  프롬프트 시드와 LORA를 입력할 때, 한국어로 입력해도 영어로 입력될 수 있게 PAPAGO OpenAPI를 사용했습니다.
<br>


### 2. 이더리움을 사용하여 NFT 등록
<p align="center">
    <img src="https://github.com/woong-nan-chanseong/wncs-back-end/assets/49395754/4f2b2de0-f7da-467b-a836-c1f42f7d1c7f" alt="image 1" width="350"/>
    <img src="https://github.com/woong-nan-chanseong/wncs-back-end/assets/49395754/56abff53-3396-4ff7-801c-00ab963324e8" alt="image 2" width="380"/>
 </p>
 
  -NFT 등록을 하기 위해서는 Web3J와 스마트 컨트랙트를 개발하기 위한 Solidity, IPFS 파일을 등록하기 위한 Pinata를 사용했습니다.
<br>

### 3. 구독 서비스 구현
<p align="center">
   <img src="https://github.com/woong-nan-chanseong/wncs-back-end/assets/49395754/1e10777a-5218-4403-8b92-9348f1470950)"  alt="image 1" width="400"/>
</p>

 - NFT에 등록할 때 드는 가스비와 생산형 AI를 통해 사진을 만들 때 드는 비용을 구독제를 통해 관리하고 있습니다.
 - 결제시스템 구현은 PortOne 사의 API를 이용하였습니다.
 - PG사와의 직접 소통을 하지 않아도 대행해주기 때문에 간편하게 결제 시스템을 구축할 수 있습니다.
<br>


## 😺 팀원 소개
|                                        AI                                         |                                        FRONTEND                                         |               BACKEND                |
|:--------------------------------------------------------------------------------------:|:--------------------------------------------------------------------------------------:|:------------------------------------:|
| <img src="https://avatars.githubusercontent.com/u/118545892?v=4" width=320px alt="김성민"/> | <img src="https://avatars.githubusercontent.com/u/140628455?v=4" width=320px alt="김찬영"/>| <img src="https://avatars.githubusercontent.com/u/49395754?v=4" width=320px alt="박세웅"/> |
|                          [김성민](https://github.com/SeongMon)                          |       [김찬영](https://github.com/flashcy)                                         |   [박세웅](https://github.com/SeWooooong)              |

<br>

## 🖥️ 운영 아키텍처

![image](https://github.com/woong-nan-chanseong/wncs-back-end/assets/49395754/137b0c65-00ba-40cb-b83e-bd5efbcaed21)
<br>

## ⌨️ CI/CD 파이프라인
![image](https://github.com/Help-M-Ssaem/back-end/assets/49395754/7abb557d-355e-4033-a230-9caa53b9ad64)
