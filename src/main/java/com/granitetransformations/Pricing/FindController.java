package com.granitetransformations.Pricing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.commons.dbutils.DbUtils;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.controlsfx.control.CheckComboBox;
import org.controlsfx.control.ListSelectionView;
import org.controlsfx.control.Notifications;
import com.granitetransformations.Pricing.Model.CountertopDetails;
import com.granitetransformations.Pricing.Model.CustomerDetails;
import com.granitetransformations.Pricing.Model.EdgingDetails;
import com.granitetransformations.Pricing.Model.FourInchBacksplashDetails;
import com.granitetransformations.Pricing.Model.FourInchBacksplashEdging;
import com.granitetransformations.Pricing.Model.FullBacksplashCustomDetails;
import com.granitetransformations.Pricing.Model.FullBacksplashDetails;
import com.granitetransformations.Pricing.Model.FullBacksplashEdgingDetails;
import com.granitetransformations.Pricing.Model.GranteColorsModel;
import com.granitetransformations.Pricing.Model.MosaicBacksplashDetails;
import com.granitetransformations.Pricing.Model.MosaicBacksplashOptionsDetails;
import com.granitetransformations.Pricing.Model.Opts1;
import com.granitetransformations.Pricing.Utils.FxDialogs;

import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.util.Duration;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;


public class FindController implements Initializable{
	@FXML MenuItem updateBut;
	Scene scene;
	private SqliteConnection db;
	StringProperty currentName = new SimpleStringProperty();
	StringProperty currentSurName = new SimpleStringProperty();
	StringProperty currentStreet = new SimpleStringProperty();
	StringProperty currentState = new SimpleStringProperty();
	StringProperty currentCity = new SimpleStringProperty();
	StringProperty currentZipCode = new SimpleStringProperty();
	StringProperty currentPhone = new SimpleStringProperty();
	StringProperty currentEmail = new SimpleStringProperty();
	int CurrentCustomerId;
	int currentOrderId;
	@FXML Button wordButton1;
	@FXML TextField firstNameField;
	@FXML TextField lastNameField;
	@FXML TextField streetField;
	@FXML TextField cityField;
	@FXML TextField stateField;
	@FXML TextField zipCodeField;
	@FXML TextField phoneField;
	@FXML TextField emailField;
	@FXML TableView<CustomerDetails> table2;
	@FXML TableColumn<CustomerDetails, String> column1t2;
	@FXML TableColumn<CustomerDetails, String> column2t2;
	@FXML TableColumn<CustomerDetails, String> column3t2;
	@FXML TableColumn<CustomerDetails, String> column4t2;
	@FXML TableColumn<CustomerDetails, String> column5t2;
	@FXML TableColumn<CustomerDetails, String> column6t2;
	@FXML TableColumn<CustomerDetails, String> column7t2;
	@FXML TableColumn<CustomerDetails, String> column8t2;
	@FXML TableColumn<CustomerDetails, Integer> column9t2;
	@FXML TableColumn<CustomerDetails, Integer> column10t2;
	@FXML TableView<CountertopDetails> kitchenTable;
	@FXML TableColumn<CountertopDetails, String> column1t1;
	@FXML TableColumn<CountertopDetails, Double> column2t1;
	@FXML TableColumn<CountertopDetails, Double> column3t1;
	@FXML TableColumn<CountertopDetails, Integer> column5t1;
	
	
	@FXML CheckBox countertopIncludeCheckBox;

    @FXML TableView<EdgingDetails> edgingTable;
    @FXML TableColumn<EdgingDetails, Double> column1t6;
    @FXML TableColumn<EdgingDetails, Boolean> column2t6;
    @FXML TableColumn<EdgingDetails, Boolean> column3t6;
    @FXML CheckBox ctEdgingIncludeCheckBox;
    
    
	@FXML TableView<FourInchBacksplashDetails> backsplashTable;
	@FXML TableColumn<FourInchBacksplashDetails, String> column1t3;
	@FXML TableColumn<FourInchBacksplashDetails, Double> column2t3;
	@FXML TableColumn<FourInchBacksplashDetails, Double> column3t3;
	@FXML TableColumn<FourInchBacksplashDetails, Integer> column4t3;
	@FXML CheckBox FourInchBSIncludeCheckBox;
    @FXML TextField buildOutsFieldT3;
    
	@FXML TableView<FullBacksplashDetails> fullBackSplashTable;
	@FXML TableColumn<FullBacksplashDetails, String> column1t4;
	@FXML TableColumn<FullBacksplashDetails, Double> column2t4;
	@FXML TableColumn<FullBacksplashDetails, Double> column3t4;
	@FXML CheckBox FullBackSplashIncludeCheckBox;
	@FXML CheckBox trendStoneFullBacksplashCheckBox;
	@FXML CheckBox MosaicBackSplashIncludeCheckBox;
	
	@FXML TableView<FullBacksplashEdgingDetails> fullBacksplashEdgingTable;
	@FXML TableColumn<FullBacksplashEdgingDetails, Double> column1t9;
	@FXML TableColumn<FullBacksplashEdgingDetails, Double> column2t9;
	@FXML TableColumn<FullBacksplashEdgingDetails, Boolean> column4t9;

	@FXML CheckBox fullBacksplashEdgingIncludeCheckBox;
	

	@FXML TableView<FourInchBacksplashEdging> fourInchBackSplashEdgingTable;
	@FXML TableColumn<FourInchBacksplashEdging, Double> column1t7;
	@FXML TableColumn<FourInchBacksplashEdging, Double> column2t7;

	@FXML CheckBox fourInchEdgingIncludeCheckBox;
	
	@FXML ChoiceBox<String> gColorBox1;
	@FXML ChoiceBox<String> gColorBox2;
	@FXML ChoiceBox<String> gColorBox3;
	@FXML ChoiceBox<String> gColorBox4;
	@FXML ChoiceBox<String> gColorBox5;
	@FXML ChoiceBox<String> gColorBox6;

@FXML CheckBox check1;
@FXML CheckBox check2;
@FXML CheckBox check3;
@FXML CheckBox check4;
@FXML CheckBox check5;
@FXML CheckBox check6;
@FXML CheckBox check7;
@FXML CheckBox check8;
@FXML CheckBox check9;
@FXML CheckBox check10;
@FXML CheckBox check11;
@FXML CheckBox check12;
@FXML CheckBox check13;
@FXML CheckBox check14;
@FXML CheckBox check15;
@FXML CheckBox check16;
@FXML CheckBox check17;
@FXML CheckBox check18;
@FXML CheckBox check19;
@FXML CheckBox check20;
@FXML TextField optionsField;
@FXML CheckBox mosaicCheckBox;
@FXML TextField bevelEdgingFieldt5NotCalc;
@FXML TextArea extraText;
@FXML TextField check1TextField;
@FXML TextField check2TextField;
@FXML TextField check3TextField;
@FXML TextField check4TextField;
@FXML TextField check5TextField;
@FXML TextField check6TextField;
@FXML TextField check7TextField;
@FXML TextField check8TextField;
@FXML TextField check9TextField;
@FXML TextField check10TextField;
@FXML TextField check11TextField;
@FXML TextField check12TextField;
@FXML TextField check13TextField;
@FXML TextField check14TextField;
@FXML TextField check15TextField;
@FXML TextField check16TextField;
@FXML TextField check17TextField;
@FXML TextField check18TextField;
@FXML TextField check19TextField;
@FXML TextField check20TextField;
@FXML TextField tableTotalField;
@FXML TextField trendFieldt5;
@FXML TextField edgingFieldt5;
@FXML TextField subTotalFieldt5;
@FXML TextField plumbingField;
@FXML TextField accessoriesField;
@FXML TextField switchPlatesField;
@FXML TextField toeKicksTextField;
@FXML ComboBox<String> box;
int currentBacksplashCustomId;
int currentOptionId;
int currentEmployeeId = 0;
@FXML Button loadButton;
	@FXML TabPane tabPane;
	@FXML Tab tab2;
	@FXML Label CustomerLabel;
	@FXML ListSelectionView<String> listView;
	Stage mainControllerStage;
	ObservableList<String> index;
	private ObservableList<CountertopDetails> countData = FXCollections.observableArrayList();
	private ObservableList<FourInchBacksplashEdging> fourInchBacksplashEdgingData = FXCollections.observableArrayList();
	private ObservableList<CustomerDetails> data = FXCollections.observableArrayList();
	private ObservableList<EdgingDetails> edgingData = FXCollections.observableArrayList();
	private ObservableList<FourInchBacksplashDetails> fourInchData = FXCollections.observableArrayList();
	private ObservableList<FullBacksplashDetails> fullBacksplashData = FXCollections.observableArrayList();
	private ObservableList<FullBacksplashCustomDetails> fullBacksplashCustomData = FXCollections.observableArrayList();
	private ObservableList<FullBacksplashEdgingDetails> fullBacksplashEdgingData = FXCollections.observableArrayList();
	private ObservableList<Opts1> opt1Data = FXCollections.observableArrayList();
	private ObservableList<GranteColorsModel> graniteColorsData = FXCollections.observableArrayList();
	private ObservableList<String> orders = FXCollections.observableArrayList();
	private ObservableList<String> jobData = FXCollections.observableArrayList();
	
	String user;
	int count;
	boolean nameFlag = false;
	boolean surnameFlag = false;
	boolean streetFlag = false;
	boolean cityFlag = false;
	boolean stateFlag = false;
	boolean zipCodeFlag = false;
	boolean phoneFlag = false;
	boolean emailFlag = false;
	
	@FXML TextField cutOutsQuantityField;
	@FXML TextField stripeMosaicsField;
	@FXML TextField stripeCustomMosaics;
	@FXML TextField inlaysDiamond5x5Field;
	@FXML TextField inlaysDiamond12x12Field;
	@FXML TextField fourInchBSField;
	@FXML TextField fourInchBSEdgingField;
	@FXML TextField fourInchBuildOutField;
	@FXML TextField fourInchTotalField;
	@FXML TextField areaFieldsqftT1;
	@FXML TextField bevelEdgingFieldt5;
	@FXML TextField polishedEdgingFieldT1;
	@FXML TextField totalLevelPriceKitchenField;
	@FXML TextField fullBSField;
	@FXML TextField bsEdgingField;
	@FXML TextField cutOutsField;
	@FXML TextField totalLevelPriceFullBSField;
	@FXML TextField totalFinalField;
	@FXML TextField totalFinalPlusField;
	@FXML TextField totalLevelPriceFourInchField;
	@FXML TextField mosaicStandardField;
	@FXML TextField mosaicCustomField;
	@FXML TextField mosaicBSEdgingField;
	@FXML TextField mosaicCutOutField;
	@FXML TextField mosaicInlay5Field;
	@FXML TextField mosaicInlay12Field;
	@FXML TextField mosaicTotalField;
	@FXML TextField edgingField1;
	@FXML TextField beveledEdgesField1;
	@FXML TextField polishedEdgesField1;
	@FXML TextField straightEdgeFieldT3;
	@FXML TextField straightEdgeFieldT2;
	@FXML TextField polishedEdgesFieldT3;
	@FXML TextField areaFieldsqftT2;
	@FXML TextField areaFieldsqftT3;
	@FXML TextField stripeCustomMosaics1;



@FXML TextField nameInformation;
@FXML TextField surNameInformation;
@FXML TextField streetinformation;
@FXML TextField cityInformation;
@FXML TextField stateInformation;
@FXML TextField zipCodeInformation;
@FXML TextField phoneInformation;
@FXML TextField emailInformation;
@FXML Tab tab1;
@FXML Tab tab3;
@FXML Tab tab4;
@FXML Tab tab5;
@FXML Tab tab6;
@FXML Tab tab7;
@FXML Tab tab8;
@FXML Tab tab9;
@FXML VBox vbox;
UpdateCustomer update = new UpdateCustomer();
@FXML Label checkedItemsLabel;
@FXML CheckComboBox<String> checkComboBox;
@FXML Button createButton;
@FXML ComboBox<String> typeComboBox;
StringProperty type = new SimpleStringProperty();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		db = new SqliteConnection();
		
		Callback<TableColumn<CountertopDetails, String>, TableCell<CountertopDetails, String>> cellFactory =
				p -> new EditingCell();
		Callback<TableColumn<CountertopDetails, Double>, TableCell<CountertopDetails, Double>> cellFactoryDouble =
				p -> new EditingCellDouble();
		Callback<TableColumn<EdgingDetails, Double>, TableCell<EdgingDetails, Double>> cellFactoryEdging =
				p -> new EditingCellEdgingDouble();
		Callback<TableColumn<FourInchBacksplashDetails, String>, TableCell<FourInchBacksplashDetails, String>> cellFactoryFourBackSplash =
				p -> new EditingCellTable3();
		Callback<TableColumn<FourInchBacksplashDetails, Double>, TableCell<FourInchBacksplashDetails, Double>> cellFactoryFourBackSplashDouble =
				p -> new EditingCellTable3Double();		
		Callback<TableColumn<FullBacksplashDetails, String>, TableCell<FullBacksplashDetails, String>> cellFactoryFullBacksplash =
				p -> new EditingCellFullBackSplash();
		Callback<TableColumn<FullBacksplashDetails, Double>, TableCell<FullBacksplashDetails, Double>> cellFactoryFullBackSplashDouble =
				p -> new EditingCellFullBackSplashDouble();
		Callback<TableColumn<FourInchBacksplashEdging, Double>, TableCell<FourInchBacksplashEdging, Double>> cellFactoryFourInchEdging = 
				p -> new EditingCellFourInchBSEdgingDouble();
		Callback<TableColumn<FullBacksplashEdgingDetails, Double>, TableCell<FullBacksplashEdgingDetails, Double>> cellFactoryFullBS =
				p -> new EditingCellFullBSEdgingDouble();
		
		//Table 1
		column1t1.setCellValueFactory(cellData -> cellData.getValue().pieceProperty());
		column2t1.setCellValueFactory(cellData -> cellData.getValue().lengthProperty().asObject());
		column3t1.setCellValueFactory(cellData -> cellData.getValue().widthProperty().asObject());
		column5t1.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
		//Make editable
		column1t1.setCellFactory(cellFactory);
		column2t1.setCellFactory(cellFactoryDouble);
		column3t1.setCellFactory(cellFactoryDouble);
		column10t2.setCellValueFactory(new PropertyValueFactory<>("customerId"));
		column1t2.setCellValueFactory(new PropertyValueFactory<>("name"));
		column2t2.setCellValueFactory(new PropertyValueFactory<>("surname"));
		column3t2.setCellValueFactory(new PropertyValueFactory<>("street"));
		column4t2.setCellValueFactory(new PropertyValueFactory<>("city"));
		column5t2.setCellValueFactory(new PropertyValueFactory<>("state"));
		column6t2.setCellValueFactory(new PropertyValueFactory<>("zipCode"));
		column7t2.setCellValueFactory(new PropertyValueFactory<>("phone"));
		column8t2.setCellValueFactory(new PropertyValueFactory<>("email"));
		db = new SqliteConnection();
		kitchenTable.setItems(countData);
		table2.setOnMousePressed(new EventHandler<MouseEvent>() {
		    @Override 
		    public void handle(MouseEvent event) {
		        if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
		            //Used to start measuring process. Sets the name and creates an orderId. 
		        	System.out.println(table2.getSelectionModel().getSelectedItem());   
		            tabPane.getSelectionModel().select(tab7);
		            CurrentCustomerId = table2.getSelectionModel().getSelectedItem().getCustomerId();
		            currentName.bindBidirectional(table2.getSelectionModel().getSelectedItem().nameProperty());
		            currentSurName.bindBidirectional(table2.getSelectionModel().getSelectedItem().surnameProperty());
		            currentStreet.bindBidirectional(table2.getSelectionModel().getSelectedItem().streetProperty());
		            currentCity.bindBidirectional(table2.getSelectionModel().getSelectedItem().cityProperty());
		            currentState.bindBidirectional(table2.getSelectionModel().getSelectedItem().stateProperty());
		            currentZipCode.bindBidirectional(table2.getSelectionModel().getSelectedItem().zipCodeProperty());
		            currentPhone.bindBidirectional(table2.getSelectionModel().getSelectedItem().phoneProperty());
		            currentEmail.bindBidirectional(table2.getSelectionModel().getSelectedItem().emailProperty());
		    		
		            nameInformation.textProperty().bindBidirectional(table2.getSelectionModel().getSelectedItem().nameProperty());
		            surNameInformation.textProperty().bindBidirectional(table2.getSelectionModel().getSelectedItem().surnameProperty());
		            streetinformation.textProperty().bindBidirectional(table2.getSelectionModel().getSelectedItem().streetProperty());
		            cityInformation.textProperty().bindBidirectional(table2.getSelectionModel().getSelectedItem().cityProperty());
		            stateInformation.textProperty().bindBidirectional(table2.getSelectionModel().getSelectedItem().stateProperty());
		            zipCodeInformation.textProperty().bindBidirectional(table2.getSelectionModel().getSelectedItem().zipCodeProperty());
		            phoneInformation.textProperty().bindBidirectional(table2.getSelectionModel().getSelectedItem().phoneProperty());
		            emailInformation.textProperty().bindBidirectional(table2.getSelectionModel().getSelectedItem().emailProperty());
		           // printCurrentCustomer(currentName, currentSurName, currentStreet, 
		            //		currentCity, currentState, currentZipCode, currentPhone, currentEmail, CurrentCustomerId);
		            CustomerLabel.textProperty().bind(currentSurName);
		           
		        }
		    }
		});
		
		//Table 2
		column1t3.setCellValueFactory(cellData -> cellData.getValue().pieceProperty());
		column2t3.setCellValueFactory(cellData -> cellData.getValue().lengthProperty().asObject());
		column3t3.setCellValueFactory(cellData -> cellData.getValue().widthProperty().asObject());
		column4t3.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
		// Makes Table 2 editable
		column1t3.setCellFactory(cellFactoryFourBackSplash);
		column2t3.setCellFactory(cellFactoryFourBackSplashDouble);
		column3t3.setCellFactory(cellFactoryFourBackSplashDouble);
		
		column1t4.setCellValueFactory(cellData -> cellData.getValue().pieceProperty());
		column2t4.setCellValueFactory(cellData -> cellData.getValue().lengthProperty().asObject());
		column3t4.setCellValueFactory(cellData -> cellData.getValue().widthProperty().asObject());
		//Makes Table 3 editable
		column1t4.setCellFactory(cellFactoryFullBacksplash);
		column2t4.setCellFactory(cellFactoryFullBackSplashDouble);
		column3t4.setCellFactory(cellFactoryFullBackSplashDouble); 
		
		column1t6.setCellValueFactory(cellData -> cellData.getValue().lengthProperty().asObject());
		column2t6.setCellValueFactory(new PropertyValueFactory<EdgingDetails, Boolean>("checkBoxBevel"));
		column3t6.setCellValueFactory(new PropertyValueFactory<EdgingDetails, Boolean>("checkBoxPolished"));
		column1t6.setCellFactory(cellFactoryEdging);
		column2t6.setCellFactory(new Callback<TableColumn<EdgingDetails ,Boolean>, TableCell<EdgingDetails ,Boolean>>() {

			 @Override
			    public CheckBoxTableCell<EdgingDetails,Boolean> call( TableColumn<EdgingDetails,Boolean> param )
			    {
			        return new CheckBoxTableCell<EdgingDetails,Boolean>()
			        {
			            {
			                setAlignment( Pos.CENTER );
			            }
			            @Override
						public void updateItem( Boolean item, boolean empty )
			            {
			                if ( ! empty )
			                {
			                    TableRow  row = getTableRow();

			                    if ( row != null )
			                    {
			                        int rowNo = row.getIndex();
			                        TableViewSelectionModel  sm = getTableView().getSelectionModel();

			                        if ( item )  sm.select( rowNo );
			                        else  sm.clearSelection( rowNo );
			                    }
			                }

			                super.updateItem( item, empty );
			            }
			        };
			    }
			} );
		column3t6.setCellFactory(new Callback<TableColumn<EdgingDetails ,Boolean>, TableCell<EdgingDetails ,Boolean>>() {

			 @Override
			    public CheckBoxTableCell<EdgingDetails,Boolean> call( TableColumn<EdgingDetails,Boolean> param )
			    {
			        return new CheckBoxTableCell<EdgingDetails,Boolean>()
			        {
			            {
			                setAlignment( Pos.CENTER );
			            }
			            @Override
						public void updateItem( Boolean item, boolean empty )
			            {
			                if ( ! empty )
			                {
			                    TableRow  row = getTableRow();

			                    if ( row != null )
			                    {
			                        int rowNo = row.getIndex();
			                        TableViewSelectionModel  sm = getTableView().getSelectionModel();

			                        if ( item )  sm.select( rowNo );
			                        else  sm.clearSelection( rowNo );
			                    }
			                }

			                super.updateItem( item, empty );
			            }
			        };
			    }
			} );
		
		column1t7.setCellValueFactory(cellData -> cellData.getValue().lengthProperty().asObject());
		column2t7.setCellValueFactory(cellData -> cellData.getValue().widthProperty().asObject());
	
		column1t7.setCellFactory(cellFactoryFourInchEdging);
		column2t7.setCellFactory(cellFactoryFourInchEdging);
		
		column1t9.setCellValueFactory(cellData -> cellData.getValue().lengthProperty().asObject());
		column2t9.setCellValueFactory(cellData -> cellData.getValue().widthProperty().asObject());
		column4t9.setCellValueFactory(cellData -> cellData.getValue().checkBoxPolishedProperty());
		column1t9.setCellFactory(cellFactoryFullBS);
		column2t9.setCellFactory(cellFactoryFullBS);
	
		column4t9.setCellFactory(new Callback<TableColumn<FullBacksplashEdgingDetails, Boolean>, TableCell<FullBacksplashEdgingDetails, Boolean>>() {

			 @Override
			    public CheckBoxTableCell<FullBacksplashEdgingDetails, Boolean> call( TableColumn<FullBacksplashEdgingDetails,Boolean> param )
			    {
			        return new CheckBoxTableCell<FullBacksplashEdgingDetails, Boolean>()
			        {
			            {
			                setAlignment( Pos.CENTER );
			            }
			            @Override
						public void updateItem( Boolean item, boolean empty )
			            {
			                if ( ! empty )
			                {
			                    TableRow  row = getTableRow();

			                    if ( row != null )
			                    {
			                        int rowNo = row.getIndex();
			                        TableViewSelectionModel  sm = getTableView().getSelectionModel();

			                        if ( item )  sm.select( rowNo );
			                        else  sm.clearSelection( rowNo );
			                    }
			                }

			                super.updateItem( item, empty );
			            }
			        };
			    }
			} );
		
		for(int index = 0; index < graniteColorsData.size(); index++){gColorBox1.getItems().addAll(graniteColorsData.get(index).getKey());}
		for(int index = 0; index < graniteColorsData.size(); index++){gColorBox2.getItems().addAll(graniteColorsData.get(index).getKey());}
		for(int index = 0; index < graniteColorsData.size(); index++){gColorBox3.getItems().addAll(graniteColorsData.get(index).getKey());}
		for(int index = 0; index < graniteColorsData.size(); index++){gColorBox4.getItems().addAll(graniteColorsData.get(index).getKey());}
		for(int index = 0; index < graniteColorsData.size(); index++){gColorBox5.getItems().addAll(graniteColorsData.get(index).getKey());}
		for(int index = 0; index < graniteColorsData.size(); index++){gColorBox6.getItems().addAll(graniteColorsData.get(index).getKey());}
		edgingTable.setItems(edgingData);
		backsplashTable.setItems(fourInchData);
		fullBackSplashTable.setItems(fullBacksplashData);
		fullBacksplashEdgingTable.setItems(fullBacksplashEdgingData);
		fourInchBackSplashEdgingTable.setItems(fourInchBacksplashEdgingData);
		jobData.addAll("Kitchen","Bathroom","Cabinets");
		
		
		checkComboBox.getItems().setAll(jobData);
		
		checkComboBox.getCheckModel().getCheckedItems().addListener(new ListChangeListener<String>() {
			@Override
			public void onChanged(javafx.collections.ListChangeListener.Change<? extends String> change) {
				 while (change.next()) {
	                    System.out.println("============================================");
	                    System.out.println("Change: " + change);
	                    System.out.println("Added sublist " + change.getAddedSubList());
	                    System.out.println("Removed sublist " + change.getRemoved());
	                    System.out.println("List " + change.getList());
	                    System.out.println("Added " + change.wasAdded() + " Permutated " + change.wasPermutated() + " Removed " + change.wasRemoved() + " Replaced "
	                            + change.wasReplaced() + " Updated " + change.wasUpdated());
	                    System.out.println("============================================");
	                    type.set(change.getList().get(0));
	                }
	            }
	        });
		ObservableList<String> type1 = FXCollections.observableArrayList();
		type1.add("Estimate");
		typeComboBox.setItems(type1);
		typeComboBox.setValue("Estimate");
		
		
	
		type.addListener((ObservableValue<? extends String> ov, String oldVal, String newVal) -> {
			System.out.println("Job Type Old Value: " + oldVal);
			System.out.println("Job Type New Value: " + newVal);

		});
		}
	
	@FXML private void show(){
		System.out.println("Ctl-S clicked");
	}
				
		public FindController(){
		graniteColorsData.add(new GranteColorsModel("Amarone", "B"));
		graniteColorsData.add(new GranteColorsModel("Bianco Modena", "B"));
		graniteColorsData.add(new GranteColorsModel("Black Star", "C"));
		graniteColorsData.add(new GranteColorsModel("Calacalta", "D"));
		graniteColorsData.add(new GranteColorsModel("Carrara", "D"));
		graniteColorsData.add(new GranteColorsModel("Chairo Ambra", "B"));
		graniteColorsData.add(new GranteColorsModel("Crema Luna", "B"));
		graniteColorsData.add(new GranteColorsModel("Dark Blue", "D"));
		graniteColorsData.add(new GranteColorsModel("Gardena", "B"));
		graniteColorsData.add(new GranteColorsModel("Karro Oro", "B"));
		graniteColorsData.add(new GranteColorsModel("King Ivory", "A"));
		graniteColorsData.add(new GranteColorsModel("Mocha Real", "C"));
		graniteColorsData.add(new GranteColorsModel("Mystic", "B"));
		graniteColorsData.add(new GranteColorsModel("Nero Galaxy", "B"));
		graniteColorsData.add(new GranteColorsModel("Nero Stella", "C"));
		graniteColorsData.add(new GranteColorsModel("Perla d'Sabbia", "C"));
		graniteColorsData.add(new GranteColorsModel("Perla Modena", "A"));
		graniteColorsData.add(new GranteColorsModel("Pietra del Cardoso", "D"));
		graniteColorsData.add(new GranteColorsModel("Pietra Serena", "A"));
		graniteColorsData.add(new GranteColorsModel("Polar Ice", "D"));
		graniteColorsData.add(new GranteColorsModel("Royal Ivory", "B"));
		graniteColorsData.add(new GranteColorsModel("Sabbia D'Oro", "C"));
		graniteColorsData.add(new GranteColorsModel("St. Leo's Copper", "C"));
		graniteColorsData.add(new GranteColorsModel("Terra Chiara", "B"));
		graniteColorsData.add(new GranteColorsModel("Terra di Sienna", "A"));
		graniteColorsData.add(new GranteColorsModel("Terra Ombra", "B"));
		graniteColorsData.add(new GranteColorsModel("Travertino Argento", "D"));
		graniteColorsData.add(new GranteColorsModel("Tropico", "A"));
		graniteColorsData.add(new GranteColorsModel("Veneto", "B"));
		graniteColorsData.add(new GranteColorsModel("Verde Emerald", "A"));
		graniteColorsData.add(new GranteColorsModel("Verde Fonte", "A"));
		graniteColorsData.add(new GranteColorsModel("Vetro Moretti", "D"));
		graniteColorsData.add(new GranteColorsModel("Walker Gold", "B"));
		graniteColorsData.add(new GranteColorsModel("White Copper", "D"));
		graniteColorsData.add(new GranteColorsModel("White Cristallino", "B"));
		graniteColorsData.add(new GranteColorsModel("White Star", "B"));
		
	}
	/**
	 * SetUser method receives the user's name so it can be displayed 
	 * @param user
	 * @param stage
	 */
	public void setUser(String user, Stage stage, Scene scene)
	{
		System.out.println("The user is: " + user);
		this.user = user;
		this.mainControllerStage = stage;
		this.scene = scene;
	}
	public void setCheckBox(){
		
		
	}
	protected void updateText(Label label, ObservableList<? extends String> list) {

        final StringBuilder sb = new StringBuilder();

         

        if (list != null) {

            for (int i = 0, max = list.size(); i < max; i++) {

                sb.append(list.get(i));

                if (i < max - 1) {

                    sb.append(", ");

                }

            }

        }

         

        final String str = sb.toString();

        label.setText(str.isEmpty() ? "<empty>" : str);

    }
	@FXML private void Exit(){
		Platform.exit();
	}
	@FXML private void Minimize(){
		mainControllerStage.setIconified(true);
	}
@FXML private void Test(){
	ObservableList<String> index = listView.getTargetItems();
	for(String item: index){
		System.out.println("List: " + item);
	}
	
}
	public void buildData(){
		
		Connection conn = null;
		
		try{
			conn = db.Connector();
			String statement = "Select * from Orders where customerId = " + CurrentCustomerId;
			
			ResultSet rs = conn.createStatement().executeQuery(statement);
			while(rs.next()){
				orders.add(rs.getString("orderId"));
				type.set(rs.getString("type"));
				System.out.println(rs.getString(1));
				
			}
			for(String item: orders){
				System.out.println(item);
				String orders1 = item.toString().concat(" - " + type.get());
			
				listView.getSourceItems().add(orders1);
			}
			
		}catch(SQLException e){
			
		}finally
	    {
			DbUtils.closeQuietly(conn);
	    }
	}
	
	@FXML private void create(ActionEvent event) throws ClassNotFoundException{
		String type = typeComboBox.getSelectionModel().getSelectedItem();
		ObservableList<String> list1 = checkComboBox.getCheckModel().getCheckedItems();
		if(!list1.isEmpty()){
			if(type.equals("Estimate") && list1.contains("Kitchen")){
				  ((Node)event.getSource()).getScene().getWindow().hide();
				  mainControllerStage = new Stage();
				  FXMLLoader fxmlLoader = new FXMLLoader();
				  Pane root = null;
				try {
					root = fxmlLoader.load(getClass().getResourceAsStream("/fxml/Kitchen.fxml"));
				} catch (IOException e) {
					FxDialogs.showException("Exception Thrown", "Check to see if something is wrong. Could not load Kitchen.fxml", e);
					e.printStackTrace();
				}
				createOrder();
				getOrderId();
				 Scene scene = new Scene(root);
				  KitchenController controller = fxmlLoader.getController();
				  controller.setStage(mainControllerStage, scene);
				  controller.setCustomer(data);
				  controller.setOrderId(currentOrderId);
				 
				  Screen screen = Screen.getPrimary();
				  root.getStylesheets().add("/styles/styles.css"); 
				  Rectangle2D bounds = screen.getVisualBounds();
				  mainControllerStage.initStyle(StageStyle.UNDECORATED);
				  mainControllerStage.setX(bounds.getMinX());
				  mainControllerStage.setY(bounds.getMinY());
				  mainControllerStage.setWidth(bounds.getWidth());
				  mainControllerStage.setHeight(bounds.getHeight());
				  mainControllerStage.setScene(scene);
				  mainControllerStage.show();
			}else{
				String title = "Type Requirement";String message = "Must Make A Selection";
				FxDialogs.showInformation(title, message);
			}

			
		}else{			
			String title = "Room Requirement";String message = "Must Select A Room";
			FxDialogs.showInformation(title, message);
		
		}
		
		
		
		
	}
	@FXML private void kitchen() throws IOException, ClassNotFoundException
	{
	  Stage userStage = new Stage();
	  FXMLLoader fxmlLoader = new FXMLLoader();
	  Pane root = fxmlLoader.load(getClass().getResourceAsStream("/fxml/Kitchen.fxml"));
	  KitchenController controller = fxmlLoader.getController();
	  Scene scene = new Scene(root);
	  controller.setStage(userStage, scene);
	  controller.setCustomer(data);
	  controller.setOrderId(currentOrderId);
	  
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


	
	/**
    This creates the orderId by placing the customer Id into the Orders table.
*/
public void createOrder(){
	Connection conn = null;
	System.out.println("TYPE: " + type.get());
	try{
		conn = db.Connector();
		String statement = "insert INTO Orders (type, customerId, employeeId) values (?, ?, ?)";
		PreparedStatement psParms = conn.prepareStatement(statement);
		psParms.setString(1, type.getValue());
		psParms.setInt(2, CurrentCustomerId);
		psParms.setInt(3, currentEmployeeId);
		psParms.execute();

	}catch(SQLException e){
		FxDialogs.showException("Create Order Exception", "Something went wrong, yo.", e);
	}finally
    {
		DbUtils.closeQuietly(conn);
    }
}
/**
This gets the customerId from the customers table in the database and
stores the current customerId in the CurrentCustomerId field.
*/
public void getCustomerId(String firstName, String lastName){
Connection conn = null;
Statement stmt = null;
try{
	conn = db.Connector();
	String statement = "Select id from Customers where name = '"+ firstName + "' and surname = '" + lastName + "'";
	stmt = conn.createStatement();
	ResultSet rs =  stmt.executeQuery(statement);
	while(rs.next())
	{
				CurrentCustomerId = rs.getInt(1);

	}
	System.out.println("getCustomerId(): current customerId = " + CurrentCustomerId);
}catch(SQLException e){
	FxDialogs.showException("Get CustomerId Exception", "Something went wrong, yo.", e);
}finally
{
	DbUtils.closeQuietly(conn);
}
}
	/**
	*     This creates an orderId for the customer.
	*/
	@FXML private void createEstimate() throws ClassNotFoundException{
		getCustomerId(currentName.get(), currentSurName.get());
		createOrder();
		getOrderId();
	}

	public StringBuilder checkCustomerFields(){
		
		StringBuilder sqlStatement = new StringBuilder();
		sqlStatement.append("Select");
		if(!firstNameField.getText().isEmpty()){
			sqlStatement.append(" name,");
			nameFlag = true;
			
		}
		if(!lastNameField.getText().isEmpty()){
			sqlStatement.append(" surname,");
			surnameFlag = true;
			
		}
		if(!streetField.getText().isEmpty()){
			sqlStatement.append(" street,");
			streetFlag = true;
		}
		if(!cityField.getText().isEmpty()){
			sqlStatement.append(" city,");
			cityFlag = true;
		}
		if(!zipCodeField.getText().isEmpty()){
			sqlStatement.append(" zipCode,");
			zipCodeFlag = true;
		}
		if(!phoneField.getText().isEmpty()){
			sqlStatement.append(" phone,");
			phoneFlag = true;
		}
		if(!emailField.getText().isEmpty()){
			sqlStatement.append(" email");
			emailFlag = true;
		}
		int length = sqlStatement.length();
		char a = sqlStatement.charAt(length - 1);
		String b = String.valueOf(a);
		System.out.println("Char at char " + length + ": " + a);
		if(b.equals(",")){
			System.out.println("Query: " + sqlStatement.toString());
			System.out.println("IT IS A COMMA!");
			sqlStatement.deleteCharAt(length-1);
			System.out.println("Query: " + sqlStatement.toString());
			}
		
		if(sqlStatement.toString().equalsIgnoreCase("Select ")){
			System.out.println("False");
			
		}
		System.out.println("True");
		return sqlStatement;
	}
	@FXML private void handleFindCustomer(){
	StringBuilder statement = checkCustomerFields();

	if(!statement.toString().equalsIgnoreCase("Select ")){
		statement.append(" FROM Customers");
		System.out.println("Statement: " + statement.toString());
		System.out.println("Found True");
		String state = statement.toString();
		if(state.contains("name"))
		{
			System.out.println("Contains: name");
			count++;
		}
		if(state.contains("surname")){
			System.out.println("Contains: surname");
			count++;
		}
		if(state.contains("street")){
			System.out.println("Contains: street");
			count++;
		}
		if(state.contains("city")){
			System.out.println("Contains: city");
			count++;
		}
		if(state.contains("state")){
			System.out.println("Contains: state");
			count++;
		}
		if(state.contains("zipCode")){
			System.out.println("Contains: zipCode");
			count++;
		}
		if(state.contains("phone")){
			System.out.println("Contains: phone");
			count++;
		}
		if(state.contains("email")){
			System.out.println("Contains: email");
			count++;
		}
	
		
	}else{
		System.out.println("Found False");
	}
	
	
}
	
	public void SignOut(ActionEvent event) throws IOException{
		((Node)event.getSource()).getScene().getWindow().hide();
		Stage userStage = new Stage();
		FXMLLoader fxmlLoader = new FXMLLoader();
		Pane root = fxmlLoader.load(getClass().getResourceAsStream("/fxml/MainScreen.fxml"));
		MainScreenController controller = fxmlLoader.getController();
		controller.setUsername(user);
		Scene scene = new Scene(root);
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
	}
	@FXML private void findCustomerr(){
		String firstName = firstNameField.getText();firstName = firstName.replaceAll("\\s","");
		String lastName = lastNameField.getText();lastName = lastName.replaceAll("\\s","");
		String street = streetField.getText();
		String city = cityField.getText();city = city.replaceAll("\\s","");
		String state = stateField.getText();state = state.replaceAll("\\s","");
		String zipCode = zipCodeField.getText();zipCode = zipCode.replaceAll("\\s","");
		String phone = phoneField.getText(); phone = phone.replaceAll("\\s","");
		String email = emailField.getText(); email = email.replaceAll("\\s","");
	
	
		
		if(!firstName.isEmpty() && !lastName.isEmpty() && !street.isEmpty() ){
			update.FindCustomerFullNameStreet(firstName, lastName, street);
			table2.setItems(data);
		}else if(!firstName.isEmpty() && lastName.isEmpty() && !street.isEmpty()){
			update.FindCustomerByNameStreet(firstName, street);
			table2.setItems(data);
		}else if(!firstName.isEmpty() && !lastName.isEmpty() && street.isEmpty()){
			data = update.FindCustomerFullName(firstName, lastName);
			table2.setItems(data);
		}else if(firstName.isEmpty() && !lastName.isEmpty() && !street.isEmpty()){
			update.FindCustomerByLastNameStreet(lastName, street);
			table2.setItems(data);
		}else if(firstName.isEmpty() && lastName.isEmpty() && !street.isEmpty()){
			update.FindCustomerByStreet(street);
			table2.setItems(data);
		}else if(!firstName.isEmpty()){
			data = update.FindCustomerByFName(firstName);
			table2.setItems(data);
		}else if(!lastName.isEmpty()){
			data = update.FindCustomerLastName(lastName);
			table2.setItems(data);
		}else if (!phone.isEmpty()){
			update.findCustomerByPhone(phone);
			table2.setItems(data);
		}else if(!email.isEmpty()){
			update.findCustomerByEmail(email);
			table2.setItems(data);
		}else if(!zipCode.isEmpty()){
			update.findCustomerByZipCode(zipCode);
			table2.setItems(data);
		}else
		{
			Notifications.create()
			.title("Could Not Load Customer Data")
			.text("Please check to see if you entered any information.")
			.showWarning();
		}
		
	}



	@FXML private void handleAddRowT1(){
		CountertopDetails details = new CountertopDetails();
		countData.add(details);

	}
@FXML private void handleAddRowT2(){
		EdgingDetails edgingDetails = new EdgingDetails();
		edgingData.add(edgingDetails);
	}
@FXML private void handleAddRowT3(){
		FourInchBacksplashDetails backsplashDetails = new FourInchBacksplashDetails();
		fourInchData.add(backsplashDetails);
	}
@FXML private void handleAddRowt4(){
		FullBacksplashDetails backsplashDetails = new FullBacksplashDetails();
		fullBacksplashData.add(backsplashDetails);
	}
@FXML private void handleAddRowT7(){
	FourInchBacksplashEdging fourInch = new FourInchBacksplashEdging();
	fourInchBacksplashEdgingData.add(fourInch);
}
@FXML private void handleAddRowT9(){
		FullBacksplashEdgingDetails backsplashEdgingDetails = new FullBacksplashEdgingDetails();
		fullBacksplashEdgingData.add(backsplashEdgingDetails);
		System.out.println(backsplashEdgingDetails.toString());
	}
	/**
	 * The deleteRow method will delete the selected row from a table. This method must be called
	 * by another method that has a table name and id for the row.
	 * @param tableName
	 * @param id
	 */
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
		 }finally
	    {
				DbUtils.closeQuietly(conn);
		    }
	}
	/**
	 * handleDeleteButtonT1 method deletes the selected row from Countertop table in the database.
	 */
	@FXML private void handleDeleteButtonT1(){
		String tableName = "Countertop";
		String idName = "ctId";
		int selectedIndex = kitchenTable.getSelectionModel().getSelectedIndex();
		if(selectedIndex >= 0) {
			int id = kitchenTable.getItems().get(selectedIndex).idProperty().get();
			deleteRow(tableName, idName, id);
			kitchenTable.getItems().remove(selectedIndex);
			System.out.println("Index " + selectedIndex + ": deleted");
		}
		else{
			FxDialogs.showError("Warning: Something Is Wrong With Selection", "Something Went Wrong With Countertop Table");
		}
	}
	/**
	 * handleDeleteButtonT2 method deletes the selected row from Edging table in the database.
	 */
	@FXML private void handleDeleteButtonT2(){
		String tableName = "Edging";
		String idName = "edgeId";
		int selectedIndex = edgingTable.getSelectionModel().getSelectedIndex();
    	if(selectedIndex >= 0) {
    			int id = edgingTable.getItems().get(selectedIndex).idProperty().get();
    			deleteRow(tableName, idName, id);
    			edgingTable.getItems().remove(selectedIndex);
    			System.out.println("Index " + selectedIndex + ": deleted");
    	}
    	else{
    		FxDialogs.showError("Warning: Edging Table Deletion", "Something Went Wrong With edging Table");
    	}
	}
	@FXML private void handleDeleteButtonT3(){
		String tableName = "Four_Inch_Backsplash";
		String idName = "backsplashId";
		int selectedIndex = backsplashTable.getSelectionModel().getSelectedIndex();
		if(selectedIndex >= 0) {
			int id = backsplashTable.getItems().get(selectedIndex).idProperty().get();
			deleteRow(tableName, idName, id);
			backsplashTable.getItems().remove(selectedIndex);
			System.out.println("Index " + selectedIndex + ": deleted");
		}
		else{
			FxDialogs.showError("Warning: Four-inch Backsplash DELETION", "Something Went Wrong With Four-inch Backsplash Table");
		}
}
	@FXML private void handleDeleteButtonT4(){
		String tableName = "Full_Backsplash";
		String idName = "Id";
		int selectedIndex = fullBackSplashTable.getSelectionModel().getSelectedIndex();
		if(selectedIndex >= 0) {
			int id = fullBackSplashTable.getItems().get(selectedIndex).idProperty().get();
			deleteRow(tableName, idName, id);
			fullBackSplashTable.getItems().remove(selectedIndex);
			System.out.println("Index " + selectedIndex + ": deleted from - " + tableName);
		}
		else{
			FxDialogs.showError("Warning: Four-inch Backsplash DELETION", "Something Went Wrong With Four-inch Backsplash Table");
		}
	}
	@FXML private void handleDeleteButtonT5(){
		String idName = "edgeId";
		String tableName = "Four_Inch_Backsplash_Edging";
		int selectedIndex = fourInchBackSplashEdgingTable.getSelectionModel().getSelectedIndex();
		if(selectedIndex >= 0) {
			int id = fourInchBackSplashEdgingTable.getItems().get(selectedIndex).idProperty().get();
			deleteRow(tableName, idName, id);
			fourInchBackSplashEdgingTable.getItems().remove(selectedIndex);
			System.out.println("Index " + selectedIndex + ": deleted from - " + tableName);
		}
		else{
			FxDialogs.showError("Warning: Four-inch Backsplash DELETION", "Something Went Wrong With Four-inch Backsplash Table");
		}
	}
	@FXML private void handleTab8(){
		
	}
	@FXML private void handleDeleteButtonT6(){
		String idName = "edgeId";
		String tableName = "Full_Backsplash_Edging";
		int selectedIndex = fullBacksplashEdgingTable.getSelectionModel().getSelectedIndex();
		if(selectedIndex >= 0) {
			int id = fullBacksplashEdgingTable.getItems().get(selectedIndex).idProperty().get();
			deleteRow(tableName, idName, id);
			fullBacksplashEdgingTable.getItems().remove(selectedIndex);
			System.out.println("Index " + selectedIndex + ": deleted");
		}else{
			FxDialogs.showError("Warning: Full Backsplash Deletion", "Something Went Wrong With Full Backsplash Table");
		}
}
	@FXML private void handleClearListView(){
		orders.clear();
		listView.sourceItemsProperty().get().clear();
		listView.targetItemsProperty().get().clear();
	}
	public void getCountertopData(){
	Connection conn = null;
	
	try{
		conn = db.Connector();
		ResultSet rs = conn.createStatement().executeQuery("select * from Countertop where orderId = " + currentOrderId);
		countData.clear();
		while(rs.next()){
			CountertopDetails countertopDetails = new CountertopDetails();
			countertopDetails.idProperty().set(rs.getInt(1));
			countertopDetails.pieceProperty().set(rs.getString(2));
			countertopDetails.lengthProperty().set(rs.getDouble(3));
			countertopDetails.widthProperty().set(rs.getDouble(4));
			countertopDetails.colorProperty().set(rs.getString(5));
			gColorBox1.setValue(rs.getString(5));
			countertopDetails.includeProperty().set(rs.getBoolean(6));
			countertopIncludeCheckBox.selectedProperty().set(rs.getBoolean(6));
			countertopDetails.orderIdProperty().set(rs.getInt(7));
			countertopDetails.employeeIdProperty().set(rs.getInt(8));
			countertopDetails.customerIdProperty().set(rs.getInt(9));
			countertopDetails.salesPersonIdProperty().set(rs.getInt(10));
			countData.add(countertopDetails);
			
		}
		for(CountertopDetails item: countData){
			System.out.println(countData.toString());
		}
		
	}catch(SQLException e){
		FxDialogs.showException("Getting Countertop Data Error", "check connection", e);
	}finally
    {
		DbUtils.closeQuietly(conn);
    }
}
public void getEdgingData() throws ClassNotFoundException{
	edgingData.clear();
	Connection conn = null;
	try{
		conn = db.Connector();
		ResultSet rs = conn.createStatement().executeQuery("select * from Edging where orderId = " + currentOrderId);
		
		while(rs.next()){
			
			EdgingDetails edging = new EdgingDetails();
			edging.idProperty().set(rs.getInt(1));
			edging.lengthProperty().set(rs.getDouble(2));
			edging.checkBoxBevelProperty().set(rs.getBoolean(3));
			edging.checkBoxPolishedProperty().set(rs.getBoolean(4));
			edging.colorProperty().set(rs.getString(5));
			gColorBox2.setValue(rs.getString(5));
			edging.includeProperty().set(rs.getBoolean(6));
			ctEdgingIncludeCheckBox.setSelected(rs.getBoolean(6));
			edging.orderIdProperty().set(rs.getInt(7));
			edging.customerIdProperty().set(rs.getInt(8));
			edging.employeeIdProperty().set(rs.getInt(9));
			edgingData.add(edging);
				
			
		}
		
	}catch(SQLException e){
		FxDialogs.showException("Getting Countertop Data Error", "check connection", e);
	}finally
    {
		DbUtils.closeQuietly(conn);
    }
}
public void getFourInchBacksplashData(){
	Connection conn = null;
	try{
		conn = db.Connector();
		ResultSet rs = conn.createStatement().executeQuery("select * from Four_Inch_Backsplash where orderId = " + currentOrderId);
		fourInchData.clear();
		System.out.println("Getting Four inch backsplash data");
		System.out.println("Current order id for four inch backsplash: " + currentOrderId);
		while(rs.next()){
			
			FourInchBacksplashDetails fourInch = new FourInchBacksplashDetails();
			fourInch.idProperty().set(rs.getInt(1));
			fourInch.pieceProperty().set(rs.getString(2));
			fourInch.lengthProperty().set(rs.getDouble(3));
			fourInch.widthProperty().set(rs.getDouble(4));
			fourInch.buildOutsProperty().set(rs.getDouble(5));
			buildOutsFieldT3.textProperty().set(rs.getString(5));
			fourInch.colorProperty().set(rs.getString(6));
			gColorBox4.setValue(rs.getString(6));
			fourInch.includeProperty().set(rs.getBoolean(7));
			FourInchBSIncludeCheckBox.setSelected(rs.getBoolean(7));
			fourInch.orderIdProperty().set(rs.getInt(8));
			fourInch.customerIdProperty().set(rs.getInt(9));
			fourInch.employeeIdProperty().set(rs.getInt(10));
			fourInch.salesPersonIdProperty().set(rs.getInt(11));
			fourInchData.add(fourInch);
			System.out.println(fourInch.toString());
		}
	}catch(SQLException e){
		FxDialogs.showException("Getting Four Inch Backsplash Data Error", "check connection", e);
	}finally
    {
		DbUtils.closeQuietly(conn);
    }
}

		public void getFourInchBSEdgingData(){
			System.out.println("Starting four inch backsplash eding getter");
			Connection conn = null;
			try{
				conn = db.Connector();
				System.out.println("Order Id for Four_Inch backsplash: " + currentOrderId);
				ResultSet rs = conn.createStatement().executeQuery("select * from Four_Inch_Backsplash_Edging where orderId = " + currentOrderId);
				fourInchBacksplashEdgingData.clear();
				while(rs.next()){
					FourInchBacksplashEdging edging = new FourInchBacksplashEdging();
					edging.idProperty().set(rs.getInt(1));
					edging.lengthProperty().set(rs.getDouble(2));
					edging.widthProperty().set(rs.getDouble(3));
					edging.colorProperty().set(rs.getString(4));
					gColorBox6.setValue(rs.getString(4));
					edging.includeProperty().set(rs.getBoolean(5));
					fourInchEdgingIncludeCheckBox.setSelected(rs.getBoolean(5));
					edging.orderIdProperty().set(rs.getInt(6));
					edging.customerIdProperty().set(rs.getInt(7));
					edging.employeeIdProperty().set(rs.getInt(8));
					edging.salesPersonIdProperty().set(rs.getInt(9));
					fourInchBacksplashEdgingData.add(edging);
					System.out.println("Four Inch Backsplash Edging Data: " + edging.toString());
				}
			}catch(SQLException e){
				FxDialogs.showException("Exception Thrown Getting Four Inch Backsplash Edging", "check if orderId exists", e);
			}finally
		    {
				DbUtils.closeQuietly(conn);
		    }
		}
		public void getFullBacksplashData(){
	Connection conn = null;
	try{
		conn = db.Connector();
		ResultSet rs = conn.createStatement().executeQuery("select * from Full_Backsplash where orderId = " + currentOrderId);
		fullBacksplashData.clear();
		System.out.println("Getting Full backsplash data");
		System.out.println("Current order id for Full backsplash: " + currentOrderId);
		while(rs.next()){
			
			FullBacksplashDetails fullBS = new FullBacksplashDetails();
			fullBS.idProperty().set(rs.getInt(1));
			fullBS.pieceProperty().set(rs.getString(2));
			fullBS.lengthProperty().set(rs.getDouble(3));
			fullBS.widthProperty().set(rs.getDouble(4));
			fullBS.colorProperty().set(rs.getString(5));
			gColorBox3.setValue(rs.getString(5));
			fullBS.includeProperty().set(rs.getBoolean(6));
			FullBackSplashIncludeCheckBox.setSelected(rs.getBoolean(6));
			fullBS.TrendstoneProperty().set(rs.getBoolean(7));
			trendStoneFullBacksplashCheckBox.setSelected(rs.getBoolean(7));
			fullBS.mosaicProperty().set(rs.getBoolean(8));
			MosaicBackSplashIncludeCheckBox.setSelected(rs.getBoolean(8));
			fullBS.orderIdProperty().set(rs.getInt(9));
			fullBS.customerIdProperty().set(rs.getInt(10));
			fullBS.employeeIdProperty().set(rs.getInt(11));
			fullBS.salesPersonIdProperty().set(rs.getInt(12));
			
			

			fullBacksplashData.add(fullBS);
				System.out.println(fullBS.toString());
			
		}
	}catch(SQLException e){
		e.printStackTrace();
		FxDialogs.showException("Getting Countertop Data Error", "check connection", e);
	}finally
    {
		DbUtils.closeQuietly(conn);
    }
}
		public void getFullBSEdgingData() throws ClassNotFoundException{
			System.out.println("Getting Full backsplash edging data");
			Connection conn = null;
			try{
				conn = db.Connector();
				ResultSet rs = conn.createStatement().executeQuery("select * from Full_Backsplash_Edging where orderId = " + currentOrderId);
				fullBacksplashEdgingData.clear();
				while(rs.next()){
					
					FullBacksplashEdgingDetails Fulledging = new FullBacksplashEdgingDetails();
					Fulledging.idProperty().set(rs.getInt(1));
					Fulledging.lengthProperty().set(rs.getDouble(2));
					Fulledging.widthProperty().set(rs.getDouble(3));
					Fulledging.checkBoxPolishedProperty().set(rs.getBoolean(4));
					Fulledging.colorProperty().set(rs.getString(5));
					gColorBox5.setValue(rs.getString(5));
					Fulledging.includeProperty().set(rs.getBoolean(6));
					fullBacksplashEdgingIncludeCheckBox.setSelected(rs.getBoolean(6));
					Fulledging.orderIdProperty().set(rs.getInt(7));
					Fulledging.customerIdProperty().set(rs.getInt(8));
					Fulledging.employeeIdProperty().set(rs.getInt(9));
					Fulledging.salesPersonIdProperty().set(rs.getInt(10));

					fullBacksplashEdgingData.add(Fulledging);
						
					System.out.println(Fulledging.toString());
				}
			}catch(SQLException e){
				FxDialogs.showException("Getting Countertop Data Error", "check connection", e);
			}finally
		    {
				DbUtils.closeQuietly(conn);
		    }
		}		
	public void getFullBackasplashCustomData() throws ClassNotFoundException{
		fullBacksplashCustomData.clear();
	Connection conn = null;
	try{
		conn = db.Connector();
		ResultSet rs = conn.createStatement().executeQuery("select * from Full_Backsplash_Custom where orderId = " + currentOrderId);
		while(rs.next()){
			
			FullBacksplashCustomDetails FullBsOptions = new FullBacksplashCustomDetails();
			System.out.println("Cut Outs: "+ rs.getDouble(1));
			System.out.println("Stripe Trendstone 7 Tiles: "+ rs.getDouble(2));
			FullBsOptions.customIdProperty().set(rs.getInt(1));
			currentBacksplashCustomId = rs.getInt(1);
			System.out.println("Existing Backsplash Custom id: " + currentBacksplashCustomId);
			FullBsOptions.cutOutsProperty().set(rs.getDouble(2));
			FullBsOptions.stripeTrendstone7TilesProperty().set(rs.getDouble(3));
			FullBsOptions.stripeCustomMosaic7TilesProperty().set(rs.getDouble(4));
			FullBsOptions.inlaysDiamond5x5Property().set(rs.getDouble(5));
			FullBsOptions.inlaysDiamond12x12Property().set(rs.getDouble(6));
			FullBsOptions.trendStoneSelectionProperty().set(rs.getBoolean(7));
			FullBsOptions.mosaicSelectionProperty().set(rs.getBoolean(8));
			FullBsOptions.orderIdProperty().set(rs.getInt(9));
			FullBsOptions.employeeIdProperty().set(rs.getInt(10));
			FullBsOptions.customerIdProperty().set(rs.getInt(11));
			FullBsOptions.setSalesPersonId(rs.getInt(12));
			System.out.println(FullBsOptions.toString());
			fullBacksplashCustomData.add(FullBsOptions);
				
			cutOutsQuantityField.textProperty().bindBidirectional(FullBsOptions.cutOutsProperty(), new NumberStringConverter());
			stripeMosaicsField.textProperty().bindBidirectional(FullBsOptions.stripeTrendstone7TilesProperty(), new NumberStringConverter());
			stripeCustomMosaics.textProperty().bindBidirectional(FullBsOptions.stripeCustomMosaic7TilesProperty(), new NumberStringConverter());
			inlaysDiamond5x5Field.textProperty().bindBidirectional(FullBsOptions.inlaysDiamond5x5Property(), new NumberStringConverter());
			inlaysDiamond12x12Field.textProperty().bindBidirectional(FullBsOptions.inlaysDiamond12x12Property(), new NumberStringConverter());
			
		}
	}catch(SQLException e){
		FxDialogs.showException("Getting Countertop Data Error", "check connection", e);
	}finally
    {
		DbUtils.closeQuietly(conn);
    }
}

	public void getOptData() throws ClassNotFoundException{
	getOrderId();
	Connection conn = null;
	try{
		conn = db.Connector();
		ResultSet rs = conn.createStatement().executeQuery("select * from Options where orderId = " + currentOrderId + " and customerId = " + CurrentCustomerId);
		opt1Data.clear();
		while(rs.next()){
			
			Opts1 opt = new Opts1();
			opt.setId(rs.getInt(1)); 							currentOptionId = rs.getInt(1);
			opt.setPrepBoard(rs.getBoolean(2)); 				opt.setPrepBoardM(rs.getDouble(3));
			opt.setRemoveExistingBacksplash(rs.getBoolean(4)); 	opt.setRemoveExistingBacksplashM(rs.getDouble(5));
			opt.setRemoveCTLaminate(rs.getBoolean(6)); 			opt.setRemoveCTLaminateM(rs.getDouble(7));
			opt.setRemoveCTTile(rs.getBoolean(8)); 				opt.setRemoveCTTileM(rs.getDouble(9));
			opt.setInstallNewCt(rs.getBoolean(10)); 				opt.setInstallNewCtM(rs.getDouble(11));
			opt.setIronBarless36in6(rs.getBoolean(12));			opt.setIronbarless36in6M(rs.getDouble(13));
			opt.setIronBarmore36in7(rs.getBoolean(14)); 		opt.setIronBarmore36in7M(rs.getDouble(15));
			opt.setBendTrendStoneApron(rs.getBoolean(16)); 		opt.setBendTrendStoneApronM(rs.getDouble(17));
		
			opt.setClippedCorners(rs.getBoolean(18)); 			opt.setClippedCornersM(rs.getDouble(19));
			opt.setOther1(rs.getBoolean(20)); 					opt.setOther1M(rs.getDouble(21));
			opt.setOther2(rs.getBoolean(22)); 					opt.setOther2M(rs.getDouble(23));
			opt.setFiller(rs.getBoolean(24)); 					opt.setFillerM(rs.getDouble(25));
			opt.setOther3(rs.getBoolean(26)); 					opt.setOther3M(rs.getDouble(27));
			opt.setOther4(rs.getBoolean(28)); 					opt.setOther4M(rs.getDouble(29));
			opt.setRsg(rs.getBoolean(30)); 						opt.setRsgM(rs.getDouble(31));
			opt.setStrainer(rs.getBoolean(32)); 				opt.setStrainerM(rs.getDouble(33));
			opt.setSinkRemoval(rs.getBoolean(34)); 				opt.setSinkRemovalM(rs.getDouble(35));
			opt.setCooktopRemoveReinstall(rs.getBoolean(36)); 	opt.setCooktopRemoveReinstallM(rs.getDouble(37));
			
			opt.setPlumbing(rs.getDouble(38));
			opt.setSinksAcc(rs.getDouble(39));
			opt.setSwitchPlates(rs.getDouble(40));
			opt.setToeKick(rs.getDouble(41));
			opt.setOrderId(rs.getInt(42));
			opt.setEmployeeId(rs.getInt(43));
			opt.setCustomerId(rs.getInt(44));
			opt.setSalesPersonId(rs.getInt(45));
			

			opt1Data.add(opt);
				
			
		}
	
	if(!opt1Data.isEmpty()){
	check1TextField.textProperty().bindBidirectional(opt1Data.get(0).prepBoardMProperty(), new NumberStringConverter() );
	check1.selectedProperty().bindBidirectional(opt1Data.get(0).prepBoardProperty());
	check2.selectedProperty().bindBidirectional(opt1Data.get(0).removeExistingBacksplashProperty());
	check2TextField.textProperty().bindBidirectional(opt1Data.get(0).removeExistingBacksplashMProperty(), new NumberStringConverter());
	check3.selectedProperty().bindBidirectional(opt1Data.get(0).removeCTLaminateProperty());
	check3TextField.textProperty().bindBidirectional(opt1Data.get(0).removeCTLaminateMProperty(), new NumberStringConverter() );
	check4.selectedProperty().bindBidirectional(opt1Data.get(0).removeCTTileProperty());
	check4TextField.textProperty().bindBidirectional(opt1Data.get(0).removeCTTileMProperty(), new NumberStringConverter());
	check5.selectedProperty().bindBidirectional(opt1Data.get(0).installNewCtProperty());
	check5TextField.textProperty().bindBidirectional(opt1Data.get(0).installNewCtMProperty(), new NumberStringConverter());
	check6.selectedProperty().bindBidirectional(opt1Data.get(0).ironBarless36in6Property());
	check6TextField.textProperty().bindBidirectional(opt1Data.get(0).ironbarless36in6MProperty(), new NumberStringConverter());
	check7.selectedProperty().bindBidirectional(opt1Data.get(0).ironBarmore36in7Property());
	check7TextField.textProperty().bindBidirectional(opt1Data.get(0).ironBarmore36in7MProperty(), new NumberStringConverter());
	check8.selectedProperty().bindBidirectional(opt1Data.get(0).bendTrendStoneApronProperty());
	check8TextField.textProperty().bindBidirectional(opt1Data.get(0).bendTrendStoneApronMProperty(), new NumberStringConverter());
	check11.selectedProperty().bindBidirectional(opt1Data.get(0).clippedCornersProperty());
	check11TextField.textProperty().bindBidirectional(opt1Data.get(0).clippedCornersMProperty(), new NumberStringConverter());
	check12.selectedProperty().bindBidirectional(opt1Data.get(0).other1Property());
	check12TextField.textProperty().bindBidirectional(opt1Data.get(0).other1MProperty(), new NumberStringConverter());
	check13.selectedProperty().bindBidirectional(opt1Data.get(0).other2Property());
	check13TextField.textProperty().bindBidirectional(opt1Data.get(0).other2MProperty(), new NumberStringConverter());
	check14.selectedProperty().bindBidirectional(opt1Data.get(0).fillerProperty());
	check14TextField.textProperty().bindBidirectional(opt1Data.get(0).fillerMProperty(), new NumberStringConverter());
	check15.selectedProperty().bindBidirectional(opt1Data.get(0).other3Property());
	check15TextField.textProperty().bindBidirectional(opt1Data.get(0).other3MProperty(), new NumberStringConverter());
	check16.selectedProperty().bindBidirectional(opt1Data.get(0).other4Property());
	check16TextField.textProperty().bindBidirectional(opt1Data.get(0).other4MProperty(), new NumberStringConverter());
	check17.selectedProperty().bindBidirectional(opt1Data.get(0).rsgProperty());
	check17TextField.textProperty().bindBidirectional(opt1Data.get(0).rsgMProperty(), new NumberStringConverter());
	check18.selectedProperty().bindBidirectional(opt1Data.get(0).strainerProperty());
	check18TextField.textProperty().bindBidirectional(opt1Data.get(0).strainerMProperty(), new NumberStringConverter());
	check19.selectedProperty().bindBidirectional(opt1Data.get(0).sinkRemovalProperty());
	check19TextField.textProperty().bindBidirectional(opt1Data.get(0).sinkRemovalMProperty(), new NumberStringConverter());
	check20.selectedProperty().bindBidirectional(opt1Data.get(0).cooktopRemoveReinstallProperty());
	check20TextField.textProperty().bindBidirectional(opt1Data.get(0).cooktopRemoveReinstallMProperty(), new NumberStringConverter());
	plumbingField.textProperty().bindBidirectional(opt1Data.get(0).plumbingProperty(), new NumberStringConverter());
	accessoriesField.textProperty().bindBidirectional(opt1Data.get(0).sinksAccProperty(), new NumberStringConverter());
	switchPlatesField.textProperty().bindBidirectional(opt1Data.get(0).switchPlatesProperty(), new NumberStringConverter());
	toeKicksTextField.textProperty().bindBidirectional(opt1Data.get(0).toeKickProperty(), new NumberStringConverter());
	}
	}catch(SQLException e){
		FxDialogs.showException("Getting Options Data Error", "check connection", e);
	}finally
    {
		DbUtils.closeQuietly(conn);
    }
}
/**
 * This method will store the current orderId for the customer inside the gui as long as the page is still
 * up. If you go back to the main screen you must find another customer before trying to get the order id.
 * @throws ClassNotFoundException
 */
public void getOrderId() throws ClassNotFoundException{
	Connection conn = null;
	Statement stmt = null;
	
	System.out.println("Customer id: " + CurrentCustomerId);
	String statement = "select * from Orders where customerId = " + CurrentCustomerId;
	try
	{
		conn = db.Connector();
		//Execute query and store result in a resultset.
		stmt = conn.createStatement();
		ResultSet rs =  stmt.executeQuery(statement);
		while(rs.next())
		{
					currentOrderId = rs.getInt("orderId");
					type.set(rs.getString("type"));
		}
		System.out.println("CURRENT ORDER ID: " + currentOrderId );
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

}




@SuppressWarnings("finally")
public boolean manageOrder(){
	Connection conn = null;
	try{
		conn = db.Connector();
		ResultSet rs = conn.createStatement().executeQuery("select employeeId FROM Employees where username = '" + user + "'");
		while(rs.next()){
			System.out.println("EmployeeId of User " + user + ": " + rs.getString(1));
			currentEmployeeId = rs.getInt(1);
		}
		System.out.println("manageOrder() setting current employee id: " + currentEmployeeId);
	
		
	}catch(SQLException e){
		e.printStackTrace();
	}
	 finally
	    {
	        try 
	        { 
	        	conn.close();
	        	return true;
	            
	        } 
	        catch (SQLException ex) 
	        {
	            System.out.println ("Errore closing connections");
	            return false;
	        }
	    }
	
}

@FXML private void getEverything(){
	
	try {
		manageOrder();
		getOrderId();
		getFullBacksplashEdging();
		getCountertopData();
		getEdgingData();
		getFourInchBacksplashData();
		getFullBacksplashData();
		getFourInchBSEdgingData();
		getFullBackasplashCustomData();
		getOptData();
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	}
}


@FXML private void LoadEst(ActionEvent event) throws IOException, ClassNotFoundException{
	index = listView.getTargetItems();
	boolean kitchen = false;
	boolean bathroom = false;
	boolean cabinets = false;
	for(String item: index){
		if(item.contains("Kitchen")){kitchen = true;}
		if(item.contains("Bathroom")){bathroom = true;}
		if(item.contains("Cabinets")){cabinets = true;}
		String nw = item.substring(0, 2);
		String num = nw.trim();
		System.out.println("Order Id Trim: " + num);
		
		currentOrderId = Integer.parseInt(num);
	}
	if(kitchen){
	if(!(currentOrderId == 0)){
		  ((Node)event.getSource()).getScene().getWindow().hide();

		 Stage userStage = new Stage();
		  FXMLLoader fxmlLoader = new FXMLLoader();
		  Pane root = fxmlLoader.load(getClass().getResourceAsStream("/fxml/Kitchen.fxml"));
		  KitchenController controller = fxmlLoader.getController();
		  Scene scene = new Scene(root);
		  controller.setStage(userStage, scene);
		  controller.setCustomer(data);
		  controller.setOrderId(currentOrderId);
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
	}else{
		String title = "Error!";String message = "There is an Error Launching Window";
		FxDialogs.showInformation(title, message);
	}
	}else if(bathroom){
		if(!(currentOrderId == 0)){
		  ((Node)event.getSource()).getScene().getWindow().hide();

			 Stage userStage = new Stage();
			  FXMLLoader fxmlLoader = new FXMLLoader();
			  Pane root = fxmlLoader.load(getClass().getResourceAsStream("/fxml/Shower.fxml"));
			  ShowerController controller = fxmlLoader.getController();
			  Scene scene = new Scene(root);
			  controller.setStage(userStage, scene);
			  controller.setCustomer(data);
			  controller.setOrderId(currentOrderId);
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
			}else{
					String title = "Error!";String message = "Must Have Order Id Present In Selected List";
					FxDialogs.showInformation(title, message);
				}
		
	}else if (cabinets){
		/**
		 * When you have cabinets priced, enter location here.
		 */
		
	}
	
}
private void getFullBacksplashEdging(){
	try {
		getFullBSEdgingData();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void updateEverything(){
	try {
		
		
		if(!(currentOrderId == 0)){
		update.updateCustomer(data);
		update.updateCoutertop(countData);
		update.updateEdging(edgingData);
		update.updateFourInchBacksplash(fourInchData);
		update.updateFourInchBacksplashEdging(fourInchBacksplashEdgingData);
		update.updateFullBacksplash(fullBacksplashData);
		update.updateFullBacksplashEdging(fullBacksplashEdgingData);
		fullBacksplashCustomData.clear();
		saveFullBacksplashCustomData();
		update.updateFullBacksplashOptions(fullBacksplashCustomData);
		opt1Data.clear();
		saveOptionsData();
		update.updateOptions(opt1Data);
		getEverything();
		}else
		{			
			String title = "Error!";String message = "Must Create Estimate To Save";
			FxDialogs.showInformation(title, message);
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}




	public void saveFullBacksplashCustomData(){
		System.out.println("Existing Backsplash Custom id: " + currentBacksplashCustomId);

		Double textField1 = Double.parseDouble(cutOutsQuantityField.getText());
		Double textField2 = Double.parseDouble(stripeMosaicsField.getText());
		Double textField3 = Double.parseDouble(stripeCustomMosaics.getText());
		Double textField4 = Double.parseDouble(inlaysDiamond5x5Field.getText());
		Double textField5 = Double.parseDouble(inlaysDiamond12x12Field.getText());
			int storedId = currentBacksplashCustomId;
			System.out.println("Existing Backsplash Custom id: " + storedId);
		  FullBacksplashCustomDetails fullCustom = new FullBacksplashCustomDetails();
		  fullCustom.customIdProperty().setValue(currentBacksplashCustomId);
		  fullCustom.cutOutsProperty().setValue(textField1);
		  fullCustom.stripeTrendstone7TilesProperty().setValue(textField2);
		  fullCustom.stripeCustomMosaic7TilesProperty().setValue(textField3);
		  fullCustom.inlaysDiamond5x5Property().setValue(textField4);
		  fullCustom.inlaysDiamond12x12Property().setValue(textField5);
		  fullCustom.trendStoneSelectionProperty().set(trendStoneFullBacksplashCheckBox.isSelected());
		  fullCustom.mosaicSelectionProperty().set(MosaicBackSplashIncludeCheckBox.isSelected());
		  fullCustom.orderIdProperty().setValue(currentOrderId);
		  fullCustom.customerIdProperty().setValue(CurrentCustomerId);
		  fullCustom.employeeIdProperty().setValue(currentEmployeeId);
		  fullBacksplashCustomData.add(fullCustom);
		  
		  System.out.println(fullCustom.toString());
	}

	public void saveOptionsData(){
	  Opts1 options = new Opts1();
	  		options.setId(currentOptionId);
	      	options.setPrepBoard(check1.isSelected());                options.setPrepBoardM(Double.parseDouble(check1TextField.getText()));
	  		options.setRemoveExistingBacksplash(check2.isSelected()); options.setRemoveExistingBacksplashM(Double.parseDouble(check2TextField.getText()));
	  		options.setRemoveCTLaminate(check3.isSelected());         options.setRemoveCTLaminateM(Double.parseDouble(check3TextField.getText()));
	  		options.setRemoveCTTile(check4.isSelected());             options.setRemoveCTTileM(Double.parseDouble(check4TextField.getText()));
	  		options.setInstallNewCt(check5.isSelected());             options.setInstallNewCtM(Double.parseDouble(check5TextField.getText()));
	  		options.setIronBarless36in6(check6.isSelected());         options.setIronbarless36in6M(Double.parseDouble(check6TextField.getText()));
	  		options.setIronBarmore36in7(check7.isSelected());         options.setIronBarmore36in7M(Double.parseDouble(check7TextField.getText()));
	  		options.setBendTrendStoneApron(check8.isSelected());      options.setBendTrendStoneApronM(Double.parseDouble(check8TextField.getText()));
	  		options.setClippedCorners(check11.isSelected());          options.setClippedCornersM(Double.parseDouble(check11TextField.getText()));
	  		options.setOther1(check12.isSelected());                  options.setOther1M(Double.parseDouble(check12TextField.getText()));
	  		options.setOther2(check13.isSelected());                  options.setOther2M(Double.parseDouble(check13TextField.getText()));
	  		options.setFiller(check14.isSelected());                  options.setFillerM(Double.parseDouble(check14TextField.getText()));
	  		options.setOther3(check15.isSelected());                  options.setOther3M(Double.parseDouble(check15TextField.getText()));
	  		options.setOther4(check16.isSelected());                  options.setOther4M(Double.parseDouble(check16TextField.getText()));
	  		options.setRsg(check17.isSelected());                     options.setRsgM(Double.parseDouble(check17TextField.getText()));
	  		options.setStrainer(check18.isSelected());                options.setStrainerM(Double.parseDouble(check18TextField.getText()));
	  		options.setSinkRemoval(check19.isSelected());             options.setSinkRemovalM(Double.parseDouble(check19TextField.getText()));
	  		options.setCooktopRemoveReinstall(check20.isSelected());  options.setCooktopRemoveReinstallM(Double.parseDouble(check20TextField.getText()));
	  		options.setPlumbing(Double.parseDouble(plumbingField.getText()));
	  		options.setSinksAcc(Double.parseDouble(accessoriesField.getText()));
	  		options.setSwitchPlates(Double.parseDouble(switchPlatesField.getText()));
	  		options.setToeKick(Double.parseDouble(toeKicksTextField.getText()));
	  		options.setOrderId(currentOrderId);
	      options.setCustomerId(CurrentCustomerId);
	  		options.setEmployeeId(currentEmployeeId);
	  		opt1Data.add(options);
	  		System.out.println("Option Data: " + options.toString());


	}
	/**
    This part will be for the FXML methods.
*/

@FXML private void calcT1(){
	calculateSqFtT1(column2t1, column3t1, kitchenTable);
	calculateSQFTt6(column1t6, column2t6, column3t6, edgingTable);
	calculateSqFtT2(column2t3, column3t3, backsplashTable);
	calculateSQFTt3(column2t4, column3t4, fullBackSplashTable);
	calculateSQFTt7(column1t9, column2t9, column4t9, fullBacksplashEdgingTable);
	handleCalcAll();

}
public void calculateSqFtT1(TableColumn<CountertopDetails, Double> column1,
		TableColumn<CountertopDetails, Double> column2,
		TableView<CountertopDetails> table)
{
		double total = 0.00;
		double total2 = 0.00;
		double sqrFeet = 0.00;
		double sqrFeetRounded = 0.00;
		ArrayList<Double> col1Data = new ArrayList<>();
		ArrayList<Double> col2Data = new ArrayList<>();
		//ArrayList<Double> col3Data = new ArrayList<>();
		for (CountertopDetails items : table.getItems()){
			col1Data.add(column1.getCellObservableValue(items).getValue());

			System.out.println("Column 1 Data: " + col1Data.toString());
		}
		for (CountertopDetails items : table.getItems()){
			col2Data.add(column2.getCellObservableValue(items).getValue());
			System.out.println("Column 2 Data: " + col2Data.toString());
		}

		int size = col1Data.size();
		for (int i = 0; i < size; i++){
				//total += col1Data.get(i);
				//total2 += col2Data.get(i);
				//total3 += col3Data.get(i);

			sqrFeet = ((col1Data.get(i) * col2Data.get(i)) / 144);
			sqrFeetRounded = Math.ceil(((col1Data.get(i) * col2Data.get(i) /144)*4));
			sqrFeetRounded = sqrFeetRounded / 4;
			total += sqrFeet; // This will be unrounded.
			total2 += sqrFeetRounded; //totals the rounded measurements


		}
		System.out.println("Unrounded Square Foot: "+ total);
		System.out.println("Rounded Square Foot: "+ total2);
		System.out.println(total);
		String format = String.format("%.2f", total2);

		areaFieldsqftT1.setText(format);

		}
public void calculateSqFtT2(TableColumn<FourInchBacksplashDetails, Double> column1, TableColumn<FourInchBacksplashDetails, Double> column2, TableView<FourInchBacksplashDetails> table)
{
	double total = 0.00;
	double total2 = 0.00;
	double total3 = 0.00;

	double sqrFeet = 0.00;
	double sqrFeetRounded = 0.00;
  ArrayList<Double> col1Data = new ArrayList<>();
  ArrayList<Double> col2Data = new ArrayList<>();
  for (FourInchBacksplashDetails items : table.getItems()){
      col1Data.add(column1.getCellObservableValue(items).getValue());
      System.out.println("Four Inch Backsplash Column 1: " + col1Data);
  }
  for (FourInchBacksplashDetails items : table.getItems()){
      col2Data.add(column2.getCellObservableValue(items).getValue());
      System.out.println("Four Inch Backsplash Column 2: " + col2Data);
  }

  int size = col1Data.size();
  for (int i = 0; i < size; i++){
      sqrFeet = ((col1Data.get(i) * col2Data.get(i)) / 144);
      System.out.println("Row " + (i+1) + sqrFeet);
      sqrFeetRounded = Math.ceil(((col1Data.get(i) * col2Data.get(i) /144)*4));
      sqrFeetRounded = sqrFeetRounded / 4;
      total += sqrFeet; // This will be unrounded.
      total2 += sqrFeetRounded; //totals the rounded measurements
  }
  System.out.println(total);
  String format = String.format("%.2f", total2);

  areaFieldsqftT2.setText(format);
  
  for (int i = 0; i < size; i++){
      sqrFeet += (col1Data.get(i) /12);
      
      sqrFeet += (col2Data.get(i) / 12);
      //sqrFeetRounded = Math.ceil(((col1Data.get(i) /12)*4));
     // sqrFeetRounded = Math.ceil(((col2Data.get(i) /12)*4));
      //total3 += sqrFeet; // This will be unrounded.
      //total3 += Math.ceil(sqrFeet * 4);
      total3 += sqrFeet;
  }
  double sqrFeet1 = 0;
  for(int i = 0; i < size; i++){
  	sqrFeet1 += (col1Data.get(i) /12);
      System.out.println("Column1 " + (i+1) + " : " + (col1Data.get(i) /12));
      sqrFeet1 += (col2Data.get(i) / 12);
      System.out.println("Column1 " + (i+1) + " : " + (col2Data.get(i) /12));
  }
  double  sqrFeetRounded1 = 0;
  System.out.println("Straight Edge Unrounded: " + sqrFeet1);
  sqrFeetRounded1 = Math.ceil(sqrFeet1 * 4) /4;
  System.out.println("Straight Edge Unrounded: " + sqrFeetRounded1);



  String format1 = String.format("%.2f", sqrFeetRounded1);
  straightEdgeFieldT2.setText(format1);
  
}
public void calculateSQFTt3(TableColumn<FullBacksplashDetails, Double> column1,
      TableColumn<FullBacksplashDetails, Double> column2,
      TableView<FullBacksplashDetails> table)
{
	double total = 0.00;
	double total2 = 0.00;
	double sqrFeet = 0.00;
	double sqrFeetRounded = 0.00;


	ArrayList<Double> col1Data = new ArrayList<>();
	ArrayList<Double> col2Data = new ArrayList<>();

	for (FullBacksplashDetails items : table.getItems()){
		col1Data.add(column1.getCellObservableValue(items).getValue());
	}
	for (FullBacksplashDetails items : table.getItems()){
		col2Data.add(column2.getCellObservableValue(items).getValue());
	}


	int size = col1Data.size();
	for (int i = 0; i < size; i++){


		  sqrFeet = ((col1Data.get(i) * col2Data.get(i)) / 144);
          sqrFeetRounded = Math.ceil(((col1Data.get(i) * col2Data.get(i) /144)*4));
          sqrFeetRounded = sqrFeetRounded / 4;
          total += sqrFeet; // This will be unrounded.
          total2 += sqrFeetRounded; //totals the rounded measurements


		}
		System.out.println(total);
			String format = String.format("%.2f", total2);
				areaFieldsqftT3.setText(format);


}
public void calculateSQFTt6(TableColumn<EdgingDetails, Double> column1,TableColumn<EdgingDetails, Boolean> column2, TableColumn<EdgingDetails, Boolean> column3, TableView<EdgingDetails> table)
{
	double total = 0.00;
	double total2 = 0.00;
	double total3 = 0.00;


	ArrayList<Double> col1Data = new ArrayList<>();
	ArrayList<Boolean> col2Data = new ArrayList<>();
	ArrayList<Boolean> col3Data = new ArrayList<>();

	for (EdgingDetails items : table.getItems())
	{
		col1Data.add(column1.getCellObservableValue(items).getValue());
		col2Data.add(column2.getCellObservableValue(items).getValue());
		col3Data.add(column3.getCellObservableValue(items).getValue());
		System.out.println("Column 1 Edging: " + col1Data.toString());
		System.out.println("Column 2 Edging: " + col2Data.toString());
		System.out.println("Column 3 Edging: " + col3Data.toString());
		
	}

	//This is used to calculate straight edging and place it into the textfield
	int size = col1Data.size();
	for (int i = 0; i < size; i++){
		double sqrFeet = col1Data.get(i) / 12;
		System.out.println("AREA OF ROW" + (i+1) + ": "+ sqrFeet);

		total += sqrFeet;
		}
	total = Math.ceil(total * 4);
	System.out.println("Square foot edgings: " + total);
	total = total / 4;

	String format = String.format("%.2f", total);
	edgingField1.setText(format);

	//If boolean value is true the measurements will be stored into the
	//beveled text field as well as the straight edge.
	for(int i = 0; i < col2Data.size(); i++){
		System.out.println("Logic Check: " + (col2Data.get(i).booleanValue() == true));
		if(col2Data.get(i).booleanValue() == true)
		{
			Double sqrFeet = col1Data.get(i) / 12;
			total2 += sqrFeet;

		}else{
			System.out.println("nope");
		}
	}
	total2 = Math.ceil(total2 * 4);
	System.out.println("Square foot edgings: " + total2);
	total2 = total2 / 4;
	String format2 = String.format("%.2f", total2);
	beveledEdgesField1.setText(format2);

	for(int i = 0; i < col3Data.size(); i++)
	{
		if(col3Data.get(i).booleanValue() == true)
		{
			Double sqrFeet = col1Data.get(i) / 12;
			total3 += sqrFeet;
			System.out.println("TOTAL SQUARE FEET OF POLISHED EDGES OF FULL BACKSPLASH: " + total3);
		}
		else
		{
			System.out.println("FULL BACKSPLASH IS NOT CLICKED");
		}
	}
	total3 = Math.ceil(total3 * 4);
	System.out.println("Square foot edgings: " + total3);
	total3 = total3 / 4;

	System.out.println("Square foot edgings: " + total3);
	String format3 = String.format("%.2f", total3);
	polishedEdgesField1.setText(format3);

}
public void calculateSQFTt7(TableColumn<FullBacksplashEdgingDetails, Double> column1, TableColumn<FullBacksplashEdgingDetails, Double> column2, TableColumn<FullBacksplashEdgingDetails, Boolean> column3, TableView<FullBacksplashEdgingDetails> table)
{
	double total = 0;
	double total3 = 0;
	double total2 = 0;
	double total4 = 0;

	ArrayList<Double> col1Data = new ArrayList<>();
	ArrayList<Double> col2Data = new ArrayList<>();
	ArrayList<Boolean> col3Data = new ArrayList<>();


	for (FullBacksplashEdgingDetails items : table.getItems())
	{
		col1Data.add(column1.getCellObservableValue(items).getValue());
		col2Data.add(column2.getCellObservableValue(items).getValue());
		col3Data.add(column3.getCellObservableValue(items).getValue());

	}
	//This is used to calculate straight edging and place it into the textfield
	int size = col1Data.size();
	for (int i = 0; i < size; i++){
		double sqrFeet = col1Data.get(i) / 12;
		double sqrFeet2 = col2Data.get(i) / 12;
		total3 += sqrFeet;
		total += sqrFeet2;
		
		}
	
	double total_4 = Math.ceil((total + total3)*4);
	System.out.println("1st total_4 = " + total_4);
			total_4 = total_4 / 4;
			System.out.println("2nd total_4 = " + total_4);

	String format = String.format("%.2f", total_4);
	straightEdgeFieldT3.setText(format);
	
	//If boolean value is true the measurements will be stored into the
	//beveled text field as well as the straight edge.
	for(int i = 0; i < col2Data.size(); i++){
		if(col3Data.get(i).booleanValue() == true)
		{
			double sqrFeet = col1Data.get(i) / 12;
			
			double sqrFeet2 = col2Data.get(i) / 12;
			total2 += sqrFeet;
			total4 += sqrFeet2;
			System.out.println("TOTAL SQUARE FEET OF POLISHED EDGES OF FULL BACKSPLASH: " + (total2 + total4));
		}else{
			System.out.println("FULL BACKSPLASH IS NOT CLICKED");
		}
	}
	double total_5 = Math.ceil((total2 + total4)*4) / 4;
	String format2 = String.format("%.2f", total_5);
	polishedEdgesFieldT3.setText(format2);



}
@FXML private void handleCalcAll(){
    //Fees
    final double ADMINFEE = 0.05;
    //Kitchen and Edging
    double table1num = 0;               double edgenum = 0;
    double edgeBevelnum = 0;            double edgePolishedNum = 0;
    //Four Inch Backsplash
    double table2num = 0;               
    double table2EdgeNum = 0;           double table2BuildOut = 0;
    //Trend Stone Full Backsplash
    double table3num = 0;               double table3BsCutOuts = 0;
    double table3StripeTrendMosaic = 0; double table3StripCustomMosaic = 0;
    double table3InLays5x5 = 0;         double table3InLays12x12 = 0;
    //Mosaic Full Backsplash
    double table3MosaicNum = 0;                 double mosaicTable3BsCutOuts = 0;
    double mosaicTable3StripeTrendMosaic = 0;   double mosaicTable3StripCustomMosaic = 0;
    double mosaicTable3InLays5x5 = 0;           double mosaicTable3InLays12x12 = 0;
    //Trendstone Full Backsplash Edging
    double table3BsEdging = 0;           double table3BsEdgingPolished = 0;
    //Mosaic Full Backsplash Edging
    double mosaicTable3BsEdging = 0;    double mosaicTable3BsEdgingPolished = 0;
    //Options
    double optionsTotalPrice = 0;
    double plumbingPrice = 0;           double sinksFaucetsAndAccessories = 0;
    double switchPlatesPrice = 0;       double toeKicks = 0; 

    //total pricing
    double totalCountertop = 0;             double totalEdge = 0;
    double total4InBacksplash = 0;          double totalFullBacksplashTrendstone = 0;
    double totalFullbacksplashMosaic = 0;   double totalTrendstoneFullBacksplashEdging = 0;
    double totalMosaicFullBacksplashEdging = 0;

    //total Pricing + fees
    double totalExtendedPriceKitchen = 0;        
    double totalExtendedPricePlusFeeKitchen = 0;
    double totalExtendedPricePlusFeePlusTripChargeKitchen = 0;

    double totalExtendedPricePlusFeeFourInch = 0;
    double totalExtendedPricePlusFeePlusTripChargeFourInch = 0;

    double totalExtendedPricePlusFeeFullTrendstone = 0;
    double totalExtendedPricePlusFeePlusTripChargeFullTrendstone = 0;

    double totalExtendedPricePlusFeeFullMosaic = 0;
    double totalExtendedPricePlusFeePlusTripChargeFullMosaic = 0;
    //All quantities
    double totalKitchen = 0;                            double totalFourInch = 0;
    double totalFullTrendstoneBacksplash = 0;           double totalFullMosaicBacksplash = 0; 
    double totalFinalPlus = 0;
   
    //Kitchen
    table1num = Double.parseDouble(areaFieldsqftT1.getText());
    if(ctEdgingIncludeCheckBox.isSelected()){
    edgenum = Double.parseDouble(edgingField1.getText());
    edgeBevelnum = Double.parseDouble(beveledEdgesField1.getText());
    edgePolishedNum = Double.parseDouble(polishedEdgingFieldT1.getText());
    }
    //Four Inch Backsplash
    if(FourInchBSIncludeCheckBox.isSelected()){
        table2num = Double.parseDouble(areaFieldsqftT2.getText());
        
        table2BuildOut = Double.parseDouble(buildOutsFieldT3.getText());
      }
    if (fourInchEdgingIncludeCheckBox.isSelected()){
  	  table2EdgeNum = Double.parseDouble(straightEdgeFieldT2.getText());
    }
      //Trendstone Full Backsplash
      if(FullBackSplashIncludeCheckBox.isSelected() && trendStoneFullBacksplashCheckBox.isSelected()){
        table3num = Double.parseDouble(areaFieldsqftT3.getText());
        table3BsCutOuts = Double.parseDouble(cutOutsQuantityField.getText());
        table3StripeTrendMosaic = Double.parseDouble(stripeMosaicsField.getText());
        table3StripCustomMosaic = Double.parseDouble(stripeCustomMosaics.getText());
        table3InLays5x5 = Double.parseDouble(inlaysDiamond5x5Field.getText());
        table3InLays12x12 = Double.parseDouble(inlaysDiamond12x12Field.getText());
      }
      //Mosaic Full Backsplash
      if(FullBackSplashIncludeCheckBox.isSelected() && MosaicBackSplashIncludeCheckBox.isSelected()){
        table3MosaicNum = Double.parseDouble(areaFieldsqftT3.getText());
        mosaicTable3BsCutOuts = Double.parseDouble(cutOutsQuantityField.getText());
        mosaicTable3StripeTrendMosaic = Double.parseDouble(stripeMosaicsField.getText());
        mosaicTable3StripCustomMosaic = Double.parseDouble(stripeCustomMosaics.getText());
        mosaicTable3InLays5x5 = Double.parseDouble(inlaysDiamond5x5Field.getText());
        mosaicTable3InLays12x12 = Double.parseDouble(inlaysDiamond12x12Field.getText());
      }
      //Trendstone Full Backsplash Edging
      if(fullBacksplashEdgingIncludeCheckBox.isSelected() && trendStoneFullBacksplashCheckBox.isSelected())
      {
        table3BsEdging = Double.parseDouble(straightEdgeFieldT3.getText());
        table3BsEdgingPolished = Double.parseDouble(polishedEdgesFieldT3.getText());
      }
      //Mosaic Full Backsplash Edging
      if(fullBacksplashEdgingIncludeCheckBox.isSelected() && MosaicBackSplashIncludeCheckBox.isSelected())
      {
        mosaicTable3BsEdging = Double.parseDouble(straightEdgeFieldT3.getText());
        mosaicTable3BsEdgingPolished = Double.parseDouble(polishedEdgesFieldT3.getText());
      }
    
      //Factoring
      //Kitchen & Edging
      table1num *= 62;          edgenum *= 24;
      edgeBevelnum *= 18;       edgePolishedNum *= 18;
      //Four Inch Backsplash & Edging
      table2num *= 62;               table2EdgeNum *= 18;
      table2BuildOut *= 30;
      //Trend Full Backsplash 
      table3num *= 62;               table3BsCutOuts *= 20;
      table3StripeTrendMosaic *= 75; table3StripCustomMosaic *= 35;
      table3InLays5x5 *= 35;         table3InLays12x12 *= 75;
      //Mosaic Full Backsplash
      table3MosaicNum *= 62;                 mosaicTable3BsCutOuts *= 20;
      mosaicTable3StripeTrendMosaic *= 75;   mosaicTable3StripCustomMosaic *= 150;
      mosaicTable3InLays5x5 *= 35;           mosaicTable3InLays12x12 *= 75;
      //Trendstone Full Backsplash Edging
      table3BsEdging *= 18; 
      //Mosaic Full Backsplash Edging
      mosaicTable3BsEdging *= 18;
      //Options 
      if(check1.selectedProperty().getValue()){optionsTotalPrice += (Double.parseDouble(check1TextField.getText()) * 4);}
      if(check2.selectedProperty().getValue()){optionsTotalPrice += (Double.parseDouble(check2TextField.getText()) * 5);}
    	if(check3.selectedProperty().getValue()){optionsTotalPrice += (Double.parseDouble(check3TextField.getText()) * 75);}
    	if(check4.selectedProperty().getValue()){optionsTotalPrice += (Double.parseDouble(check4TextField.getText()) * 200);}
    	if(check5.selectedProperty().getValue()){optionsTotalPrice += (Double.parseDouble(check5TextField.getText()) * 5);}
    	if(check6.selectedProperty().getValue()){optionsTotalPrice += (Double.parseDouble(check6TextField.getText()) * 50);}
    	if(check7.selectedProperty().getValue()){optionsTotalPrice += (Double.parseDouble(check7TextField.getText()) * 50);}
    	if(check8.selectedProperty().getValue()){optionsTotalPrice += (Double.parseDouble(check8TextField.getText()) * 20);}
    	if(check11.selectedProperty().getValue()){optionsTotalPrice += (Double.parseDouble(check11TextField.getText()) * 30);}
    	if(check12.selectedProperty().getValue()){optionsTotalPrice +=(Double.parseDouble(check12TextField.getText()) * 1);} // no information in options on the factor
    	if(check13.selectedProperty().getValue()){optionsTotalPrice += (Double.parseDouble(check13TextField.getText()) * 1);}// no information in options on the factor
    	if(check14.selectedProperty().getValue()){optionsTotalPrice += (Double.parseDouble(check14TextField.getText()) * 130);}
    	if(check15.selectedProperty().getValue()){optionsTotalPrice += (Double.parseDouble(check15TextField.getText()) * 1);}// no information in options on the factor
    	if(check16.selectedProperty().getValue()){optionsTotalPrice += (Double.parseDouble(check16TextField.getText()) * 1);;}// no information in options on the factor
    	if(check17.selectedProperty().getValue()){optionsTotalPrice += (Double.parseDouble(check17TextField.getText()) * 37);}
    	if(check18.selectedProperty().getValue()){optionsTotalPrice += (Double.parseDouble(check18TextField.getText()) * 20);}
    	if(check19.selectedProperty().getValue()){optionsTotalPrice += (Double.parseDouble(check19TextField.getText()) * 75);}
    	if(check20.selectedProperty().getValue()){optionsTotalPrice += (Double.parseDouble(check20TextField.getText()) * 75);}
      plumbingPrice = Double.parseDouble(plumbingField.getText());                  
      sinksFaucetsAndAccessories = Double.parseDouble(accessoriesField.getText()); 
      switchPlatesPrice = Double.parseDouble(switchPlatesField.getText());          
      toeKicks = Double.parseDouble(toeKicksTextField.getText());
      double totalAdditional = plumbingPrice + sinksFaucetsAndAccessories + switchPlatesPrice + toeKicks;

      //Summation of Factors
      totalCountertop = table1num + edgenum + edgeBevelnum + edgePolishedNum;
      total4InBacksplash = table2num + table2EdgeNum + table2BuildOut;
      totalFullBacksplashTrendstone = table3num + table3BsEdging + table3BsCutOuts + table3StripeTrendMosaic + table3StripCustomMosaic + table3InLays5x5 + table3InLays12x12;          
      totalFullbacksplashMosaic = table3MosaicNum + mosaicTable3BsEdging + mosaicTable3BsCutOuts + mosaicTable3StripeTrendMosaic + mosaicTable3StripCustomMosaic + mosaicTable3InLays5x5 + mosaicTable3InLays12x12;              
      
     
      
      System.out.println("Countertop: " + totalCountertop);
      System.out.println("Four Inch: " + total4InBacksplash);
      System.out.println("Full Trendstone: " + totalFullBacksplashTrendstone);
      System.out.println("Full Mosaic: " + totalFullbacksplashMosaic);
      System.out.println("Countertop: " + optionsTotalPrice);
      //With Fees
      //Kitchen + Edging + Options
      totalExtendedPriceKitchen = totalCountertop + optionsTotalPrice;
      totalExtendedPricePlusFeeKitchen = (totalExtendedPriceKitchen * ADMINFEE) + totalExtendedPriceKitchen;
      totalExtendedPricePlusFeePlusTripChargeKitchen = TripChange(totalExtendedPricePlusFeeKitchen);
      //Four Inch Backsplash + Four Inch Backsplash Edging + Build out
      totalExtendedPricePlusFeeFourInch = (total4InBacksplash * ADMINFEE) + total4InBacksplash;
      //totalExtendedPricePlusFeePlusTripChargeFourInch = TripChange(totalExtendedPricePlusFeeFourInch);
      //Full Trendstone Backsplash 
      totalExtendedPricePlusFeeFullTrendstone = (totalFullBacksplashTrendstone * ADMINFEE) + totalFullBacksplashTrendstone;
      //totalExtendedPricePlusFeePlusTripChargeFullTrendstone = TripChange(totalExtendedPricePlusFeeFullTrendstone);
      //Full Mosaic Backsplash
      totalExtendedPricePlusFeeFullMosaic = (totalFullbacksplashMosaic * ADMINFEE) + totalFullbacksplashMosaic;
      //totalExtendedPricePlusFeePlusTripChargeFullMosaic = TripChange(totalExtendedPricePlusFeeFullMosaic);
   
      
      //Granite Color Factor
	      double percent1 = checkGraniteColor(gColorBox1);    double percent2 = checkGraniteColor(gColorBox2);
	      double percent3 = checkGraniteColor(gColorBox3);    
	      
	      
      System.out.println("Percent 1: " + percent1);
      System.out.println("Percent 2: " + percent2);
      System.out.println("Percent 3: " + percent3);
  
      
      //Final
      totalKitchen = (totalExtendedPricePlusFeePlusTripChargeKitchen * percent1);
      totalFourInch = (totalExtendedPricePlusFeeFourInch * percent2);
      totalFullTrendstoneBacksplash = (totalExtendedPricePlusFeeFullTrendstone * percent3);           
      totalFullMosaicBacksplash = totalExtendedPricePlusFeeFullMosaic;
   

      double allTotal = totalKitchen + totalFourInch + totalFullTrendstoneBacksplash+ totalFullMosaicBacksplash;
      String res = String.format("%.2f", allTotal);
      totalFinalField.setText(res);
      
       totalFinalPlus = totalAdditional + allTotal;
      

      //Part 1 Formatter
      String resultT1 = String.format("%.2f", table1num); //Trend Stone Material field
      String resultT2 = String.format("%.2f", edgenum); //Edge price Field
      String resultEdgeT2 = String.format("%.2f", edgeBevelnum);
      String resultEdgePolishedT2 = String.format("%.2f", edgePolishedNum);
      String resultOption = String.format("%.2f", optionsTotalPrice); //Options field
      String resultT_1 = String.format("%.2f", totalExtendedPricePlusFeePlusTripChargeKitchen); // sub total field
   
      trendFieldt5.setText(resultT1);
      edgingFieldt5.setText(resultT2);
      bevelEdgingFieldt5.setText(resultEdgeT2);
      polishedEdgingFieldT1.setText(resultEdgePolishedT2);
      optionsField.setText(resultOption);
      subTotalFieldt5.setText(resultT_1);
      
        //Four inch Backsplash
      String result4inch = String.format("%.2f", table2num);
      String result4Inchedging = String.format("%.2f", table2EdgeNum);
      String result4InchBuildOut = String.format("%.2f", table2BuildOut);
      String result4Inchtotal = String.format("%.2f", totalExtendedPricePlusFeePlusTripChargeFourInch);
      
      fourInchBSField.setText(result4inch);
      fourInchBSEdgingField.setText(result4Inchedging);
      fourInchBuildOutField.setText(result4InchBuildOut);
      fourInchTotalField.setText(result4Inchtotal);
      

      //FULL BS
      String resultT5 = String.format("%.2f", table3num); //Full BS text field
      String resultT5FullEdge = String.format("%.2f", table3BsEdging); //Full BS edging field
      String resultT5FullCutOuts = String.format("%.2f", table3BsCutOuts); //Full BS cut out field
      
      fullBSField.setText(resultT5);
      bsEdgingField.setText(resultT5FullEdge);
      cutOutsField.setText(resultT5FullCutOuts);

      //MOSAIC
      String resultMosaic = String.format("%.2f", table3MosaicNum);
      String resultMosaicBsEdging = String.format("%.2f", mosaicTable3BsEdging);
      String resultMosaicCutOut = String.format("%.2f", mosaicTable3BsCutOuts);
      String resultMosaicInlay5x5 = String.format("%.2f", mosaicTable3InLays5x5);
      String resultMosaicInlay12x12 = String.format("%.2f", mosaicTable3InLays12x12);
      
      mosaicStandardField.setText(resultMosaic);
      mosaicBSEdgingField.setText(resultMosaicBsEdging);
      mosaicCutOutField.setText(resultMosaicCutOut);
      mosaicInlay5Field.setText(resultMosaicInlay5x5);
      mosaicInlay12Field.setText(resultMosaicInlay12x12);

      //Formatting results for text fields.
      String resultKitchenLevelPrice = String.format("%.2f", totalKitchen);
      String resultFourInchPrice = String.format("%.2f", totalFourInch);
      String resultFullTrendstonePrice = String.format("%.2f", totalFullTrendstoneBacksplash);
      String resultFullMosaicPrice = String.format("%.2f", totalFullMosaicBacksplash);



	       //Setting formatted results into the text fields.
	       totalLevelPriceKitchenField.setText(resultKitchenLevelPrice);
	       totalLevelPriceFourInchField.setText(resultFourInchPrice);
	       totalLevelPriceFullBSField.setText(resultFullTrendstonePrice);
	       mosaicTotalField.setText(resultFullMosaicPrice);

	       String resultEverything = String.format("%.2f", totalFinalPlus);
	       totalFinalPlusField.setText(resultEverything);


     


      
    

}
public double TripChange(double number){
	
if(number < 3000)
{
 number = number + 150;
 System.out.println("Added $150 to Subtotal");
 return number;
}else if(number > 3000 && number < 5000){
 number = number + 200;
 System.out.println("Added $200 to Subtotal");
 return number;
}else{
 number = number + 250;
 System.out.println("Added $250 to Subtotal");
 return number;
}

}


/**	 @FXML private void handleCalcAll1(){
	 	double mosaicBSEdging = 0.00;
	 	double table3FinalPrice = 0.00;
	 	double table3BsEdging = 0.00;
	 	double table2num = 0.00;
	 	double table2BsEdging = 0.00;
	 	double table2EdgeNum = 0.00;
	 	double table2BuildOut = 0.00;
	 	//Kitchen
	 	double table1num = Double.parseDouble(areaFieldsqftT1.getText());
      double edgenum = Double.parseDouble(edgingField1.getText());
      double edgeBevelnum = Double.parseDouble(beveledEdgesField1.getText());
      double edgePolishedNum = Double.parseDouble(polishedEdgingFieldT1.getText());
      double toeKickNum = Double.parseDouble(toeKicksTextField.getText());
      //Four inch BS
      if(FourInchBSIncludeCheckBox.isSelected()){
      table2num = Double.parseDouble(areaFieldsqftT2.getText());
      table2EdgeNum = Double.parseDouble(straightEdgeFieldT2.getText());
      table2BuildOut = Double.parseDouble(buildOutsFieldT3.getText());
      }else
      {
      	table2num = 0.00;
	        table2BsEdging = 0.00;
	        table2EdgeNum = 0.00;
	        table2BuildOut = 0.00;
      }
      //Full BS
      double table3num = Double.parseDouble(areaFieldsqftT3.getText());
      if(FullBackSplashIncludeCheckBox.selectedProperty().get())
      {table3BsEdging = Double.parseDouble(straightEdgeFieldT3.getText());}else
      {table3BsEdging = Double.parseDouble("0.00");}
      double table3BsCutOuts = Double.parseDouble(cutOutsQuantityField.getText());
      double table3StripeTrendMosaic = Double.parseDouble(stripeMosaicsField.getText());
      double table3StripCustomMosaic = Double.parseDouble(stripeCustomMosaics.getText());
      double table3InLays5x5 = Double.parseDouble(inlaysDiamond5x5Field.getText());
      double table3InLays12x12 = Double.parseDouble(inlaysDiamond12x12Field.getText());
      //FULL MOSAIC BACKSPLASH
      double mosaicTableNum = 0.00;
      //double mosaicTableCustomNum = 0.00;
      if(MosaicBackSplashIncludeCheckBox.isSelected())
      {  mosaicTableNum = Double.parseDouble(areaFieldsqftT3.getText());
      //mosaicTableCustomNum = Double.parseDouble(stripeCustomMosaicsMosaic.getText());//CHANGE WHEN YOU HAVE TEXT FIELD AND TABLE FOR MOSAICS.
      	mosaicBSEdging = Double.parseDouble(straightEdgeFieldT3.getText());}
      else{mosaicBSEdging = Double.parseDouble("0");}
      double mosaicCutOut = 0.00;
      mosaicCutOut =	Double.parseDouble(cutOutsMosaicsField.getText());
      double mosaicInLayStripe = 0.00;
      mosaicInLayStripe = Double.parseDouble(stripeCustomMosaicsMosaic.getText());
      double mosaicInLaysDiamond5x5 = 0.00;
      mosaicInLaysDiamond5x5 = Double.parseDouble(inlaysDiamond5x5FieldMosaic.getText());
      double mosaicInLaysDiamond12x12 = 0.00;
      mosaicInLaysDiamond12x12 = Double.parseDouble(inlaysDiamond12x12FieldMosaic.getText());

      double plumbingPrice = Double.parseDouble(plumbingField.getText());
      double sinksFaucetsAndAccessories = Double.parseDouble(accessoriesField.getText());
      double switchPlatesPrice = Double.parseDouble(switchPlatesField.getText());
      double table1numPrice = table1num * 62;
      double edgePrice = edgenum * 24;
      double edgeBevelPrice = edgeBevelnum * 18;
      double edgeBevelPriceNotCalc = edgenum * 18;
      bevelEdgingFieldt5NotCalc.textProperty().set(Double.toString(edgeBevelPriceNotCalc));
      double edgePolishedPrice = edgePolishedNum * 18;
      double toeKickPrice = toeKickNum * 18;
      double table1FinalPrice = table1numPrice + edgePrice + edgeBevelPrice + edgePolishedPrice + toeKickPrice; //Holds the total for kitchen countertop
      //Options Factor
      double optionsTotalPrice = 0.00;
      //Four inch Factor
      double table2numPrice = table2num * 62;
      double table2EdgeNumPrice = table2EdgeNum * 18;
      double table2BuildOutPrice = table2BuildOut * 30;
      double table2FinalPrice = table2numPrice + table2EdgeNumPrice + table2BuildOutPrice; //Holds final price for Four in BackSplash
      double table2FinalPricePlusFee = table2FinalPrice + (table2FinalPrice * ADMINFEE);
      //FULL BS Factor
      double table3TrendPrice = table3num * 62;
      double table3BsEdgingPrice = table3BsEdging * 18;
      double table3BsCutOutsPrice = table3BsCutOuts * 20;
      double table3StripeTrendMosaicPrice = table3StripeTrendMosaic * 75;
      double table3StripCustomMosaicPrice = table3StripCustomMosaic * 150;
      double table3InLays5x5Price = table3InLays5x5 * 35;
      double table3InLays12x12Price = table3InLays12x12 * 75;
      table3FinalPrice = table3TrendPrice + table3BsEdgingPrice + table3BsCutOutsPrice + table3StripeTrendMosaicPrice +
      							table3StripCustomMosaicPrice +table3InLays5x5Price + table3InLays12x12Price; //Holds the total for Full Backsplash4

      double table3FinalPricePlusFee = table3FinalPrice + (table3FinalPrice * ADMINFEE);
      //MOSAIC BS FACTOR
      double mosaicTableNumPrice = mosaicTableNum * 62;
      double mosaicTableCustomNumPrice = 0;
      double mosaicBSEdgingPrice = mosaicBSEdging * 18;
      double mosaicCutOutPrice = mosaicCutOut * 20;
      double mosaicInLayStripePrice = mosaicInLayStripe * 75;
      double mosaicInLaysDiamond5x5Price = mosaicInLaysDiamond5x5 * 35;
      double mosaicInLaysDiamond12x12Price = mosaicInLaysDiamond12x12 * 75;
      double mosaicFinalPrice = mosaicTableNumPrice + mosaicTableCustomNumPrice + mosaicBSEdgingPrice + mosaicCutOutPrice + mosaicInLayStripePrice + mosaicInLaysDiamond5x5Price +  mosaicInLaysDiamond12x12Price;
      double mosaicFinalPricePlusFee = mosaicFinalPrice + (mosaicFinalPrice * ADMINFEE);
      System.out.println("Kitchen Final Price Total: " + table1FinalPrice + "\n" +
      					"Four Inch BS Price Total: " + table2FinalPrice + "\n" +
      					"Full BS Price Total: " + table3FinalPrice + "\n" +
      					"Mosaic Price Total: " + mosaicFinalPrice);

      if(check1.selectedProperty().getValue()){optionsTotalPrice += (Double.parseDouble(check1TextField.getText()) * 4);}
      if(check2.selectedProperty().getValue()){optionsTotalPrice += (Double.parseDouble(check2TextField.getText()) * 5);}
      if(check3.selectedProperty().getValue()){optionsTotalPrice += 75;}
      if(check4.selectedProperty().getValue()){optionsTotalPrice += 200;}
      if(check5.selectedProperty().getValue()){optionsTotalPrice += (Double.parseDouble(check5TextField.getText()) * 5);}
      if(check6.selectedProperty().getValue()){optionsTotalPrice += 50;}
      if(check7.selectedProperty().getValue()){optionsTotalPrice += 100;}
      if(check8.selectedProperty().getValue()){optionsTotalPrice += 0.00;}
      if(check11.selectedProperty().getValue()){optionsTotalPrice += 30;}
      if(check12.selectedProperty().getValue()){optionsTotalPrice +=(Double.parseDouble(check8TextField.getText()) * 20);}
      if(check13.selectedProperty().getValue()){optionsTotalPrice += 130;}
      if(check14.selectedProperty().getValue()){optionsTotalPrice += 100;}
      if(check15.selectedProperty().getValue()){optionsTotalPrice += 0.00;}
      if(check16.selectedProperty().getValue()){optionsTotalPrice += 0.00;}
      if(check17.selectedProperty().getValue()){optionsTotalPrice += 60;}
      if(check18.selectedProperty().getValue()){optionsTotalPrice += 30;}
      if(check19.selectedProperty().getValue()){optionsTotalPrice += 75;}
      if(check20.selectedProperty().getValue()){optionsTotalPrice += 75;}

      checkCheckBoxes();

      double fullBackSplashPrice = table3TrendPrice;

      double allTables = table1num + table3num;


      double  subTotalPrice = table1FinalPrice +  optionsTotalPrice + ((table1FinalPrice +  optionsTotalPrice) * ADMINFEE);
      System.out.println("subTotalPrice : " + subTotalPrice);
      //Calculates Trip Charge and adds to subTotalPrice
      if(subTotalPrice < 3000.00)
      {
      	subTotalPrice += 150.00;
      	System.out.println("Added $150 to subTotalPrice");
      	System.out.println("New subTotalPrice : " + subTotalPrice);
      }else if(subTotalPrice > 3000.00 && subTotalPrice < 5000.00){
      	subTotalPrice += 200.00;
      	System.out.println("Added $200 to subTotalPrice");
      	System.out.println("New subTotalPrice : " + subTotalPrice);
      }else{
      	subTotalPrice += 250.00;
      	System.out.println("Added $250 to subTotalPrice");
      	System.out.println("New subTotalPrice : " + subTotalPrice);
      }



      double percent1 = checkGraniteColor(gColorBox1);
      double percent2 = checkGraniteColor(gColorBox2);
      double percent3 = checkGraniteColor(gColorBox3);
      System.out.println("Kitchen PRICING LEVEL: " + percent1);
      System.out.println("4 inch PRICING LEVEL: " + percent2);
      System.out.println("Full BS PRICING LEVEL: " + percent3);

      double kitchenTOTAL = subTotalPrice * percent1;


      table2FinalPricePlusFee = table2FinalPricePlusFee * percent2;
      table3FinalPricePlusFee = table3FinalPricePlusFee + percent3;

      String resultT1 = String.format("%.2f", allTables); //Calc page -  KEEP

      double finaltotalKitchen = table1numPrice + edgePrice + optionsTotalPrice;


      String resultT2 = String.format("%.2f", table1numPrice); //Trend Stone Material field
      String resultT3 = String.format("%.2f", edgePrice); //Edge price Field
      String resultEdgeT1 = String.format("%.2f", edgeBevelPrice);
      String resultOption = String.format("%.2f", optionsTotalPrice); //Options field
      String resultT4 = String.format("%.2f", finaltotalKitchen); // sub total field
      String resultKitchenLevelPrice = String.format("%.2f", kitchenTOTAL);

        //Four inch Backsplash
      String result4inch = String.format("%.2f", table2numPrice);
      String result4Inchedging = String.format("%.2f", table2EdgeNumPrice);
      String result4InchBuildOut = String.format("%.2f", table2BuildOut);
      String result4Inchtotal = String.format("%.2f", table2FinalPrice);
      String result4InchLevelPrice = String.format("%.2f", table2FinalPricePlusFee);

      //FULL BS
      String resultT5 = String.format("%.2f", table3TrendPrice); //Full BS text field
      String resultT5FullEdge = String.format("%.2f", table3BsEdgingPrice); //Full BS edging field
      String resultT5FullCutOuts = String.format("%.2f", table3BsCutOutsPrice); //Full BS cut out field
      String resultT5TotalLevelPrice = String.format("%.2f", table3FinalPricePlusFee);

      //MOSAIC
      String resultMosaic = String.format("%.2f", mosaicTableNumPrice);
      String resultMosaicCustom = String.format("%.2f", mosaicTableCustomNumPrice);
      String resultMosaicBsEdging = String.format("%.2f", mosaicBSEdgingPrice);
      String resultMosaicCutOut = String.format("%.2f", mosaicCutOutPrice);
      String resultMosaicInlay5x5 = String.format("%.2f", mosaicInLaysDiamond5x5Price);
      String resultMosaicInlay12x12 = String.format("%.2f", mosaicInLaysDiamond12x12Price);
      String resultMosaicFinalPrice = String.format("%.2f", mosaicFinalPrice);
      double allFieldsTotal;
      //FINAL FIELD WITH ALL VALUES ADDED
      if(MosaicBackSplashIncludeCheckBox.isSelected()){
      	allFieldsTotal = table1FinalPrice + table2FinalPrice +  mosaicFinalPrice;
      }else{
      	allFieldsTotal = table1FinalPrice + table2FinalPrice + table3FinalPrice;
      }
      double allFieldsTotalPlusExtra = allFieldsTotal + plumbingPrice + sinksFaucetsAndAccessories + switchPlatesPrice;
      String resultFinalTotalProducts = String.format("%.2f", allFieldsTotal);
      String resultsFinalTotalProductsPlusAccessories = String.format("%.2f", allFieldsTotalPlusExtra);



       tableTotalField.setText(resultT1); //1

       //Kitchen Countertop setting prices
       trendFieldt5.setText(resultT2); //calc page
       edgingFieldt5.setText(resultT3); //2
       bevelEdgingFieldt5.setText(resultEdgeT1);
       optionsField.setText(resultOption); //3
       subTotalFieldt5.setText(resultT4); //4
       totalLevelPriceKitchenField.setText(resultKitchenLevelPrice);
       if(MosaicBackSplashIncludeCheckBox.isSelected()){
       fullBSField.setText("0"); //5
	        bsEdgingField.setText("0"); //6
	        cutOutsField.setText("0"); // 7
	        totalLevelPriceFullBSField.setText("0");
       }else{
      	   //FULL BS setting prices
      fullBSField.setText(resultT5); //5
      bsEdgingField.setText(resultT5FullEdge); //6
      cutOutsField.setText(resultT5FullCutOuts); // 7
      totalLevelPriceFullBSField.setText(resultT5TotalLevelPrice);
       }
      fourInchBSField.setText(result4inch);
      fourInchBSEdgingField.setText(result4Inchedging);
      fourInchBuildOutField.setText(result4InchBuildOut);
      fourInchTotalField.setText(result4Inchtotal);
      totalLevelPriceFourInchField.setText(result4InchLevelPrice);

      if(MosaicBackSplashIncludeCheckBox.isSelected()){
      mosaicStandardField.setText(resultMosaic);
	   mosaicCustomField.setText(resultMosaicCustom);
	    mosaicBSEdgingField.setText(resultMosaicBsEdging);
	    mosaicCutOutField.setText(resultMosaicCutOut);
	    mosaicInlay5Field.setText(resultMosaicInlay5x5);
	    mosaicInlay12Field.setText(resultMosaicInlay12x12);
	    mosaicTotalField.setText(resultMosaicFinalPrice);

      }else{
      	System.out.println("mosaic backsplash is not selected");
      	String numStr = "0";
      	  mosaicStandardField.setText(numStr);
 		   mosaicCustomField.setText(numStr);
 		    mosaicBSEdgingField.setText(numStr);
 		    mosaicCutOutField.setText(numStr);
 		    mosaicInlay5Field.setText(numStr);
 		    mosaicInlay12Field.setText(numStr);
 		    mosaicTotalField.setText(numStr);

      }

	       totalFinalField.setText(resultFinalTotalProducts);
	    totalFinalPlusField.setText(resultsFinalTotalProductsPlusAccessories);







  }
  */
public double checkGraniteColor(ChoiceBox<String> choiceBox){
  	
  	double value = 1.00;
  	final double a = 0.80;
  	final double b = 1.00;
  	final double c = 1.20;
  	final double d = 1.30;
  	String str = "";
  	Object check = choiceBox.getSelectionModel().getSelectedItem();
  	
  	for(int index = 0; index < graniteColorsData.size(); index++){
  		if(graniteColorsData.get(index).getKey() != check){
  		}else{
  			str = graniteColorsData.get(index).toStringColor();
  			break;
  		}
  	}
  	if(str == "A"){
  		return a;
  		
  	}
  	if(str == "B"){
  		
  		return b;
  	}
  	if(str == "C"){
  		
  		return c;
  	}
  	if(str == "D"){
  		return d;
  	}
  	return value;
  }
  public void checkCheckBoxes(){
  	System.out.println("Check 1" + check1.isSelected() + "\n"  +
				"Check 2" + check2.isSelected() + "\n"  +
				"Check 3" + check3.isSelected() + "\n"  +
				"Check 4" + check4.isSelected() + "\n"  +
				"Check 5" + check5.isSelected() + "\n"  +
				"Check 6" + check6.isSelected() + "\n"  +
				"Check 7" + check7.isSelected() + "\n"  +
				"Check 8" + check8.isSelected() + "\n"  +
				"Check 11" + check11.isSelected() + "\n"  +
				"Check 12" + check12.isSelected() + "\n"  +
				"Check 13" + check13.isSelected() + "\n"  +
				"Check 14" + check14.isSelected() + "\n"  +
				"Check 15" + check15.isSelected() + "\n"  +
				"Check 16" + check16.isSelected() + "\n"  +
				"Check 17" + check17.isSelected() + "\n"  +
				"Check 18" + check18.isSelected() + "\n"  +
				"Check 19" + check19.isSelected() + "\n"  +
				"Check 1" + check20.isSelected() + "\n"
	);
  }
  @FXML private void createAndSendProposal(){
	  try {
		handleCreateDocument();
		handleSendEmail();
	} catch (FileNotFoundException | EmailException e) {
		e.printStackTrace();
	}
	  
  }

  @FXML private void handleCreateDocument() throws FileNotFoundException {
      //CustomerDetails firstCustomer = new CustomerDetails();
      String firstName;
      String lastName;
      String street;
      String city;
      String state;
      String zipCode;
      String phoneNumber;
     // System.out.println(firstCustomer.toString());

      try {

          XWPFDocument document = new XWPFDocument();
          String imgFile = "C:\\GTPricing\\Images\\GTlogo.jpg";
                   
          FileInputStream inputStream = new FileInputStream(imgFile);
          
         
         
          //document.addPictureData(IOUtils.toByteArray(inputStream), document.PICTURE_TYPE_JPEG);
          XWPFParagraph paragraph = document.createParagraph();
          XWPFRun run = paragraph.createRun();

          //TITLE
          paragraph.setAlignment(ParagraphAlignment.CENTER);
          run.setFontSize(14);
          run.setBold(true);
        
          try {
				run.addPicture(inputStream, XWPFDocument.PICTURE_TYPE_JPEG, imgFile, Units.toEMU(110), Units.toEMU(40));
			} catch (Exception e) {
				e.printStackTrace();
			}
         inputStream.close();
          //run.setText("Granite Transformations");
          //PARAGRAPH 1
          XWPFParagraph paragraph1 = document.createParagraph();
          XWPFRun run1 = paragraph1.createRun();
          run1.setText("840 Upper State Rd. North Wales, PA 19454"); run1.addTab();run1.addTab();
          run1.setText("(215)283-4498");run1.addTab();run1.addTab();run1.setText("(215)283-4868 (Fax)");
          run1.addBreak();
          run1.setText("365 Lancaster Ave. Malvern, PA 19355");run1.addTab();run1.addTab();run1.addTab();
          run1.setText("(484)586-0051");run1.addTab();run1.addTab();run1.setText("(484)568-0053 (Fax)");
          run1.setBold(true);


          //PARAGRAPH 2
          XWPFParagraph paragraph2 = document.createParagraph();
          XWPFRun run2 = paragraph2.createRun();
          run2.setText("PA Bureau of Consumer Protection 1-888-520-6680");run2.addTab();run2.setText("         ");
          run2.setText("Liability Insurance Coverage $3,000,000"); run2.addBreak();
          run2.setText("HIC# PA42774");
          run2.addTab();run2.addTab();run2.addTab();run2.addTab();run2.addTab();run2.addTab();
          run2.addTab();run2.addTab();run2.addTab();
          run2.setText("     NJ13VH06978300");

          //PARAGRAPH 3
          XWPFParagraph paragraph3 = document.createParagraph();
          paragraph3.setBorderTop(Borders.BASIC_THIN_LINES);
          paragraph3.setBorderBottom(Borders.BASIC_THIN_LINES);
          paragraph3.setBorderLeft(Borders.BASIC_THIN_LINES);
          paragraph3.setBorderRight(Borders.BASIC_THIN_LINES);

          XWPFRun run31 = paragraph3.createRun();
          run31.addTab();run31.addTab();run31.addTab();run31.addTab();run31.addTab();
          run31.setText("WORKING PROPOSAL");
          run31.setBold(true);
          run31.setFontSize(16);
          //run31.setTextPosition(100);
          run31.addBreak();
          XWPFRun run3 = paragraph3.createRun();
          
          //run3.setText(str);
          
          run3.setText("Included: ");
          run3.addBreak();
          if(countertopIncludeCheckBox.isSelected()){
       	   run3.setText("Kitchen Countertop");
       	   run3.addBreak();
       	   //String color = gColorBox1.getValue();
       	   //run3.setText("Countertop Color: " + color);
          }
          if(ctEdgingIncludeCheckBox.isSelected()){
       	   run3.addBreak();
       	   run3.setText("Edging");
          }
          if(FourInchBSIncludeCheckBox.isSelected()){
       	   run3.addBreak();
       	   run3.setText("Four Inch Backsplash");
       	   //run3.addBreak();
       	   //run3.setText("Color: " + gColorBox2.getValue());
          }
           if(fourInchEdgingIncludeCheckBox.isSelected()){
       	   run3.addBreak();
       	   run3.setText("Four Inch Backsplash Edging");
          }
           
          if(FullBackSplashIncludeCheckBox.isSelected()){
       	   run3.addBreak();
       	   if(trendStoneFullBacksplashCheckBox.isSelected()){
       	   run3.setText("Full Trendstone Backsplash");
       	   }
       	   if(MosaicBackSplashIncludeCheckBox.isSelected()){
       		   run3.addBreak();
       		   run3.setText("Full Mosaic Backsplash");
       	   }
          }
          if(fullBacksplashEdgingIncludeCheckBox.isSelected()){
       	   run3.addBreak();
       	   run3.setText("Full Backsplash Edging");
          }
         if(check1.isSelected()){run3.addBreak();run3.setText("Installing Prep Board");}
         if(check2.isSelected()){run3.addBreak();run3.setText("Removing Existing Backsplash");}
         if(check3.isSelected()){run3.addBreak();run3.setText("Removing Existing Laminate Countertop");}
         if(check4.isSelected()){run3.addBreak();run3.setText("Removing Existing Tile Countertop");}
         //if(check5.isSelected()){run3.addBreak();run3.setText("Installing Prep Board");}
         if(check6.isSelected()){run3.addBreak();run3.setText("Installing Iron Bar < 36\"");}
         if(check7.isSelected()){run3.addBreak();run3.setText("Installing Iron Bar > 36\"");}
         if(check8.isSelected()){run3.addBreak();run3.setText("Installing Bend Trendstone Apron");}
         if(check11.isSelected()){run3.addBreak();run3.setText("Clipped Corners Quantity: " + check11TextField.getText());}
         //if(check12.isSelected()){run3.addBreak();run3.setText("Installing Prep Board");}
         //if(check13.isSelected()){run3.addBreak();run3.setText("Installing Prep Board");}
         if(check14.isSelected()){run3.addBreak();run3.setText("Adding Filler");}
         //if(check15.isSelected()){run3.addBreak();run3.setText("Installing Prep Board");}
         //if(check16.isSelected()){run3.addBreak();run3.setText("Installing Prep Board");}
         if(check17.isSelected()){run3.addBreak();run3.setText("RSG");}
         if(check18.isSelected()){run3.addBreak();run3.setText("Strainer");}
         if(check19.isSelected()){run3.addBreak();run3.setText("Sink Removal");}
         if(check20.isSelected()){run3.addBreak();run3.setText("Cooktop Removal");}

   
          run3.addBreak();
          run3.addBreak();
          run3.addBreak();
          run3.addBreak();
          run3.addBreak();
          run3.addBreak();
       
        String bevelEdge = bevelEdgingFieldt5.getText();
        bevelEdge.trim();
          run3.addBreak();run3.addBreak();run3.addBreak();run3.addBreak();run3.addBreak();run3.addBreak();
          if(bevelEdge.startsWith("0")){
          	bevelEdge = "N/A";
          }
          run3.setText("Bevel Edge Price: $" + bevelEdge);
          run3.addTab();run3.addTab();run3.addTab();run3.addTab();run3.addTab();run3.addTab();
          run3.setText("Additional Toe Kicks: $" + toeKicksTextField.getText());



          //Paragraph 7
          XWPFParagraph paragraph7 = document.createParagraph();
          paragraph7.setBorderTop(Borders.BASIC_BLACK_DASHES);
          paragraph7.setBorderRight(Borders.BASIC_BLACK_DASHES);
          paragraph7.setBorderLeft(Borders.BASIC_BLACK_DASHES);
          paragraph7.setBorderBottom(Borders.BASIC_BLACK_DASHES);
          XWPFRun run7 = paragraph7.createRun();
          run7.setText("Trend Stone / Trend Glass / Mosaic Installation:                                               Purchase Price: $" + totalFinalField.getText());
          run7.addBreak();
          run7.setText("Sink, Faucets, and Other Accessories:                                                                  Purchase Price: $" + accessoriesField.getText());
          run7.addBreak();
          run7.setText("Plumbing:                                                                                                                  Purchase Price: $" + plumbingField.getText());
          run7.addBreak();
          run7.setText("Options:                                                                                                                     Purchase Price: $" + optionsField.getText());
          run7.addBreak();
          run7.setText("GRAND TOTAL:                                                                                                         Purchase Price $" + totalFinalPlusField.getText());
          File file = new File("C:\\GTPricing\\Customers");
          if(!file.exists()){
          	if(file.mkdir()){
          		System.out.println("Directory has been created");
          		
          	}
          }
          StringBuilder sb = new StringBuilder();
	    	sb.append("C:\\GTPricing\\Customers\\").append(currentSurName.get()).append("_").append(currentName.get()).append(".docx");
	    	
	    	
	    	String location = sb.toString();
	    	location.replaceAll("\\s","");
	    	System.out.println(location);
          FileOutputStream out = new FileOutputStream(new File(location));
          document.write(out);
          out.close();          
          String title = "Great News!";
          String message = currentName.get() + " " + currentSurName.get() + "'s Working Proposal has been created";
          FxDialogs.showInformation(title, message);
          
          String imgFale = "file:C\\GTPricing\\images\\logo-mark.jpg";
          FileInputStream inputStream1 = new FileInputStream(imgFile);
			Image image = new Image(inputStream1);
			
        
      } catch (IOException e) {
          e.printStackTrace();
      }


}
	    @FXML private void handleSendEmail() throws EmailException{
	    	MultiPartEmail email = new MultiPartEmail();
	    	email.setHostName("smtp.googlemail.com");
	    	email.setSmtpPort(465);
	    	email.setAuthenticator(new DefaultAuthenticator("briankennedy392@gmail.com", "@Charlie1blue"));
	    	email.setSSLOnConnect(true);
	    	email.setFrom("briankennedy392@gmail.com");
	    	email.setSubject("TestMail");

	    	EmailAttachment attachment = new EmailAttachment();
	    	StringBuilder sb = new StringBuilder();
	    	sb.append("C:\\GTPricing\\Customers\\").append(currentSurName.get()).append("_").append(currentName.get()).append(".docx");
	    	String location = sb.toString();  
	    	location.replaceAll("\\s","");

	    	attachment.setPath(location);
	    	  attachment.setDisposition(EmailAttachment.ATTACHMENT);
	    	  attachment.setDescription("Granite Transformations: Working Proposal");






	    	email.setMsg("This is a test mail ... :-)");
	    	email.addTo(currentEmail.get());
	    	email.attach(attachment);
	    	email.send();
	    }
	    @FXML private void openDocument() throws IOException{
	    	update.openDocument(currentName.get(), currentSurName.get());
	    	
	    }
	  
/**
 * This class is used to allow the Countertop table column 1 the ability 
 * to edit. Only string values are able to be entered.
 * @author Brian
 *
 */
public class EditingCell extends TableCell<CountertopDetails, String> {
    private TextField textField;

    EditingCell(){
    }
    @Override
    public void startEdit(){
        super.startEdit();

        if (textField == null){createTextField();}
        setGraphic(textField);
        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        textField.selectAll();
    }
    @Override
    public void cancelEdit() {
        super.cancelEdit();

        setText(String.valueOf(getItem()));
        setContentDisplay(ContentDisplay.TEXT_ONLY);
    }
    @Override
    public void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setText(null);
            setGraphic(textField);
        } else {
            if (isEditing()) {
                if (textField != null) {
                    textField.setText(getString());
                }
                setGraphic(textField);
                setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            } else {
                setText(getString());
                setContentDisplay(ContentDisplay.TEXT_ONLY);
            }
        }
    }
    private void createTextField(){
        textField = new TextField(getString());
        textField.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
        textField.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ENTER){
                commitEdit(textField.getText());
            }else if(event.getCode() == KeyCode.ESCAPE){
                cancelEdit();
            }
        });

        textField.setOnKeyPressed(t -> {
         if (t.getCode() == KeyCode.ENTER){
         commitEdit(textField.getText());
         }else if(t.getCode() == KeyCode.ESCAPE){
         cancelEdit();
         }
         });
         
    }
    private String getString(){
        return getItem() == null ? "" : getItem();
    }


}
public class EditingCellFullBackSplashDouble extends TableCell<FullBacksplashDetails, Double> {
    private TextField textField;
    private TextFormatter<Double> textFormatter;

    private DecimalFormat decimalFormat;

    public EditingCellFullBackSplashDouble(String...styleClass){
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
public class EditingCellTable3Double extends TableCell<FourInchBacksplashDetails, Double> {
    private TextField textField;
    private TextFormatter<Double> textFormatter;

    private DecimalFormat decimalFormat;

    public EditingCellTable3Double(String...styleClass){
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
public class EditingCellEdgingDouble extends TableCell<EdgingDetails, Double> {
    private TextField textField;
    private TextFormatter<Double> textFormatter;

    private DecimalFormat decimalFormat;

    public EditingCellEdgingDouble(String...styleClass){
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
public class EditingCellTable3 extends TableCell<FourInchBacksplashDetails, String> {
    private TextField textField;

    public EditingCellTable3(){
    }
    @Override
    public void startEdit(){
        super.startEdit();

        if (textField == null){createTextField();}
        setGraphic(textField);
        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        textField.selectAll();
    }
    @Override
    public void cancelEdit() {
        super.cancelEdit();

        setText(String.valueOf(getItem()));
        setContentDisplay(ContentDisplay.TEXT_ONLY);
    }
    @Override
    public void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setText(null);
            setGraphic(textField);
        } else {
            if (isEditing()) {
                if (textField != null) {
                    textField.setText(getString());
                }
                setGraphic(textField);
                setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            } else {
                setText(getString());
                setContentDisplay(ContentDisplay.TEXT_ONLY);
            }
        }
    }
    private void createTextField(){
        textField = new TextField(getString());
        textField.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
        textField.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ENTER){
                commitEdit(textField.getText());
            }else if(event.getCode() == KeyCode.ESCAPE){
                cancelEdit();
            }
        });

        /** textField.getOnKeyPressed(t -> {
         if (t.getCode() == KeyCode.ENTER){
         commitEdit(textField.getText());
         }else if(t.getCode() == KeyCode.ESCAPE){
         cancelEdit();
         }
         });
         */
    }
    private String getString(){
        return getItem() == null ? "" : getItem();
    }


}
public class EditingCellFullBackSplash extends TableCell<FullBacksplashDetails, String> {
    private TextField textField;

    public EditingCellFullBackSplash(){
    }
    @Override
    public void startEdit(){
        super.startEdit();

        if (textField == null){createTextField();}
        setGraphic(textField);
        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        textField.selectAll();
    }
    @Override
    public void cancelEdit() {
        super.cancelEdit();

        setText(String.valueOf(getItem()));
        setContentDisplay(ContentDisplay.TEXT_ONLY);
    }
    @Override
    public void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setText(null);
            setGraphic(textField);
        } else {
            if (isEditing()) {
                if (textField != null) {
                    textField.setText(getString());
                }
                setGraphic(textField);
                setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            } else {
                setText(getString());
                setContentDisplay(ContentDisplay.TEXT_ONLY);
            }
        }
    }
    private void createTextField(){
        textField = new TextField(getString());
        textField.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
        textField.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ENTER){
                commitEdit(textField.getText());
            }else if(event.getCode() == KeyCode.ESCAPE){
                cancelEdit();
            }
        });

        /** textField.getOnKeyPressed(t -> {
         if (t.getCode() == KeyCode.ENTER){
         commitEdit(textField.getText());
         }else if(t.getCode() == KeyCode.ESCAPE){
         cancelEdit();
         }
         });
         */
    }
    private String getString(){
        return getItem() == null ? "" : getItem();
    }


}
public class EditingCellFourInchBSEdgingDouble extends TableCell<FourInchBacksplashEdging, Double> {
    private TextField textField;
    private TextFormatter<Double> textFormatter;

    private DecimalFormat decimalFormat;

    public EditingCellFourInchBSEdgingDouble(String...styleClass){
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

public class EditingCellFullBSEdgingDouble extends TableCell<FullBacksplashEdgingDetails, Double> {
    private TextField textField;
    private TextFormatter<Double> textFormatter;

    private DecimalFormat decimalFormat;

    public EditingCellFullBSEdgingDouble(String...styleClass){
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
public class EditingCellDouble extends TableCell<CountertopDetails, Double> {
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

	}


