//package com.clubnu.oauth.client;
//
//import com.clubnu.common.dto.OidcPublicKeyResponse;
//import com.clubnu.config.DefaultFeignConfig;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@FeignClient(
//        name = "GoogleOidcClient",
//        url = "${oauth2.client.provider.google.jwks-uri}",
//        configuration = DefaultFeignConfig.class
//)
//public interface GoogleOidcClient extends OidcProviderClient{
//    @Override
//    @GetMapping("/.well-known/jwks.json")
//    OidcPublicKeyResponse getPublicKey();
//}
