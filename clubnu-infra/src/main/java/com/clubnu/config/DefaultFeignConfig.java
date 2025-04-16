package com.clubnu.config;

import feign.codec.Encoder;
import feign.form.FormEncoder;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultFeignConfig {
    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }

    @Bean
    Encoder formEncoder() {
        return new FormEncoder();
    }
}
