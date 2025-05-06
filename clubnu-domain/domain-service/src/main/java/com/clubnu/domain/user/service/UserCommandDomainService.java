package com.clubnu.domain.user.service;

import com.clubnu.common.event.CreateUserEvent;
import com.clubnu.domain.oauth.entity.OAuthProvider;
import com.clubnu.domain.oauth.service.OAuthDomainService;
import com.clubnu.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserCommandDomainService {
    private final UserRdsCommandService userRdsCommandService;
    private final UserQueryDomainService userQueryDomainService;
    private final OAuthDomainService oAuthDomainService;
    private final ApplicationEventPublisher publisher;

    public void createUser(String sub, OAuthProvider provider) {
        // sub와 provider를 이용하여 유저가 존재하는지 확인
        if (oAuthDomainService.findWithUserBySubAndProvider(sub, provider).isPresent()) {
            throw new IllegalStateException("User already exists");
        }
        // 유저 정보 생성
        User user = User.of();
        User target = userRdsCommandService.createUser(user);

        publisher.publishEvent(CreateUserEvent.builder()
                .userId(target.getUserId())
                .sub(sub)
                .provider(provider)
                .build());
    }

    public void updateUser(User user) {
        userRdsCommandService.updateUser(user);
    }
}
