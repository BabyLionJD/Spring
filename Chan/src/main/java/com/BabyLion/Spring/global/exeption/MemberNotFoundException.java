package com.BabyLion.Spring.global.exeption;

public class MemberNotFoundException extends RuntimeException {
    private final ErrorCode errorCode;

    public MemberNotFoundException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() { return errorCode; }
}
