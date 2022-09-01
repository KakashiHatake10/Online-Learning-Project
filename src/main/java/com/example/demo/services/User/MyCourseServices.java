package com.example.demo.services.User;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.BuyCourseRepository;
import com.example.demo.Repository.Content_detailsRepository;
import com.example.demo.entity.BuyCourse;
import com.example.demo.entity.ContentDetails;

@Service
public class MyCourseServices {

	@Autowired
	BuyCourseRepository myCourse;

	@Autowired
	Content_detailsRepository conRepo;

	public List<ContentDetails> AllCourse(String email) {

		List<ContentDetails> d = new ArrayList<ContentDetails>();

		List<BuyCourse> findByEmail = myCourse.findByEmail(email);
		//
		for (BuyCourse ids : findByEmail) {
			System.out.println(ids.getTitleid());
			String[] id = ids.getTitleid().split("\\s");

			for (String id1 : id) {
				ContentDetails findByContentid = conRepo.findByContentid(Integer.parseInt(id1));
				d.add(findByContentid);
			}

		}
		// System.out.println(findByEmail);

		return d;
	}

	@Autowired
	ResourceLoader resourceLoader;

	public static String videoFolder = "D:" + File.separator + "projects";

	public String getCourseData(String contentid, String title) {

		File dir = new File(
				"D:\\java\\Spring boot\\Project_Assignment\\src\\main\\webapp\\video" + File.separator + title);
		File[] files = dir.listFiles();
		String s = "";
		/*
		 * for (File f : files) { System.out.println(f.getName() + "   " +
		 * f.getAbsolutePath()); s = s.concat(f.getName()); }
		 */
		String s1 = "video" + File.separator + title + File.separator + files[0].getName();
		System.out.println(s1);
		return s1;
	}

	public ArrayList<String> getAllDataLinks(String title) {
		
		ArrayList<String> s = new ArrayList<String>(); ;
		
		File dir = new File("D:\\java\\Spring boot\\Project_Assignment\\src\\main\\webapp\\video"+File.separator+ title);
		File[] files = dir.listFiles();
		for (File f : files) {
			System.out.println(f.getName() + "   " + f.getAbsolutePath());
			s.add(f.getName());
		}
		return s; 
	}
}
