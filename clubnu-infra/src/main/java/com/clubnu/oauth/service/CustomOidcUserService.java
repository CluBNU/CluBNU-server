package com.clubnu.oauth.service;

import com.clubnu.domain.oauth.entity.OAuthProvider;
import com.clubnu.domain.oauth.service.OAuthDomainService;
import com.clubnu.domain.user.entity.User;
import com.clubnu.domain.user.service.UserCommandDomainService;
import com.clubnu.domain.user.service.UserQueryDomainService;
import com.clubnu.oauth.CustomOidcUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CustomOidcUserService extends OidcUserService {

    private final UserCommandDomainService userCommandDomainService; // 우리 유저 서비스 (UserRepository 기반)
    private final UserQueryDomainService userQueryDomainService; // 우리 유저 서비스 (UserRepository 기반)
    private final OAuthDomainService oAuthDomainService; // OAuth 서비스 (OAuthIdentityRepository 기반)

    @Override
    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
        OidcUser oidcUser = super.loadUser(userRequest);

        OAuthProvider provider = OAuthProvider.from(userRequest.getClientRegistration().getRegistrationId());
        String sub = oidcUser.getSubject();

        // 필요 시 분기
        switch (provider) {
            case KAKAO -> {

            }
            case NAVER -> {

            }
            case GOOGLE -> {

            }
        }

        // 유저 가입 유무 체크
        if (oAuthDomainService.findWithUserBySubAndProvider(sub, provider).isEmpty()){
            // 빈 사용자 생성
            userCommandDomainService.createUser(sub, provider);
        }

        return new CustomOidcUser(oidcUser, provider);
    }
}
