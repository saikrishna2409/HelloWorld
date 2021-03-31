package com.tweetapp.service;

import java.util.Scanner;

import com.tweetapp.dao.PostTweetDao;
import com.tweetapp.model.Tweet;

public class PostTweet {

	Scanner scanner = new Scanner(System.in);

	public void postTweet(String userName) {

		System.out.println("***POST TWEET ***");
		System.out.print("Enter a Tweet -> ");
		String tweet = scanner.nextLine();
		Tweet tweetObject = new Tweet();
		tweetObject.setTweet(tweet);
		tweetObject.setUserName(userName);
		PostTweetDao postTweetDao = new PostTweetDao();
		if (postTweetDao.postATweet(tweetObject)) {
			System.out.println("Tweet Posted");
			Menu menu = new Menu();
			menu.getMenu(userName);
		} else {
			System.out.println("Tweet Post Failed");
		}
	}
}