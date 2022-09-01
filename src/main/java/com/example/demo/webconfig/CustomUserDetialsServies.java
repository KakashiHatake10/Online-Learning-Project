package com.example.demo.webconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.example.demo.Repository.UserRepository;
import com.example.demo.entity.User;

public class CustomUserDetialsServies implements UserDetailsService{

	@Autowired
	UserRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		User user = userRepo.findByEmail(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("Could not find ........");
		}
		
		CustomUserDetials cu = new CustomUserDetials(user);
		return  cu;
	}

}
