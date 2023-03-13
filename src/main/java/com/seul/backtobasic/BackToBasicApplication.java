package com.seul.backtobasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class BackToBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackToBasicApplication.class, args);
	}

}
