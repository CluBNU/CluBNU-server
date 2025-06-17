package com.clubnu.domain.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@Builder(toBuilder = true)
@AllArgsConstructor(access = lombok.AccessLevel.PRIVATE)
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class UserIdentity {
    @Column(unique = true)
    private String email;

    @Column(name ="student_id", unique = true)
    private String studentId;

    @Column(name = "name")
    private String name;

    @Column(name = "major")
    private String major;

    public static UserIdentity of(String email, String name, String studentId, String major){
        return UserIdentity.builder()
                .email(email)
                .name(name)
                .studentId(studentId)
                .major(major)
                .build();
    }
}
