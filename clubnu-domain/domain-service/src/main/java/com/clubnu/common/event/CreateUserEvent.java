package com.clubnu.common.event;

import com.clubnu.domain.oauth.entity.OAuthProvider;
import com.clubnu.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserEvent {
    private Long userId;
    private String sub;
    private OAuthProvider provider;
}
