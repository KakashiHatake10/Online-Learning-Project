package com.example.demo.controller.CustomerController;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.entity.ContentDetails;
import com.example.demo.services.User.MyCourseServices;

@Controller
public class MyCourse {

	@Autowired
	MyCourseServices myCourseServices;

	@GetMapping("/mycourse")
	public String myCoursePage(Model m, @RequestParam("id") String id) {

		List<ContentDetails> allCourse = myCourseServices.AllCourse(id);
System.out.println("mycourse");
		m.addAttribute("cartdata", allCourse);
		return "course";
	}

	@GetMapping("/start")
	public String singleCourse(@RequestParam("contentid") String contentid, @RequestParam("title") String title,
			Model m) {
		String courseData = myCourseServices.getCourseData(contentid, title);
		System.out.println("hello  " + contentid);
		ArrayList<String> allDataLinks = myCourseServices.getAllDataLinks(title);
		m.addAttribute("all", allDataLinks);
		m.addAttribute("q", 0);
		m.addAttribute("path", courseData);
		return "VideoPlay";
	}
}
