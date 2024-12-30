package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectDemo {

	public static void main(String[] args) {
		
		String driverName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/wiprobatch5db";
		String username = "root";
		String password = "SecurityHigh@8777*";
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			// step 1: Load the driver
			Class.forName(driverName);
			System.out.println("Driver loaded");
			
			// step 2: Establish the connection
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection established");
			
			// step 3: perform database operations
			String sql = "select * from customer_tbl";
			
			st = con.createStatement();   // creating a statement object which will submit the sql string to the driver
			
			rs = st.executeQuery(sql);  // submitting the sql string to the driver
			                       // executeQuery method is used for selection
			
			// step 4: process the result
			while(rs.next()) {
				int customerId = rs.getInt(1);
				String customerName = rs.getString(2);
				String city = rs.getString("city");
				String email = rs.getString(4);
				System.out.println(customerId + " " + customerName + " " + city + " " + email);
			}
			
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			// step 5: close the resources and connection
			try {
				rs.close();
				st.close();
				con.close();
				System.out.println("Connection closed");
			}
			catch(SQLException e) {
				e.printStackTrace();
			}					
		}

	}

}
