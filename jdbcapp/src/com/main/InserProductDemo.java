package com.main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserProductDemo {

	public static void main(String[] args) {
		
		Connection con = DBUtil.getDBConnection();
		PreparedStatement ps = null;
		
		String sql = "insert into product_tbl(product_name, product_price, mfd, category) values(?, ?, ?, ?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,  "ScanDisk");
			ps.setDouble(2, 1500.00);
			ps.setDate(3, new Date(2024,12,27));
			ps.setString(4,  "PenDrive");
			
			ps.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(con != null) {
				try {
					con.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}

	}

}
