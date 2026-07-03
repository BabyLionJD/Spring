package com.likelion.likelionspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;  // ← import 추가

@SpringBootApplication
public class LikelionspringApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(LikelionspringApplication.class, args);  // ← context로 받기
	}
}