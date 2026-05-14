package com.BabyLion.Spring.config;

import com.BabyLion.Spring.step2.MemberService;
import com.BabyLion.Spring.step2.MemoryMemberRepository;
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
