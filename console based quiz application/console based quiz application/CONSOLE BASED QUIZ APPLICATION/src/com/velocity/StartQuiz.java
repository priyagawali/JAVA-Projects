package com.velocity;
import com.velocity.Record_candidate_Answers;
import com.velocity.ScoreCalculation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StartQuiz implements StartQuiz_Interafce {
	static Scanner scanner=new Scanner(System.in);
	static CreateConection cc=new CreateConection();
	static Connection con=null;
	static PreparedStatement ps=null;
	static ResultSet rSet=null;
	
	public static void startQuiz() throws SQLException
	{
		
		try {
			con=cc.getconnecion();
			
			//step 3-prepare statement
			
			PreparedStatement ps=con.prepareStatement("SELECT * FROM QUIZDATA ORDER BY RAND() LIMIT 10; ");
			
			//step 4- submit query
			
			 rSet=ps.executeQuery();
			 
			 while(rSet.next())
			 {
				 
				 int Q_no=rSet.getInt(1);
				 System.out.print("Question - " );
				 
				 String Question_1=rSet.getString(2);
				 System.out.println(Question_1);
				 
				 
				 
				 String Option_1=rSet.getString(3);
				 System.out.println(Option_1);
				 
				 String Option_2=rSet.getString(4);
				 System.out.println(Option_2);
				 
				 String Option_3=rSet.getString(5);
				 System.out.println(Option_3);
				 
				 String Option_4=rSet.getString(6);
				 System.out.println(Option_4);
				 
				 System.out.println("Enter Answer: ");
				 String answer=scanner.next();
				 
				Record_candidate_Answers.recordAnswers(Q_no, answer);
			
				ScoreCalculation.calScore();

								 
			}
			 Result.storeResult();

			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		 finally {
	            // Close resources in the finally block
	            if (con != null) {
	                con.close();
	            }
	            if (ps != null) {
	                ps.close();
	            }
	            if (rSet != null) {
	                rSet.close();
	            }
		}
		
	}
	
	

}
