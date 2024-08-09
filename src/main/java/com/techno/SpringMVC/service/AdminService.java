package com.techno.SpringMVC.service;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import com.techno.SpringMVC.POJO.Admin;
import com.techno.SpringMVC.Repository.AdminRepository;
@Service

public class AdminService {
	@Autowired
	AdminRepository repository;
	public Admin addAdmin( String username, String password) {
	Admin admin=repository.addadmin(username,password);
	return admin;
	}
	public Admin login(String username, String password) {
		Admin admin=repository.login(username,password);	
		return admin;
	}
}

