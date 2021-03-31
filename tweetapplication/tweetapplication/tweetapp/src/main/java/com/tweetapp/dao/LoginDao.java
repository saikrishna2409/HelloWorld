package com.tweetapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tweetapp.DBConnection;

public class LoginDao {

	public boolean loginUser(String emailId, String password) {

		boolean result = false;
		try {
			String query = "SELECT * from user_details WHERE email_id=? and user_password=?";
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, emailId);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				result = true;
			} else {
				result = false;
			}
			DBConnection.disconnect(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
