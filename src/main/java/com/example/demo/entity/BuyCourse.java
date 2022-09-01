package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BuyCourse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idNo;
	@Column
	private String email;
	@Column
	private long transaction;
	@Column
	private String price;
	@Column
	private String titleid;
	@Column
	private String cardno;

	public String getTitleid() {
		return titleid;
	}

	public void setTitleid(String titleid) {
		this.titleid = titleid;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public int getIdNo() {
		return idNo;
	}

	public void setIdNo(int idNo) {
		this.idNo = idNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getTransaction() {
		return transaction;
	}

	public void setTransaction(long transaction) {
		this.transaction = transaction;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "BuyCourse [idNo=" + idNo + ", email=" + email + ", transaction=" + transaction + ", price=" + price
				+ ", titleid=" + titleid + ", cardno=" + cardno + "]";
	}
}