package user;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewUser {
	ResultSet resultSet;
	
	public void userMenuList() {
		 System.out.println("\t\t\t\t\t\t =========================");
			System.out.println("\t\t\t\t\t\t  User list");
			System.out.println("\t\t\t\t\t\t =========================");
			System.out.println(" --------------------------------------------------------------------------------------------------------------------- ");
			System.out.println(" \t ID \t first name \t last name \t\t email \t\t adress \t phone \t\t role");
			System.out.println(" --------------------------------------------------------------------------------------------------------------------- ");
	}
	
	public void ViewAll() throws ClassNotFoundException, SQLException {		
		 UserService userDB = new UserService();
		 resultSet = userDB.getAllUser();
		 while(resultSet.next()){
				System.out.println("\t " + resultSet.getString(1) + " \t " 
									+ resultSet.getString(2) + " \t\t " 
									+ resultSet.getString(3) + " \t " 
									+ resultSet.getString(4) + " \t\t " 
									+ resultSet.getString(5) + " \t\t " 
									+ resultSet.getString(6) + " \t " 
									+ resultSet.getString(9));
		}
	}
}
