package com.clubnu.domain.user.exception.exceptions;

import com.clubnu.domain.user.exception.UserErrCode;

public class NoSuchUserException extends RuntimeException {
    private final UserErrCode userErrCode;
    public NoSuchUserException(UserErrCode userErrCode) {
        super(userErrCode.getMessage());
        this.userErrCode = userErrCode;
    }
    public UserErrCode getUserErrCode() {
        return userErrCode;
    }
    public String getErrMessage() {
        return userErrCode.getMessage();
    }
}
