package com.velocity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Registration implements Registration_Interface{
	static CreateConection c=new CreateConection();
	static Connection con=null;

	static PreparedStatement ps=null;

	
	public static void register(String Fname, String Lname, String Username,String Password,String City,String Email_id,String Mob) throws SQLException
	{
		
		
		try 
	  {
			
			 con=c.getconnecion();
		
		
		//step 3-prepare statement
		 ps=con.prepareStatement("insert into registrationdata (Fname,Lname, Username, Password, City, Email_id, Mob) values(?,?,?,?,?,?,?)");
//		-- insert into registrationdata (Fname,Lname, Username, Password, City, Email_id, Mob) values('priya', 'gawali', 'piya', 'gawali@123', 'shirdi', 'priyanka2614@gmail.com','9878987899');

		 ps.setString(1, Fname);
		 ps.setString(2,Lname );
		 ps.setString(3, Username);
		 ps.setString(4, Password);
		 ps.setString(5, City);
		 ps.setString(6, Email_id);
		 ps.setString(7, Mob);
		 
		 //step 4-submit query
		 ps.executeUpdate();
		 
		 
		 //step 5-process teh result will be done by the java
		 
		 
	  }
		catch (Exception e) 
		{
			e.printStackTrace();
			// TODO: handle exception
		}
		finally
		{
			//step 6-clos ethe resources
			
			if(con!=null) {
				con.close();}
			if(ps!=null) {
			ps.close();}
			
		}
	}
	
	

}
