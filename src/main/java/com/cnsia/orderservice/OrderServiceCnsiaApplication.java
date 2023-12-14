package com.cnsia.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class OrderServiceCnsiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceCnsiaApplication.class, args);
	}

}
