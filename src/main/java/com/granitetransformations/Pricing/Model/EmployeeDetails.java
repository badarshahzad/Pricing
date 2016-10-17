package com.granitetransformations.Pricing.Model;
/**
 * This class is used to populate the table with sql data.
 */
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EmployeeDetails {
	private StringProperty name;
	private StringProperty surname;
	private StringProperty street;
	private StringProperty city;
	private StringProperty state;
	private StringProperty zipCode;
	private StringProperty phone;
	private StringProperty email;
	
	
	
	
	public EmployeeDetails(String name, String surname, String street, String city,
			String state, String zipCode, String phone, String email) {
		this.name = new SimpleStringProperty(name);
		this.surname = new SimpleStringProperty(surname);
		this.street = new SimpleStringProperty(street);
		this.city = new SimpleStringProperty(city);
		this.state = new SimpleStringProperty(state);
		this.zipCode = new SimpleStringProperty(zipCode);
		this.phone = new SimpleStringProperty(phone);
		this.email = new SimpleStringProperty(email);
		
	}

	public final StringProperty nameProperty() {
		return this.name;
	}
	
	public final java.lang.String getName() {
		return this.nameProperty().get();
	}
	
	public final void setName(final java.lang.String name) {
		this.nameProperty().set(name);
	}
	
	public final StringProperty surnameProperty() {
		return this.surname;
	}
	
	public final java.lang.String getSurname() {
		return this.surnameProperty().get();
	}
	
	public final void setSurname(final java.lang.String surname) {
		this.surnameProperty().set(surname);
	}
	
	public final StringProperty streetProperty() {
		return this.street;
	}
	
	public final java.lang.String getStreet() {
		return this.streetProperty().get();
	}
	
	public final void setStreet(final java.lang.String street) {
		this.streetProperty().set(street);
	}
	
	public final StringProperty cityProperty() {
		return this.city;
	}
	
	public final java.lang.String getCity() {
		return this.cityProperty().get();
	}
	
	public final void setCity(final java.lang.String city) {
		this.cityProperty().set(city);
	}
	
	public final StringProperty stateProperty() {
		return this.state;
	}
	
	public final java.lang.String getState() {
		return this.stateProperty().get();
	}
	
	public final void setState(final java.lang.String state) {
		this.stateProperty().set(state);
	}
	
	public final StringProperty zipCodeProperty() {
		return this.zipCode;
	}
	
	public final java.lang.String getZipCode() {
		return this.zipCodeProperty().get();
	}
	
	public final void setZipCode(final java.lang.String zipCode) {
		this.zipCodeProperty().set(zipCode);
	}
	
	public final StringProperty phoneProperty() {
		return this.phone;
	}
	
	public final java.lang.String getPhone() {
		return this.phoneProperty().get();
	}
	
	public final void setPhone(final java.lang.String phone) {
		this.phoneProperty().set(phone);
	}
	
	public final StringProperty emailProperty() {
		return this.email;
	}
	
	public final java.lang.String getEmail() {
		return this.emailProperty().get();
	}
	
	public final void setEmail(final java.lang.String email) {
		this.emailProperty().set(email);
	}
	
	


	
	
	
	
}
