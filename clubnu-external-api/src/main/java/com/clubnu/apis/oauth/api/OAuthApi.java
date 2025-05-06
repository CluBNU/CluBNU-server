package com.clubnu.apis.oauth.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Tag(name = "OAuth API", description = "OAuth API")
public interface OAuthApi {
    @Operation(
            summary = "OAuth 로그인 처리",
            description = """
        OAuth 로그인 후 accessToken과 refreshToken을 발급합니다. <br>
        OAuth 인증 후 accessToken은 JSON body로, refreshToken은 HttpOnly 쿠키로 내려갑니다. <br>
        Swagger에서는 refreshToken을 확인할 수 없지만, 실제 응답에는 Set-Cookie 헤더로 내려갑니다. <br>
        set-cookie: refreshToken=abc.def.ghi; HttpOnly; Path=/; Max-Age=604800;
        """)
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "로그인 성공", content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(name = "accessToken 예시", value =
                """
                    {
                      "accessToken": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
                    }
                """)
            )),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(name = "잘못된 요청 예시", value =
                """
                    {
                        "timestamp": "2025-05-02T10:31:44.123+09:00",
                        "status": 400,
                        "error": "Bad Request",
                        "path": "/login/oauth2/code/kakao"
                    }
                """)
            )),
    })

    @GetMapping("login/oauth2/code/kakao")
    public ResponseEntity<Map<String, String>> oauthLoginExample();
}
