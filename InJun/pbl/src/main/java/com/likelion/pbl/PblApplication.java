package com.likelion.pbl;

import com.likelion.pbl.step2.MemberService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class PblApplication {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(PblApplication.class, args);

		MemberService memberService = ac.getBean(MemberService.class);

		System.out.println("memberService = " + memberService);
		System.out.println("자동 주입 Bean 등록 성공!");

		System.out.println("===== 전체 Bean 목록 =====");

		String[] beanNames = ac.getBeanDefinitionNames();
		Arrays.sort(beanNames);

		for (String beanName : beanNames) {
			System.out.println(beanName);
		}


	}
}
