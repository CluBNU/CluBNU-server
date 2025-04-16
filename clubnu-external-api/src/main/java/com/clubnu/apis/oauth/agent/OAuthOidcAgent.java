package com.clubnu.apis.oauth.agent;

import com.clubnu.client.GoogleOidcClient;
import com.clubnu.client.KakaoOidcClient;
import com.clubnu.client.NaverOidcClient;
import com.clubnu.client.OidcProviderClient;
import com.clubnu.domain.oauth.entity.Provider;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class OAuthOidcAgent {
    private final Map<Provider, OidcProviderClient> clientMap;

    public OAuthOidcAgent(List<OidcProviderClient> clients) {
        this.clientMap = Map.of(
                Provider.KAKAO, getClient(clients, KakaoOidcClient.class),
                Provider.GOOGLE, getClient(clients, GoogleOidcClient.class),
                Provider.NAVER, getClient(clients, NaverOidcClient.class)
        );
    }

    public OidcProviderClient get(Provider provider) {
        return clientMap.get(provider);
    }

    private <T> T getClient(List<OidcProviderClient> clients, Class<T> type) {
        return clients.stream()
                .filter(type::isInstance)
                .map(type::cast)
                .findFirst()
                .orElseThrow();
    }
}
