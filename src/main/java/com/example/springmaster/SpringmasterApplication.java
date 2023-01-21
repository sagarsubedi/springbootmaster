package com.example.springmaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringmasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmasterApplication.class, args);
	}

}
