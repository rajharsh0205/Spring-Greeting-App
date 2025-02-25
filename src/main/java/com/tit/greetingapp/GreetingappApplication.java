package com.tit.greetingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class GreetingappApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreetingappApplication.class, args);
	}

}
