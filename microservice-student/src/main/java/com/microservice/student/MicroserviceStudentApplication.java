package com.microservice.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Porn defecto, Spring detecta que es cliente de Eureka,
 * pero siempre es bueno tenerlo de manera explicita,
 * por eso se usa @EnableDiscoveryClient
 */
@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceStudentApplication.class, args);
	}

}
