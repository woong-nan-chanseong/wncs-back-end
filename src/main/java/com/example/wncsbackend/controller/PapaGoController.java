package com.example.wncsbackend.controller;

import com.example.wncsbackend.service.PapaGoService;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PapaGoController {

    private final PapaGoService papaGoService;

    @GetMapping("/papago")
    public ResponseEntity<String> translateText(@RequestParam String text) throws IOException {
        return ResponseEntity.ok(papaGoService.translateKorea(text));
    }
}
