package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ContentDetails;

public interface Content_detailsRepository extends JpaRepository<ContentDetails, Integer> {

	public List<ContentDetails> findByLanguage(String name);

	public ContentDetails findByContentid(int content);
}
