package com.clubnu.domain.user.entity;

import com.clubnu.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@AllArgsConstructor(access = lombok.AccessLevel.PRIVATE)
@Builder(toBuilder = true)
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Embedded
    private UserIdentity userIdentity;

    @Embedded
    private UserAttributes userAttributes;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public static User of(String email, String name, String studentId, String major){
        return User.builder()
                .userIdentity(UserIdentity.of(email, name, studentId, major))
                .userAttributes(UserAttributes.of(
                        Nationality.NOT_YET,
                        RegistStatus.NOT_YET,
                        UserRole.NONE
                ))
                .build();
    }

    public static User of(){
        return User.builder()
                .userIdentity(UserIdentity.of(
                        "PENDING",
                        "UNREGISTERED",
                        "NOT_SET",
                        "UNKNOWN"))
                .userAttributes(UserAttributes.of(
                        Nationality.NOT_YET,
                        RegistStatus.NOT_YET,
                        UserRole.NONE
                ))
                .build();
    }
}
