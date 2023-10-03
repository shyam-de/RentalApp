package com.capstone.RentAPlaceAdmin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.RentAPlaceAdmin.dao.Admin;
import com.capstone.RentAPlaceAdmin.dao.LoginAdmin;
import com.capstone.RentAPlaceAdmin.repos.AdminRepo;

@Service
public class AdminService {
	
	@Autowired
	AdminRepo adminRepo;

	public void createAdmin(Admin admin) {
		// TODO Auto-generated method stub
		adminRepo.save(admin);
	}

	public void loginAdmin(LoginAdmin admin) {
		// TODO Auto-generated method stub
		Admin ad = adminRepo.findByNameAndPassword(admin.getName(),admin.getPassword());
	}

}
