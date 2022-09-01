package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.BuyCourse;

public interface BuyCourseRepository extends JpaRepository<BuyCourse, Integer> {

	public List<BuyCourse> findByEmail(String email);

}
