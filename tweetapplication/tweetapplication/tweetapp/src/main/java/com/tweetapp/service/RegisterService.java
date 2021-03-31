package com.tweetapp.service;

import java.util.Scanner;

import com.tweetapp.dao.RegistrationDao;
import com.tweetapp.model.Register;

public class RegisterService {

	Scanner scanner = new Scanner(System.in);

	public void getRegister() {

		System.out.println("*** REGISTRATION ***");
		System.out.print(" Enter firstName -> ");
		String firstName = scanner.nextLine();
		System.out.print(" Enter lastName -> ");
		String lastName = scanner.nextLine();
		System.out.print(" Enter gender -> ");
		String gender = scanner.nextLine();
		System.out.print(" Enter dob in dd-MM-yyyy format=> ");
		String dob = scanner.nextLine();
		System.out.print(" Enter emailId -> ");
		String emailId = scanner.nextLine();
		System.out.print(" Enter password -> ");
		String password = scanner.nextLine();

		if (firstName != null && !firstName.isEmpty() && gender != null && !gender.isEmpty() && emailId != null
				&& !emailId.isEmpty() && password != null && !password.isEmpty() && dob != null && !dob.isEmpty()) {
			String arr[] = dob.split("-");
			if (dob.length() == 10 && arr[0].length() == 2 && arr[1].length() == 2 && arr[2].length() == 4) {// 1996-21-01
				String s = arr[2] + "-" + arr[1] + "-" + arr[0];
				Register user = new Register(firstName, lastName, gender, s, emailId, password);
				RegistrationDao dao = new RegistrationDao();
				if (dao.insertUser(user)) {
					System.out.println("Registration Successfull!!");
					System.out.println("Please Login");
					LoginService login = new LoginService();
					login.getLogin();
				} else {
					System.out.println("Registration failed - email already exist!");
					getRegister();
				}
			} else {
				System.out.println("InCorrect date format please give proper format dd-mm-yyyy");
				getRegister();
			}
		} else {
			System.out.println("Registration failed - One or more required fields are empty please try again");
			getRegister();
		}
	}
}