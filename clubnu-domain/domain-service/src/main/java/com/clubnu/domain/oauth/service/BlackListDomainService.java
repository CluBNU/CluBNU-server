package com.clubnu.domain.oauth.service;

import com.clubnu.domain.token.service.AceessTokenBlackListRedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class BlackListDomainService {
    private final AceessTokenBlackListRedisService aceessTokenBlackListRedisService;

    public void addToBlackListToken(String token, Duration ttl){
        aceessTokenBlackListRedisService.addToBlackList(token, ttl);
    }

    public boolean isTokenInBlackList(String token){
        return aceessTokenBlackListRedisService.isBlackListed(token);
    }
}
