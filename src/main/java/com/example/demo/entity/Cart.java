package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartid;
	@Column
	private String title;
	@Column
	private String price;
	@Column
	private String loginid ;
	@Column
	private String contentid;

	public int getCartid() {
		return cartid;
	}

	@Override
	public String toString() {
		return "Cart [cartid=" + cartid + ", title=" + title + ", price=" + price + ", login_id=" + loginid
				+ ", contentid=" + contentid + "]";
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getContentid() {
		return contentid;
	}

	public void setContentid(String contentid) {
		this.contentid = contentid;
	}

}
