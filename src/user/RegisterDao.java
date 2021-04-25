package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Scanner;
import connectionDB.ConnectionUtils;
public class RegisterDao  {
	
	final String sql = 
			"INSERT "
			+ "INTO users(first_name, last_name, email, address, national_id, phone, password)"
			+ "VALUES(?,?,?,?,?,?,?)";
	
    static Connection connection = null;
    static Statement insertStatement = null;
    static Statement SelectStatement = null;
    PreparedStatement pstmt = null;
    @SuppressWarnings("resource")
	public void registerUser() throws ClassNotFoundException {
    	System.out.println("========================================================");
    	System.out.println("---------------- Register new account -----------------");
    	System.out.println("========================================================");
    	Scanner input = new Scanner(System.in);
    	RegisterBean user = new RegisterBean();
    	
    	System.out.print("First name: ");
    	String first_name = input.next();
    	user.setFirst_name(first_name);
    	
    	System.out.print("Last name: ");
    	String last_name = input.next();
    	user.setLast_name(last_name);
    	
    	System.out.print("Email: ");
    	String email = input.next();
    	user.setEmail(email);
    	
    	System.out.print("Address: ");
    	String address = input.next();
    	user.setAddress(address);
    	
    	System.out.print("Phone: ");
    	String phone = input.next();
    	user.setPhone(phone);
    	
    	System.out.print("Nationale ID: ");
    	String national_id = input.next();
    	user.setNational_id(national_id);
    	
    	String password;
    	String password_confirm;
    	System.out.print("Passowrd: ");
    	password = input.next();
    	System.out.print("Confirm password: ");
    	password_confirm = input.next();
    	user.setPassword(password);
    	
    	Boolean isValidPassowrdUserInput = validationPassowrdUserInput(password, password_confirm);
    	while(!isValidPassowrdUserInput){
    		System.out.println("----------Password confirmst is not valid------------");
    		System.out.println("----------Please retype password and confirst password again-----------");
    		System.out.print("Passowrd: ");
        	password = input.next();
        	System.out.print("Confirm password: ");
        	password_confirm = input.next();
        	isValidPassowrdUserInput = validationPassowrdUserInput(password, password_confirm);
        	user.setPassword(password);
    	}
    	System.out.println(user.getFirst_name());
    	System.out.println(user.getLast_name());
    	System.out.println(user.getEmail());
    	System.out.println(user.getAddress());
    	System.out.println(user.getNational_id());
    	System.out.println(user.getPhone());
    	System.out.println(user.getPassword());
    	try {
    		String salt = PasswordUtils.getSalt(30);
    		String SecurePassword = PasswordUtils.generateSecurePassword(user.getPassword(), salt);
    		connection = ConnectionUtils.getSQLConnection();
    		pstmt = connection.prepareStatement(sql);
    		pstmt.setString(1, user.getFirst_name());
    		pstmt.setString(2, user.getLast_name());
    		pstmt.setString(3, user.getEmail());
    		pstmt.setString(4, user.getAddress());
    		pstmt.setString(5, user.getNational_id());
    		pstmt.setString(6, user.getPhone());
    		pstmt.setString(7, SecurePassword);
    		int effectRows = pstmt.executeUpdate();
    		System.out.println(effectRows + " Register success!");
    	} catch(SQLException e) {
    		System.out.println("Connection fail");
    	} finally {
    		try {
    			if(connection == null) {
    				connection.close();
    			}
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    	}
    }
    public static Boolean validationPassowrdUserInput(String password, String password_confirm) {
    	if(password.equals(password_confirm)) {
    		return true;
    	} else {
    		return false;
    	}
    }
}