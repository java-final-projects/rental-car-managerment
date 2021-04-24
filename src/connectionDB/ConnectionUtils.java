package connectionDB;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtils {
	public static Connection getSQLConnection() throws ClassNotFoundException, SQLException {
		return SQLUtil.getSQLConnection();
	}
	
}
