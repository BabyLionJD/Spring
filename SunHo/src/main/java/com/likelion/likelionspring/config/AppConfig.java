package com.likelion.likelionspring.config;

import com.likelion.likelionspring.repository.MemberRepository;
import com.likelion.likelionspring.repository.MemoryMemberRepository;
import com.likelion.likelionspring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration //수동 주입
public class AppConfig {

    @Bean // 스프링 컨테이너가 관리해주는 객체
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean // 스프링 컨테이너가 관리해주는 객체
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}