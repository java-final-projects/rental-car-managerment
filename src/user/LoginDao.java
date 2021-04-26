package user;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginDao {

	@SuppressWarnings("resource")
	public String Login() throws ClassNotFoundException, SQLException {
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
    	
    	UserService userDB = new UserService();
    	var resultSet = userDB.findOne(user.getEmail());
    	
		 while(resultSet.next()) {
            String passwordDB = resultSet.getString(8);
            boolean SecurePassword = PasswordUtils.verifyUserPassword(user.getPassword(), passwordDB);
			if(SecurePassword) {
				System.out.println("=========================================================");
				System.out.println("================Login success ============================");
				return resultSet.getString(4);
			} else {
				System.out.println("Invalid email or password");
				return null;
			}
		 }
		 return null;
	}
	
}
