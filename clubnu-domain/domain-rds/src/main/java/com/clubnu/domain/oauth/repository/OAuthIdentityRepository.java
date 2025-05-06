package com.clubnu.domain.oauth.repository;

import com.clubnu.domain.oauth.entity.OAuthIdentity;
import com.clubnu.domain.oauth.entity.OAuthProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface OAuthIdentityRepository extends JpaRepository<OAuthIdentity, Long> {
    Optional<OAuthIdentity> findBySubAndProvider(String sub, OAuthProvider provider);

    @Query("""
    SELECT oi FROM OAuthIdentity oi
    JOIN FETCH oi.user u
    WHERE oi.sub = :sub AND oi.provider = :provider
""")
    Optional<OAuthIdentity> findWithUserBySubAndProvider(@Param("sub") String sub, @Param("provider") OAuthProvider provider);

}
