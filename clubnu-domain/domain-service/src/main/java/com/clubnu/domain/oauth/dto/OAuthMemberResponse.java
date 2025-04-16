package com.clubnu.domain.oauth.dto;

import com.clubnu.domain.oauth.entity.Provider;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public record OAuthMemberResponse(
        String email,
        String name,
        Provider provider
) {
    public static OAuthMemberResponse of (String email, String name, Provider provider){
        return OAuthMemberResponse.builder()
                .email(email)
                .name(name)
                .provider(provider)
                .build();
    }
}
