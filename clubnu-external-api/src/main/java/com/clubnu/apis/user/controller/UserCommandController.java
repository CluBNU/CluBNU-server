package com.clubnu.apis.user.controller;

import com.clubnu.apis.user.api.UserCommandApi;
import com.clubnu.apis.user.dto.EditUserRequest;
import com.clubnu.apis.user.usecase.UserCommandUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserCommandController implements UserCommandApi {
    private final UserCommandUsecase userCommandUsecase;

    @PutMapping("/edit")
    public ResponseEntity<Void> editUser(@AuthenticationPrincipal UserDetails userDetails, @RequestBody EditUserRequest request) {
        userCommandUsecase.updateUser(Long.parseLong(userDetails.getUsername()), request);
        return ResponseEntity.ok().build();
    }
}
