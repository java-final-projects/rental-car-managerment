package view;

import java.sql.SQLException;

import user.UserService;

public class Menu {
	public void menu() throws ClassNotFoundException, SQLException {
		System.out.println("================= Welcome to Rental car managerment system ==================");
		System.out.println("================= Please choose menu option bellow===========================");
		System.out.println("1: Register");
		System.out.print("");
		System.out.println("2: Login ");
		System.out.print("");
		System.out.print("Enter here: ");
		UserService authUser = new UserService();
		authUser.defaultUser();
	}
}
