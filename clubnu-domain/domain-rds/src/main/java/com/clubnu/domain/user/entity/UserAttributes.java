package com.clubnu.domain.user.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Builder(toBuilder = true)
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@AllArgsConstructor(access = lombok.AccessLevel.PRIVATE)
@Getter
public class UserAttributes {
    private Nationality nationality;
    private RegistStatus registStatus;
    private UserRole role;

    public static UserAttributes of(Nationality nationality, RegistStatus registStatus, UserRole userRole){
        return UserAttributes.builder()
                .nationality(nationality)
                .registStatus(registStatus)
                .role(userRole)
                .build();
    }
}
