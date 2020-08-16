package io.github.mariazevedo88.springrabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootApplication
public class SpringRabbitmqExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRabbitmqExampleApplication.class, args);
		log.info("SpringBoot application with rabbitmq started successfully.");
	}

}
