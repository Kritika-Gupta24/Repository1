package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetMetaDataDemo {

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
			
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			ResultSetMetaData metaData = rs.getMetaData();
			
			
			// step 4: process the result				
			int columnCount = metaData.getColumnCount();
			System.out.println("Number of Columns: " + columnCount);
			
			for(int i = 1; i <= columnCount; i++) {
				System.out.println("Column Name: " + metaData.getColumnName(i));
                System.out.println("Column Type: " + metaData.getColumnTypeName(i));
                System.out.println("Column Size: " + metaData.getColumnDisplaySize(i));
                System.out.println("Is Nullable: " + metaData.isNullable(i));
                System.out.println("Is Nullable: " + ResultSetMetaData.columnNullable);
                System.out.println("Is Auto Increment: " + metaData.isAutoIncrement(i));
                
                
                boolean isNullable = metaData.isNullable(i) == ResultSetMetaData.columnNullable;
                System.out.println("Boolean equality: " + isNullable);
                
                System.out.println("---------------------------");

			}
			
			while(rs.next()) {
				int customerId = rs.getInt("customer_id");
				String name = rs.getString("customer_name");
				String city = rs.getString("city");
				String email = rs.getString("email");
				
				System.out.println("Customer Id: " + customerId + ", Customer Name: " + name + ", City: " + city + ", Email: " + email);
			}
			
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
				rs.close();
				st.close();
				con.close();
				System.out.println("---------------------------------");
				System.out.println("Connection closed");
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
					
		}

	}

}
