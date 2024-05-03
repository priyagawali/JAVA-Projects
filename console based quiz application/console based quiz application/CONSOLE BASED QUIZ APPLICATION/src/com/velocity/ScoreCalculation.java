package com.velocity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.exceptions.StatementIsClosedException;
import com.mysql.cj.xdevapi.ColumnDefinition.StaticColumnDefinition;

public class ScoreCalculation implements ScoreCalulation_Interface{
	
	static CreateConection cc=new CreateConection();
	static Connection con=null;
	static Connection con1=null;
	static PreparedStatement ps=null;
	static PreparedStatement ps1=null;
	 
	static PreparedStatement ps2=null;
	public static int score1;
	 
	

	public static void calScore() throws SQLException {
	    try {
	        con = cc.getconnecion();
	        ps = con.prepareStatement("select * from record_answers");
	        ps1 = con.prepareStatement("UPDATE record_answers SET score = ? where Q_No=?");

	        ResultSet rS = ps.executeQuery();

	        while (rS.next()) {
	            int q_number = rS.getInt(1);
	            String sub_ans = rS.getString(2);
	            String exp_ans = rS.getString(3);

	            int score = (sub_ans.equals(exp_ans)) ? 1 : 0;

	            ps1.setInt(1, score);
	            ps1.setInt(2, q_number);
	            ps1.executeUpdate();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        // Close resources in the finally block
	        if (con != null) {
	            con.close();
	        }

	        if (ps != null) {
	            ps.close();
	        }

	        if (ps1 != null) {
	            ps1.close();
	        }
	    }
	}


	public static int calculatedscore() throws SQLException {
		try {
			
			
			 con1= cc.getconnecion();
			
			 
		
			
			ps2=con1.prepareStatement("SELECT SUM(SCORE) FROM RECORD_ANSWERS");
			ResultSet rs1=ps2.executeQuery();
			while(rs1.next())
			{
			 score1=rs1.getInt(1);
			}
			
				
		}
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		finally {
			
			if(ps2!=null)
			{
				ps2.close();
			}
			if(con1!=null)
			{
				con1.close();
			}
		}
		
		return score1;
	}
	
}

