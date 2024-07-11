package com.java.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.Model.userAccount;
import com.java.Repository.UserRepository;

@Service
public class UserService implements UserServiceInterface {
	@Autowired
	private UserRepository repo;

	@Override
	public userAccount save(userAccount account) {
		userAccount save = repo.save(account);
		return save;
	}

	@Override
	public double creditAmount(String email, double amount) {
		userAccount account = getAccount(email);
		double amount2 = account.getAmount();
		account.setAmount(amount2 + amount);
		repo.save(account);
		return amount + amount2;
	}

	@Override
	public double debitAmount(String email, double amount) {
		userAccount account = getAccount(email);
		double amount2 = account.getAmount();
		account.setAmount(amount2 - amount);
		repo.save(account);
		return amount2 - amount;
	}

	@Override
	public boolean accoutValidation(String email) {
		userAccount account = getAccount(email);
		return account != null;
	}

	@Override
	public double balance(String email) {
		return getAccount(email).getAmount();
	}

	@Override
	public userAccount getAccount(String email) {
		return repo.findById(email).orElse(null);
	}

	@Override
	public boolean LoginValidation(String email, String password) {
		userAccount account = getAccount(email);
		if (account != null) {
			if (account.getPassword().equals(password))
				return true;
		}
		return false;
	}

	@Override
	public boolean PasswordUpdate(String email, String oldPassword, String newPassword) {
		userAccount account = getAccount(email);
		if (account.getPassword().equals(oldPassword)) {
			account.setPassword(newPassword);
			repo.save(account);
			return true;
		}
		return false;
	}

}