package car;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Views {
	ResultSet resultSet;
	public void viewCarMenu() {
		 System.out.println("Car list");
		 System.out.println("======================================================================");
			System.out.println("=======================LIST OF ALL Car RECORD======================");
			System.out.println("===================================================================");
			System.out.println(" --------------------------------------------------------------------------------------------------------------------- ");
			System.out.println(" \t ID \t Brand_Name \t\t Color \t\t Plate_ID \t Year \t\t Status \t Price_Per_Day");
			System.out.println(" --------------------------------------------------------------------------------------------------------------------- ");
	}
	public void viewCar() throws ClassNotFoundException, SQLException {
		CarService car = new CarService();
		resultSet = car.get();
		while(resultSet.next()){
			System.out.println("\t " + resultSet.getString(1) + " .\t " 
								+ resultSet.getString(2) + " \t\t " 
								+ resultSet.getString(3) + " \t\t " 
								+ resultSet.getString(4) + " \t\t " 
								+ resultSet.getString(5) + " \t\t " 
								+ resultSet.getString(6) + " \t " 
								+ resultSet.getString(7));
		}
	}
}
