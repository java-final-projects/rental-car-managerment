package application;
import view.Menu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import car.CarService;
import car.Views;
import user.LoginDao;
import user.RegisterDao;
import user.UserService;
import user.ViewUser;

public class Application {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ResultSet resultSet;
		int userInput = 0;
			do {
				Menu menu = new Menu();
				menu.menu();
				try {
					Scanner input = new Scanner(System.in);
					userInput = input.nextInt();
					switch (userInput) {
					case 1: 
						RegisterDao register = new RegisterDao();
						register.registerUser();
						userInput = 0;
						break;
					case 2: 
						LoginDao login = new LoginDao();
						String getEmail = login.Login();
						while(getEmail == null) {
							getEmail = login.Login();
						}
						if(getEmail != null) {
							UserService userDB = new UserService();
					    	resultSet = userDB.findOne(getEmail);
					    	 while(resultSet.next()) {
					    		 if(resultSet.getString(9).equals("OWNER")) {
					    			 System.out.println("====================== You are owner user ==================");
					    			 System.out.println("0: Logout");
					    			 System.out.println("1: Car list");
					    			 System.out.println("2: User list");
					    			 userInput = input.nextInt();
					    			 switch (userInput) {
					    			 case 1: 
					    				 Views view = new Views();
					    				 CarService carService = new CarService();
					    				 view.viewCarMenu();
					    				 view.viewCar();
					    				 break;
					    			 case 2: 
					    				 ViewUser viewUser = new ViewUser();
					    				 viewUser.userMenuList();
					    				 viewUser.ViewAll();
					    				 break;
					    			 default:
					    				 userInput = 0;
					    			 }
					    		 } else {
					    			 System.out.println("====================== You are guest user ==================");
					    			 System.out.println("0: Logout");
					    			 System.out.println("1: Car list");
					    			 userInput = input.nextInt();
					    			 switch (userInput) {
					    			 case 1: 
					    				 System.out.println("Car list");
					    				 Views view = new Views();
					    				 view.viewCarMenu();
					    				 view.viewCar();
					    				 break;
					    			 default:
					    				 userInput = 0;
					    			 }
					    		 }
					    	 }
						}
							break;
						default: 
							message();
							userInput = 0;
					}
				} catch (InputMismatchException e) {
					message();
				}
			} while(userInput == 0);
	}
	
	public static void message() {
		System.out.println("------------------ You choose wrong the wrong menu ------------------");
		System.out.println("------------------ Please choose again!------------------------------");
		System.out.println("");
	}
}
