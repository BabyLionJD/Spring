package com.BabyLion.Spring.exeption;

public class InvalidStudentIdException extends RuntimeException{
    private final ErrorCode errorCode;

    public InvalidStudentIdException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() { return errorCode; }
}
