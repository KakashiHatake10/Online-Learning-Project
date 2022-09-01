package com.example.demo.services.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.entity.User;

@Service
public class RegisterServices {

	@Autowired
	UserRepository regrepo;


	public User saveUser(User user) {
		user.setPassword(user.getPassword());
		System.out.println("s");
		User save = regrepo.save(user);
		return save;
	}
}
