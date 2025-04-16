package com.clubnu.domain.oauth.exception.exceptions;

import com.clubnu.domain.oauth.exception.OAuthErrCode;

public class IllegalProviderException extends RuntimeException {
    private final OAuthErrCode oAuthErrCode;

    public IllegalProviderException(OAuthErrCode oAuthErrCode) {
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
