package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:MAHESH";
		String user = "SCOTT";
		String pass = "tiger";
		
		try {
			System.out.println("Connecting to database: " + jdbcURL);
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection(jdbcURL, user, pass);
			
			System.out.println("Connection Successfull :");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
