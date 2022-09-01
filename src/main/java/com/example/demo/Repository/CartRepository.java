package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	public List<Cart> findByLoginid(String name);

	@Transactional
	@Modifying
	@Query("Delete FROM Cart c Where c.loginid =:n  and c.contentid =:m")
	public int deleteByLoginidAndContentid(@Param("n") String loginid, @Param("m") String contentid);
}
