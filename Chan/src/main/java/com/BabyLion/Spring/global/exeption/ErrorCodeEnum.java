package com.BabyLion.Spring.global.exeption;

public enum ErrorCodeEnum {
    INVALID_STUDENT_ID(400, "studentId는 숫자만 입력 가능합니다."),
    MEMBER_NOT_FOUND(404, "존재하지 않는 멤버입니다."),
    ASSIGNMENT_NOT_FOUND(404, "존재하지 않는 과제입니다."),
    DUPLICATE_MEMBER_NAME(409, "이미 존재하는 이름입니다.");

    private final int status;
    private final String message;

    ErrorCodeEnum(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() { return status; }
    public String getMessage() { return message; }
}

