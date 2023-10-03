package com.Capstone.RentAPlace.service;


import java.util.Optional;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Capstone.RentAPlace.customeException.InvalidCredentialException;
import com.Capstone.RentAPlace.dao.Booking;
import com.Capstone.RentAPlace.dao.User;
import com.Capstone.RentAPlace.dao.UserLogin;
import com.Capstone.RentAPlace.rabbitmqConfig.RabbitMQConfig;
//import com.Capstone.RentAPlace.repos.BookingRepo;
import com.Capstone.RentAPlace.repos.UserRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	UserRepo userRepo;
	
//	@Autowired
//	BookingRepo bookingRepo;
	
	
	


    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.booking.key}")
    private String routingKey;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private RabbitTemplate rabbitTemplate;

    public UserService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

	public String createuser(User user){
		userRepo.save(user);
		
		return "new User Created Successfully..";
		
	}

	public ResponseEntity<User> loginUser(UserLogin user){

			Optional<User> us = userRepo.findByNameAndPassword(user.getName(),user.getPassword());
		

		    if(us.isPresent()) {
		        return ResponseEntity.ok().body(us.get());
		    } else {
		        return ResponseEntity.notFound().build();
		    }
		
	}

	public void booking(Booking booking) {
		rabbitTemplate.convertAndSend(exchange, routingKey, booking);
		System.out.println("Send msg = " + booking);
	}

}
