package com.clubnu.apis.user.api;

import com.clubnu.apis.user.dto.EditUserRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Tag(name = "User Command API", description = "User Command API")
public interface UserCommandApi {

        @Operation(summary = "사용자 정보 수정", description = "사용자 정보를 수정합니다. 회원가입 시에도 해당 API를 사용합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", examples = {
                    @ExampleObject(name = "성공", value = """
                            """),
            })),
            @ApiResponse(responseCode = "400", content = @Content(mediaType = "application/json", examples = {
                    @ExampleObject(name = "잘못된 요청", value = """
                            {
                                "timestamp": "2025-05-02T10:31:44.123+09:00",
                                "status": 400,
                                "error": "Bad Request",
                                "path": "/api/v1/user/edit"
                            }
                            """)
            })),
            @ApiResponse(responseCode = "401", content = @Content(mediaType = "application/json", examples = {
                    @ExampleObject(name = "인증 실패", value = """
                            {
                                "timestamp": "2025-05-02T10:31:44.123+09:00",
                                "status": 401,
                                "error": "Unauthorized",
                                "path": "/api/v1/user/edit"
                            }
                            """)
            })),
            @ApiResponse(responseCode = "403", content = @Content(mediaType = "application/json", examples = {
                    @ExampleObject(name = "권한 없음", value = """
                            {
                                "timestamp": "2025-05-02T10:31:44.123+09:00",
                                "status": 403,
                                "error": "Forbidden",
                                "path": "/api/v1/user/edit"
                            }
                            """)
            }))
    })
    public ResponseEntity<Void> editUser(@AuthenticationPrincipal UserDetails userDetails, @RequestBody EditUserRequest request);

}
