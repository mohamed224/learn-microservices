package com.mtrade.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProductsApplication.class, args);
	}

}
