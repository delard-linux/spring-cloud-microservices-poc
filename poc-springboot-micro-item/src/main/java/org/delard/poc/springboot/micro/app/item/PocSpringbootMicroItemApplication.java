package org.delard.poc.springboot.micro.app.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@RibbonClient(name="servicio-productos")
@EnableFeignClients
@SpringBootApplication
public class PocSpringbootMicroItemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocSpringbootMicroItemApplication.class, args);
	}

}
