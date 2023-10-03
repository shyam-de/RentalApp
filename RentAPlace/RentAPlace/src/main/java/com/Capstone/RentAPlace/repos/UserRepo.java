package com.Capstone.RentAPlace.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Capstone.RentAPlace.dao.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	Optional<User> findByNameAndPassword(String name, String password);

}
