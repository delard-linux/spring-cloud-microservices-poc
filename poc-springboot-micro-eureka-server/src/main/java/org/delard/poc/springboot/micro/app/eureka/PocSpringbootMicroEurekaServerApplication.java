package org.delard.poc.springboot.micro.app.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class PocSpringbootMicroEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocSpringbootMicroEurekaServerApplication.class, args);
	}

}
