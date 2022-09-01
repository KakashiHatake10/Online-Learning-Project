package com.example.demo.controller.CustomerController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Repository.UserRepository;
import com.example.demo.entity.User;

@Controller
public class Profile {
	
	@Autowired
	public UserRepository userRepo;
	@GetMapping("/profile")
	public User getProfile(Model m,@RequestParam("id") String id) {
		
		
		User findByEmail = userRepo.findByEmail(id);
		System.out.println(findByEmail);
		m.addAttribute("profile", findByEmail);
		return findByEmail;
		
	}
	
	@PostMapping("/editProfile")
	public String editProfile(Model m, @ModelAttribute("user") User user) {
		User findByEmail = userRepo.findByEmail(user.getEmail());
		System.out.println(user);
		findByEmail.setName(user.getName());
		findByEmail.setAddress(user.getAddress());
		findByEmail.setPassword(user.getPassword());
		findByEmail.setPhone(user.getPhone());
		
		User save = userRepo.save(findByEmail);
		m.addAttribute("profile", save);
		
		return "Profile";
		
	}

}
