package org.delard.poc.springboot.micro.app.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PocSpringbootMicroProductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocSpringbootMicroProductosApplication.class, args);
	}

}
