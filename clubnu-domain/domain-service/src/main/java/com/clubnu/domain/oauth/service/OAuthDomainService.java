package com.clubnu.domain.oauth.service;

import com.clubnu.common.event.CreateUserEvent;
import com.clubnu.domain.oauth.entity.OAuthIdentity;
import com.clubnu.domain.oauth.entity.OAuthProvider;
import com.clubnu.domain.user.entity.User;
import com.clubnu.domain.user.service.UserQueryDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OAuthDomainService {
    private final OAuthRdsService oAuthRdsService;
    private final UserQueryDomainService userQueryDomainService;

    @EventListener
    public void createOAuthIdentity(CreateUserEvent event) {
        User user = userQueryDomainService.findById(event.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        oAuthRdsService.create(
                OAuthIdentity.builder()
                        .sub(event.getSub())
                        .provider(event.getProvider())
                        .user(user)
                        .build()
        );
    }

    public Optional<OAuthIdentity> findWithUserBySubAndProvider(String sub, OAuthProvider provider) {
        return oAuthRdsService.findWithUserBySubAndProvider(sub, provider);
    }
}
