package com.example.demo.controller.adminsController;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.ContentDetails;
import com.example.demo.entity.User;
import com.example.demo.services.Admin.LoginCheck;
import com.example.demo.services.Admin.UploadData;
import com.example.demo.services.User.ContentLinksServices;

@Controller
public class LoginController {

	@Autowired
	UploadData uploadData;

	@Autowired
	LoginCheck check;

	@Autowired
	ContentLinksServices contentLink;

	@GetMapping("/login")
	public String loginpage() {
		return "login";
	}

	@PostMapping("/login_user")
	public ModelAndView loginUser(@ModelAttribute("login") User login, ModelAndView m, HttpSession s) {
		System.out.println("user data :: sdsd :: " + login);
		User checkLogin = check.CheckLogin(login);
		if (checkLogin.getName() != null) {
			if (checkLogin.getRole().equalsIgnoreCase("ROLE_ADMIN")) {
				System.out.println("admin");
				// m.addObject("loginUser", checkLogin.getName());
				System.out.println("test admin");
				s.setAttribute("login", checkLogin.getName());
				s.setAttribute("email", checkLogin.getEmail());
				System.out.println("user data :: admin After Check sdsd :: " + login);
				List<ContentDetails> sendData = uploadData.SendData();
				System.out.println(sendData.get(0).getImgloc());
				
				m.addObject("data", sendData);
				// m.addObject("data", contentLink.getImageData());
				m.setViewName("AdminPanel");
			} else if (checkLogin.getRole().equalsIgnoreCase("ROLE_CUSTOMER")) {
				s.setAttribute("login", checkLogin.getName());
				s.setAttribute("email", checkLogin.getEmail());
				System.out.println("user data :: After Check sdsd :: " + login);
				List<ContentDetails> sendData = uploadData.SendData();
				m.addObject("data", sendData);
				m.setViewName("Homepage");
			}
		} else {
			m.addObject("loginUser", null);
			m.setViewName("login");
		}
		return m;

	}

	@GetMapping("/logout")
	public String logout(Model m) {
		
		List<ContentDetails> sendData = uploadData.SendData();
		m.addAttribute("data", sendData);
		return "Homepage";
	}

}
