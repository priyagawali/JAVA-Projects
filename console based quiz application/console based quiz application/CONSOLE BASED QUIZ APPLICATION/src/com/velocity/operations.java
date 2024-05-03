package com.velocity;
import java.io.NotActiveException;
import java.sql.SQLException;
import java.time.Year;
import java.util.Scanner;

import javax.print.DocFlavor.STRING;
import javax.swing.text.AbstractDocument.BranchElement;

import com.mysql.cj.log.Log;


public class operations {
	static Scanner scanner = new Scanner(System.in);
	static int choice;
	public static void toContinue() throws SQLException {
	    char ch;
	    System.out.println("Do You Want to continue? press Y for Yes");
	    ch = scanner.next().charAt(0);
	    if (ch == 'Y' || ch == 'y') {
	    	Test.choices();
	        System.out.println("Enter your Choice");
	        choice = scanner.nextInt();
	        PerformOperation(choice);
	    } else {
	        System.out.println("Exiting from This page...Thank You!");
	    }
	}
	
	public static void PerformOperation(int choice) throws SQLException
	{
		
		switch (choice) {
		case 1:
			System.out.println("Let's Do Registration");
			
			System.out.println("Enter the Fname for user: ");
				String Fname=scanner.next();
				
				System.out.println("Enter the Lname for user: ");
				String Lname=scanner.next();
				

				System.out.println("Enter the Username for user: ");
				String Username=scanner.next();
				
				System.out.println("Enter the Password for user: ");
				String Password=scanner.next();
				

				System.out.println("Enter the City for user: ");
				String City=scanner.next();
				
				System.out.println("Enter the Email-id for user: ");
				String Email_id=scanner.next();
				
				
				System.out.println("Enter the Mobile Number for user: ");
				String Mob =scanner.next();
				
				Registration.register(Fname,Lname, Username, Password, City, Email_id, Mob);
				
				
				System.out.println("Done Registration....");
			
			toContinue();
			
			break;
			
		case 2:
			System.out.println("Are you registered Alreay  if yes press Y/y");
			char reg=scanner.next().charAt(0);
			
			if(reg=='y' || reg=='Y')
			{
				
			
		
			System.out.println("Let's Login");
			
			
			System.out.println("Enter Username");
			String user= scanner.next();
			
			System.out.println("Enter Password");
			String pass= scanner.next();
			
			
			Login.validateLogin(user,pass);
			}
			else {
				System.out.println("First You need to Register Yourself");
				PerformOperation(1);
			}
			
	
			
			break;
					
			
			
		case 3:
			if (!Login.isLoggedIn()) {
			    System.out.println("You need to log in first.");
			    PerformOperation(2); // Call the login operation
			}
			
			System.out.println("Let's Start the quiz");
			
			System.out.println("General Instruction:- ");
			System.out.println("1. Candidate Will have 10 question.");
			System.out.println("2. Each question will have 1 mark.");
			System.out.println("3. All questions are compulsory.");
			System.out.println("4. Only one answer is correct for each question ");
			System.out.println("5. Your answer will be considered only if it is A/B/C/D");
			System.out.println("6. Once you mark your answer you are not able to change it ");
			System.out.println("7. There is no negative marking.: This means that you will not be penalized for answering a question incorrectly.");
			System.out.println("BEST LUCK...!");
			
			System.out.println("PRESS y/Y TO START THE TEST");
			char ch=scanner.next().charAt(0);
			if(ch=='Y' || ch=='y')
			{
			
			StartQuiz.startQuiz();
			
			System.out.println("Would like to Finish Exam if Yes Write 'FINISH' as it is");
			String input=scanner.next();
			
			if (input.equals("FINISH"))
			{
				System.out.println("THANK YOU FOR SUBMITTING EXAM ...!");
			}
			
			
			}
			
			toContinue();
			
			break;
			
		case 4:

			
			System.out.println("This For Admin Use Only");
			if(Admin.isAdmin()) {
				System.out.println(" -: RESULT :- ");
			DisplayResult.resultDisplay();
			System.out.println();
			
			}
			else {
				 System.out.println("You are not authorized to see  result. Only admins can .");
		           
			}
			
			toContinue();
			break;
		case 5:
			System.out.println("This For Admin Use Only");
//			System.out.println("Display result(Score) in ascending order");
			if(Admin.isAdmin()) {
				System.out.println(" -: RESULT :- ");
				ResultInAscOrder.AscresultDisplay();
				System.out.println();
			
			}
			else {
				 System.out.println("You are not authorized to see  result. Only admins can .");
		           
			}
			
			toContinue();
			break;
		case 6:
//			System.out.println("Display result by Usrname");
			System.out.println("This For Admin Use Only");
			
			if(Admin.isAdmin()) {
				
				System.out.println("Enter Username To get the Result: ");
				String usernm=scanner.next();
				
				System.out.println(" -: RESULT :- ");
				ResByUsername.SearchResByUserName(usernm);
				System.out.println();
			
			}
			else {
				 System.out.println("You are not authorized to see  result. Only admins can .");
		           
			}
			
			
			
			
			
			toContinue();
			break;
		case 7:
			System.out.println("This For Admin Use Only");
			if(Admin.isAdmin()) {
				
				System.out.println("You are authorized to add a question.");
				System.out.println("Enter your question: ");
		        String question = scanner.nextLine();

		        System.out.println("Enter Option 1: ");
		        String option1 = scanner.nextLine();

		        System.out.println("Enter Option 2: ");
		        String option2 = scanner.nextLine();

		        System.out.println("Enter Option 3: ");
		        String option3 = scanner.nextLine();

		        System.out.println("Enter Option 4: ");
		        String option4 = scanner.nextLine();

	
	            AddQuestion.addquestion(question, option1, option2, option3, option4);
			
			}
			else {
				 System.out.println("You are not authorized to Add question. Only admins can .");
		           
			}
			

			toContinue();
			
			break;
		
		default:

			System.out.println("invalid choice ....");

			toContinue();
			
			break;
		}
	}

}
