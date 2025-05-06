package com.clubnu.apis.user.dto;

import com.clubnu.domain.user.entity.Nationality;
import com.clubnu.domain.user.entity.RegistStatus;
import com.clubnu.domain.user.entity.UserRole;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record EditUserRequest(
        String email,
        String studentId,
        String name,
        LocalDateTime birthDate,
        Nationality nationality,
        String major,
        UserRole userRole,
        RegistStatus registStatus
) {
}
