package com.clubnu.config.security;

import com.clubnu.domain.user.service.UserQueryDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserQueryDomainService userQueryDomainService;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        var user = userQueryDomainService.findById(Long.parseLong(userId)).orElseThrow();
        return new User(
                Long.toString(user.getUserId()), "", List.of(new SimpleGrantedAuthority(user.getUserAttributes().getRole().name()))
        );
    }
}
