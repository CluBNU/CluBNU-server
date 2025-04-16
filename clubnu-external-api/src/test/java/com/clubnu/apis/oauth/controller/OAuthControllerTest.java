package com.clubnu.apis.oauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(OAuthController.class)

class OAuthControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OAuthLoginService oAuthLoginService;

    @MockBean
    private OAuthAdapter kakaoOAuthAdapter;
}