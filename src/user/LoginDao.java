package user;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginDao {
	
	@SuppressWarnings("resource")
	public void Login() throws ClassNotFoundException, SQLException {
		System.out.println("========================================================");
		System.out.println("---------------- Login user -----------------");
		System.out.println("========================================================");
		Scanner input = new Scanner(System.in);
		LoginBean user = new LoginBean();
		
		System.out.print("Email: ");
    	String email = input.next();
    	user.setEmail(email);
    	
    	System.out.print("Password: ");
    	String password = input.next();
    	user.setPassword(password);
    	
    	UserService login = new UserService();
    	var resultSet = login.findOne(user.getEmail());
    	
		 while(resultSet.next()) {
            System.out.println(resultSet.getString(4) + "   " + resultSet.getString(8));
            String passwordDB = resultSet.getString(8);
            boolean SecurePassword = PasswordUtils.verifyUserPassword(user.getPassword(), passwordDB);
			System.out.println(SecurePassword);
			if(SecurePassword) {
				System.out.println("Login success");
			} else {
				System.out.println("Invalid email or password");
			}
		 }
	}
	
}
