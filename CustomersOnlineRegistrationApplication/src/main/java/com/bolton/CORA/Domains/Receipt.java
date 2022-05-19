package com.bolton.CORA.Domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recipts")
public class Receipt {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ReciptID")
	private long reciptId;

	@Column(name = "total")
	private int paid;

	@Column(name = "date")
	private String date;

	@Column(name = "email")
	private String email;

	public Receipt(int paid, String date, String email) {
		super();
		this.paid = paid;
		this.date = date;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Receipt [paid=" + paid + ", date=" + date + ", email=" + email + "]";
	}

	public int getPaid() {
		return paid;
	}

	public String getDate() {
		return date;
	}

	public String getEmail() {
		return email;
	}
}