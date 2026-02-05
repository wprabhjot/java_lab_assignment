package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Assignment4Application {

	public static void main(String[] args) {
		SpringApplication.run(Assignment4Application.class, args);
	}

}
