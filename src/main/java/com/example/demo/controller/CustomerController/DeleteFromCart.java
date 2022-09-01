package com.example.demo.controller.CustomerController;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.services.User.AddtoCartService;

@Controller
public class DeleteFromCart {

	@Autowired
	AddtoCartService delete;
	
	@GetMapping("/remove")
	public String removeById(@RequestParam("id") String id,HttpServletRequest request) {
		
		delete.deleteByid(Integer.valueOf(id));
		System.out.println("de");
		String referer = request.getHeader("Referer");
	    return "redirect:"+ referer;
	}	
}
