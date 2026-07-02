package com.BabyLion.Spring.global.exeption;

public class CommentNotFoundException extends RuntimeException {
    private final ErrorCodeEnum errorCode;

    public CommentNotFoundException(ErrorCodeEnum errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCodeEnum getErrorCode() { return errorCode; }
}
