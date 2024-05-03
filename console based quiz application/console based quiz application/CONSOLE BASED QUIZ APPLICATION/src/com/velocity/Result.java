package com.velocity;
import com.velocity.Login;
import com.velocity.ScoreCalculation;
import com.velocity.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Result implements Result_Interface {
	static CreateConection cc=new CreateConection();
	static Connection con=null;
	static PreparedStatement ps=null;
	static char grade;
	
	
	public static void storeResult() throws SQLException {
	    try {
	        con = cc.getconnecion();

	        if (Login.isLoggedIn()) {
	            String loggedInUsername = Login.LoggediUserName();
	            int marks = ScoreCalculation.calculatedscore();

	            if (marks <= 2) {
	                grade = 'D';
	            } else if (marks <= 5) {
	                grade = 'C';
	            } else if (marks <= 8) {
	                grade = 'B';
	            } else if (marks <= 10) {
	                grade = 'A';
	            }

	            ps = con.prepareStatement("INSERT INTO result ( USERNAME, SCORE, GRADE) VALUES (?, ?, ?)");

	            ps.setString(1, loggedInUsername);
	            ps.setInt(2, marks);
	            ps.setString(3, String.valueOf(grade));

	            ps.executeUpdate();
	        } else {
	            operations.PerformOperation(2);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (con != null) {
	            con.close();
	        }
	        if (ps != null) {
	            ps.close();
	        }
	    }
	}

}
