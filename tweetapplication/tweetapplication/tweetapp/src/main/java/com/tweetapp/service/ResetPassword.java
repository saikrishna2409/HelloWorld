package com.tweetapp.service;

import java.util.Scanner;

import com.tweetapp.dao.ResetPasswordDao;

public class ResetPassword {
	Scanner scanner = new Scanner(System.in);

	Menu menu = new Menu();
	public void resetPassword(String userName, String oldPassword) {

		ResetPasswordDao resetPasswordDao = new ResetPasswordDao();
		if (resetPasswordDao.oldPasswordCheck(userName, oldPassword)) {
			System.out.print("Enter New password -> ");
			String newPassword = scanner.nextLine();
			if (resetPasswordDao.resetPassword(userName, newPassword)) {
				System.out.println("Password Resetted Successfully...");
				menu.getMenu(userName);
			} else {
				System.out.println("Failed to Reset password...");
			}

		} else {
			System.out.println("Incorrect user name or password...");
			menu.getMenu(userName);
		}
	}

}
