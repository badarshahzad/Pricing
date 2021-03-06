package com.granitetransformations.Pricing.Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.granitetransformations.Pricing.SqliteConnection;




public class LoginModel {
	Connection connection;
	public LoginModel(){
		connection = SqliteConnection.Connector();
		if(connection == null) System.exit(1);
					
	}
	
	public boolean isDbConnected(){
		try {
			return !connection.isClosed();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean isLogin(String user, String pass) throws SQLException{
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "select * from Employees where username = ? and password = ?";
		try{
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, pass);
			
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				return true;
			}else{return false;}
		}catch(Exception e){e.getCause(); return false;}
		finally{
			preparedStatement.close();
			resultSet.close(); 
		}
	}
}
