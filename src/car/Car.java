package car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.StringTokenizer;

import connectionDB.ConnectionUtils;

public class Car {
	static Connection connection = null;
    static Statement insertStatement = null;
    static Statement SelectStatement = null;
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
    
    public static void ListCar() throws ClassNotFoundException {
    	Statement selectStmt = null;
    	try {
    		connection = ConnectionUtils.getSQLConnection();
    		selectStmt = connection.createStatement();
    		ResultSet rs = selectStmt.executeQuery("SELECT id,brand_name, color, plate_id, year, status, price_per_day FROM cars");
    		
			System.out.println("\t\t\t\t\t\t =========================");
			System.out.println("\t\t\t\t\t\t  LIST OF ALL Car RECORD");
			System.out.println("\t\t\t\t\t\t =========================");
			
			System.out.println(" --------------------------------------------------------------------------------------------------------------------- ");
			System.out.println(" \t ID \t Brand_Name \t\t Color \t\t Plate_ID \t Year \t\t Status \t Price_Per_Day");
			System.out.println(" --------------------------------------------------------------------------------------------------------------------- ");
			
			while(rs.next()){
    			System.out.println("\t " + rs.getString(1) + " .\t " + rs.getString(2) + " \t\t " + rs.getString(3) + " \t\t " 
    								+ rs.getString(4) + " \t " + rs.getString(5) + " \t\t " + rs.getString(6) + " \t " + 
    								rs.getString(7));
    		}
    		
			System.out.println(" --------------------------------------------------------------------------------------------------------------------- ");
			
			System.out.println("Press any key to continue...");
			
    		
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

	public static void SearchRecordByID() throws ClassNotFoundException, SQLException {
		Statement selectStmt = null;
		try {
			
			Scanner strInput = new Scanner(System.in);
			
			System.out.println("\t\t ====================");
			System.out.println("\t\t  Search Car Record");
			System.out.println("\t\t ====================");
			
			System.out.print("Enter the Car ID: ");
			int ID = strInput.nextInt();
			
			String query ="select * from cars where id="+ID;
			connection = ConnectionUtils.getSQLConnection();
    		selectStmt = connection.createStatement();
    		PreparedStatement pst1=connection.prepareStatement(query);
			ResultSet rs=pst1.executeQuery();
			
			while(rs.next()){
				System.out.println("\t " + rs.getString(1) + " .\t " + rs.getString(2) + " \t\t " + rs.getString(3) + " \t\t " 
						+ rs.getString(4) + " \t " + rs.getString(5) + " \t\t " + rs.getString(6) + " \t " + 
						rs.getString(7));
			}
			System.out.println("Press any key to continue...");
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
    
	public static void DeleteRecordByID() throws ClassNotFoundException {
		Statement selectStmt = null;
		try {
			
			Scanner strInput = new Scanner(System.in);
			
			System.out.println("\t\t ====================");
			System.out.println("\t\t  Delete Car Record");
			System.out.println("\t\t ====================");
			
			System.out.print("Enter the Car ID: ");
			int ID = strInput.nextInt();
			String query ="DELETE FROM cars WHERE id="+ID;
			connection = ConnectionUtils.getSQLConnection();
    		selectStmt = connection.createStatement();
            //6) execute the SQL code
            if(selectStmt.executeUpdate(query)==1) { //query was successful
                
            	System.out.println(">>Succesfully deleted to system.");

            }else {
				System.out.println(">>Failed!!!.");
			}
            System.out.println("Press any key to continue...");
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
