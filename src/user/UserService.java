package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connectionDB.ConnectionUtils;

public class UserService {
	static Connection connection = null;
    static Statement insertStatement = null;
    static Statement SelectStatement = null;
    
	public ResultSet findOne(String email) throws ClassNotFoundException, SQLException {
		String query = "SELECT * FROM users WHERE email = '" + email + "'";
		connection = ConnectionUtils.getSQLConnection();
		Statement stmts=connection.createStatement();
		ResultSet resultSet= (ResultSet) stmts.executeQuery(query);
		return resultSet;
	}
	
	public ResultSet delete(int id) throws ClassNotFoundException, SQLException {
		String query = "SELECT * FROM users WHERE id = '" + id + "'";
		connection = ConnectionUtils.getSQLConnection();
		Statement stmts=connection.createStatement();
		ResultSet resultSet= (ResultSet) stmts.executeQuery(query);
		return resultSet;
	}
	
	public ResultSet getUserRole(String role) throws ClassNotFoundException, SQLException {
		String query = "SELECT * FROM users WHERE role = '" + role + "'";
		connection = ConnectionUtils.getSQLConnection();
		Statement stmts=connection.createStatement();
		ResultSet resultSet= (ResultSet) stmts.executeQuery(query);
		return resultSet;
	}
	
	public ResultSet getAllUser() throws ClassNotFoundException, SQLException {
		String query = "SELECT * FROM users";
		connection = ConnectionUtils.getSQLConnection();
		Statement stmts=connection.createStatement();
		ResultSet resultSet= (ResultSet) stmts.executeQuery(query);
		return resultSet;
	}
	
	public void defaultUser() throws ClassNotFoundException, SQLException {
		String query = "SELECT * FROM users";
		connection = ConnectionUtils.getSQLConnection();
		Statement stmts=connection.createStatement();
		ResultSet resultSet= (ResultSet) stmts.executeQuery(query);
		if(!resultSet.next()) {
			PreparedStatement pstmt = null;
			final String sql = 
					"INSERT "
					+ "INTO users(first_name, last_name, email, address, national_id, phone, password,role)"
					+ "VALUES(?,?,?,?,?,?,?,?)";
			String SecurePassword = PasswordUtils.generateSecurePassword("!password!");
			connection = ConnectionUtils.getSQLConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, "Virak");
			pstmt.setString(2, "Ran");
			pstmt.setString(3, "virakcambodia44@gmail.com");
			pstmt.setString(4, "Cambodia");
			pstmt.setString(5, "09493854");
			pstmt.setString(6, "099393709");
			pstmt.setString(7, SecurePassword);
			pstmt.setString(8, "OWNER");
			pstmt.executeUpdate();
		}
	}
}
