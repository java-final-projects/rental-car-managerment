package application;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import user.LoginDao;
import user.RegisterDao;
import user.UserService;

public class Application {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		System.out.println("================= Welcome to Rental car managerment system ==================");
		System.out.println("================= Please choose menu option bellow===========================");
		System.out.println("1: Register");
		System.out.print("");
		System.out.println("2: Login ");
		System.out.print("");
		System.out.print("Enter here: ");
		ResultSet resultSet;
		Scanner input = new Scanner(System.in);
		UserService authUser = new UserService();
		int userInput = input.nextInt();
		switch (userInput) {
			case 1: 
				RegisterDao register = new RegisterDao();
				register.registerUser();
				break;
			case 2: 
				LoginDao login = new LoginDao();
				String getEmail = login.Login();
				System.out.println(getEmail);
				if(getEmail != null) {
					UserService userDB = new UserService();
			    	resultSet = userDB.findOne(getEmail);
			    	 while(resultSet.next()) {
			    		 if(resultSet.getString(9) == "OWNER") {
			    			 System.out.println("====================== You are owner user ==================");
			    			 System.out.println("0: Logout");
			    			 System.out.println("1: Car list");
			    			 System.out.println("2: ");
			    		 } else {
			    			 System.out.println("====================== You are guest user ==================");
			    			 System.out.println("0: Logout");
			    			 System.out.println("1: Car list");
			    		 }
			    	 }
				}
				break;
		}
	}
}
