package com.clubnu.apis.oauth.controller;

import com.clubnu.apis.oauth.api.OAuthApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class OAuthController implements OAuthApi {
    @GetMapping("/login/oauth2/code/kakao")
    public ResponseEntity<Map<String, String>> oauthLoginExample() {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.SET_COOKIE, "refreshToken=abc.def.ghi; HttpOnly; Path=/; Max-Age=604800;");
        return ResponseEntity.ok()
                .headers(headers)
                .body(Map.of("accessToken", "eyJhb..."));
    }
}
