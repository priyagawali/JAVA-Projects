package com.velocity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Record_candidate_Answers implements RecordCandidateAnswers_Interface {
	 static CreateConection cc=new CreateConection();
	static Connection con=null;
	static PreparedStatement ps=null;
	 
	 
	 public static void recordAnswers(int q_no,String answer ) throws SQLException
	 {
		
		 
		
		try {
			
			 con= cc.getconnecion();
			 
			 //step 3-prepare statement 
			ps = con.prepareStatement("UPDATE record_answers SET submittedAnswer = ? WHERE Q_No = ?");
		
			ps.setString(1, answer);
			ps.setInt(2, q_no);
			
			//step 4-submit/excute query
			
			ps.executeUpdate();
			
			
			//step 5- process result internally
		
		} catch (SQLException e)
		{
		
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
