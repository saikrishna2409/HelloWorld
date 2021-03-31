package com.tweetapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;

public class DBConnection {

	private static final String URL = "jdbc:mysql://localhost:3306/";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String DBNAME = "tweet_App_DB";
	private static final String PARAMETERS = "?verifyServerCertificate=false&useSSL=true";

	public static Connection getConnection() {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(URL + DBNAME + PARAMETERS, USER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void disconnect(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
