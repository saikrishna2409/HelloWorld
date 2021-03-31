package com.tweetapp.service;

import java.util.Scanner;

import com.tweetapp.dao.LoginDao;

public class LoginService {

	Scanner scanner = new Scanner(System.in);

	public void getLogin() {
		System.out.println("*** LOGIN ***");
		System.out.println("Enter User Name -> ");
		String userName = scanner.nextLine();
		System.out.print("Enter password -> ");
		String password = scanner.nextLine();
		LoginDao loginDao = new LoginDao();
		if (loginDao.loginUser(userName, password)) {
			System.out.println(userName + " Logged-in successfully...");
			Menu menu = new Menu();
			menu.getMenu(userName);

		} else {
			System.out.println("Invalid Credentials.Please Try again");
			getLogin();
		}
	}
}
