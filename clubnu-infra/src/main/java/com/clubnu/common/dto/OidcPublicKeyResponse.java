package com.clubnu.common.dto;

import java.util.List;

public record OidcPublicKeyResponse(
        List<OidcKey> keys
) {
    public record OidcKey(
            String kty,
            String kid,
            String use,
            String alg,
            String n,
            String e
    ) {}
}
