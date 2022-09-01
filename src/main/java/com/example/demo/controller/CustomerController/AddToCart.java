package com.example.demo.controller.CustomerController;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
import com.example.demo.services.User.ContentLinksServices;

@Controller
public class AddToCart {

	@Autowired
	AddtoCartService addCart;

	@Autowired
	ContentLinksServices contentLink;
	
	@GetMapping("/addcart")
	public String addedToCart(@ModelAttribute("cart") Cart cart,Model m,HttpServletRequest request) {
		System.out.println(cart);
		addCart.savetoCart(cart);
	//	m.addAttribute("data", contentLink.getImageData());
		String referer = request.getHeader("Referer");
	    return "redirect:"+ referer;
	}

	@GetMapping("/cartpage")
	public String cartpage(@RequestParam("user") String user, Model m) {

		System.out.println("cart page1" + user);
		if (user.equals("null")) {
			System.out.println("cart page2" + user);
			user = "-1";
			List<ContentDetails> findUserCart = addCart.findUserCart(user);
			findUserCart.forEach(e->System.out.println("sda"+e));
			m.addAttribute("cartdata", findUserCart);
		}
		if (!user.equals("null")) {
			List<ContentDetails> findUserCart = addCart.findUserCart(user);
			
			m.addAttribute("cartdata", findUserCart);
			findUserCart.forEach(e->System.out.println("after addd::: "+e.getCartid()));
		}
		return "cart";
	}
}
