package com.granitetransformations.Pricing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.granitetransformations.Pricing.Model.CountertopDetails;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainApp extends Application {
 
    
    public static void main(String[] args) throws Exception
    {
        launch(args);
    }

    public void start(Stage stage) throws Exception 
    {
        String fxmlFile = "/fxml/Login.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
        LoginController controller = loader.getController();
        controller.setStage(stage);
        Scene scene = new Scene(rootNode);
        
        scene.getStylesheets().add("/styles/styles.css"); 
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Granite Transformations Pricing Tool");
        stage.setScene(scene);
        stage.show();
        
       
    }
}
