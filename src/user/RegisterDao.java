package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import connectionDB.ConnectionUtils;

public class RegisterDao  {
    static Connection connection = null;
    static Statement insertStatement = null;
    static Statement SelectStatement = null;
    public void registerUser() throws ClassNotFoundException {
    	String salt = PasswordUtils.getSalt(30);
    	PreparedStatement pstmt = null;
    	String password = "12345678";
    	String sql = "INSERT INTO users(first_name, last_name, email, address, national_id, phone, password) "
    			+ "VALUES(?,?,?,?,?,?,?)";
    	try {
    		String SecurePassword = PasswordUtils.generateSecurePassword(password, salt);
    		connection = ConnectionUtils.getSQLConnection();
    		pstmt = connection.prepareStatement(sql);
    		pstmt.setString(1, "dddd");
    		pstmt.setString(2, "Sean");
    		pstmt.setString(3, "virakcambodia144@gmail.com");
    		pstmt.setString(4, "Cambodia, Phnom Penh, Teok Tla");
    		pstmt.setString(5, "99039498");
    		pstmt.setString(6, "099393709");
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
}