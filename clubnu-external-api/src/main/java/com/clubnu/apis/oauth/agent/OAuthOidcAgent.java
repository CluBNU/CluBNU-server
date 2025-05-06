//package com.clubnu.apis.oauth.agent;
//
//import com.clubnu.oauth.client.GoogleOidcClient;
//import com.clubnu.oauth.client.KakaoOidcClient;
//import com.clubnu.oauth.client.NaverOidcClient;
//import com.clubnu.oauth.client.OidcProviderClient;
//import com.clubnu.domain.oauth.entity.OAuthProvider;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.Map;
//
//@Component
//public class OAuthOidcAgent {
//    private final Map<OAuthProvider, OidcProviderClient> clientMap;
//
//    public OAuthOidcAgent(List<OidcProviderClient> clients) {
//        this.clientMap = Map.of(
//                OAuthProvider.KAKAO, getClient(clients, KakaoOidcClient.class),
//                OAuthProvider.GOOGLE, getClient(clients, GoogleOidcClient.class),
//                OAuthProvider.NAVER, getClient(clients, NaverOidcClient.class)
//        );
//    }
//
//    public OidcProviderClient get(OAuthProvider OAuthProvider) {
//        return clientMap.get(OAuthProvider);
//    }
//
//    private <T> T getClient(List<OidcProviderClient> clients, Class<T> type) {
//        return clients.stream()
//                .filter(type::isInstance)
//                .map(type::cast)
//                .findFirst()
//                .orElseThrow();
//    }
//}
