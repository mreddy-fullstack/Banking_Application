package com.java.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.Model.userAccount;
import com.java.Service.UserServiceInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserServiceInterface service;

	@GetMapping("/getAccount")
	public ResponseEntity<userAccount> getAccount(@RequestParam String email) {
		return ResponseEntity.ok(service.getAccount(email));
	}

	@PostMapping("/save")
	public ResponseEntity<userAccount> saveAccount(@RequestBody userAccount account) {
		return ResponseEntity.ok(service.save(account));
	}

	@PostMapping("/login")
	public ResponseEntity<String> Login(@RequestParam String email, @RequestParam String password) {
		boolean validation = service.LoginValidation(email, password);
		if (validation)
			return new ResponseEntity<>("Succesfully login", HttpStatus.OK);
		return new ResponseEntity<>("Invalid user details please check and reenter", HttpStatus.UNAUTHORIZED);
	}

	@PostMapping("/UpdatePassword")
	public ResponseEntity<String> PasswordUpdate(@RequestParam String email, @RequestParam String oldPassword,
			@RequestParam String newPassword) {
		boolean valid = service.PasswordUpdate(email, oldPassword, newPassword);
		if (valid)
			return new ResponseEntity<>("succesfully updated your password", HttpStatus.OK);
		return new ResponseEntity<>("old password doesnot match", HttpStatus.UNAUTHORIZED);
	}

	@PostMapping("/CreditAmount")
	public ResponseEntity<String> creditAmount(@RequestParam String email, @RequestParam double amount) {
		double balance = service.creditAmount(email, amount);
		return ResponseEntity.ok("Your current account balance is  : " + balance);
	}

	@GetMapping("/getBalance")
	public ResponseEntity<String> getBalance(@RequestParam String email) {
		return ResponseEntity.ok("Your current account balance is " + service.balance(email));
	}

	@PostMapping("/debitAmount")
	public ResponseEntity<String> DebitAmount(String email, double amount) {
		if (service.balance(email) >= amount) {
			double debitAmount = service.debitAmount(email, amount);
			return ResponseEntity.ok("In your account amount has debited and know current balance is " + debitAmount);
		}
		return ResponseEntity.ok("You have in sufficent funds in your account");
	}

	@PutMapping("/transfor")
	public ResponseEntity<String> putMethodName(@RequestParam String fromemail, @RequestParam String toemail,
			@RequestParam double amount) {
		if (service.accoutValidation(toemail)) {
			if (service.balance(fromemail) >= amount) {
				double debitAmount = service.debitAmount(fromemail, amount);
				service.creditAmount(toemail, debitAmount);
				return ResponseEntity
						.ok("In your account amount has debited and know current balance is " + debitAmount);
			}
			return ResponseEntity.ok("You have in sufficent funds in your account");
		}
		return ResponseEntity.ok("Invalid account plese check respcted account");
	}

}
