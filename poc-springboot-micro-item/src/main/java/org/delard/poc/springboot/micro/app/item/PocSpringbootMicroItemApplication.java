package org.delard.poc.springboot.micro.app.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class PocSpringbootMicroItemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocSpringbootMicroItemApplication.class, args);
	}

}
