package com.tweetapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;

import com.tweetapp.DBConnection;
import com.tweetapp.model.Tweet;

public class ViewTweetsDao {

	public ArrayList<Tweet> getMyTweets(String userName) {

		ArrayList<Tweet> arrayList = new ArrayList<Tweet>();
		try {
			String query = "SELECT * from tweet_details WHERE user_name=?";
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userName);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Tweet tweet = new Tweet();
				tweet.setTweet(resultSet.getString(2));
				tweet.setUserName(resultSet.getString(1));
				arrayList.add(tweet);
			}
			DBConnection.disconnect(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayList;
	}

	public ArrayList<Tweet> getAllTweets() {
		ArrayList<Tweet> arrayList = new ArrayList<Tweet>();
		try {
			String query = "SELECT * from tweet_details";
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Tweet tweet = new Tweet();
				tweet.setTweet(resultSet.getString(2));
				tweet.setUserName(resultSet.getString(1));
				arrayList.add(tweet);
			}
			DBConnection.disconnect(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayList;
	}

	public HashSet<String> getAllUsers() {
		HashSet<String> hashSet = new HashSet<String>();
		try {
			String query = "SELECT * from user_details";
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				hashSet.add(resultSet.getString(4));
			}
			DBConnection.disconnect(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hashSet;
	}
}
