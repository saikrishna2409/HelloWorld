package com.tweetapp.service;

import java.util.Scanner;

import com.tweetapp.dao.ForgotPasswordDao;

public class ForgotPassword {

	Scanner scanner = new Scanner(System.in);

	public void forgotPassword() {

		System.out.println("*** To reset Password username is required ***");
		System.out.println("Enter User Name -> ");
		String userName = scanner.nextLine();
		System.out.print("Enter New password -> ");
		String newPassword = scanner.nextLine();
		ForgotPasswordDao forgotPasswordDao = new ForgotPasswordDao();
		if (forgotPasswordDao.forgotPasswordDao(userName, newPassword)) {
			System.out.println("Password reset successfull - Please Login");
			LoginService loginService = new LoginService();
			loginService.getLogin();
		} else {
			System.out.println(" Password reset failed...");
		}
	}
}