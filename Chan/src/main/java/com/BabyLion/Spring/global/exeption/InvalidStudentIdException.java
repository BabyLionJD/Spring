package com.BabyLion.Spring.global.exeption;

public class InvalidStudentIdException extends RuntimeException{
    private final ErrorCodeEnum errorCode;

    public InvalidStudentIdException(ErrorCodeEnum errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCodeEnum getErrorCode() { return errorCode; }
}
