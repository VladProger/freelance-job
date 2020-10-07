package com.jobfreelance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.jobfreelance.repository")
@EntityScan(basePackages = "com.jobfreelance.entity")
public class SpringSecurityJpaApplication {

		public static void main(String[] args) {
			SpringApplication.run(SpringSecurityJpaApplication.class, args);
		}

}
