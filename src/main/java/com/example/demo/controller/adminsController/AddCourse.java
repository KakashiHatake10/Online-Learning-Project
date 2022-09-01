package com.example.demo.controller.adminsController;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.ContentDetails;
import com.example.demo.services.Admin.UploadData;
import com.example.demo.services.User.ContentLinksServices;

@Controller
public class AddCourse {

	@Autowired
	UploadData uploadData;

	@Autowired
	ContentLinksServices contentLink;

	@GetMapping("/addContent")
	public String addContent() {

		return "AddCourse";
	}

	@PostMapping("/contentsubmit")
	public String Upload(@ModelAttribute ContentDetails data, HttpSession s, Model m) {

		System.out.println("data :: " + data);
		String uploadContent = uploadData.UploadContent(data, s);
		ContentDetails saveFiledata = uploadData.saveFiledata(data);
		// m.addAttribute("data", saveFiledata);
		m.addAttribute("data", contentLink.getImageData());
		return "Adminpanel";
	}

	@GetMapping("/seeAll")
	public String SendToAllUploadPage(Model m) {

		List<ContentDetails> sendData = uploadData.SendData();
		m.addAttribute("data", sendData);

		return "AllUploadContent";
	}

}
