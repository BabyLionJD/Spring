package com.BabyLion.Spring.auth.service;

import com.BabyLion.Spring.assignment.repository.AssignmentRepository;
import com.BabyLion.Spring.auth.dto.LoginRequest;
import com.BabyLion.Spring.auth.dto.SignupRequest;
import com.BabyLion.Spring.auth.jwt.JwtProvider;
import com.BabyLion.Spring.global.exeption.*;
import com.BabyLion.Spring.member.domain.Member;
import com.BabyLion.Spring.member.domain.RoleType;
import com.BabyLion.Spring.member.dto.LionCreateRequest;
import com.BabyLion.Spring.member.dto.StaffCreateRequest;
import com.BabyLion.Spring.member.repository.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {


    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public AuthService(MemberRepository memberRepository, PasswordEncoder passwordEncoder, JwtProvider jwtProvider) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
    }


    public Member signup(SignupRequest dto){
        String rawPassword = dto.getPassword();
        String encPassword = passwordEncoder.encode(rawPassword);

        if (dto.getRoleType() == RoleType.LION){
            Member member = new Member(
                    dto.getName(),
                    dto.getMajor(),
                    dto.getPart(),
                    dto.getGeneration(),
                    RoleType.LION,
                    dto.getStudentId(),
                    null, encPassword, dto.getLoginId());

            return memberRepository.save(member);
        }else{

            Member member = new Member(
                    dto.getName(),
                    dto.getMajor(),
                    dto.getPart(),
                    dto.getGeneration(),
                    RoleType.STAFF,
                    null,
                    dto.getPosition(), encPassword, dto.getLoginId());
            return memberRepository.save(member);
        }

    }

    public String login(LoginRequest dto){
        String password = dto.getPassword();
        String id = dto.getLoginId();
        Member member = memberRepository.findByLoginId(id)
                .orElseThrow(() -> new MemberNotFoundException(ErrorCodeEnum.MEMBER_NOT_FOUND));

        if (!passwordEncoder.matches(dto.getPassword(), member.getPassword())) {
            throw new InvalidPasswordException(ErrorCodeEnum.INVALID_PASSWORD);
        }
        return jwtProvider.createToken(member.getId());
    }
}
