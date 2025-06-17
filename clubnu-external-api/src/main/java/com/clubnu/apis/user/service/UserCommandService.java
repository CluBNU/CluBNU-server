package com.clubnu.apis.user.service;

import com.clubnu.apis.user.dto.EditUserRequest;
import com.clubnu.domain.user.entity.User;
import com.clubnu.domain.user.exception.UserErrCode;
import com.clubnu.domain.user.exception.exceptions.NoSuchUserException;
import com.clubnu.domain.user.exception.exceptions.UserMismatchException;
import com.clubnu.domain.user.service.UserCommandDomainService;
import com.clubnu.domain.user.service.UserQueryDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Service
public class UserCommandService {
    private final UserCommandDomainService userCommandDomainService;
    private final UserQueryDomainService userQueryDomainService;

    public void updateUser(Long userId, EditUserRequest request){
        User target = userQueryDomainService.findById(userId)
                .orElseThrow(() -> new NoSuchUserException(UserErrCode.USER_NOT_FOUND));
        if (!Objects.equals(target.getUserId(), userId)) {
            throw new UserMismatchException(UserErrCode.DOESNT_MATCH_USER);
        }
        User updatedUser = target.toBuilder()
                .userIdentity(target.getUserIdentity().toBuilder()
                        .email(request.email())
                        .major(request.major())
                        .studentId(request.studentId())
                        .name(request.name())
                        .build())
                .userAttributes(target.getUserAttributes().toBuilder()
                        .role(request.userRole())
                        .nationality(request.nationality())
                        .registStatus(request.registStatus())
                        .build())
                .build();
        userCommandDomainService.updateUser(updatedUser);
    }

    public void deleteUser(Long userId) {
        User target = userQueryDomainService.findById(userId)
                .orElseThrow(() -> new NoSuchUserException(UserErrCode.USER_NOT_FOUND));
        if (!Objects.equals(target.getUserId(), userId)) {
            throw new UserMismatchException(UserErrCode.DOESNT_MATCH_USER);
        }
        target.delete();
    }
}
