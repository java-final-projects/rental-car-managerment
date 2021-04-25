package application;
import java.sql.SQLException;

import user.LoginDao;
import user.RegisterDao;
import user.UserService;

public class Application {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		
//		RegisterDao register = new RegisterDao();
//		register.registerUser();
		
		LoginDao login = new LoginDao();
		login.Login();
	}
}
