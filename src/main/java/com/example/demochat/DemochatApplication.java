package com.example.demochat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class DemochatApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(DemochatApplication.class, args);
	}

}
