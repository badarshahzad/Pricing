package com.granitetransformations.Pricing.Model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EdgingDetails {
	private IntegerProperty id;
	private DoubleProperty length;
	private BooleanProperty checkBoxBevel;
	private BooleanProperty checkBoxPolished;
	private StringProperty color;
	private BooleanProperty include;
	private IntegerProperty orderId;
	private IntegerProperty customerId;
	private IntegerProperty employeeId;
	private IntegerProperty salesPersonId;
	
	public EdgingDetails(){
		this(0, 0, true, false, "", false, 0, 0, 0, 0);
		
	}
	public EdgingDetails(int order, int customer, int employee){
		this(0, 0, true, false, "", false, order, customer, employee, 0);
		
	}
	public EdgingDetails(int id, double length,boolean checkBoxBevel,  boolean checkBoxPolished, String color,
			boolean include, int orderId, int customerId, int employeeId, int salesPersonid) {
		this.id = new SimpleIntegerProperty(id);
		this.length = new SimpleDoubleProperty(length);
		this.checkBoxBevel = new SimpleBooleanProperty(checkBoxBevel);
		this.checkBoxPolished  = new SimpleBooleanProperty(checkBoxPolished);
		this.color = new SimpleStringProperty(color);
		this.include = new SimpleBooleanProperty(include);
		this.orderId = new SimpleIntegerProperty(orderId);
		this.customerId = new SimpleIntegerProperty(customerId);
		this.employeeId = new SimpleIntegerProperty(employeeId);
		this.salesPersonId = new SimpleIntegerProperty(salesPersonid);
		
	}
	
	public final DoubleProperty lengthProperty() {
		return this.length;
	}
	
	public final double getLength() {
		return this.lengthProperty().get();
	}
	
	public final void setLength(final double length) {
		this.lengthProperty().set(length);
	}
	
	public final BooleanProperty checkBoxBevelProperty() {
		return this.checkBoxBevel;
	}
	
	public final boolean isCheckBoxBevel() {
		return this.checkBoxBevelProperty().get();
	}
	
	public final void setCheckBoxBevel(final boolean checkBoxBevel) {
		this.checkBoxBevelProperty().set(checkBoxBevel);
	}
	
	public final BooleanProperty checkBoxPolishedProperty() {
		return this.checkBoxPolished;
	}
	
	public final boolean isCheckBoxPolished() {
		return this.checkBoxPolishedProperty().get();
	}
	
	public final void setCheckBoxPolished(final boolean checkBoxPolished) {
		this.checkBoxPolishedProperty().set(checkBoxPolished);
	}
	
	public final StringProperty colorProperty() {
		return this.color;
	}
	
	public final java.lang.String getColor() {
		return this.colorProperty().get();
	}
	
	public final void setColor(final java.lang.String color) {
		this.colorProperty().set(color);
	}
	
	public final BooleanProperty includeProperty() {
		return this.include;
	}
	
	public final boolean isInclude() {
		return this.includeProperty().get();
	}
	
	public final void setInclude(final boolean include) {
		this.includeProperty().set(include);
	}
	
	public final IntegerProperty orderIdProperty() {
		return this.orderId;
	}
	
	public final int getOrderId() {
		return this.orderIdProperty().get();
	}
	
	public final void setOrderId(final int orderId) {
		this.orderIdProperty().set(orderId);
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

	public final IntegerProperty idProperty() {
		return this.id;
	}
	
	public final int getId() {
		return this.idProperty().get();
	}
	
	public final void setId(final int id) {
		this.idProperty().set(id);
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
	@Override
	public String toString() {
		return "EdgingDetails [id=" + id + ", length=" + length + ", checkBoxBevel=" + checkBoxBevel
				+ ", checkBoxPolished=" + checkBoxPolished + ", color=" + color + ", include=" + include + ", orderId="
				+ orderId + ", customerId=" + customerId + ", employeeId=" + employeeId + ", salesPersonId="
				+ salesPersonId + "]";
	}
	



	

	
	
	
	

}
