package com.granitetransformations.Pricing;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;

import com.granitetransformations.Pricing.Model.EmployeeDetails;
import com.sun.javafx.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class UserController implements Initializable {
	String user;
	@FXML Label userWelcomeLabel;
	@FXML TableView<EmployeeDetails> table1;
	@FXML TableColumn<EmployeeDetails, String> column1t1;
	@FXML TableColumn<EmployeeDetails, String> column2t1;
	@FXML TableColumn<EmployeeDetails, String> column3t1;
	@FXML TableColumn<EmployeeDetails, String> column4t1;
	@FXML TableColumn<EmployeeDetails, String> column5t1;
	@FXML TableColumn<EmployeeDetails, String> column6t1;
	@FXML TableColumn<EmployeeDetails, String> column7t1;
	@FXML TableColumn<EmployeeDetails, String> column8t1;
	@FXML TableColumn<EmployeeDetails, String> column9t1;
	@FXML TableColumn<EmployeeDetails, String> column10t1;
	@FXML Button loadDetailsButton;

	private ObservableList<EmployeeDetails> data;
	private SqliteConnection db;
	Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
	
	
	public void initialize(URL location, ResourceBundle resources) {
		db = new SqliteConnection();
		
	}
	public void getUser(String user){
		userWelcomeLabel.setText(user);
	}
	public void SignOut(ActionEvent event) throws IOException{
		((Node)event.getSource()).getScene().getWindow().hide();
		Stage userStage = new Stage();
		FXMLLoader fxmlLoader = new FXMLLoader();
		Pane root = fxmlLoader.load(getClass().getResourceAsStream("/fxml/MainScreen.fxml"));
		MainScreenController controller = fxmlLoader.load();
		controller.setUsername(user);
		Scene scene = new Scene(root, screenBounds.getHeight(), screenBounds.getWidth());
		userStage.setScene(scene);
		userStage.show();
	}
	@SuppressWarnings("restriction")
	@FXML void loadDataFromDatabase(ActionEvent event) {
		try
		{
		Connection conn = db.Connector();
		data = FXCollections.observableArrayList();
		//Execute query and store result in a resultset.
		ResultSet rs = conn.createStatement().executeQuery("SELECT name, surname, street, city, state, zipCode, phone, email FROM Customer");
			while(rs.next())
			{
					data.add(new EmployeeDetails(rs.getString(1), rs.getString(2), rs.getString(3), 
										 rs.getString(4), rs.getString(5), rs.getString(6),
										 rs.getString(7), rs.getString(8)));
			}
		}catch(SQLException e)
			{
				System.out.println("Error: " + e.getSQLState());
			}
		
		//Set cell value factory to tableview.
		//NB.PropertyValue Factory must be the same with the one set in the model class.
		
	
		column1t1.setCellValueFactory(new PropertyValueFactory<>("name"));
		column2t1.setCellValueFactory(new PropertyValueFactory<>("surname"));
		column3t1.setCellValueFactory(new PropertyValueFactory<>("street"));
		column4t1.setCellValueFactory(new PropertyValueFactory<>("city"));
		column5t1.setCellValueFactory(new PropertyValueFactory<>("state"));
		column6t1.setCellValueFactory(new PropertyValueFactory<>("zipCode"));
		column7t1.setCellValueFactory(new PropertyValueFactory<>("phone"));
		column8t1.setCellValueFactory(new PropertyValueFactory<>("email"));
		
		
		
		table1.setItems(null);
		table1.setItems(data);
		
		
		
		
		
		
		}
	public void setUser(String user){
		this.user = user;
	}
	
}
