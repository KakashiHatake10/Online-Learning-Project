package com.example.demo.controller.CustomerController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.entity.Cart;
import com.example.demo.entity.ContentDetails;
import com.example.demo.services.User.AddtoCartService;
import com.example.demo.services.User.BuyCourseService;

@Controller
public class BuyCourse {

	@Autowired
	AddtoCartService buyCourses;

	@Autowired
	BuyCourseService buyService;

	@GetMapping("/buy")
	public String buyPage(@ModelAttribute("cart") Cart cart, Model m) {

		ContentDetails findSingleContent = buyCourses.findSingleContent(cart.getContentid());
		m.addAttribute("cartdata", findSingleContent);
		m.addAttribute("idsall", findSingleContent.getContentid());
		m.addAttribute("total", findSingleContent.getPrice());
		//m.addAttribute("email", )
		return "Buy";
	}

	@GetMapping("/sumbitdetails")
	public String buyCoursePage(@RequestParam("user") String email, Model m) {
		System.out.println(email);
		List<ContentDetails> findSingleContent = buyCourses.findUserCart(email);
		System.out.println(findSingleContent);

		int total = 0, x = 0;
		String idsall = "";
		System.out.println("findSingleContent"+ findSingleContent);
		for (ContentDetails contentDetails : findSingleContent) {
			total += contentDetails.getPrice();
			contentDetails.getContentid();
			System.out.println("contentDetails id s"+ contentDetails.getContentid());
			idsall = idsall.concat(contentDetails.getContentid()+" ");
			x++;
		}
		System.out.println("all id "+ idsall);
		m.addAttribute("idsall", idsall);
		m.addAttribute("total", total);
		m.addAttribute("x", x);
		m.addAttribute("cartdata", findSingleContent);
		return "Buy";
	}

	@PostMapping("/order")
	public String BuyCourseSubmit(@ModelAttribute("Buy") com.example.demo.entity.BuyCourse buy) {
		System.out.println("buy order  : " + buy.getEmail());
		System.out.println("buy order  : " + buy.getCardno());
		System.out.println("buy order  : " + buy.getPrice());
		System.out.println("buy order  : " + buy.getTitleid());
		buyService.orderService(buy);
	buyCourses.deleteAll(buy.getEmail(), buy.getTitleid());
		return "buy";
	}
}
