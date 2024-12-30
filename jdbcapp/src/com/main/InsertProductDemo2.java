package com.main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertProductDemo2 {

	public static void main(String[] args) {
		
		String sql = "insert into product_tbl(product_name, product_price, mfd, category) values(?, ?, ?, ?)";
		
		// try with resource
		try(
				Connection con = DBUtil.getDBConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				) {
			
			ps.setString(1,  "SonyE26");
			ps.setDouble(2, 1500.00);
			ps.setDate(3, new Date(2024,12,27));
			ps.setString(4,  "Music");
			
			ps.executeUpdate();
			System.out.println("New Product Added");
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
