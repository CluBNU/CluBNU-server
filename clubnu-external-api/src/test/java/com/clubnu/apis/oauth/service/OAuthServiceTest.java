package com.clubnu.apis.oauth.service;

import com.clubnu.apis.oauth.agent.OAuthOidcAgent;
import com.clubnu.apis.user.service.UserService;
import com.clubnu.client.OidcProviderClient;
import com.clubnu.domain.oauth.dto.OAuthMemberResponse;
import com.clubnu.domain.oauth.entity.Provider;
import com.clubnu.domain.oauth.exception.exceptions.InvalidUserException;
import com.clubnu.domain.user.entity.User;
import com.clubnu.domain.user.service.UserDomainService;
import com.clubnu.fixtures.OAuthMemberResponseFixture;
import com.clubnu.fixtures.UserFixture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.never;

@ExtendWith(MockitoExtension.class)
class OAuthServiceTest {
    @Mock
    private UserDomainService userDomainService;

    @Mock
    private UserService userService;

    @Mock
    private OAuthOidcAgent oAuthOidcAgent;

    @Mock
    private OAuthService oAuthService;

    @Mock
    private JwtTokenProvider jwtTokenProvider;

    @InjectMocks
    private OAuthService oAuthService;

    @Test
    void 로그인_성공() {
        // given
        OAuthMemberResponse kakaoUser = OAuthMemberResponseFixture.kakaoUser();
        User existing = UserFixture.user();
        when(userDomainService.findByEmail(kakaoUser.getEmail()))
                .thenReturn(Optional.of(existing));

        // when
        User result = oAuthService.login(kakaoUser);

        // then
        assertThat(result).isEqualTo(existing);
    }

    @Test
    void 로그인_회원가입이_안되어있는_사용자() {
        OAuthMemberResponse kakaoUser = OAuthMemberResponseFixture.kakaoUser();
        when(userDomainService.findByEmail(kakaoUser.getEmail()))
                .thenReturn(Optional.empty());

        assertThatThrownBy(() -> oAuthService.login(kakaoUser))
                .isInstanceOf(InvalidUserException.class);
    }

    @Test
    void 회원가입_성공() {
        // given
        OAuthMemberResponse kakaoUser = OAuthMemberResponseFixture.kakaoUser();
        User newUser = UserFixture.user();
        when(userDomainService.findByEmail(kakaoUser.getEmail()))
                .thenReturn(Optional.empty());
        when(userDomainService.save(any(User.class)))
                .thenReturn(newUser);

        // when
        User result = oAuthService.signUp(kakaoUser);

        // then
        assertThat(result).isEqualTo(newUser);
    }

    @Test
    void 회원가입_이미_가입된_사용자() {
        // given
        OAuthMemberResponse kakaoUser = OAuthMemberResponseFixture.kakaoUser();
        when(userDomainService.findByEmail(kakaoUser.getEmail()))
                .thenReturn(Optional.of(UserFixture.user()));

        // when & then
        assertThatThrownBy(() -> oAuthService.signUp(kakaoUser))
                .isInstanceOf(UserAlreadyExistsException.class);
    }

    @Test
    void authCode_로_정상_로그인_및_JWT_발급까지_완료된다() {
        // given
        String code = "dummy-code";
        OAuthToken token = new OAuthToken("access-token");
        OAuthMemberResponse userInfo = OAuthMemberResponseFixture.kakaoUser();
        User user = UserFixture.user();
        TokenResponse jwt = new TokenResponse("jwt-token");

        // mocking
        OidcProviderClient kakaoClient = mock(OidcProviderClient.class);
        when(oAuthOidcAgent.get(Provider.KAKAO)).thenReturn(kakaoClient);
        when(kakaoClient.fetchToken(code)).thenReturn(token);
        when(kakaoClient.fetchUserInfo(token)).thenReturn(userInfo);
        when(oAuthService.login(userInfo)).thenReturn(user);
        when(jwtTokenProvider.issue(user)).thenReturn(jwt);

        // when
        TokenResponse result = oAuthFacade.login(code, Provider.KAKAO); // ← provider는 외부에서 전달된다고 가정

        // then
        assertThat(result.getAccessToken()).isEqualTo("jwt-token");
        verify(oAuthOidcAgent).get(Provider.KAKAO);
        verify(kakaoClient).fetchToken(code);
        verify(kakaoClient).fetchUserInfo(token);
        verify(oAuthService).login(userInfo);
        verify(jwtTokenProvider).issue(user);
    }

}