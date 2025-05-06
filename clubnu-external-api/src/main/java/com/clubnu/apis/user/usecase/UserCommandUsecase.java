package com.clubnu.apis.user.usecase;

import com.clubnu.apis.user.dto.EditUserRequest;
import com.clubnu.apis.user.service.UserCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserCommandUsecase {
    private final UserCommandService userCommandService;

    public void updateUser(Long userId, EditUserRequest request) {
        userCommandService.updateUser(userId, request);
    }
}
