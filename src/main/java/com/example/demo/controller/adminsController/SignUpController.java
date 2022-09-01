package com.example.demo.controller.adminsController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.User;
import com.example.demo.services.Admin.RegisterServices;
import com.example.demo.services.User.ContentLinksServices;

@Controller
public class SignUpController {

	@Autowired
	RegisterServices registerservice;

	@Autowired
	ContentLinksServices contentLink;

	@GetMapping("/signup")
	public String signupPage() {

		return "signup";
	}

	@PostMapping("/user_register")
	public String signForm(@ModelAttribute("user") User user, Model m, HttpSession s) {
		System.out.println("ssw");
		User saveUser = registerservice.saveUser(user);
		System.out.println("ssw");
		s.setAttribute("login", saveUser.getName());
		System.out.println(saveUser.getName());
		m.addAttribute("data", contentLink.getImageData());
		return "HomePage";
	}
}
