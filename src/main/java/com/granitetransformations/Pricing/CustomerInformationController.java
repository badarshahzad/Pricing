package com.granitetransformations.Pricing;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CustomerInformationController implements Initializable {
	Stage userStage;
	String user;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	@FXML private void SignOut(ActionEvent event) throws IOException
	{
		((Node)event.getSource()).getScene().getWindow().hide();
		userStage = new Stage();
		FXMLLoader fxmlLoader = new FXMLLoader();
		Pane root = fxmlLoader.load(getClass().getResourceAsStream("/fxml/MainScreen.fxml"));
		MainScreenController controller = fxmlLoader.getController();
		controller.setUsername(user);
		Scene scene = new Scene(root);
		userStage.setScene(scene);
		userStage.show();
	}
	public void setUser(String user){
		this.user = user;
		System.out.println("User: ?"+ user);
	}
}
