package com.tweetapp;

import java.util.Scanner;

import com.tweetapp.service.LoginService;
import com.tweetapp.service.RegisterService;
import com.tweetapp.service.ForgotPassword;

public class App {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("****** TWEET APP ******");
		System.out.println("Introduction Menu");
		System.out.println("1. Register");
		System.out.println("2. Login");
		System.out.println("3. Forget Password");
		System.out.println("Enter your choice : ");
		String choice = scanner.nextLine();

		switch (choice) {
		case "1":
			RegisterService registerService = new RegisterService();
			registerService.getRegister();
		case "2":
			LoginService loginService = new LoginService();
			loginService.getLogin();
		case "3":
			ForgotPassword forgotPassword = new ForgotPassword();
			forgotPassword.forgotPassword();
		default:
			System.out.println("Please enter a valid choice");
			main(args);
		}
		scanner.close();
	}
}