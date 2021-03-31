package com.tweetapp.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.*;
import com.tweetapp.App;
import com.tweetapp.model.Tweet;

public class Menu {

	Scanner scanner = new Scanner(System.in);

	public void getMenu(String userName) {

		System.out.println("*** Menu Page ***");
		System.out.println("Your choices:");
		System.out.println("1. Post a tweet");
		System.out.println("2. View my tweets");
		System.out.println("3. View all Users");
		System.out.println("4. View all tweets");
		System.out.println("5. Reset Password");
		System.out.println("6. Logout");
		System.out.println("Enter your choice :");
		String choice = scanner.nextLine();
		switch (choice) {

		case "1":
			PostTweet postTweet = new PostTweet();
			postTweet.postTweet(userName);
		case "2":
			ViewTweets viewTweets = new ViewTweets();
			ArrayList<Tweet> arrayList = viewTweets.getMyTweets(userName);
			if (arrayList.isEmpty()) {
				System.out.println("No tweets available");
				getMenu(userName);
			} else {
				System.out.println("My Tweets");
				for (int i = 0; i < arrayList.size(); i++) {
					System.out.println("" + arrayList.get(i).getTweet());
				}
				getMenu(userName);
			}
		case "3":
			viewTweets = new ViewTweets();
			HashSet<String> hashSet = viewTweets.getAllUserList();
			if (hashSet.isEmpty()) {
				System.out.println("No users found");
				getMenu(userName);
			} else {
				System.out.println("All users");
				Iterator<String> i = hashSet.iterator();
				while (i.hasNext())
					System.out.println(i.next());
				getMenu(userName);
			}
		case "4":
			ViewTweets viewTweet = new ViewTweets();
			arrayList = viewTweet.getAllUserTweets();
			if (arrayList.isEmpty()) {
				System.out.println("No tweets avialable!");
				getMenu(userName);
			} else {
				System.out.println("__All tweets__");
				for (int i = 0; i < arrayList.size(); i++) {
					System.out.println("" + arrayList.get(i).getTweet());
				}
				getMenu(userName);
			}
		case "5":
			ResetPassword resetPassword = new ResetPassword();
			System.out.println("Enter old password");
			String oldPassword=scanner.next();
			resetPassword.resetPassword(userName,oldPassword);
			getMenu(userName);
		case "6":
			App.main(null);
		default:
			System.out.println("Invalid Choice, Please enter a valid choice");
			getMenu(userName);
		}
	}
}