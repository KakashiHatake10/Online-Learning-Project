package com.example.demo.services.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.UserRepository;
import com.example.demo.entity.User;

@Service
public class LoginCheck {

	@Autowired
	UserRepository regrepo;

	public User CheckLogin(User login) {
		System.out.println("login method:: ");
		List<User> findAll = regrepo.findAll();
		User regData = new User();
		for (User l : findAll) {
			if (login.getEmail().equalsIgnoreCase(l.getEmail()) && login.getPassword().equals(l.getPassword())) {
				System.out.println(l.getEmail() + "  " + l.getPassword());

				regData.setName(l.getName());
				regData.setEmail(l.getEmail());
				regData.setPassword(l.getPassword());
				regData.setRole(l.getRole());
				return regData;
			}
		}
		return regData;
	}
}
