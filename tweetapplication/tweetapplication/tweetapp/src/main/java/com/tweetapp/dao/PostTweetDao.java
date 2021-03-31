package com.tweetapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.tweetapp.DBConnection;
import com.tweetapp.model.Tweet;

public class PostTweetDao {

	public boolean postATweet(Tweet tweet) {

		boolean result = false;
		try {
			String sql = "insert into tweet_details VALUES(?,?)";
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, tweet.getUserName());
			preparedStatement.setString(2, tweet.getTweet());
			int inserted = preparedStatement.executeUpdate();
			result = inserted >= 1;
			DBConnection.disconnect(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
