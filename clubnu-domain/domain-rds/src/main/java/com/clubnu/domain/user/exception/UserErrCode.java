package com.clubnu.domain.user.exception;

import com.clubnu.exception.HttpStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserErrCode {
    USER_NOT_FOUND(HttpStatus.BAD_REQUEST, "User not found"),
    USER_ALREADY_EXISTS(HttpStatus.CONFLICT, "User already exists"),
    INVALID_USER_ID(HttpStatus.BAD_REQUEST, "Invalid user ID"),
    INVALID_USER_EMAIL(HttpStatus.BAD_REQUEST, "Invalid user email"),
    INVALID_USER_NAME(HttpStatus.BAD_REQUEST, "Invalid user name"),
    INVALID_USER_PASSWORD(HttpStatus.BAD_REQUEST, "Invalid user password"),
    INVALID_USER_ROLE(HttpStatus.BAD_REQUEST, "Invalid user role"),
    DOESNT_MATCH_USER(HttpStatus.FORBIDDEN, "Doesn't match user");

    private final HttpStatus status;
    private final String message;
}
