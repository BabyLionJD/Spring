package com.BabyLion.Spring.global.exeption;

public class MemberNotFoundException extends RuntimeException {
    private final ErrorCodeEnum errorCode;

    public MemberNotFoundException(ErrorCodeEnum errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCodeEnum getErrorCode() { return errorCode; }
}
