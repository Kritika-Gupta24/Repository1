package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String driverName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/wiprobatch5db";
		String username = "root";
		String password = "SecurityHigh@8777*";
		
		// step 1: Load the driver
		Class.forName(driverName);
		System.out.println("Driver loaded");
		
		// step 2: Establish the connection
		Connection con = DriverManager.getConnection(url, username, password);
		System.out.println("Connection established");
		
		// step 3: perform database operations
		
		// step 4: process the result
		
		// step 5: close the connection
		con.close();
		System.out.println("Connection closed");
	}

}