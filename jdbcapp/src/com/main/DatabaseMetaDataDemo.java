package com.main;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseMetaDataDemo {

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
			DatabaseMetaData metaData = con.getMetaData();
			
			String databaseProductName = metaData.getDatabaseProductName();
            String databaseProductVersion = metaData.getDatabaseProductVersion();
            String driverName_md = metaData.getDriverName();
            String driverVersion = metaData.getDriverVersion();
            String url_md = metaData.getURL();
            String userName = metaData.getUserName();
            
            ResultSet tables = metaData.getTables(null, null, "%", new String[] {"TABLE"});
            ResultSet columns = metaData.getColumns(null, null, "customer_tbl", "%");

			
			// step 4: process the result	  
            System.out.println("--------------------------------------");
            System.out.println("Database Product Name: " + databaseProductName);
            System.out.println("Database Product Version: " + databaseProductVersion);
            System.out.println("Driver Name: " + driverName_md);
            System.out.println("Driver Version: " + driverVersion);
            System.out.println("URL: " + url_md);
            System.out.println("User Name: " + userName);
            
            System.out.println("--------------------------------------");
            System.out.println("TABLES:\n");
            
            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                String tableType = tables.getString("TABLE_TYPE");
                System.out.println("Table Name: " + tableName + ", Table Type: " + tableType);
            }
            
            System.out.println("--------------------------------------");
            System.out.println("Columns in 'customers_tbl' table:");
            while (columns.next()) {
                String columnName = columns.getString("COLUMN_NAME");
                String columnType = columns.getString("TYPE_NAME");
                int columnSize = columns.getInt("COLUMN_SIZE");
                boolean isNullable = columns.getInt("NULLABLE") == DatabaseMetaData.columnNullable;

                System.out.println("Column Name: " + columnName + ", Column Type: " + columnType + ", Column Size: " + columnSize + ", Is Nullable: " + isNullable);
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
				System.out.println("--------------------------------------");
				con.close();
				
				System.out.println("Connection closed");
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
					
		}

	}

}
