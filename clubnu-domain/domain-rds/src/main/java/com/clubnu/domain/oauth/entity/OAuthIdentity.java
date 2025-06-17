package com.clubnu.domain.oauth.entity;

import com.clubnu.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder(toBuilder = true)
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@AllArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class OAuthIdentity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oauthIdentityId;

    @Column(name = "sub", nullable = false)
    private String sub;

    @Column(name = "oauth_provider", nullable = false)
    private OAuthProvider provider;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public static OAuthIdentity of(String sub, OAuthProvider provider, User user) {
        return OAuthIdentity.builder()
                .sub(sub)
                .provider(provider)
                .user(user)
                .build();
    }
}
