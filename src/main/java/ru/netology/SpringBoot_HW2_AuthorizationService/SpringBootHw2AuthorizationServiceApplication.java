package ru.netology.SpringBoot_HW2_AuthorizationService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.netology.SpringBoot_HW2_AuthorizationService.controller.AuthorizationController;

@SpringBootApplication
public class SpringBootHw2AuthorizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHw2AuthorizationServiceApplication.class, args);
	}
}
