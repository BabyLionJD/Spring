package com.BabyLion.Spring.global.exeption;

public class DuplicateMemberException extends RuntimeException {
  private final ErrorCodeEnum errorCode;

  public DuplicateMemberException(ErrorCodeEnum errorCode) {
    super(errorCode.getMessage());
    this.errorCode = errorCode;
  }

  public ErrorCodeEnum getErrorCode() { return errorCode; }
}
