package com.granitetransformations.Pricing;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.commons.dbutils.DbUtils;

import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.util.StringConverter;

import com.granitetransformations.Pricing.Model.CustomerDetails;
import com.granitetransformations.Pricing.Model.Bathroom.ShowerDetails;
import com.granitetransformations.Pricing.Utils.FxDialogs;

public class ShowerController implements Initializable{
	Stage showerStage;
	Scene scene;
	SqliteConnection db;
	String currentName;
	String currentSurName;
	IntegerProperty CurrentCustomerId = new SimpleIntegerProperty();
	IntegerProperty currentEmployeeId = new SimpleIntegerProperty();
	IntegerProperty currentOrderId = new SimpleIntegerProperty();
	
	UpdateCustomer update = new UpdateCustomer();
	
	@FXML Label CustomerLabel;
	@FXML TableView<ShowerDetails> showerTable;
	@FXML TableColumn<ShowerDetails, Double> column1t1;
	@FXML TableColumn<ShowerDetails, Double> column2t1;
	@FXML CheckBox showIncludeCheckBox;
	
	@FXML private ObservableList<ShowerDetails> showerData = FXCollections.observableArrayList();
	@FXML private ObservableList<CustomerDetails> data = FXCollections.observableArrayList();
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		db = new SqliteConnection();
		Callback<TableColumn<ShowerDetails, Double>, TableCell<ShowerDetails, Double>> cellFactoryDouble =
				p -> new EditingCellDouble();
		column1t1.setCellFactory(cellFactoryDouble);
		column2t1.setCellFactory(cellFactoryDouble);
		column1t1.setCellValueFactory(cellData -> cellData.getValue().lengthProperty().asObject());
		column2t1.setCellValueFactory(cellData -> cellData.getValue().widthProperty().asObject());
		showerTable.setItems(showerData);
		
		CurrentCustomerId.addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
				System.out.println("Old Value: " + oldValue);
				System.out.println("New Value: " + newValue);
				
			}
		});
		currentOrderId.addListener((ObservableValue<? extends Number> ov, Number oldVal,
		        Number newVal) -> {
		            System.out.println("OrderId old value:"+oldVal);
		            System.out.println("OrderId new value:"+newVal);
		        });
		currentEmployeeId.addListener((ObservableValue<? extends Number> ov, Number oldVal,
		        Number newVal) -> {
		            System.out.println("EmployeeId old value:"+oldVal);
		            System.out.println("EmployeeId new value:"+newVal);
		        });
		showIncludeCheckBox.setOnAction((event) -> {
			if(!showerData.isEmpty()){
				for(ShowerDetails item: showerData){
					item.includeProperty().set(showIncludeCheckBox.isSelected());
				}
			}
				boolean newVal = showIncludeCheckBox.isSelected();
	          System.out.println("Shower Included Check Box new value:"+newVal);
		});
		
		
	}
	public void setStage(Stage stage, Scene scene){
		this.showerStage = stage;
		this.scene = scene;
	}
	public void setCustomer(ObservableList<CustomerDetails> customer){
		data = customer;
		StringProperty name = new SimpleStringProperty("none");
		for(CustomerDetails item: customer){
			currentName = item.getName();
			currentSurName = item.getSurname();
			CurrentCustomerId.set(item.customerIdProperty().get());
			name.set(item.getSurname().concat(", ").concat(item.getName()));
		
		}
		
		CustomerLabel.textProperty().bind(name);
	}
	public void setCustomerId(int customerId){
		this.CurrentCustomerId.set(customerId);
	}
	public void setEmployeeId(int employeeId){
		this.currentEmployeeId.set(employeeId);
	}
	public void setOrderId(int orderId){
		System.out.println("Setting order Id as: " + orderId);
		currentOrderId.set(orderId);
		getShower();
		System.out.println("Order Id after getAllData: " + currentOrderId);
	}
	@FXML private void PrintCustomer(){
		System.out.println(data.toString());
	}
	@FXML private void printOrderId(){
		System.out.println("Current Order Id: " + currentOrderId);
	}
	@FXML private void printCustomerId(){
		System.out.println("Current CustomerId: " + CurrentCustomerId);
	}
	@FXML private void printEmployeeId(){	
		System.out.println("Current EmployeeId: " + currentEmployeeId);
	}
	@FXML private void printShower(){
		System.out.println("Current EmployeeId: " + showerData.toString());

	}
	@FXML private void Minimize(){
		showerStage.setIconified(true);
	}
	@FXML private void Exit(){
		Platform.exit();
	}
	@FXML private void showDateAndTime(){
		LocalDateTime time = LocalDateTime.now();
		System.out.println("Time: " + time);
	}
	@FXML private void findCustomer(ActionEvent event) throws IOException{
		((Node)event.getSource()).getScene().getWindow().hide();
		Stage userStage = new Stage();
		FXMLLoader fxmlLoader = new FXMLLoader();
		Pane root = fxmlLoader.load(getClass().getResourceAsStream("/fxml/Main.fxml"));
		Scene scene = new Scene(root);
		FindController controller = fxmlLoader.getController();
//		controller.setUser(userNameLabel.getText(), userStage);
		
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
	@FXML private void addRowTable1(){
		ShowerDetails shower = new ShowerDetails(currentOrderId.get(), CurrentCustomerId.get(), currentEmployeeId.get());
		showerData.add(shower);
	}
	/**
	 * handleDeleteButtonT1 method deletes the selected row from Countertop table in the database.
	 */
	@FXML private void handleDeleteRowT1(){
		String tableName = "Shower";
		String idName = "id";
		int selectedIndex = showerTable.getSelectionModel().getSelectedIndex();
		if(selectedIndex >= 0) {
			int id = showerTable.getItems().get(selectedIndex).idProperty().get();
			deleteRow(tableName, idName, id);
			showerTable.getItems().remove(selectedIndex);
			System.out.println("Index " + selectedIndex + ": deleted");
		}
		else{
			FxDialogs.showError("Warning: Something Is Wrong With Selection", "Something Went Wrong With Countertop Table");
		}
	}
	public class EditingCellDouble extends TableCell<ShowerDetails, Double> {
	    private TextField textField;
	    private TextFormatter<Double> textFormatter;

	    private DecimalFormat decimalFormat;

	    public EditingCellDouble(String...styleClass){
	        Locale locale = new Locale("US");
	        String pattern ="##.##";
	        decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(locale);
	        getStyleClass().addAll(styleClass);

	    }
	    @Override
	    public void startEdit(){
	        if(!isEmpty()){
	            super.startEdit();
	            createTextField();
	            setText(null);
	            setGraphic(textField);
	            textField.requestFocus();
	        }
	    }
	    @Override
	    public void cancelEdit() {
	        super.cancelEdit();

	        setText(decimalFormat.format(getItem()));
	        setGraphic(null);
	    }

	    @Override
	  public void updateItem(Double item, boolean empty) {
	        super.updateItem(item, empty);

	        if (empty) {
	            setText(null);
	            setGraphic(null);
	        } else {
	            if (isEditing()) {
	                if (textField != null) {
	                    textField.setText(getDouble());
	                }
	                setText(null);
	                setGraphic(textField);

	            } else {
	                setText(getDouble());
	                setGraphic(null);
	            }
	        }
	    }
	    private void createTextField()
	    {

	        textField = new TextField();
	        StringConverter<Double> converter = new StringConverter<Double>() {
	            @Override
	            public String toString(Double number) {
	                return decimalFormat.format(number);
	            }

	            @Override
	            public Double fromString(String string) {
	                try{
	                    double value = decimalFormat.parse(string).doubleValue();
	                    return value;
	                }catch (ParseException e){
	                    e.printStackTrace();
	                    return 0.0;
	                }

	            }
	        };
	        textFormatter = new TextFormatter<Double>(converter, 0.0, change -> {
	            if(change.getControlNewText().isEmpty()){
	                return change;
	            }
	            ParsePosition parsePosition = new ParsePosition(0);
	            Object object = decimalFormat.parse(change.getControlNewText(), parsePosition);

	            if(object == null || parsePosition.getIndex() < change.getControlNewText().length()){
	                return null;
	            }
	            else
	            {
	                return change;
	            }
	        });

	        textField.setTextFormatter(textFormatter);
	        textField.setText(getDouble());
	        textField.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);

	        textFormatter.valueProperty().addListener((observable, oldValue, newValue) -> {
	            commitEdit(newValue);
	        });


	    }
	    private String getDouble(){
	        return getItem() == null ? "" : decimalFormat.format(getItem());
	    }

	}

	public void deleteRow(String tableName, String idName, int id){
		Connection conn = null;
		try{
			 	conn = db.Connector();
			 	String statement = "delete from " +  tableName + " where " + idName + " = " + id;
			 	PreparedStatement psParms = conn.prepareStatement(statement);
			 	psParms.execute();
			 	System.out.println("Delected ctId: " + id);
			 	conn.close();
		 }
		catch(SQLException e){
			 	FxDialogs.showException("Exception Thrown Deleting Row in " + tableName + " Table", "check existence", e);
		 }finally{DbUtils.closeQuietly(conn);}
	}  
	@FXML private void saveShower(){
		update.updateShower(showerData);
		System.out.println("Finished Setting; Now Getting"); 
	
	}
	@FXML private void getShower(){
		Connection conn = null;
		Statement statement = null;
		String stmt = "Select * from Shower where orderId = " + currentOrderId.get();
		System.out.println(stmt);
		try{
			conn = db.Connector();
			
			
			statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(stmt);
			while(rs.next()){
				ShowerDetails shower = new ShowerDetails();
				
				shower.setId(rs.getInt("Id"));
				shower.setLength(rs.getDouble("Length"));
				shower.setWidth(rs.getDouble("Width"));
				shower.setInclude(rs.getBoolean("Include"));
				shower.includeProperty().set(rs.getBoolean("Include"));
				shower.setColor(rs.getString("Color"));
				shower.setOrderId(rs.getInt("orderId"));
				shower.setCustomerId(rs.getInt("customerId"));
				shower.setEmployeeId(rs.getInt("employeeId"));
				shower.setSalesPersonId(rs.getInt("salesPersonId"));
				//shower.setDate(rs.getString("Date"));
				
				
				showerData.add(shower);
				
			}
		
		}catch(SQLException e){FxDialogs.showException("Uhoh", "Something went wrong with getting Shower Data", e);}
		finally{DbUtils.closeQuietly(conn);}
	}
}
