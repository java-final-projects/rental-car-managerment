package application;
import user.RegisterDao;

public class Application {

	public static void main(String[] args) throws ClassNotFoundException {
		
		RegisterDao register = new RegisterDao();
		register.registerUser();

	}
}
