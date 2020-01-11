package com.sk.learn;

import com.sk.learn.client.web.InvitationWebClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.sk.learn")
public class SpringBoot2WebFluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2WebFluxApplication.class, args);
	}

}
