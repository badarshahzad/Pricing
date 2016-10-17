package com.granitetransformations.Pricing;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import org.controlsfx.control.spreadsheet.GridBase;
import org.controlsfx.control.spreadsheet.SpreadsheetCell;
import org.controlsfx.control.spreadsheet.SpreadsheetCellType;
import org.controlsfx.control.spreadsheet.SpreadsheetColumn;
import org.controlsfx.control.spreadsheet.SpreadsheetView;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Callback;

public class TestController implements Initializable {
	@FXML BorderPane borderPane1;
	Stage stage;
	SpreadsheetView spreadSheet;
	Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
	String user;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		 int rowCount = 200;
	     int columnCount = 100;
	     GridBase grid = new GridBase(rowCount, columnCount);
	     grid.setRowHeightCallback(new Callback<Integer, Double>() {
			
			@Override
			public Double call(Integer param) {
				
				return 50.00;
			}
		});
	     
	     ObservableList<ObservableList<SpreadsheetCell>> rows = FXCollections.observableArrayList();
	     for (int row = 0; row < grid.getRowCount(); ++row) {
	         final ObservableList<SpreadsheetCell> list = FXCollections.observableArrayList();
	         for (int column = 0; column < grid.getColumnCount(); ++column) {
	             list.add(SpreadsheetCellType.STRING.createCell(row, column, 1, 1,"value"));
	         }
	         rows.add(list);
	     }
	     grid.setRows(rows);
	    
	     SpreadsheetView spv = new SpreadsheetView(grid);
	    ObservableList<SpreadsheetColumn> column = spv.getColumns();
	    for(SpreadsheetColumn item: column){
	    	System.out.println(item.getWidth());
	    	//item.setMinWidth(60);
	    	item.fitColumn();
	    }
	   
	     //spv.setMinSize(50, 50);
	    // spv.setPrefSize(100, 100);
	    
	     //printSpreadSheetProperties(spv);
	     borderPane1.setCenter(spv);
		
		
	    
	}
	public void setStage(Stage stage){
		this.stage = stage;
	}
	@FXML private void backButton(ActionEvent event) throws IOException{
		((Node)event.getSource()).getScene().getWindow().hide();
		Stage userStage = new Stage();
		FXMLLoader fxmlLoader = new FXMLLoader();
		Pane root = fxmlLoader.load(getClass().getResourceAsStream("/fxml/MainScreen.fxml"));
		MainScreenController controller = fxmlLoader.getController();
		controller.setUsername(user);
		
		Scene scene = new Scene(root, screenBounds.getWidth(), screenBounds.getHeight());

		userStage.setScene(scene);
		userStage.show();
	}
	public void printSpreadSheetProperties(SpreadsheetView spv){
		System.out.println("Spreadsheet computed area in screen " + spv.computeAreaInScreen());
		System.out.println("Spreadsheet X layour" + spv.getLayoutX() );
		System.out.println("Spreadsheet Layout Y" + spv.getLayoutY());
		System.out.println("Spreadsheet Row Header Width: " + spv.getRowHeaderWidth());
		System.out.println("Spreadsheet Preferred Width: " + spv.getPrefWidth());
		System.out.println("Spreadsheet Preferred Height: " + spv.getPrefHeight());
	}
	public void setUser(String user){
		this.user = user;
	}
}
