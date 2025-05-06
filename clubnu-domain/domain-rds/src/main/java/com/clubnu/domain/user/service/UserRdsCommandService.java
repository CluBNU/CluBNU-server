package com.clubnu.domain.user.service;

import com.clubnu.domain.user.entity.User;
import com.clubnu.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserRdsCommandService {
    private final UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public void updateUser(User user){
        userRepository.save(user);
    }

    public void deleteUser(User user){
        user.delete();
    }
}
