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
	
	public ResultSet getUserRole(String role) throws ClassNotFoundException, SQLException {
		String query = "SELECT * FROM users WHERE role = '" + role + "'";
		connection = ConnectionUtils.getSQLConnection();
		Statement stmts=connection.createStatement();
		ResultSet resultSet= (ResultSet) stmts.executeQuery(query);
		return resultSet;
	}
}
