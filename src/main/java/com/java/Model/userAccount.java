package com.java.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_account")
public class userAccount {

	@Id
	private String email;
	private String mobile;
	private String name;
	private String address;
	private String accountType;
	private String password;
	private double amount;

	public userAccount(String email, String mobile, String name, String address, String accountType, String password,
			double amount) {
		super();
		this.email = email;
		this.mobile = mobile;
		this.name = name;
		this.address = address;
		this.accountType = accountType;
		this.password = password;
		this.amount = amount;
	}

	public userAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
