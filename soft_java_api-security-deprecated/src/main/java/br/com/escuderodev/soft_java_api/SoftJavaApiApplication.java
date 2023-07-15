package br.com.escuderodev.soft_java_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SoftJavaApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(SoftJavaApiApplication.class, args);
	}

}
