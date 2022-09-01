package com.example.demo.controller.CustomerController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;import com.example.demo.entity.ContentDetails;
import com.example.demo.services.Admin.UploadData;
import com.example.demo.services.User.ContentLinksServices;

@Controller
public class DirectToContentController {

	@Autowired
	ContentLinksServices conlink;

	@Autowired
	UploadData uploadData;

	@RequestMapping(value = "/content", method = RequestMethod.GET)
	public String contentvalue(@RequestParam("id") String language, Model m) {

		List<ContentDetails> infoSingle = conlink.getInfoSingle(language);

		m.addAttribute("data", infoSingle);

		return "discription";

	}
}
