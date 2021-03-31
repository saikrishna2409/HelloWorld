package com.tweetapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tweetapp.DBConnection;

public class ForgotPasswordDao {

	public boolean forgotPasswordDao(String emailId, String newPassword) {

		boolean result = false;
		try {
			String query = "SELECT * from user_details WHERE email_id=?";
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, emailId);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				String updateQuery = "UPDATE user_details SET user_password =? WHERE email_id =?";
				preparedStatement = connection.prepareStatement(updateQuery);
				preparedStatement.setString(1, newPassword);
				preparedStatement.setString(2, emailId);
				int inserted = preparedStatement.executeUpdate();
				result = inserted >= 1;
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
