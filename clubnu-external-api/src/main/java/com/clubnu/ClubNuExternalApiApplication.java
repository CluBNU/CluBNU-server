package com.clubnu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClubNuExternalApiApplication {
    public static void main(String[] args) {
        System.setProperty("spring.config.location", "classpath:/domain-property/,classpath:/");
        SpringApplication.run(ClubNuExternalApiApplication.class, args);
    }
}