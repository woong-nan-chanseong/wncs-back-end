package com.example.wncsbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class WncsBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(WncsBackendApplication.class, args);
    }

}
