package com.clubnu.domain.oauth.service;

import com.clubnu.domain.oauth.entity.OAuthIdentity;
import com.clubnu.domain.oauth.entity.OAuthProvider;
import com.clubnu.domain.oauth.repository.OAuthIdentityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OAuthRdsService {
    private final OAuthIdentityRepository oAuthIdentityRepository;

    @Transactional(readOnly = true)
    public Optional<OAuthIdentity> findWithUserBySubAndProvider(String sub, OAuthProvider provider) {
        return oAuthIdentityRepository.findWithUserBySubAndProvider(sub, provider);
    }

    @Transactional
    public void create(OAuthIdentity oAuthIdentity) {
        oAuthIdentityRepository.save(oAuthIdentity);
    }
}
