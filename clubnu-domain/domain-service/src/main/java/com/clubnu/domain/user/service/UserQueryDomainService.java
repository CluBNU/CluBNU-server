package com.clubnu.domain.user.service;

import com.clubnu.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserQueryDomainService {
    private final UserRdsQueryService userRdsQueryService;
    public Optional<User> findByEmail(String email) {
        return userRdsQueryService.findByEmail(email);
    }
    public Optional<User> findById(Long id) {
        return userRdsQueryService.findById(id);
    }
}
