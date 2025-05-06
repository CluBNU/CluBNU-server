package com.clubnu.domain.user.service;

import com.clubnu.domain.user.entity.User;
import com.clubnu.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserRdsQueryService {
    private final UserRepository userRepository;

    public Optional<User> findByEmail(String email) {
        return userRepository.findByUserIdentity_EmailAndIsDeletedFalse(email);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findByUserIdAndIsDeletedFalse(id);
    }

}
