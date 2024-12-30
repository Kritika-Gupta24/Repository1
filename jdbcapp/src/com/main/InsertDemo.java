package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDemo {

	public static void main(String[] args) {
		
		
		String driverName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/wiprobatch5db";
		String username = "root";
		String password = "SecurityHigh@8777*";
		Connection con = null;
		
		try {
			// step 1: Load the driver
			Class.forName(driverName);
			System.out.println("Driver loaded");
			
			// step 2: Establish the connection
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection established");
			
			// step 3: perform database operations
			//String sql = "insert into customer_tbl values(10001, 'Harry Potter', 'London', 'harry@gmail.com')";
			String sql = "insert into customer_tbl values(10002, 'KL Rahul', 'Bangalore', 'rahul@gmail.com')";
			
			Statement st = con.createStatement();   // creating a statement object which will submit the sql string to the driver
			
			st.executeUpdate(sql);  // submitting the sql string to the driver
			                       // executeUpdate method id used for insertion, updation and deletion
			
			// step 4: process the result
			System.out.println("New Customer Added");
			
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			// step 5: close the connection
			try {
				con.close();
				System.out.println("Connection closed");
			}
			catch(SQLException e) {
				e.printStackTrace();
			}					
		}
		
	}

}
