package com.tweetapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tweetapp.DBConnection;
import com.tweetapp.model.Register;

public class RegistrationDao {

	public boolean insertUser(Register user) {

		boolean result = false;
		try {
			String query = "select * from user_details where email_id = ?";
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getEmailId());
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				System.out.println("User already exist...");
			} else {
				query = "Insert into user_details VALUES(?, ?, ?, ?, ?, ?)";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, user.getFirstName());
				preparedStatement.setString(2, user.getLastName());
				preparedStatement.setString(3, user.getGender());
				preparedStatement.setString(4, user.getEmailId());
				preparedStatement.setString(5, user.getDob());
				preparedStatement.setString(6, user.getPassword());
				int inserted = preparedStatement.executeUpdate();
				result = inserted >= 1;
				DBConnection.disconnect(connection);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
