package com.banks.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConfig {

	static Connection con = null;

	public static Connection getConnection()
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {

		if(con == null) {
			String url = "jdbc:mysql://localhost:3306/banks_api";
			String user = "root";
			String password = "";
	
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url, user, password);
		}
		
		return con;
	}

	public static void closeConnection() throws SQLException {
		con.close();
	}

}
