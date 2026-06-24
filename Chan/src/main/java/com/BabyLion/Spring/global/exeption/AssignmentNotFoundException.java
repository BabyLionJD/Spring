package com.BabyLion.Spring.global.exeption;

public class AssignmentNotFoundException extends RuntimeException {
    private final ErrorCodeEnum errorCode;

    public AssignmentNotFoundException(ErrorCodeEnum errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCodeEnum getErrorCode() { return errorCode; }
}
