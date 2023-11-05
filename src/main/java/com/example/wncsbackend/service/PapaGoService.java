package com.example.wncsbackend.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Value;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PapaGoService {

    @Value("${naver.X_Naver_Client_id}")
    private String naverClientid;

    @Value("${naver.X_Naver_Client_Secret}")
    private String naverSecretid;

    public String translateKorea(String text) throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType,
                "{\"source\":\"ko\",\"target\":\"en\",\"text\":\""+text+" \"}");


        Request request = new Request.Builder()
                .url("https://openapi.naver.com/v1/papago/n2mt")
                .post(body)
                .addHeader("accept", "/*")
                .addHeader("content-type", "application/json")
                .addHeader("X-Naver-Client-id", naverClientid)
                .addHeader("X-Naver-Client-Secret", naverSecretid)
                .build();

        ResponseBody responsebody = client.newCall(request).execute().body();
        ObjectMapper mapper = new ObjectMapper();
        assert responsebody != null;
        JsonNode jsonNode = mapper.readTree(responsebody.byteStream());
        return jsonNode.get("message").get("result").get("translatedText").asText();
    }
}
