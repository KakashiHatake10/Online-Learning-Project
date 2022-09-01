package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.services.User.ContentLinksServices;

@Controller
public class HomeController {

	@Autowired
	ContentLinksServices contentLink;
	
	@GetMapping("/")
	public String home_page(Model m) {
		m.addAttribute("data", contentLink.getImageData());
		m.addAttribute("loginUser", null);
		m.addAttribute("l_id", 10);
		return "Homepage";
	}
}