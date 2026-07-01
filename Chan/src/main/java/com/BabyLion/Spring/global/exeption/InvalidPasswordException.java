package com.BabyLion.Spring.global.exeption;

public class InvalidPasswordException extends RuntimeException {
    private final ErrorCodeEnum errorCode;

    public InvalidPasswordException(ErrorCodeEnum errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCodeEnum getErrorCode() { return errorCode; }
}

