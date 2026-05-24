package com.BabyLion.Spring.config;

import com.BabyLion.Spring.service.MemberService;
import com.BabyLion.Spring.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;

//@Configuration
public class AppConfig {
    @Bean
    public MemoryMemberRepository memoryMemberRepository(){
        return new MemoryMemberRepository();
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memoryMemberRepository());
    }
}
