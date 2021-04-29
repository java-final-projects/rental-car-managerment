package car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Scanner;
import connectionDB.ConnectionUtils;

public class CarService {
	static Connection connection = null;
    static Statement insertStatement = null;
    static Statement SelectStatement = null;
    
    public ResultSet get() throws ClassNotFoundException, SQLException {
		String query = "SELECT * FROM cars";
		connection = ConnectionUtils.getSQLConnection();
		Statement stmts=connection.createStatement();
		ResultSet resultSet= (ResultSet) stmts.executeQuery(query);
		return resultSet;
	}
    
    public static void AddCar() throws ClassNotFoundException {
    	PreparedStatement pstmt = null;
    	String sql = "INSERT INTO cars(brand_name, color, plate_id, year, status, price_per_day) "
    			+ "VALUES(?,?,?,?,?,?)";
    	try {
    		Scanner strInput = new Scanner(System.in);
			String branch_name, color, plate_id, status;
			Integer year, price_per_day;
			
			System.out.println("\t\t ================");
			System.out.println("\t\t  New Car Form");
			System.out.println("\t\t ================");
			
			System.out.print("Enter the Branch Name: ");
			branch_name = strInput.nextLine();
			System.out.print("Enter the Color: ");
			color = strInput.nextLine();
			System.out.print("Enter the Plate ID: ");
			plate_id = strInput.nextLine();    	
			System.out.print("Enter the Status: ");
			status = strInput.nextLine();
			System.out.print("Enter the Year: ");
			year = strInput.nextInt();  
			System.out.print("Enter the Price Per Day: ");
			price_per_day = strInput.nextInt();
			
    		connection = ConnectionUtils.getSQLConnection();
    		pstmt = connection.prepareStatement(sql);
    		pstmt.setString(1, branch_name);
    		pstmt.setString(2, color);
    		pstmt.setString(3, plate_id);
    		pstmt.setInt(4, year);
    		pstmt.setString(5, status);
    		pstmt.setInt(6, price_per_day);
    		int rowAffected = pstmt.executeUpdate();
    		System.out.println(rowAffected + ". >>Succesfully added to system.");
			System.out.print("Do you want to add more record? <Y/N> :");
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
    
    public static void UpdateRecordByID() throws ClassNotFoundException {
		PreparedStatement pstmt = null;
		String sqlUpdate = "UPDATE cars "
                + "SET brand_name = ? "
                + ", color = ? "
                + ", plate_id = ? "
                + ", year = ? "
                + ", status = ? "
                + ", price_per_day = ? "
                + "WHERE id = ?";
		
		try {
    		
			Scanner strInput = new Scanner(System.in);
			
			Integer year, price_per_day, ID;
			String branch_name, color, plate_id, status;
			
			System.out.println("\t\t ================");
			System.out.println("\t\t  New Car Form");
			System.out.println("\t\t ================");
			System.out.println(sqlUpdate);
			System.out.print("Enter the New Branch Name: ");
			branch_name = strInput.nextLine();
			System.out.print("Enter the New Color: ");
			color = strInput.nextLine();
			System.out.print("Enter the New Plate ID: ");
			plate_id = strInput.nextLine();    	
			System.out.print("Enter the New Status: ");
			status = strInput.nextLine();
			System.out.print("Enter the New Year: ");
			year = strInput.nextInt();  
			System.out.print("Enter the New Price Per Day: ");
			price_per_day = strInput.nextInt();
			System.out.print("Enter the Car ID: ");
			ID = strInput.nextInt();
			
    		connection = ConnectionUtils.getSQLConnection();
    		pstmt = connection.prepareStatement(sqlUpdate);
    		
    		pstmt.setString(1, branch_name);
    		pstmt.setString(2, color);
    		pstmt.setString(3, plate_id);
    		pstmt.setInt(4, year);
    		pstmt.setString(5, status);
    		pstmt.setInt(6, price_per_day);
    		pstmt.setInt(7, ID);
    		
    		int rowAffected = pstmt.executeUpdate();
    		System.out.println(rowAffected + ". >>Succesfully updated to system.");
			System.out.print("Do you want to update more record? <Y/N> :");


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
	}
    
    public static ResultSet delete(int id) throws ClassNotFoundException, SQLException {
		String query = "SELECT * FROM cars WHERE id = '" + id + "'";
		connection = ConnectionUtils.getSQLConnection();
		Statement stmts=connection.createStatement();
		ResultSet resultSet= (ResultSet) stmts.executeQuery(query);
		return resultSet;
	}
    
    public static ResultSet findOne(int id) throws ClassNotFoundException, SQLException {
		String query = "SELECT * FROM cars WHERE id = '" + id + "'";
		connection = ConnectionUtils.getSQLConnection();
		Statement stmts=connection.createStatement();
		ResultSet resultSet= (ResultSet) stmts.executeQuery(query);
		return resultSet;
	}
}
