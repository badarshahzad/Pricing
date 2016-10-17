package com.granitetransformations.Pricing;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import com.granitetransformations.Pricing.Utils.Images;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainScreenController implements Initializable{
	String username1;
	@FXML Label userNameLabel;
	Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
	Stage userStage;
	Stage MainScreenStage;
	@FXML MenuItem closeItem;
	@FXML Button exitButton1;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	closeItem.graphicProperty().set(Images.exit());
		//exitButton1.graphicProperty().set(Images.exitIcon());
	}
	public void setStage(Stage stage){
		this.MainScreenStage = stage;
	}
	public void OpenEmployees(ActionEvent event) throws IOException{
		((Node)event.getSource()).getScene().getWindow().hide();
		Stage userStage = new Stage();
		FXMLLoader fxmlLoader = new FXMLLoader();
		Pane root = fxmlLoader.load(getClass().getResourceAsStream("/fxml/User.fxml"));
		Scene scene = new Scene(root);
		UserController controller = fxmlLoader.load();
		
		controller.setUser(username1);
		userStage.setScene(scene);
		userStage.show();
	}
	public void NewCustomer(ActionEvent event) throws IOException{
		((Node)event.getSource()).getScene().getWindow().hide();
		Stage userStage = new Stage();
		FXMLLoader fxmlLoader = new FXMLLoader();
		Pane root = fxmlLoader.load(getClass().getResourceAsStream("/fxml/NewCustomer.fxml"));
		NewCustomerController controller = fxmlLoader.getController();
		String user = userNameLabel.getText();
		System.out.println("Setting User: " + user + " to Main");
		root.getStylesheets().add("/styles/styles.css"); 
		controller.setUser(user);
		controller.setStage(userStage);
		Scene scene = new Scene(root);
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();
		userStage.initStyle(StageStyle.UNDECORATED);
		userStage.setX(bounds.getMinX());
		userStage.setY(bounds.getMinY());
		userStage.setWidth(bounds.getWidth());
		userStage.setHeight(bounds.getHeight());
		userStage.setScene(scene);
		userStage.show();
	}
	public void findCustomer(ActionEvent event) throws IOException{
		((Node)event.getSource()).getScene().getWindow().hide();
		Stage userStage = new Stage();
		FXMLLoader fxmlLoader = new FXMLLoader();
		Pane root = fxmlLoader.load(getClass().getResourceAsStream("/fxml/CustomerInformation.fxml"));
		Scene scene = new Scene(root);
		CustomerInformationController controller = fxmlLoader.getController();
		controller.setUser(userNameLabel.getText());
		root.getStylesheets().add("/styles/styles.css");
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();
		userStage.initStyle(StageStyle.UNDECORATED);
		userStage.setX(bounds.getMinX());
		userStage.setY(bounds.getMinY());
		userStage.setWidth(bounds.getWidth());
		userStage.setHeight(bounds.getHeight());
		userStage.setScene(scene);
		userStage.show();
	}
	
	public void editExistingCustomer(ActionEvent event) throws IOException{
		((Node)event.getSource()).getScene().getWindow().hide();
		Stage userStage = new Stage();
		FXMLLoader fxmlLoader = new FXMLLoader();
		Pane root = fxmlLoader.load(getClass().getResourceAsStream("/fxml/Main.fxml"));
		Scene scene = new Scene(root);
		FindController controller = fxmlLoader.getController();
		controller.setUser(userNameLabel.getText(), userStage, scene);
		controller.setCheckBox();
		root.getStylesheets().add("/styles/styles.css");
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();
		userStage.initStyle(StageStyle.UNDECORATED);
		userStage.setX(bounds.getMinX());
		userStage.setY(bounds.getMinY());
		userStage.setWidth(bounds.getWidth());
		userStage.setHeight(bounds.getHeight());
		userStage.setScene(scene);
		userStage.show();
	}

	public void testButton(ActionEvent event) throws IOException{
		((Node)event.getSource()).getScene().getWindow().hide();
		userStage = new Stage();
		FXMLLoader fxmlLoader = new FXMLLoader();
		Pane root = fxmlLoader.load(getClass().getResourceAsStream("/fxml/Test.fxml"));
		TestController controller = fxmlLoader.getController();
		controller.setStage(userStage);
		controller.setUser(username1);
		root.getStylesheets().add("/styles/styles.css");
		Scene scene = new Scene(root);
		userStage.setScene(scene);
		userStage.show();
	}
	@FXML private void kitchen(ActionEvent event) throws IOException
	{
	  ((Node)event.getSource()).getScene().getWindow().hide();
	  userStage = new Stage();
	  FXMLLoader fxmlLoader = new FXMLLoader();
	  Pane root = fxmlLoader.load(getClass().getResourceAsStream("/fxml/Kitchen.fxml"));
	  KitchenController controller = fxmlLoader.getController();
	  Scene scene = new Scene(root);
	  controller.setStage(userStage, scene);
	
	  
	  Screen screen = Screen.getPrimary();
	  root.getStylesheets().add("/styles/styles.css"); 
	  Rectangle2D bounds = screen.getVisualBounds();
	  userStage.initStyle(StageStyle.UNDECORATED);
	  userStage.setX(bounds.getMinX());
	  userStage.setY(bounds.getMinY());
	  userStage.setWidth(bounds.getWidth());
	  userStage.setHeight(bounds.getHeight());
	  userStage.setScene(scene);
	  userStage.show();
	}


	
	public void setUsername(String username){
		System.out.println("Who is the user? " + username);
			userNameLabel.setText(username);
	}
	@FXML private void Exit(){
		Platform.exit();
	}
	@FXML private void Minimize(){
		MainScreenStage.setIconified(true);
	}
	@FXML private void showDateAndTime(){
		LocalDateTime time = LocalDateTime.now();
		System.out.println("Time: " + time);
		
	}
}
