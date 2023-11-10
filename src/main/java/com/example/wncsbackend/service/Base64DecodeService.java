package com.example.wncsbackend.service;

import com.amazonaws.util.IOUtils;
import com.example.wncsbackend.global.s3.S3Service;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;
import javax.imageio.ImageIO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class Base64DecodeService {

    public MultipartFile decodeBase64ToImage(String base64String) throws IOException {
        // Base64 문자열에서 데이터 부분만 추출합니다 (헤더 제외).
        String imageDataBytes = base64String.substring(base64String.indexOf(",") + 1);

        // Base64 문자열을 바이트 배열로 디코딩합니다.
        byte[] imageBytes = Base64.getDecoder().decode(imageDataBytes);

        // ByteArrayInputStream을 통해 바이트 배열을 읽어 BufferedImage 객체를 생성합니다.
        BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageBytes));

        return S3Service.convertBufferedImageToMultipartFile(image);
    }

}
