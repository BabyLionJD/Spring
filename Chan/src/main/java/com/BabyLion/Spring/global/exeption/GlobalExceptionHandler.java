package com.BabyLion.Spring.global.exeption;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleMemberNotFoundException(MemberNotFoundException e) {
        return ResponseEntity
                .status(e.getErrorCode().getStatus())
                .body(Map.of(
                        "status", e.getErrorCode().getStatus(),
                        "message", e.getErrorCode().getMessage()
                ));
    }

    @ExceptionHandler(InvalidStudentIdException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidStudentId(InvalidStudentIdException e) {
        return ResponseEntity
                .status(e.getErrorCode().getStatus())
                .body(Map.of(
                        "status", e.getErrorCode().getStatus(),
                        "message", e.getErrorCode().getMessage()
                ));
    }
}