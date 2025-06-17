package com.clubnu.domain.oauth.exception;

import com.clubnu.exception.HttpStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OAuthErrCode {
    INVALID_OAUTH_PROVIDER(HttpStatus.BAD_REQUEST, "Invalid OAuth provider"),
    INVALID_OAUTH_TOKEN(HttpStatus.BAD_REQUEST,"Invalid OAuth token"),
    INVALID_OAUTH_USER(HttpStatus.FORBIDDEN, "Invalid OAuth user"),
    INVALID_OAUTH_USER_RESPONSE(HttpStatus.BAD_REQUEST, "Invalid OAuth user response"),
    INVALID_OAUTH_USER_ID(HttpStatus.BAD_REQUEST, "Invalid OAuth user ID"),
    INVALID_OAUTH_USER_NAME(HttpStatus.BAD_REQUEST, "Invalid OAuth user name");

    private final HttpStatus status;
    private final String message;
}
