package com.BabyLion.Spring.global.exeption;

public enum ErrorCode {
    INVALID_STUDENT_ID(400, "studentId는 숫자만 입력 가능합니다."),
    MEMBER_NOT_FOUND(404, "존재하지 않는 멤버입니다.");

    private final int status;
    private final String message;

    ErrorCode(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() { return status; }
    public String getMessage() { return message; }
}

