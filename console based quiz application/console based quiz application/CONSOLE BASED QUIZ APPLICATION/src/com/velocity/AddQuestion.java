package com.velocity;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.time.Year;
import java.util.Scanner;

import javax.print.DocFlavor.STRING;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.mysql.cj.xdevapi.ColumnDefinition.StaticColumnDefinition;



public class AddQuestion {
	
	static CreateConection cc=new CreateConection();
	static Connection con=null;
	static PreparedStatement ps=null;
	static Scanner scanner=new Scanner(System.in);

	
	public static void addquestion( String question,String opt1,String opt2,String opt3,String opt4) throws SQLException
	{

				try {
					
					con=cc.getconnecion();
					
					//step 3-prepare statement
					ps= con.prepareStatement("insert into quizdata (Question,Option1,Option2,Option3,Option4) values (?,?,?,?,?)");
					
					ps.setString(1, question);
					ps.setString(2, opt1);
					ps.setString(3, opt2);
					ps.setString(4, opt3);
					ps.setString(5, opt4);
					
					
					//step 4-excutequery
					
					ps.executeUpdate();
					
					
					System.out.println("Question Added Sucessfully...");
					
					
					
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
		
		
		
	



