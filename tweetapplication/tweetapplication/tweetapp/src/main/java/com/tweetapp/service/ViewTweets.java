package com.tweetapp.service;

import java.util.ArrayList;
import java.util.HashSet;

import com.tweetapp.dao.ViewTweetsDao;
import com.tweetapp.model.Tweet;

public class ViewTweets {

	public ArrayList<Tweet> getMyTweets(String userName) {

		ViewTweetsDao viewTweetsDao = new ViewTweetsDao();
		ArrayList<Tweet> arrayList = viewTweetsDao.getMyTweets(userName);
		return arrayList;
	}

	public ArrayList<Tweet> getAllUserTweets() {

		ViewTweetsDao viewTweetsDao = new ViewTweetsDao();
		ArrayList<Tweet> arrayList = viewTweetsDao.getAllTweets();
		return arrayList;
	}

	public HashSet<String> getAllUserList() {
		ViewTweetsDao viewTweetsDao = new ViewTweetsDao();
		HashSet<String> arrayList = viewTweetsDao.getAllUsers();
		return arrayList;
	}
}