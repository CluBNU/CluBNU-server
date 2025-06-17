package com.clubnu.domain.oauth.dto;

import com.clubnu.domain.oauth.entity.OAuthProvider;
import lombok.Builder;

@Builder
public record OAuthMemberResponse(
        String email,
        String name,
        OAuthProvider provider
) {
    public static OAuthMemberResponse of (String email, String name, OAuthProvider OAuthProvider){
        return OAuthMemberResponse.builder()
                .email(email)
                .name(name)
                .provider(OAuthProvider)
                .build();
    }
}
