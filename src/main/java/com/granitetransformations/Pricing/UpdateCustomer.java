package com.granitetransformations.Pricing;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.io.FileUtils;
import org.controlsfx.control.Notifications;

import com.granitetransformations.Pricing.Model.CountertopDetails;
import com.granitetransformations.Pricing.Model.CustomerDetails;
import com.granitetransformations.Pricing.Model.EdgingDetails;
import com.granitetransformations.Pricing.Model.FourInchBacksplashDetails;
import com.granitetransformations.Pricing.Model.FourInchBacksplashEdging;
import com.granitetransformations.Pricing.Model.FullBacksplashCustomDetails;
import com.granitetransformations.Pricing.Model.FullBacksplashDetails;
import com.granitetransformations.Pricing.Model.FullBacksplashEdgingDetails;
import com.granitetransformations.Pricing.Model.Opts1;
import com.granitetransformations.Pricing.Model.Bathroom.ShowerDetails;
import com.granitetransformations.Pricing.Utils.FxDialogs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UpdateCustomer {
	private SqliteConnection db;
	private ObservableList<CustomerDetails> data = FXCollections.observableArrayList();
	public ObservableList<CustomerDetails> FindCustomerByFName(String firstName){
		
	String statement = "select * from Customers where name GLOB '" +  firstName + "*'";
	System.out.println("Statement: " + statement);
	Connection conn = null;
	try {
		conn = db.Connector();
	//Execute query and store result in a resultset.
	ResultSet rs;
	
	
		rs = conn.createStatement().executeQuery(statement);
		
		while(rs.next())
		{
			CustomerDetails customer = new CustomerDetails();
			customer.customerIdProperty().set(rs.getInt(1));
			customer.nameProperty().set(rs.getString(2));
			customer.surnameProperty().set(rs.getString(3));
			customer.streetProperty().set(rs.getString(4));
			customer.cityProperty().set(rs.getString(5));
			customer.stateProperty().set(rs.getString(6));
			customer.zipCodeProperty().set(rs.getString(7));
			customer.phoneProperty().set(rs.getString(8));
			customer.emailProperty().set(rs.getString(9));
			customer.employeeIdProperty().set(rs.getInt(10));
			data.add(customer);
			
		}
		if(data.isEmpty()){
			System.out.println("EMPTY DATA");
			//FxDialogs.showWarning("No Customer Found", "Please re-enter customer information.");
			Notifications.create()
            .title("No Customers Found")
            .text("Please re-enter customer information")
            .showWarning();
			return data;
		}
		
	
		
	
	
	} catch (Exception e) {
System.out.println("Exeption");
		Notifications.create()
						.title("Could Not Load Customer Data")
						.text("Please check to see if you entered any information.")
						.showWarning();
		
		e.printStackTrace();
	}finally
    {
		DbUtils.closeQuietly(conn);
    }
	return data;
}
	public ObservableList<CustomerDetails> FindCustomerLastName(String lastName){
		
	String statement = "select * from Customers where surname GLOB '" +  lastName + "*'";
	System.out.println("Statement: " + statement);
	Connection conn = null;
	try {
		conn = db.Connector();
	
	//Execute query and store result in a resultset.
	ResultSet rs;
	
	
		rs = conn.createStatement().executeQuery(statement);
		
		while(rs.next())
		{
			CustomerDetails customer = new CustomerDetails();
			customer.customerIdProperty().set(rs.getInt(1));
			customer.nameProperty().set(rs.getString(2));
			customer.surnameProperty().set(rs.getString(3));
			customer.streetProperty().set(rs.getString(4));
			customer.cityProperty().set(rs.getString(5));
			customer.stateProperty().set(rs.getString(6));
			customer.zipCodeProperty().set(rs.getString(7));
			customer.phoneProperty().set(rs.getString(8));
			customer.emailProperty().set(rs.getString(9));
			customer.employeeIdProperty().set(rs.getInt(10));
			data.add(customer);
			
		}

		if(data.isEmpty()){
			System.out.println("EMPTY DATA");
			//FxDialogs.showWarning("No Customer Found", "Please re-enter customer information.");
			Notifications.create()
            .title("No Customers Found")
            .text("Please re-enter customer information")
            .showWarning();
		}
	
	} catch (Exception e) {
System.out.println("Exeption");
		Notifications.create()
							.title("Could Not Load Customer Data")
							.text("Please check to see if you entered any information.")
							.showWarning();

		
		e.printStackTrace();
	}finally
    {
		DbUtils.closeQuietly(conn);
    }
	return data;
}
	public ObservableList<CustomerDetails> FindCustomerFirstLastStreetCity(String firstName, String lastName, String street, String city){
		
	String statement = "select * from Customers where name GLOB '" +  firstName + "*' and surname GLOB '" 
						+ lastName + "*' and street GLOB '" + street + "*' and city GLOB '" + city + "*'" ;
	System.out.println("Statement: " + statement);
	Connection conn = null;
	try {
		conn = db.Connector();
	
	//Execute query and store result in a resultset.
	ResultSet rs;
	
	
		rs = conn.createStatement().executeQuery(statement);
		
		while(rs.next())
		{
			CustomerDetails customer = new CustomerDetails();
			customer.customerIdProperty().set(rs.getInt(1));
			customer.nameProperty().set(rs.getString(2));
			customer.surnameProperty().set(rs.getString(3));
			customer.streetProperty().set(rs.getString(4));
			customer.cityProperty().set(rs.getString(5));
			customer.stateProperty().set(rs.getString(6));
			customer.zipCodeProperty().set(rs.getString(7));
			customer.phoneProperty().set(rs.getString(8));
			customer.emailProperty().set(rs.getString(9));
			customer.employeeIdProperty().set(rs.getInt(10));
			data.add(customer);
			
		}
	
		if(data.isEmpty()){
			System.out.println("EMPTY DATA");
			//FxDialogs.showWarning("No Customer Found", "Please re-enter customer information.");
			Notifications.create()
            .title("No Customers Found")
            .text("Please re-enter customer information")
            .showWarning();
		}
	
	
	} catch (Exception e) {
		System.out.println("Exeption");
		Notifications.create()
        .title("Could Not Load Customer Data")
        .text("Please check to see if you entered any information.")
        .showWarning();
	
		
		e.printStackTrace();
	}finally
    {
		DbUtils.closeQuietly(conn);
    }
	return data;
}
	public void updateCustomer(ObservableList<CustomerDetails> data){
		db = new SqliteConnection();
		Connection conn = null;
		try{
			
			conn = db.Connector();
			String statement = "INSERT OR REPLACE INTO Customers (name, surname, street, city, state, zipCode, phone, email, employee_Id, id) VALUES (?,?,?,?,?,?,?,?,?, (Select id FROM Customers WHERE id = ?))";
			PreparedStatement psParms = conn.prepareStatement(statement); 	
			System.out.println("Executing Customer Update");
			for(CustomerDetails item: data){
			if(item.getCustomerId() != 0){
				System.out.println("Customer: " + item.getName() + " does have id: " + item.getCustomerId());
				
				psParms.setString(1, item.getName());
				psParms.setString(2, item.getSurname());
				psParms.setString(3, item.getStreet());
				psParms.setString(4, item.getCity());
				psParms.setString(5, item.getState());
				psParms.setString(6, item.getZipCode());
				psParms.setString(7, item.getPhone());
				psParms.setString(8, item.getEmail());
				psParms.setInt(9, item.getEmployeeId());
				psParms.setInt(10, item.getCustomerId());
				psParms.execute();
			}else{
	System.out.println("Customer: " + item.getName() + " does have id: " + item.getCustomerId());
				
				psParms.setString(1, item.getName());
				psParms.setString(2, item.getSurname());
				psParms.setString(3, item.getStreet());
				psParms.setString(4, item.getCity());
				psParms.setString(5, item.getState());
				psParms.setString(6, item.getZipCode());
				psParms.setString(7, item.getPhone());
				psParms.setString(8, item.getEmail());
				psParms.setInt(9, item.getEmployeeId());
				psParms.setInt(10, item.getCustomerId());
				psParms.execute();
			}
			}
			
		}catch(SQLException e){
			
		}finally
	    {
			DbUtils.closeQuietly(conn);
	    }
	}
	public ObservableList<CustomerDetails> FindCustomerFullName(String firstName, String lastName){
		
		String statement = "select * from Customers where name GLOB '" +  firstName + "*' and surname GLOB '" + lastName + "*'";
		System.out.println("Statement: " + statement);
		Connection conn = null;
		try {
			conn = db.Connector();
		data = FXCollections.observableArrayList();
		//Execute query and store result in a resultset.
		ResultSet rs;
		
		
			rs = conn.createStatement().executeQuery(statement);
			
			while(rs.next())
			{
				CustomerDetails customer = new CustomerDetails();
				customer.customerIdProperty().set(rs.getInt(1));
				customer.nameProperty().set(rs.getString(2));
				customer.surnameProperty().set(rs.getString(3));
				customer.streetProperty().set(rs.getString(4));
				customer.cityProperty().set(rs.getString(5));
				customer.stateProperty().set(rs.getString(6));
				customer.zipCodeProperty().set(rs.getString(7));
				customer.phoneProperty().set(rs.getString(8));
				customer.emailProperty().set(rs.getString(9));
				customer.employeeIdProperty().set(rs.getInt(10));
				data.add(customer);
				
			}
		
		
			
			if(data.isEmpty()){
				System.out.println("EMPTY DATA");
				//FxDialogs.showWarning("No Customer Found", "Please re-enter customer information.");
				Notifications.create()
	            .title("No Customers Found")
	            .text("Please re-enter customer information")
	            .showWarning();
			}
		
		
		} catch (Exception e) {
			System.out.println("Exeption");
			Notifications.create()
	        .title("Could Not Load Customer Data")
	        .text("Please check to see if you entered any information.")
	        .showWarning();
		
			
			e.printStackTrace();
		}finally
	    {
			DbUtils.closeQuietly(conn);
	    }
		return data;
	}
	public ObservableList<CustomerDetails> FindCustomerFullNameStreet(String firstName, String lastName, String street){
		
	String statement = "select * from Customers where name GLOB '" +  firstName + "*' and surname GLOB '" + lastName + "*' and street GLOB '" + street + "*'";
	System.out.println("Statement: " + statement);
	Connection conn = null;
	try {
		conn = db.Connector();
	data = FXCollections.observableArrayList();
	//Execute query and store result in a resultset.
	ResultSet rs;
	
	
		rs = conn.createStatement().executeQuery(statement);
		
		while(rs.next())
		{
			CustomerDetails customer = new CustomerDetails();
			customer.customerIdProperty().set(rs.getInt(1));
			customer.nameProperty().set(rs.getString(2));
			customer.surnameProperty().set(rs.getString(3));
			customer.streetProperty().set(rs.getString(4));
			customer.cityProperty().set(rs.getString(5));
			customer.stateProperty().set(rs.getString(6));
			customer.zipCodeProperty().set(rs.getString(7));
			customer.phoneProperty().set(rs.getString(8));
			customer.emailProperty().set(rs.getString(9));
			customer.employeeIdProperty().set(rs.getInt(10));
			data.add(customer);
			
		}
	
		
		if(data.isEmpty()){
			System.out.println("EMPTY DATA");
			//FxDialogs.showWarning("No Customer Found", "Please re-enter customer information.");
			Notifications.create()
            .title("No Customers Found")
            .text("Please re-enter customer information")
            .showWarning();
		}
	
	
	} catch (Exception e) {
		System.out.println("Exeption");
		Notifications.create()
        .title("Could Not Load Customer Data")
        .text("Please check to see if you entered any information.")
        .showWarning();
	
		
		e.printStackTrace();
	}finally
    {
		DbUtils.closeQuietly(conn);
    }
	return data;
}	public ObservableList<CustomerDetails> FindCustomerByStreet(String street){
	
	String statement = "select * from Customers where street like '%" +  street + "%'"; 
	System.out.println("Statement: " + statement);
	Connection conn = null;
	try {
		conn = db.Connector();
	data = FXCollections.observableArrayList();
	//Execute query and store result in a resultset.
	ResultSet rs;
	
	
		rs = conn.createStatement().executeQuery(statement);
		
		while(rs.next())
		{
			CustomerDetails customer = new CustomerDetails();
			customer.customerIdProperty().set(rs.getInt(1));
			customer.nameProperty().set(rs.getString(2));
			customer.surnameProperty().set(rs.getString(3));
			customer.streetProperty().set(rs.getString(4));
			customer.cityProperty().set(rs.getString(5));
			customer.stateProperty().set(rs.getString(6));
			customer.zipCodeProperty().set(rs.getString(7));
			customer.phoneProperty().set(rs.getString(8));
			customer.emailProperty().set(rs.getString(9));
			customer.employeeIdProperty().set(rs.getInt(10));
			data.add(customer);
			
		}

		if(data.isEmpty()){
			System.out.println("EMPTY DATA");
			//FxDialogs.showWarning("No Customer Found", "Please re-enter customer information.");
			Notifications.create()
            .title("No Customers Found")
            .text("Please re-enter customer information")
            .showWarning();
		}
	
	
	} catch (Exception e) {
		System.out.println("Exeption");
		Notifications.create()
        .title("Could Not Load Customer Data")
        .text("Please check to see if you entered any information.")
        .showWarning();
	
		
		e.printStackTrace();
	}finally
    {
		DbUtils.closeQuietly(conn);
    }
	return data;
}
public  ObservableList<CustomerDetails> FindCustomerByNameStreet(String firstName, String street){
	
String statement = "select * from Customers where name GLOB '" +  firstName + "*' and street GLOB '" + street + "*'"; 
System.out.println("Statement: " + statement);
Connection conn = null;
try {
	conn = db.Connector();
data = FXCollections.observableArrayList();
//Execute query and store result in a resultset.
ResultSet rs;


	rs = conn.createStatement().executeQuery(statement);
	
	while(rs.next())
	{
		CustomerDetails customer = new CustomerDetails();
		customer.customerIdProperty().set(rs.getInt(1));
		customer.nameProperty().set(rs.getString(2));
		customer.surnameProperty().set(rs.getString(3));
		customer.streetProperty().set(rs.getString(4));
		customer.cityProperty().set(rs.getString(5));
		customer.stateProperty().set(rs.getString(6));
		customer.zipCodeProperty().set(rs.getString(7));
		customer.phoneProperty().set(rs.getString(8));
		customer.emailProperty().set(rs.getString(9));
		customer.employeeIdProperty().set(rs.getInt(10));
		data.add(customer);
		
	}
	if(data.isEmpty()){
		System.out.println("EMPTY DATA");
		//FxDialogs.showWarning("No Customer Found", "Please re-enter customer information.");
		Notifications.create()
        .title("No Customers Found")
        .text("Please re-enter customer information")
        .showWarning();
	}


} catch (Exception e) {
	System.out.println("Exeption");
	Notifications.create()
    .title("Could Not Load Customer Data")
    .text("Please check to see if you entered any information.")
    .showWarning();

	
	e.printStackTrace();
}finally
{
	DbUtils.closeQuietly(conn);
}
return data;
}

public ObservableList<CustomerDetails> FindCustomerByLastNameStreet(String lastName, String street){

String statement = "select * from Customers where surname GLOB '" +  lastName + "*' and street GLOB '" + street + "*'"; 
System.out.println("Statement: " + statement);
Connection conn = null;
try {
	conn = db.Connector();
data = FXCollections.observableArrayList();
//Execute query and store result in a resultset.
ResultSet rs;


	rs = conn.createStatement().executeQuery(statement);
	
	while(rs.next())
	{
		CustomerDetails customer = new CustomerDetails();
		customer.customerIdProperty().set(rs.getInt(1));
		customer.nameProperty().set(rs.getString(2));
		customer.surnameProperty().set(rs.getString(3));
		customer.streetProperty().set(rs.getString(4));
		customer.cityProperty().set(rs.getString(5));
		customer.stateProperty().set(rs.getString(6));
		customer.zipCodeProperty().set(rs.getString(7));
		customer.phoneProperty().set(rs.getString(8));
		customer.emailProperty().set(rs.getString(9));
		customer.employeeIdProperty().set(rs.getInt(10));
		data.add(customer);
		
	}
	
	
	if(data.isEmpty()){
		System.out.println("EMPTY DATA");
		//FxDialogs.showWarning("No Customer Found", "Please re-enter customer information.");
		Notifications.create()
        .title("No Customers Found")
        .text("Please re-enter customer information")
        .showWarning();
	}


} catch (SQLException e) {
	FxDialogs.showException("Exception Thrown Finding Customer", "Cannot Find Customer via Last Name and Street Address", e);

	
	e.printStackTrace();
}finally
{
	DbUtils.closeQuietly(conn);
}
return data;
}
public ObservableList<CustomerDetails> findCustomerByPhone(String phone){
	
String statement = "select * from Customers where phone like '%" +  phone + "%'"; 
System.out.println("Statement: " + statement);
Connection conn = null;
try {
	conn = db.Connector();
data = FXCollections.observableArrayList();
//Execute query and store result in a resultset.
ResultSet rs;


	rs = conn.createStatement().executeQuery(statement);
	
	while(rs.next())
	{
		CustomerDetails customer = new CustomerDetails();
		customer.customerIdProperty().set(rs.getInt(1));
		customer.nameProperty().set(rs.getString(2));
		customer.surnameProperty().set(rs.getString(3));
		customer.streetProperty().set(rs.getString(4));
		customer.cityProperty().set(rs.getString(5));
		customer.stateProperty().set(rs.getString(6));
		customer.zipCodeProperty().set(rs.getString(7));
		customer.phoneProperty().set(rs.getString(8));
		customer.emailProperty().set(rs.getString(9));
		customer.employeeIdProperty().set(rs.getInt(10));
		data.add(customer);
		
	}

	
	if(data.isEmpty()){
		System.out.println("EMPTY DATA");
		//FxDialogs.showWarning("No Customer Found", "Please re-enter customer information.");
		Notifications.create()
        .title("No Customers Found")
        .text("Please re-enter customer information")
        .showWarning();
	}


} catch (Exception e) {
	System.out.println("Exeption");
	Notifications.create()
    .title("Could Not Load Customer Data")
    .text("Please check to see if you entered any information.")
    .showWarning();

	
	e.printStackTrace();
}finally
{
	DbUtils.closeQuietly(conn);
}
return data;
}
public ObservableList<CustomerDetails> findCustomerByEmail(String email){
	
String statement = "select * from Customers where email like '%" +  email + "%'"; 
System.out.println("Statement: " + statement);
Connection conn = null;
try {
	conn = db.Connector();
//Execute query and store result in a resultset.
ResultSet rs;


	rs = conn.createStatement().executeQuery(statement);
	
	while(rs.next())
	{
		CustomerDetails customer = new CustomerDetails();
		customer.customerIdProperty().set(rs.getInt(1));
		customer.nameProperty().set(rs.getString(2));
		customer.surnameProperty().set(rs.getString(3));
		customer.streetProperty().set(rs.getString(4));
		customer.cityProperty().set(rs.getString(5));
		customer.stateProperty().set(rs.getString(6));
		customer.zipCodeProperty().set(rs.getString(7));
		customer.phoneProperty().set(rs.getString(8));
		customer.emailProperty().set(rs.getString(9));
		customer.employeeIdProperty().set(rs.getInt(10));
		data.add(customer);
		
	}

	
	if(data.isEmpty()){
		System.out.println("EMPTY DATA");
		//FxDialogs.showWarning("No Customer Found", "Please re-enter customer information.");
		Notifications.create()
        .title("No Customers Found")
        .text("Please re-enter customer information")
        .showWarning();
	}


} catch (Exception e) {
	System.out.println("Exeption");
	Notifications.create()
    .title("Could Not Load Customer Data")
    .text("Please check to see if you entered any information.")
    .showWarning();

	
	e.printStackTrace();
}finally
{
	DbUtils.closeQuietly(conn);
}
return data;
}
public ObservableList<CustomerDetails> findCustomerByZipCode(String zipCode){

String statement = "select * from Customers where zipCode like '%" +  zipCode + "%'"; 
System.out.println("Statement: " + statement);
Connection conn = null;
try {
	conn = db.Connector();
data = FXCollections.observableArrayList();
//Execute query and store result in a resultset.
ResultSet rs;


	rs = conn.createStatement().executeQuery(statement);
	
	while(rs.next())
	{
		CustomerDetails customer = new CustomerDetails();
		customer.customerIdProperty().set(rs.getInt(1));
		customer.nameProperty().set(rs.getString(2));
		customer.surnameProperty().set(rs.getString(3));
		customer.streetProperty().set(rs.getString(4));
		customer.cityProperty().set(rs.getString(5));
		customer.stateProperty().set(rs.getString(6));
		customer.zipCodeProperty().set(rs.getString(7));
		customer.phoneProperty().set(rs.getString(8));
		customer.emailProperty().set(rs.getString(9));
		customer.employeeIdProperty().set(rs.getInt(10));
		data.add(customer);
		
	}

	if(data.isEmpty()){
		System.out.println("EMPTY DATA");
		//FxDialogs.showWarning("No Customer Found", "Please re-enter customer information.");
		Notifications.create()
        .title("No Customers Found")
        .text("Please re-enter customer information")
        .showWarning();
	}


} catch (Exception e) {
	System.out.println("Exeption");
	Notifications.create()
    .title("Could Not Load Customer Data")
    .text("Please check to see if you entered any information.")
    .showWarning();

	
	e.printStackTrace();
}finally
{
	DbUtils.closeQuietly(conn);
}
return data;
}

	public void updateCoutertop(ObservableList<CountertopDetails> countData) throws ClassNotFoundException {
		Connection conn = null;
		try
		{
		conn = db.Connector();	
		
			String psStringWithParms = "INSERT OR REPLACE INTO Countertop (ctId, Piece, Length, Width, Color, Include, orderId, employeeId, customerId, salesPersonId) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, (SELECT ctId FROM Countertop WHERE ctId = ?))";
			PreparedStatement psParms = conn.prepareStatement(psStringWithParms);
			for(CountertopDetails item: countData){
			if(item.getId() != 0){
			psParms.setInt(1, item.getId());
			psParms.setString(2, item.getPiece());
			psParms.setDouble(3, item.getLength());
			psParms.setDouble(4, item.getWidth());
			psParms.setString(5, item.getColor());
			psParms.setBoolean(6, item.isInclude());
			psParms.setInt(7, item.getOrderId());
			psParms.setInt(8, item.getEmployeeId());
			psParms.setInt(9, item.getCustomerId());
			psParms.setInt(10, item.getSalesPersonId());
			}else
			{
				psParms.setString(2, item.getPiece());
				psParms.setDouble(3, item.getLength());
				psParms.setDouble(4, item.getWidth());
				psParms.setString(5, item.getColor());
				psParms.setBoolean(6, item.isInclude());
				psParms.setInt(7, item.getOrderId());
				psParms.setInt(8, item.getEmployeeId());
				psParms.setInt(9, item.getCustomerId());
				psParms.setInt(10, item.getSalesPersonId());
			}
			
			psParms.execute();		
		
			}
		}catch(SQLException e)
			{
				FxDialogs.showException("Countertop Measurements Error", "There was a problem with loading the data to the database", e);
			}
		finally
	    {
			DbUtils.closeQuietly(conn);
	    }

	}



public void updateEdging(ObservableList<EdgingDetails> edgingData) throws ClassNotFoundException {
	
	Connection conn = null;
	
	try
	{
	conn = db.Connector();	
	for(EdgingDetails item: edgingData){

		String psStringWithParms = "INSERT OR REPLACE INTO Edging (edgeId, Length, Bevel, Polished, Color, Include, orderId, customerId, employeeId, salesPersonId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, (SELECT edgeId FROM Edging WHERE edgeId = ?))";
		PreparedStatement psParms = conn.prepareStatement(psStringWithParms);
		
		if(item.getId() != 0){
			psParms.setInt(1, item.getId());
			psParms.setDouble(2, item.getLength());
			psParms.setBoolean(3, item.isCheckBoxBevel());
			psParms.setBoolean(4, item.isCheckBoxPolished());
			psParms.setString(5, item.getColor());
			psParms.setBoolean(6, item.isInclude());
			psParms.setInt(7, item.getOrderId());
			psParms.setInt(8, item.getCustomerId());
			psParms.setInt(9, item.getEmployeeId());
			psParms.setInt(10, item.getSalesPersonId());
			System.out.println("Edging with Id: " + item.toString());
				}
		else
		{
			
			psParms.setDouble(2, item.getLength());
			psParms.setBoolean(3, item.isCheckBoxBevel());
			psParms.setBoolean(4, item.isCheckBoxPolished());
			psParms.setString(5, item.getColor());
			psParms.setBoolean(6, item.isInclude());
			psParms.setInt(7, item.getOrderId());
			psParms.setInt(8, item.getCustomerId());
			psParms.setInt(9, item.getEmployeeId());
			psParms.setInt(10, item.getSalesPersonId());
			System.out.println("Edging with Id: " + item.toString());

		}
		psParms.execute();
		
		
	}
	
		
	}catch(SQLException e)
		{
			FxDialogs.showException("Edging Measurements Error", "Unable to load data to database", e);
		}
	finally
    {
		DbUtils.closeQuietly(conn);
    }

}
public void updateFourInchBacksplash(ObservableList<FourInchBacksplashDetails> fourInchData) throws ClassNotFoundException {
	
	Connection conn = null;

	try
	{
	conn = db.Connector();	
	for(FourInchBacksplashDetails item: fourInchData){
///The problem is when I call the getId method, it return a 0 and doesn't check to see if the id already exists within the table. So I need to check to see when I instantiate the table if the number already exists, but do so with sql. !!!!!!!
		/**
		 * Check here. This is the solution. when you are adding new rows, have the computer check to see
		 * if the row id already exists and if it does, then receive the largest integer of the rows and add 1
		 * then set that number to be the default row id of that session. However check only when the first time. 
		 * THis methods will save time check. It would be too costly to check each time I wanted to add a row. 
		 * So, for simplicity,  
		 */

		String psStringWithParms = "INSERT OR REPLACE INTO Four_Inch_Backsplash (backsplashId, Piece, Length, Width, BuildOuts, Color, Include, orderId, customerId, employeeId, salesPersonId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ( SELECT backsplashId FROM Four_Inch_Backsplash WHERE backsplashId = 3));";
		PreparedStatement psParms = conn.prepareStatement(psStringWithParms);
		
		if(item.getId() != 0){
			psParms.setInt(1, item.getId());
			psParms.setString(2, item.getPiece());
			psParms.setDouble(3, item.getLength());
			psParms.setDouble(4, item.getWidth());
			psParms.setDouble(5, item.getBuildOuts());
			psParms.setString(6, item.getColor());
			psParms.setBoolean(7, item.isInclude());
			psParms.setInt(8, item.getOrderId());
			psParms.setInt(9, item.getCustomerId());
			psParms.setInt(10, item.getEmployeeId());
			
		}
		else
		{
			psParms.setString(2, item.getPiece());
			psParms.setDouble(3, item.getLength());
			psParms.setDouble(4, item.getWidth());
			psParms.setDouble(5, item.getBuildOuts());
			psParms.setString(6, item.getColor());
			psParms.setBoolean(7, item.isInclude());
			psParms.setInt(8, item.getOrderId());
			psParms.setInt(9, item.getCustomerId());
			psParms.setInt(10, item.getEmployeeId());

		}
		psParms.execute();
		
		
	}
		
	}catch(SQLException e)
		{
			FxDialogs.showException("Four Inch Backsplash Measurements Error", "Unable to load data to database", e);
		}
	finally
    {
		DbUtils.closeQuietly(conn);
    }

}
public void updateFourInchBacksplashEdging(ObservableList<FourInchBacksplashEdging> fourInchBacksplashEdgingData){
	Connection conn = null;
	try{
		conn = db.Connector();
		for(FourInchBacksplashEdging item: fourInchBacksplashEdgingData){
			String statement = "INSERT OR REPLACE INTO Four_Inch_Backsplash_Edging (edgeId, Length, Width, Color, Include, orderId, customerId, employeeId, salesPersonId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ( SELECT edgeId FROM Four_Inch_Backsplash_Edging WHERE edgeId = ?))";
			PreparedStatement psParms = conn.prepareStatement(statement);
			if(item.getId() != 0){
				psParms.setInt(1, item.getId());
				psParms.setDouble(2, item.getLength());
				psParms.setDouble(3, item.getWidth());
				psParms.setString(4, item.getColor());
				psParms.setBoolean(5, item.isInclude());
				psParms.setInt(6, item.getOrderId());
				psParms.setInt(7, item.getCustomerId());
				psParms.setInt(8, item.getEmployeeId());
				psParms.setInt(9, item.getSalesPersonId());
				System.out.println("Four Backsplash Edging: " + item.toString());
				
			}else
			{
				psParms.setDouble(2, item.getLength());
				psParms.setDouble(3, item.getWidth());
				psParms.setString(4, item.getColor());
				psParms.setBoolean(5, item.isInclude());
				psParms.setInt(6, item.getOrderId());
				psParms.setInt(7, item.getCustomerId());
				psParms.setInt(8, item.getEmployeeId());
				psParms.setInt(9, item.getSalesPersonId());
				System.out.println("Four Backsplash Edging: " + item.toString());

			}
			psParms.execute();
		}
	}catch(SQLException e){
		FxDialogs.showException("Exeception Thrown While Updating Full Backsplash Edging Data", "Check to see if database is connected.", e);
	}finally
    {
		DbUtils.closeQuietly(conn);
    }
}

public void updateFullBacksplash(ObservableList<FullBacksplashDetails> fullBacksplashData){
	Connection conn = null;
	
	try{
		conn = db.Connector();
		for (FullBacksplashDetails item: fullBacksplashData){
			String statement = "INSERT OR REPLACE INTO Full_Backsplash (Id, Piece, Length, Width, Color, Include, Trendstone_Selection, Mosaic_Selection, orderId, customerId, employeeId, salesPersonId) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ( SELECT Id FROM Full_Backsplash WHERE Id = ?))";
			PreparedStatement psParms = conn.prepareStatement(statement);
			if(item.getId() != 0){
			psParms.setInt(1, item.getId());
			psParms.setString(2, item.getPiece());
			psParms.setDouble(3, item.getLength());
			psParms.setDouble(4, item.getWidth());
			psParms.setString(5, item.getColor());
			psParms.setBoolean(6, item.isInclude());
			psParms.setBoolean(7, item.isTrendstone());
			psParms.setBoolean(8, item.isMosaic());
			psParms.setInt(9, item.getOrderId());
			psParms.setInt(10, item.getCustomerId());
			psParms.setInt(11, item.getEmployeeId());
			psParms.setInt(12, item.getSalesPersonId());
			} else
			{
				
				psParms.setString(2, item.getPiece());
				psParms.setDouble(3, item.getLength());
				psParms.setDouble(4, item.getWidth());
				psParms.setString(5, item.getColor());
				psParms.setBoolean(6, item.isInclude());
				psParms.setBoolean(7, item.isTrendstone());
				psParms.setBoolean(8, item.isMosaic());
				psParms.setInt(9, item.getOrderId());
				psParms.setInt(10, item.getCustomerId());
				psParms.setInt(11, item.getEmployeeId());
				psParms.setInt(12, item.getSalesPersonId());
			}
			psParms.execute();
			
			
			
		}
	}catch(SQLException e){
		FxDialogs.showException("Updating Full Backsplash Error", "Something went wrong with updateing full backsplash data for this customer.", e);
	}finally
    {
		DbUtils.closeQuietly(conn);
    }
}

public void updateFullBacksplashEdging(ObservableList<FullBacksplashEdgingDetails> fullBacksplashEdgingData){
	Connection conn = null;
	try{
		conn = db.Connector();
		for(FullBacksplashEdgingDetails item: fullBacksplashEdgingData){
			String statement = "INSERT OR REPLACE INTO Full_Backsplash_Edging (edgeId, Length, Width, Polished, Color, Include, orderId, customerId, employeeId, salesPersonId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ( SELECT edgeId FROM Full_Backsplash_Edging WHERE edgeId = ?))";
			PreparedStatement psParms = conn.prepareStatement(statement);
			if(item.getId() != 0){
				psParms.setInt(1, item.getId());
				psParms.setDouble(2, item.getLength());
				psParms.setDouble(3, item.getWidth());
				psParms.setBoolean(4, item.isCheckBoxPolished());
				psParms.setString(5, item.getColor());
				psParms.setBoolean(6, item.isInclude());
				psParms.setInt(7, item.getOrderId());
				psParms.setInt(8, item.getCustomerId());
				psParms.setInt(9, item.getEmployeeId());
				psParms.setInt(10, item.getSalesPersonId());
				System.out.println("Full Backsplash Edging: " + item.toString());
				
			}else
			{
				psParms.setDouble(2, item.getLength());
				psParms.setDouble(3, item.getWidth());
				psParms.setBoolean(4, item.isCheckBoxPolished());
				psParms.setString(5, item.getColor());
				psParms.setBoolean(6, item.isInclude());
				psParms.setInt(7, item.getOrderId());
				psParms.setInt(8, item.getCustomerId());
				psParms.setInt(9, item.getEmployeeId());
				psParms.setInt(10, item.getSalesPersonId());
				System.out.println("Full Backsplash Edging: " + item.toString());

			}
			psParms.execute();
		}
	}catch(SQLException e){
		FxDialogs.showException("Exeception Thrown While Updating Full Backsplash Edging Data", "Check to see if database is connected.", e);
	}finally
    {
		DbUtils.closeQuietly(conn);
    }
}
public void updateFullBacksplashOptions(ObservableList<FullBacksplashCustomDetails> fullBacksplashCustomData){

Connection conn = null;
try{
	conn = db.Connector();
	for(FullBacksplashCustomDetails item: fullBacksplashCustomData){
		
		String statement = "INSERT OR REPLACE INTO Full_Backsplash_Custom (Id, CutOuts, StripeTrend7Tiles, StripeCustomMosaic, InlayDiamond5x5, InlayDiamond12x12, Trendstone_Selection, Mosaic_Selection, orderId, customerId, employeeId, salesPersonId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ( SELECT Id FROM Full_Backsplash_Custom WHERE Id = ?))";
		PreparedStatement psParms = conn.prepareStatement(statement);
		
		if(item.getCustomId() != 0){
			psParms.setInt(1, item.getCustomId());
			psParms.setDouble(2, item.getCutOuts());
			psParms.setDouble(3, item.getStripeTrendstone7Tiles());
			psParms.setDouble(4, item.getStripeCustomMosaic7Tiles());
			psParms.setDouble(5, item.getInlaysDiamond5x5());
			psParms.setDouble(6, item.getInlaysDiamond12x12());
			psParms.setBoolean(7, item.isTrendStoneSelection());
			psParms.setBoolean(8, item.isMosaicSelection());
			psParms.setInt(9, item.getOrderId());
			psParms.setInt(10, item.getCustomerId());
			psParms.setInt(11, item.getEmployeeId());
			psParms.setInt(12, item.getSalesPersonId());
		}else
		{
			
			psParms.setDouble(2, item.getCutOuts());
			psParms.setDouble(3, item.getStripeTrendstone7Tiles());
			psParms.setDouble(4, item.getStripeCustomMosaic7Tiles());
			psParms.setDouble(5, item.getInlaysDiamond5x5());
			psParms.setDouble(6, item.getInlaysDiamond12x12());
			psParms.setBoolean(7, item.isTrendStoneSelection());
			psParms.setBoolean(8, item.isMosaicSelection());
			psParms.setInt(9, item.getOrderId());
			psParms.setInt(10, item.getCustomerId());
			psParms.setInt(11, item.getEmployeeId());
			psParms.setInt(12, item.getSalesPersonId());
			System.out.println("Full Backsplash Custom without Id: " + item.toString());

		}
		
		psParms.execute();
	}
	
}catch(SQLException e){
	FxDialogs.showException("Exeception Thrown Updating Full Backsplash Options", "Check to see if all fields are entered correctly.", e);
	
}finally
{
	DbUtils.closeQuietly(conn);
}
}
public void updateOptions(ObservableList<Opts1> opt1Data) throws ClassNotFoundException {
	
	Connection conn = null;
	try
	{
			conn = db.Connector();
			for(Opts1 item: opt1Data){
				String psStringWithParms = "insert or Replace into Options (id, prep_board, prep_board_m, remove_backsplash, remove_backsplash_m, remove_existing_ct_laminate, remove_existing_ct_laminate_m, remove_ct_tile, remove_ct_tile_m, install_new_ct, install_new_ct_m, iron_bar_less_36, iron_bar_less_36_m, iron_bar_more_36, iron_bar_more_36_m, bend_trendstone_apron, bend_trendstone_apron_m, clipped_corner, clipped_corner_m, other_1, other_1_m, other_2, other_2_m, filler, filler_m, other_3, other_3_m, other_4, other_4_m, rsg, rsg_m, strainer, strainer_m, sink_removal, sink_removal_m, cooktop_removal_reinstall, cooktop_removal_reinstall_m, plumbing, sink_faucets_accessories, switch_plates, toe_kick, orderId, customerId, employeeId, salesPersonId) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ( SELECT id FROM Options WHERE id = ?))";
				PreparedStatement psParms = conn.prepareStatement(psStringWithParms);
				if(item.getId() != 0){
					System.out.println("Option Data with Id: " + item.toString());
					psParms.setInt(1, item.getId());
					psParms.setBoolean(2, item.isPrepBoard()); psParms.setDouble(3, item.getPrepBoardM());
					psParms.setBoolean(4, item.isRemoveExistingBacksplash()); psParms.setDouble(5, item.getRemoveExistingBacksplashM());
					psParms.setBoolean(6, item.isRemoveCTLaminate()); psParms.setDouble(7, item.getRemoveCTLaminateM());
					psParms.setBoolean(8, item.isRemoveCTTile()); psParms.setDouble(9, item.getRemoveCTTileM());
					psParms.setBoolean(10, item.isInstallNewCt());psParms.setDouble(11, item.getInstallNewCtM());
					psParms.setBoolean(12, item.isIronBarless36in6()); psParms.setDouble(13, item.getIronbarless36in6M());
					psParms.setBoolean(14, item.isIronBarmore36in7()); psParms.setDouble(15, item.getIronBarmore36in7M());
					psParms.setBoolean(16, item.isBendTrendStoneApron()); psParms.setDouble(17, item.getBendTrendStoneApronM());
					psParms.setBoolean(18, item.isClippedCorners()); psParms.setDouble(19, item.getClippedCornersM());
					psParms.setBoolean(20, item.isOther1()); psParms.setDouble(21, item.getOther1M());
					psParms.setBoolean(22, item.isOther2()); psParms.setDouble(23, item.getOther2M());
					psParms.setBoolean(24, item.isFiller()); psParms.setDouble(25, item.getFillerM());
					psParms.setBoolean(26, item.isOther3()); psParms.setDouble(27, item.getOther3M());
					psParms.setBoolean(28, item.isOther4()); psParms.setDouble(29, item.getOther4M());
					psParms.setBoolean(30, item.isRsg()); psParms.setDouble(31, item.getRsgM());
					psParms.setBoolean(32, item.isStrainer()); psParms.setDouble(33, item.getStrainerM());
					psParms.setBoolean(34, item.isSinkRemoval()); psParms.setDouble(35, item.getSinkRemovalM());
					psParms.setBoolean(36, item.isCooktopRemoveReinstall()); psParms.setDouble(37, item.getCooktopRemoveReinstallM());
					psParms.setDouble(38, item.getPlumbing());
					psParms.setDouble(39, item.getSinksAcc());
					psParms.setDouble(40, item.getSwitchPlates());
					psParms.setDouble(41, item.getToeKick());
					psParms.setInt(42, item.getOrderId());
					psParms.setDouble(43, item.getCustomerId());
					psParms.setDouble(44, item.getEmployeeId());
					psParms.setDouble(45, item.getSalesPersonId()); 
					}else
					{
						System.out.println("Option Data without Id: " + item.toString());
						psParms.setBoolean(2, item.isPrepBoard()); psParms.setDouble(3, item.getPrepBoardM());
						psParms.setBoolean(4, item.isRemoveExistingBacksplash()); psParms.setDouble(5, item.getRemoveExistingBacksplashM());
						psParms.setBoolean(6, item.isRemoveCTLaminate()); psParms.setDouble(7, item.getRemoveCTLaminateM());
						psParms.setBoolean(8, item.isRemoveCTTile()); psParms.setDouble(9, item.getRemoveCTTileM());
						psParms.setBoolean(10, item.isInstallNewCt());psParms.setDouble(11, item.getInstallNewCtM());
						psParms.setBoolean(12, item.isIronBarless36in6()); psParms.setDouble(13, item.getIronbarless36in6M());
						psParms.setBoolean(14, item.isIronBarmore36in7()); psParms.setDouble(15, item.getIronBarmore36in7M());
						psParms.setBoolean(16, item.isBendTrendStoneApron()); psParms.setDouble(17, item.getBendTrendStoneApronM());
						psParms.setBoolean(18, item.isClippedCorners()); psParms.setDouble(19, item.getClippedCornersM());
						psParms.setBoolean(20, item.isOther1()); psParms.setDouble(21, item.getOther1M());
						psParms.setBoolean(22, item.isOther2()); psParms.setDouble(23, item.getOther2M());
						psParms.setBoolean(24, item.isFiller()); psParms.setDouble(25, item.getFillerM());
						psParms.setBoolean(26, item.isOther3()); psParms.setDouble(27, item.getOther3M());
						psParms.setBoolean(28, item.isOther4()); psParms.setDouble(29, item.getOther4M());
						psParms.setBoolean(30, item.isRsg()); psParms.setDouble(31, item.getRsgM());
						psParms.setBoolean(32, item.isStrainer()); psParms.setDouble(33, item.getStrainerM());
						psParms.setBoolean(34, item.isSinkRemoval()); psParms.setDouble(35, item.getSinkRemovalM());
						psParms.setBoolean(36, item.isCooktopRemoveReinstall()); psParms.setDouble(37, item.getCooktopRemoveReinstallM());
						psParms.setDouble(38, item.getPlumbing());
						psParms.setDouble(39, item.getSinksAcc());
						psParms.setDouble(40, item.getSwitchPlates());
						psParms.setDouble(41, item.getToeKick());
						psParms.setInt(42, item.getOrderId());
						psParms.setDouble(43, item.getCustomerId());
						psParms.setDouble(44, item.getEmployeeId());
						psParms.setDouble(45, item.getSalesPersonId()); 
					}
				psParms.execute();
}
}catch(SQLException e)
	{
	System.out.println("Error Options data");
		FxDialogs.showException("Options Error", "Unable to load data to database", e);
	}
finally
{
	DbUtils.closeQuietly(conn);
}

}
public void updateShower(ObservableList<ShowerDetails> showerData){
	Connection conn = null;
	String stmt = null;
	
	try{
		conn = db.Connector();
		stmt = "Insert or Replace into Shower (Id, Length, Width, Include, Color, orderId, customerId, employeeId, salesPersonId, Date ) Values(?,?,?,?,?,?,?,?, ?, ( SELECT Id FROM Shower WHERE Id = ?))";
		PreparedStatement psParms = conn.prepareStatement(stmt);
		for(ShowerDetails item: showerData){
			LocalDateTime date = LocalDateTime.now();
			item.setDate(date.toString());
			String nowDate = date.toString();
			System.out.println("Current Date and Time: " + nowDate);
			if(!(item.idProperty().get() == 0)){
				psParms.setInt(1, item.getId());
				psParms.setDouble(2, item.getLength());
				psParms.setDouble(3, item.getWidth());
				psParms.setBoolean(4, item.isInclude());
				psParms.setString(5, item.getColor());
				psParms.setInt(6, item.getOrderId());
				psParms.setInt(7, item.getCustomerId());
				psParms.setInt(8, item.getEmployeeId());
				psParms.setInt(9, item.getSalesPersonId());
				psParms.setString(10, item.getDate());
			}else{
				psParms.setDouble(2, item.getLength());
				psParms.setDouble(3, item.getWidth());
				psParms.setBoolean(4, item.isInclude());
				psParms.setString(5, item.getColor());
				psParms.setInt(6, item.getOrderId());
				psParms.setInt(7, item.getCustomerId());
				psParms.setInt(8, item.getEmployeeId());
				psParms.setInt(9, item.getSalesPersonId());
				psParms.setString(10, item.getDate());
			}
			psParms.execute();
			
		}
		
	}catch (SQLException e){FxDialogs.showException("Uhoh!", "Exception Thrown with Shower Details", e);}
	finally
    {
		DbUtils.closeQuietly(conn);
    }
	
}
public int getOrderId(String customerId) throws ClassNotFoundException{
	Connection conn = null;
	Statement stmt = null;
	int id = 0;
	
	System.out.println("Customer id: " + customerId);
	String statement = "select orderId from Orders where customerId = '" + customerId + "'";
	try
	{
		conn = db.Connector();
		//Execute query and store result in a resultset.
		stmt = conn.createStatement();
		ResultSet rs =  stmt.executeQuery(statement);
		while(rs.next())
		{
			id = rs.getInt(1);		
		}
		System.out.println("CURRENT ORDER ID: " + id );
	}catch(SQLException e)
		{
			System.out.println("Error: " + e.getSQLState());
			System.out.println("Error: " + e.getMessage());
			System.out.println("Error: " + e.getCause());
		}
	finally
    {
		DbUtils.closeQuietly(conn);
    }
	return id;

}
public void openDocument(String currentName, String currentSurName) throws IOException{
	Desktop desktop = Desktop.getDesktop();
	StringBuilder sb = new StringBuilder();
	sb.append("C:\\GTPricing\\Customers\\").append(currentSurName).append("_").append(currentName).append(".docx");
	String location = sb.toString();  
	location.replaceAll("\\s","");
	boolean isFileUnlocked = false;
	File file = new File(location);
	if(file.exists()){
	
	try{
		
		FileUtils.touch(file);
		isFileUnlocked = true;
	}catch(IOException e){
		isFileUnlocked = false;
	}
	
	if(isFileUnlocked){
		
		String title = "Now Opening Estimate";
		String message = currentName + " " + currentSurName + "'s Estimate is Opening";
		
		desktop.open(file);
	}}
	else{
		String title = "File Does not exist";
		String message = currentName + " " + currentSurName + "'s Estimate Does Not Exist";
		
	}
	
}




}
