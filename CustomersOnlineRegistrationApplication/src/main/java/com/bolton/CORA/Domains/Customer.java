package com.bolton.CORA.Domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers_details")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CustomerID")
	private long customerID;

	@Column(name = "Name")
	private String name;

	@Column(name = "Surname")
	private String surname;

	@Column(name = "Address")
	private String address;

	@Column(name = "Phone")
	private long phone;

	@Column(name = "Email")
	private String email;

	@Column(name = "Password")
	private String password;

	public Customer() {

	}

	public Customer(String name, String surname, String address, long phone, String email, String password) {
		super();
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", name=" + name + ", surname=" + surname + ", address=" + address
				+ ", phone=" + phone + ", email=" + email + ", password=" + password + "]";
	}

	public long getCustomerID() {
		return customerID;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getAddress() {
		return address;
	}

	public long getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
}