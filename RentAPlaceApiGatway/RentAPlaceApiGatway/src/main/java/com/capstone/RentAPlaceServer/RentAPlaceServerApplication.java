package com.capstone.RentAPlaceServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication

public class RentAPlaceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentAPlaceServerApplication.class, args);
	}

}
