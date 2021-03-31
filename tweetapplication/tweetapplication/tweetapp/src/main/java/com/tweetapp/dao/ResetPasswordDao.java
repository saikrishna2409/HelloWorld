package com.tweetapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tweetapp.DBConnection;

public class ResetPasswordDao {

	public boolean oldPasswordCheck(String userName, String oldPassword) {
		
		boolean result = false;
		try {
			String query = "SELECT * from user_details WHERE email_id=? AND user_password=?";
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, oldPassword);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				result = true;
			}
			DBConnection.disconnect(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	public boolean resetPassword(String userName, String newPassword) {

		boolean result = false;
		try {
			String updateQuery = "UPDATE user_details SET user_password =? WHERE email_id =?";
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, newPassword);
			preparedStatement.setString(2, userName);
			int inserted = preparedStatement.executeUpdate();
			result = inserted >= 1;
			DBConnection.disconnect(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
