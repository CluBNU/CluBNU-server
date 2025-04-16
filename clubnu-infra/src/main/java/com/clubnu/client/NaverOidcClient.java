package com.clubnu.client;

import com.clubnu.common.dto.OidcPublicKeyResponse;
import com.clubnu.config.DefaultFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "NaverOidcClient",
        url = "${oauth2.client.provider.naver.jwks-uri}",
        configuration = DefaultFeignConfig.class
)
public interface NaverOidcClient extends OidcProviderClient{
    @Override
    @GetMapping("/.well-known/jwks.json")
    OidcPublicKeyResponse getPublicKey();
}
