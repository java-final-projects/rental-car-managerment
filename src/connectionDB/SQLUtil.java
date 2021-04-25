package connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLUtil {
	public static Connection getSQLConnection() throws ClassNotFoundException, SQLException {
		String hostName = "localhost";
		String dbName = "rental_car_maangerment";
		String userName = "root";
		String password = "";
		return getSQLConnection(hostName, dbName, userName, password);
	}
	
	public static Connection getSQLConnection(String hostName, String dbName, String userName, String password) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
		Connection connection = DriverManager.getConnection(connectionURL, userName, password);
		return connection;
	}
}
