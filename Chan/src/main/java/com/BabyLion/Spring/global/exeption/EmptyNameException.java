package com.BabyLion.Spring.global.exeption;

public class EmptyNameException extends RuntimeException {
    private final ErrorCodeEnum errorCode;

    public EmptyNameException(ErrorCodeEnum errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCodeEnum getErrorCode() { return errorCode; }
}
