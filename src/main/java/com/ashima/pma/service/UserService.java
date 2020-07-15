package com.ashima.pma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ashima.pma.dao.UserRepo;
import com.ashima.pma.entities.UserAccount;

@Service
public class UserService {

	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired 
	UserRepo userRepo;
	
	public UserAccount saveUser(UserAccount user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepo.save(user);
	}
}
