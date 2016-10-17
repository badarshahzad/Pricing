package com.granitetransformations.Pricing.Model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
public class FullBacksplashDetails {
	private IntegerProperty id;
	private StringProperty piece;
	private DoubleProperty width;
	private DoubleProperty length;
	private StringProperty color;
	private BooleanProperty include;
	private BooleanProperty Trendstone;
	private BooleanProperty mosaic;
	private IntegerProperty orderId;
	private IntegerProperty customerId;
	private IntegerProperty employeeId;
	private IntegerProperty salesPersonId;
	public FullBacksplashDetails(){
		this(0, "A", 25.00, 0.00, "", false, false, false, 0, 0, 0, 0);
	}
	public FullBacksplashDetails(int order, int customer, int employee){
		this(0, "A", 25.00, 0.00, "", false, false, false, order, customer, employee, 0);
	}
	public FullBacksplashDetails(int id, String piece, double width, double length, String color, boolean include,
			boolean Trendstone, boolean mosaic, int orderId, int customerId, int employeeId, int salesPersonId) {
			this.id = new SimpleIntegerProperty(id);
		 	this.piece = new SimpleStringProperty(piece);
	        this.width = new SimpleDoubleProperty(width);
	        this.length = new SimpleDoubleProperty(length);
			this.color = new SimpleStringProperty(color);
			this.include = new SimpleBooleanProperty(include);
			this.Trendstone = new SimpleBooleanProperty(Trendstone);
			this.mosaic = new SimpleBooleanProperty(mosaic);
			this.orderId = new SimpleIntegerProperty(orderId);
			this.customerId = new SimpleIntegerProperty(customerId);
			this.employeeId = new SimpleIntegerProperty(employeeId);
			this.salesPersonId = new SimpleIntegerProperty(salesPersonId);
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
	
	public final DoubleProperty widthProperty() {
		return this.width;
	}
	
	public final double getWidth() {
		return this.widthProperty().get();
	}
	
	public final void setWidth(final double width) {
		this.widthProperty().set(width);
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
	public final IntegerProperty idProperty() {
		return this.id;
	}
	
	public final int getId() {
		return this.idProperty().get();
	}
	
	public final void setId(final int id) {
		this.idProperty().set(id);
	}
	public final BooleanProperty TrendstoneProperty() {
		return this.Trendstone;
	}
	
	public final boolean isTrendstone() {
		return this.TrendstoneProperty().get();
	}
	
	public final void setTrendstone(final boolean Trendstone) {
		this.TrendstoneProperty().set(Trendstone);
	}
	
	public final BooleanProperty mosaicProperty() {
		return this.mosaic;
	}
	
	public final boolean isMosaic() {
		return this.mosaicProperty().get();
	}
	
	public final void setMosaic(final boolean mosaic) {
		this.mosaicProperty().set(mosaic);
	}
	@Override
	public String toString() {
		return "FullBacksplashDetails [id=" + id + ", piece=" + piece + ", width=" + width + ", length=" + length
				+ ", color=" + color + ", include=" + include + ", Trendstone=" + Trendstone + ", mosaic=" + mosaic
				+ ", orderId=" + orderId + ", customerId=" + customerId + ", employeeId=" + employeeId
				+ ", salesPersonId=" + salesPersonId + "]";
	}
	
	

	
}
