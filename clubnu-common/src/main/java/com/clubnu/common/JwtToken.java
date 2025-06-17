package com.clubnu.common;

import lombok.Builder;

@Builder
public record JwtToken(
        String accessToken,
        String refreshToken
) {
}
