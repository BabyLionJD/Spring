package com.BabyLion.Spring.global.exeption;

public class ForbiddenException extends RuntimeException {
    private final ErrorCodeEnum errorCode;

    public ForbiddenException(ErrorCodeEnum errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCodeEnum getErrorCode() { return errorCode; }
}
