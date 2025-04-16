package com.clubnu.domain.oauth.exception.exceptions;

import com.clubnu.domain.oauth.exception.OAuthErrCode;

public class InvalidUserException extends RuntimeException {
    private OAuthErrCode oAuthErrCode;

    public InvalidUserException(OAuthErrCode oAuthErrCode) {
        super(oAuthErrCode.getMessage());
        this.oAuthErrCode = oAuthErrCode;
    }

    public OAuthErrCode getOAuthErrCode() {
        return oAuthErrCode;
    }

    public String getErrMessage() {
        return oAuthErrCode.getMessage();
    }
}
