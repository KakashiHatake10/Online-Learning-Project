package com.example.demo.services.Admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.Repository.Content_detailsRepository;
import com.example.demo.entity.ContentDetails;

@Service
public class UploadData {

	@Autowired
	Content_detailsRepository conRepo;

	public static String videoFolder = "D:" + File.separator + "projects";

	public String UploadContent(ContentDetails data, HttpSession s) {

		String path = s.getServletContext().getRealPath("/") + "VideoImages";

		System.out.println("context = " + s.getServletContext().getRealPath("/") + " \n dfdjfhsakj :: " + path);

		try {
			InputStream is = data.getImage().getInputStream();
			byte b[] = new byte[is.available()];
			is.read(b);

			FileOutputStream out = new FileOutputStream(path + File.separator + data.getImage().getOriginalFilename());
			out.write(b);
			out.close();

			data.setImgloc("VideoImages" + File.separator + data.getImage().getOriginalFilename());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String path1 = s.getServletContext().getRealPath("/") + "video";
		try {
			File f1 = new File(path1 + File.separator + data.getTitle());
			boolean bool2 = f1.mkdir();
			if (bool2) {
				for (MultipartFile v : data.getVideo()) {
					InputStream is = v.getInputStream();
					byte b[] = new byte[is.available()];
					is.read(b);

					FileOutputStream out = new FileOutputStream(
							path1 + File.separator + data.getTitle() + File.separator + v.getOriginalFilename());
					out.write(b);
					out.close();
				}
			} else {
				System.out.println("not created");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data.getImage().getOriginalFilename();
	}

	public ContentDetails saveFiledata(ContentDetails data) {

		ContentDetails save = conRepo.save(data);
		return save;
	}

	public List<ContentDetails> SendData() {
		List<ContentDetails> findAll = conRepo.findAll();
		return findAll;
	}

}
