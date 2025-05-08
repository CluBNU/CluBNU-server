package com.clubnu.config.security;

import com.clubnu.common.JwtToken;
import com.clubnu.common.jwt.JwtProvider;
import com.clubnu.domain.oauth.entity.OAuthIdentity;
import com.clubnu.domain.oauth.entity.OAuthProvider;
import com.clubnu.domain.oauth.service.OAuthDomainService;
import com.clubnu.domain.user.entity.User;
import com.clubnu.domain.user.service.UserCommandDomainService;
import com.clubnu.domain.user.service.UserQueryDomainService;
import com.clubnu.oauth.CustomOidcUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class Oauth2AuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final JwtProvider jwtProvider;
    private final OAuthDomainService oAuthDomainService;
    @Value("${url.redirect.base}")
    private String REDIRECT_URL;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        OidcUser oidcUser = (OidcUser) authentication.getPrincipal();
        String sub = oidcUser.getSubject();
        OAuthProvider provider = ((CustomOidcUser) oidcUser).getProvider();

        Optional<OAuthIdentity> oAuthIdentity = oAuthDomainService.findWithUserBySubAndProvider(sub,provider);
        Optional<User> user;

        if(oAuthIdentity.isPresent()){
            user = Optional.ofNullable(oAuthIdentity.get().getUser());
            if(user.isEmpty()) {
                throw new NoSuchElementException("사용자를 찾을 수 없음");
            }
        } else {
            throw new NoSuchElementException("사용자를 찾을 수 없음");
        }

        JwtToken token = jwtProvider.provideTokens(
                user.get().getUserId(),
                user.get().getUserAttributes().getRole(),
                user.get().getUserAttributes().getNationality(),
                user.get().getUserAttributes().getRegistStatus()
        );

        response.addCookie(createRefreshTokenCookie(token.refreshToken()));
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(
                new ObjectMapper().writeValueAsString(Map.of(
                        "accessToken", token.accessToken()
                ))
        );
        response.sendRedirect(REDIRECT_URL);
    }

    private Cookie createRefreshTokenCookie(String refreshToken) {
        Cookie cookie = new Cookie("refreshToken", refreshToken);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60 * 24); // 24 hours
        return cookie;
    }
}
