package com.granitetransformations.Pricing.Model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MosaicBacksplashDetails {

	private IntegerProperty mosaicId;
	private StringProperty piece;
	private DoubleProperty length;
	private DoubleProperty width;
	private BooleanProperty include;
	private IntegerProperty orderId;
	private IntegerProperty employeeId;
	private IntegerProperty customerId;
	private IntegerProperty salesPersonId;
	
	public MosaicBacksplashDetails(int mosaicId, String piece, double length,
			double width, boolean include, int orderId, int employeeId, int customerId,
			int salesPersonId) {
		this.mosaicId = new SimpleIntegerProperty(mosaicId);
		this.piece = new SimpleStringProperty(piece);
		this.length = new SimpleDoubleProperty(length);
		this.width = new SimpleDoubleProperty(width);
		this.include = new SimpleBooleanProperty(include);
		this.orderId = new SimpleIntegerProperty(orderId);
		this.employeeId = new SimpleIntegerProperty(employeeId);
		this.customerId = new SimpleIntegerProperty(customerId);
		this.salesPersonId = new SimpleIntegerProperty(salesPersonId);
	}

	public MosaicBacksplashDetails() {
		this(0,"",0,0,false,0,0,0,0);
	}

	public final IntegerProperty mosaicIdProperty() {
		return this.mosaicId;
	}
	

	public final int getMosaicId() {
		return this.mosaicIdProperty().get();
	}
	

	public final void setMosaicId(final int mosaicId) {
		this.mosaicIdProperty().set(mosaicId);
	}
	

	public final StringProperty pieceProperty() {
		return this.piece;
	}
	

	public final java.lang.String getPiece() {
		return this.pieceProperty().get();
	}
	

	public final void setPiece(final java.lang.String piece) {
		this.pieceProperty().set(piece);
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
	

	public final DoubleProperty widthProperty() {
		return this.width;
	}
	

	public final double getWidth() {
		return this.widthProperty().get();
	}
	

	public final void setWidth(final double width) {
		this.widthProperty().set(width);
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
	

	public final IntegerProperty employeeIdProperty() {
		return this.employeeId;
	}
	

	public final int getEmployeeId() {
		return this.employeeIdProperty().get();
	}
	

	public final void setEmployeeId(final int employeeId) {
		this.employeeIdProperty().set(employeeId);
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

	public final IntegerProperty customerIdProperty() {
		return this.customerId;
	}
	

	public final int getCustomerId() {
		return this.customerIdProperty().get();
	}
	

	public final void setCustomerId(final int customerId) {
		this.customerIdProperty().set(customerId);
	}
	
	
	
	
	
}
