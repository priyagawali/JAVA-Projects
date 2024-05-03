package com.velocity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResByUsername implements ResByUserName_Interface{
	static CreateConection cc=new CreateConection();
	static Connection con=null;
	static PreparedStatement ps=null;
	
	public static void SearchResByUserName(String user_name) throws SQLException 
	{
		
		try {
			
			con=cc.getconnecion();
			
			//step 3-prepare statement
			ps= con.prepareStatement("SELECT * FROM miniproject.result WHERE username=?");
			
			ps.setString(1, user_name);
			//step 4-excutequery
			ResultSet rs =ps.executeQuery();
			//show result in tabular form
			System.out.printf("%-5s%-20s%-10s%-5s\n", "ID", "USERNAME", "SCORE", "GRADE");
			
			while(rs.next())
			{
				int id=rs.getInt(1);
				//System.out.println("ID" +id +"\t");
				
				String username=rs.getString(2);
				//System.out.println("USERNAME "+username+"\t");
				
				int SCORE=rs.getInt(3);
				//System.out.println("SCORE "+SCORE+"\t");
				
				String grade=rs.getString(4);
				//System.out.println("GRADE "+grade+"\t");
				  // Format and print each row
				System.out.printf("%-5d%-20s%-10d%-5s\n", id, username, SCORE, grade);

			}
			
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally 
		{
			if(con!=null)
			{
				con.close();
			}
			if(ps!=null)
			{
				ps.close();
			}
		}
	}


}
