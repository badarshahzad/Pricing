package com.granitetransformations.Pricing;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.granitetransformations.Pricing.Model.LoginModel;
import com.granitetransformations.Pricing.Utils.FxDialogs;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class LoginController implements Initializable
{
	Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    public LoginModel loginModel = new LoginModel();
    @FXML private Label isConnect;
    @FXML private TextField userNameField;
    @FXML private TextField lastNameField;
    @FXML private PasswordField passwordField;
    @FXML private Label messageLabel;
    @FXML private Button loginButton;
    @FXML private ImageView imageView;
    Stage loginStage;
    
		public void initialize(URL location, ResourceBundle resources) {
			
			userNameField.requestFocus();
			
			
			 String imgFile = "C:\\GTPricing\\Images\\logo-mark.jpg";
             
	            try {
					FileInputStream inputStream = new FileInputStream(imgFile);
					Image image = new Image(inputStream);
					imageView.setImage(image);
				} catch (FileNotFoundException e1) {
					
					e1.printStackTrace();
				}
		
			
			
		if(loginModel.isDbConnected()){
			isConnect.setText("Connected");
			
		}else{
			isConnect.setText("Not Connected");
		}
		passwordField.setOnKeyPressed((event) -> { 
			if(event.getCode() == KeyCode.ENTER) 
			{
				try {
					loginEnter(event);
				} catch (Exception e) {
					System.out.println("Exception Occured");
					e.printStackTrace();
				}
				System.out.println("Enter Key Pressed");
			}
			});
	}
    
	public void setStage(Stage stage){
		this.loginStage = stage;
	}
	

	

	public void loginEnter(KeyEvent event) throws SQLException, IOException{
		try{
		if(loginModel.isLogin(userNameField.getText(), passwordField.getText()))
		{
			isConnect.setText("Username and password is correct");
			((Node)event.getSource()).getScene().getWindow().hide();
			Stage userStage = new Stage();
			FXMLLoader fxmlLoader = new FXMLLoader();
			Pane root = fxmlLoader.load(getClass().getResourceAsStream("/fxml/MainScreen.fxml"));
			Scene scene = new Scene(root);
			MainScreenController controller = fxmlLoader.getController();
			System.out.println("Username: " + userNameField.getText() );
			String username = userNameField.getText();
			controller.setUsername(username);
			controller.setStage(userStage);
			
			userNameField.requestFocus();
			scene.getStylesheets().add("/styles/styles.css"); 
			Screen screen = Screen.getPrimary();
			Rectangle2D bounds = screen.getVisualBounds();
			userStage.initStyle(StageStyle.UNDECORATED);
			userStage.setX(bounds.getMinX());
			userStage.setY(bounds.getMinY());
			userStage.setWidth(bounds.getWidth());
			userStage.setHeight(bounds.getHeight());
			userStage.setScene(scene);
		
			userStage.show();
			FxDialogs.TrayInfo("Welcome", userNameField.getText());
			
			
		}else
		{
			isConnect.setText("Username and password is not correct");
		}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void login(ActionEvent event) throws SQLException, IOException{
		try{
		if(loginModel.isLogin(userNameField.getText(), passwordField.getText()))
		{
			isConnect.setText("Username and password is correct");
			((Node)event.getSource()).getScene().getWindow().hide();
			Stage userStage = new Stage();
			FXMLLoader fxmlLoader = new FXMLLoader();
			Pane root = fxmlLoader.load(getClass().getResourceAsStream("/fxml/MainScreen.fxml"));
			Scene scene = new Scene(root, screenBounds.getWidth(), screenBounds.getHeight());
			MainScreenController controller = fxmlLoader.getController();
			System.out.println("Username: " + userNameField.getText() );
			controller.setUsername(userNameField.getText());
			scene.getStylesheets().add("/styles/styles.css"); 
			Screen screen = Screen.getPrimary();
			Rectangle2D bounds = screen.getVisualBounds();
			userStage.initStyle(StageStyle.UNDECORATED);
			userStage.setX(bounds.getMinX());
			userStage.setY(bounds.getMinY());
			userStage.setWidth(bounds.getWidth());
			userStage.setHeight(bounds.getHeight());
			userStage.setScene(scene);
			userStage.show();
			
			
			FxDialogs.TrayInfo("Welcome", userNameField.getText());
			
		}else
		{
			isConnect.setText("Username and password is not correct");
		}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
    public void sayHello() {

        String firstName = userNameField.getText();
        String lastName = lastNameField.getText();

        StringBuilder builder = new StringBuilder();

        if (!StringUtils.isEmpty(firstName)) {
            builder.append(firstName);
        }

        if (!StringUtils.isEmpty(lastName)) {
            if (builder.length() > 0) {
                builder.append(" ");
            }
            builder.append(lastName);
        }

        if (builder.length() > 0) {
            String name = builder.toString();
            log.debug("Saying hello to " + name);
            messageLabel.setText("Hello " + name);
        } else {
            log.debug("Neither first name nor last name was set, saying hello to anonymous person");
            messageLabel.setText("Hello mysterious person");
        }
    }
    
    @FXML private void EndPropgram(){
    	Platform.exit();
    }


    
}
