package RentalCarManagerment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB {
    static Connection connection = null;
    static Statement insertStatement = null;
    static Statement SelectStatement = null;
    public static void main(String[] args) throws ClassNotFoundException {
    	System.out.println("------------- MySql JDBC Connection -------------");
    	PreparedStatement pstmt = null;
    	String sql = "INSERT INTO users(first_name, last_name, email, address, national_id, phone) VALUES(?,?,?,?,?,?)";
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    	} catch(ClassNotFoundException e) {
    		System.out.println("MySQL JDBC Driver not found");
    	}
    	System.out.println("MySQL JDBC Driver Register");
    	try {
//    		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rental_car_maangerment","root","");
//    		insertStatement=connection.createStatement();
    		connection = ConnectionUtils.getSQLConnection();
    		pstmt = connection.prepareStatement(sql);
    		pstmt.setString(1, "Srey");
    		pstmt.setString(2, "Sean");
    		pstmt.setString(3, "virakcambodia144@gmail.com");
    		pstmt.setString(4, "Cambodia, Phnom Penh, Teok Tla");
    		pstmt.setString(5, "99039498");
    		pstmt.setString(6, "099393709");
    		int effectRows = pstmt.executeUpdate();
    		System.out.println(effectRows + "affectd !");
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
    	System.out.println("Connection database successfully");
    }
}