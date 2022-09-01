package com.example.demo.services.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.BuyCourseRepository;
import com.example.demo.entity.BuyCourse;

@Service
public class BuyCourseService {

	@Autowired
	BuyCourseRepository order;
	
	public void orderService(BuyCourse buy) {
		
		long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
		buy.setTransaction(number);
		order.save(buy);
		
	}

}
