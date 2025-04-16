package com.clubnu.fixtures;

import com.clubnu.domain.oauth.dto.OAuthMemberResponse;
import com.clubnu.domain.oauth.entity.Provider;

public class OAuthMemberResponseFixture {
    public static OAuthMemberResponse kakaoUser() {
        return OAuthMemberResponse.of(
                "kakao@user.com",
                "카카오 유저",
                Provider.KAKAO
        );
    }

    public static OAuthMemberResponse googleUser() {
        return OAuthMemberResponse.of(
                "google@user.com",
                "구글 유저",
                Provider.GOOGLE
        );
    }
}
