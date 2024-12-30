package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDemo {

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
			String sql = "update customer_tbl set city = ? where customer_id = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1,  "Lucknow");
			ps.setInt(2,  1113);
			
			ps.executeUpdate();
			
			// step 4: process the result
			System.out.println("Customer Recor Updated");
			
			
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
