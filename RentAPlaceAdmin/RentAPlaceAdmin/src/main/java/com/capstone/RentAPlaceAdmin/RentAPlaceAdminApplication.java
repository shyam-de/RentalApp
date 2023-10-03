package com.capstone.RentAPlaceAdmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RentAPlaceAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentAPlaceAdminApplication.class, args);
	}

}
