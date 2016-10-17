package com.granitetransformations.Pricing;
import java.sql.*;

import com.granitetransformations.Pricing.Model.CustomerDetails;
import com.granitetransformations.Pricing.Utils.FxDialogs;
/**
 * This class holds only one method that is designed to connect to
 * a specified database.
 * @author Brian
 *
 */
public class SqliteConnection {
	public static Connection Connector(){
		
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\GTPricing\\Customer.sqlite");
			return conn;
		}catch(Exception e){e.getStackTrace();return null;}
	}
	/**
	 * This method will return the id number of the user. For example, this will be
	 *  used as a way to link every order to the one who logged in. Thus, there is a difference 
	 *  between the employeeid and the salespersonId. 
	 */
	public void getEmployeeId(){
		Connection conn = null;
		
		try{conn = Connector();
		ResultSet rs;

		rs = conn.createStatement().executeQuery("SELECT name, surname, street, city, state, zipCode, phone, email, id FROM   Customers WHERE  id=(SELECT MAX(id) FROM Customers)");
	
		while(rs.next())
		{
				
		}
	
		}
		catch(SQLException e){
			FxDialogs.showException("Error", "Cannot Get Information from SQL database", e);
		}
	}
	public void getSalesPersonId(String salesName){
		Connection conn = null;
		
		try{conn = Connector();
		ResultSet rs;
		String statement = "select salesPersonId from Employees where name = " + salesName;

		rs = conn.createStatement().executeQuery(statement);
	
		
	
		}
		catch(SQLException e){
			FxDialogs.showException("Error", "Cannot Get Information from SQL database", e);
		}
	}
}
