package com.clubnu.domain.oauth.entity;

import com.clubnu.domain.oauth.exception.OAuthErrCode;
import com.clubnu.domain.oauth.exception.exceptions.IllegalProviderException;

public enum Provider {
    KAKAO("kakao"),
    NAVER("naver"),
    GOOGLE("google");

    private final String provider;

    Provider(String provider) {
        this.provider = provider;
    }

    public String getProvider() {
        return provider;
    }
    public static Provider from(String provider) {
        for (Provider p : values()) {
            if (p.getProvider().equalsIgnoreCase(provider)) {
                return p;
            }
        }
        throw new IllegalProviderException(OAuthErrCode.INVALID_OAUTH_PROVIDER);
    }
}
