package com.codes.shuk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringDataAuditApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataAuditApplication.class, args);
	}

}
