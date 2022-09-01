package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class ContentDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int contentid;
	@Column
	public String title;
	@Column
	public String contentBy;
	@Column
	public int price;
	@Column
	public String imgloc;

	@Transient
	public MultipartFile image;

	@Transient
	public MultipartFile[] video;

	@Transient
	public String contentids;
	
	@Column
	private String language;

	@Transient
	private int cartid;

	public String getContentids() {
		return contentids;
	}

	public void setContentids(String contentids) {
		this.contentids = contentids;
	}
	
	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getContentid() {
		return contentid;
	}

	public void setContentid(int contentid) {
		this.contentid = contentid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContentBy() {
		return contentBy;
	}

	public void setContentBy(String contentBy) {
		this.contentBy = contentBy;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImgloc() {
		return imgloc;
	}

	public void setImgloc(String imgloc) {
		this.imgloc = imgloc;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "ContentDetails [id=" + contentid + ", title=" + title + ", contentBy=" + contentBy + ", price=" + price
				+ ", imgloc=" + imgloc + ", image=" + image + ", video=" + video + "]";
	}

	public MultipartFile[] getVideo() {
		return video;
	}

	public void setVideo(MultipartFile[] video) {
		this.video = video;
	}

}
