package com.BabyLion.Spring.auth.controller;

import com.BabyLion.Spring.auth.dto.SignupRequest;
import com.BabyLion.Spring.auth.service.AuthService;
import com.BabyLion.Spring.member.domain.Member;
import com.BabyLion.Spring.member.dto.LionCreateRequest;
import com.BabyLion.Spring.member.dto.MemberResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/auth/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest dto) {
        Member member = authService.signup(dto);
        MemberResponse response = MemberResponse.from(member);
        return ResponseEntity.status(201).body(response);
    }

}
