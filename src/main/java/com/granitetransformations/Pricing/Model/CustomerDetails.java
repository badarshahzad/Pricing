package com.granitetransformations.Pricing.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CustomerDetails {
	private StringProperty name;
	private StringProperty surname;
	private StringProperty street;
	private StringProperty city;
	private StringProperty state;
	private StringProperty zipCode;
	private StringProperty phone;
	private StringProperty email;
	private IntegerProperty employeeId;
	private IntegerProperty customerId;
	private IntegerProperty salesPersonId;
	public CustomerDetails(String name, String surname, String street, String city,
			String state, String zipCode, String phone, String email, int employeeId, int customerId,
			int salesPersonId)  {
		this.name = new SimpleStringProperty(name);
		this.surname = new SimpleStringProperty(surname);
		this.street = new SimpleStringProperty(street);
		this.city = new SimpleStringProperty(city);
		this.state = new SimpleStringProperty(state);
		this.zipCode = new SimpleStringProperty(zipCode);
		this.phone = new SimpleStringProperty(phone);
		this.email = new SimpleStringProperty(email);
		this.employeeId = new SimpleIntegerProperty(employeeId);
		this.customerId = new SimpleIntegerProperty(customerId);
		this.salesPersonId = new SimpleIntegerProperty(salesPersonId);
	}
	public CustomerDetails() {
		this("", "", "", "", "","","","", 0, 0, 0);
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
	
	@Override
	public String toString() {
		return "CustomerDetails [name=" + name + ", surname=" + surname + ", street=" + street + ", city=" + city
				+ ", state=" + state + ", zipCode=" + zipCode + ", phone=" + phone + ", email=" + email
				+ ", employeeId=" + employeeId + ", customerId=" + customerId + ", salesPersonId=" + salesPersonId
				+ "]";
	}
	public final IntegerProperty customerIdProperty() {
		return this.customerId;
	}
	
	public final int getCustomerId() {
		return this.customerIdProperty().get();
	}
	
	public final void setCustomerId(final int customerId) {
		this.customerIdProperty().set(customerId);
	}
	public final IntegerProperty salesPersonIdProperty() {
		return this.salesPersonId;
	}
	
	public final int getSalesPersonId() {
		return this.salesPersonIdProperty().get();
	}
	
	public final void setSalesPersonId(final int salesPersonId) {
		this.salesPersonIdProperty().set(salesPersonId);
	}
	public final IntegerProperty employeeIdProperty() {
		return this.employeeId;
	}
	
	public final int getEmployeeId() {
		return this.employeeIdProperty().get();
	}
	
	public final void setEmployeeId(final int employeeId) {
		this.employeeIdProperty().set(employeeId);
	}
	
	
	
	
	
	
}
