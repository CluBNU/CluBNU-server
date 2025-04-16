package com.clubnu.client;

import com.clubnu.common.dto.OidcPublicKeyResponse;

public interface OidcProviderClient {
    OidcPublicKeyResponse getPublicKey();
}
