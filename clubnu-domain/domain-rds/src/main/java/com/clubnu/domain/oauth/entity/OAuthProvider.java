package com.clubnu.domain.oauth.entity;

import com.clubnu.domain.oauth.exception.OAuthErrCode;
import com.clubnu.domain.oauth.exception.exceptions.IllegalProviderException;

public enum OAuthProvider {
    KAKAO("kakao"),
    NAVER("naver"),
    GOOGLE("google");

    private final String provider;

    OAuthProvider(String provider) {
        this.provider = provider;
    }

    public String getProvider() {
        return provider;
    }
    public static OAuthProvider from(String provider) {
        for (OAuthProvider p : values()) {
            if (p.getProvider().equalsIgnoreCase(provider)) {
                return p;
            }
        }
        throw new IllegalProviderException(OAuthErrCode.INVALID_OAUTH_PROVIDER);
    }
}
