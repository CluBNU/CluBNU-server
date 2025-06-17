package com.clubnu.domain.user.exception.exceptions;

import com.clubnu.domain.user.exception.UserErrCode;

public class UserMismatchException extends RuntimeException{
    private final UserErrCode userErrCode;

    public UserMismatchException(UserErrCode userErrCode) {
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
