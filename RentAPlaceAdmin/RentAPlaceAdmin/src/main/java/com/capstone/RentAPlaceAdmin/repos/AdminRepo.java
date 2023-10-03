package com.capstone.RentAPlaceAdmin.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.RentAPlaceAdmin.dao.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer> {

	Admin  findByNameAndPassword(String name, String password);

	
}
