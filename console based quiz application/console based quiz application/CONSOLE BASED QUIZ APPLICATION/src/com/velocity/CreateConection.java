package com.velocity;
import java.sql.Connection;
import java.sql.DriverManager;

public class CreateConection {
	public Connection getconnecion() {
		Connection conn=null;
		try {
			//step 1-load teh driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//STEP 2-eshstablish the connection
			
			 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject?useSSL=false", "root", "Prashant@27");
			
			
			
			
//			System.out.println("CONNECTION ESHSTABLISH SUCESSFULLY.......");
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			return conn;
		}
	}
	
}
