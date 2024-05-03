package com.velocity;

import java.util.Scanner;

public class Admin {
       static Scanner scanner=new Scanner(System.in);
       
	public static boolean isAdmin()
	{
		System.out.println("Enter Admin Username: ");
		String Adminuser=scanner.next();
		
		System.out.println("Enter Admin Password: ");
		String Adminpass=scanner.next();
		
		if(Adminuser.equals("root") && Adminpass.equals("root"))
		{
		return true;
		}
		else {
			return false;
		}
	}
}
