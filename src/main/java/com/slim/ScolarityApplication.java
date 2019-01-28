package com.slim;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/**
 * @author slim
 *
 */

@SpringBootApplication
@ComponentScan(basePackages = { "com.esprit"})

public class ScolarityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScolarityApplication.class, args);
	}
}
