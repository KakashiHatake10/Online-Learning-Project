package com.example.demo.services.User;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.Content_detailsRepository;
import com.example.demo.entity.ContentDetails;

@Service
public class ContentLinksServices {

	@Autowired
	Content_detailsRepository con;

	public List<ContentDetails> getImageData() {

		List<ContentDetails> findAll = con.findAll();

		return findAll;
	}

	// fetch single content data

	public List<ContentDetails> getInfoSingle(String language) {

		List<ContentDetails> findByLanguage = con.findByLanguage(language);

		for (ContentDetails contentDetails : findByLanguage) {
			System.out.println(contentDetails);
		}
		return findByLanguage;

	}

}
