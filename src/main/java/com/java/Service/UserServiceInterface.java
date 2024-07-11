package com.java.Service;

import org.springframework.context.annotation.Configuration;

import com.java.Model.userAccount;
@Configuration
public interface UserServiceInterface {
	
	public userAccount save(userAccount account);
	public boolean LoginValidation(String email,String password);
	public boolean PasswordUpdate(String email,String oldPassword,String newPassword);
	public double creditAmount(String email,double amount);
	public double debitAmount(String email,double amount);
	public boolean accoutValidation(String email);
	public double balance(String email);
	public userAccount getAccount(String email);

}
