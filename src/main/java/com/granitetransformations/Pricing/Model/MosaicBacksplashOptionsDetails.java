package com.granitetransformations.Pricing.Model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class MosaicBacksplashOptionsDetails {
	
	private IntegerProperty mosaicOptionId;
	private DoubleProperty cutOuts;
	private DoubleProperty stripeTrendstoneMosaic7Tiles;
	private DoubleProperty stripeCustomMosaic7Tiles;
	private DoubleProperty inlayDiamond5x5;
	private DoubleProperty inlayDiamond12x12;
	private BooleanProperty include;
	private IntegerProperty orderId;
	private IntegerProperty employeeId;
	private IntegerProperty customerId;
	private IntegerProperty salesPersonId;
	
	public MosaicBacksplashOptionsDetails(int mosaicOptionId, double cutOuts,
			double stripeTrendstoneMosaic7Tiles, double stripeCustomMosaic7Tiles,
			double inlayDiamond5x5, double inlayDiamond12x12, boolean include,
			int orderId, int employeeId, int customerId, int salesPersonId) {
		this.mosaicOptionId = new SimpleIntegerProperty(mosaicOptionId);
		this.cutOuts = new SimpleDoubleProperty(cutOuts);
		this.stripeTrendstoneMosaic7Tiles = new SimpleDoubleProperty(stripeTrendstoneMosaic7Tiles);
		this.stripeCustomMosaic7Tiles =  new SimpleDoubleProperty(stripeCustomMosaic7Tiles);
		this.inlayDiamond5x5 = new SimpleDoubleProperty(inlayDiamond5x5);
		this.inlayDiamond12x12 = new SimpleDoubleProperty(inlayDiamond12x12);
		this.include = new SimpleBooleanProperty(include);
		this.orderId = new SimpleIntegerProperty(orderId);
		this.employeeId = new SimpleIntegerProperty(employeeId);
		this.customerId = new SimpleIntegerProperty(customerId);
		this.salesPersonId = new SimpleIntegerProperty(salesPersonId);
	}
	public MosaicBacksplashOptionsDetails() {
		this(0,0,0,0,0,0,false,0,0,0,0);
	}
	public final IntegerProperty mosaicOptionIdProperty() {
		return this.mosaicOptionId;
	}
	
	public final int getMosaicOptionId() {
		return this.mosaicOptionIdProperty().get();
	}
	
	public final void setMosaicOptionId(final int mosaicOptionId) {
		this.mosaicOptionIdProperty().set(mosaicOptionId);
	}
	
	public final DoubleProperty cutOutsProperty() {
		return this.cutOuts;
	}
	
	public final double getCutOuts() {
		return this.cutOutsProperty().get();
	}
	
	public final void setCutOuts(final double cutOuts) {
		this.cutOutsProperty().set(cutOuts);
	}
	
	public final DoubleProperty stripeTrendstoneMosaic7TilesProperty() {
		return this.stripeTrendstoneMosaic7Tiles;
	}
	
	public final double getStripeTrendstoneMosaic7Tiles() {
		return this.stripeTrendstoneMosaic7TilesProperty().get();
	}
	
	public final void setStripeTrendstoneMosaic7Tiles(final double stripeTrendstoneMosaic7Tiles) {
		this.stripeTrendstoneMosaic7TilesProperty().set(stripeTrendstoneMosaic7Tiles);
	}
	
	public final DoubleProperty stripeCustomMosaic7TilesProperty() {
		return this.stripeCustomMosaic7Tiles;
	}
	
	public final double getStripeCustomMosaic7Tiles() {
		return this.stripeCustomMosaic7TilesProperty().get();
	}
	
	public final void setStripeCustomMosaic7Tiles(final double stripeCustomMosaic7Tiles) {
		this.stripeCustomMosaic7TilesProperty().set(stripeCustomMosaic7Tiles);
	}
	
	public final DoubleProperty inlayDiamond5x5Property() {
		return this.inlayDiamond5x5;
	}
	
	public final double getInlayDiamond5x5() {
		return this.inlayDiamond5x5Property().get();
	}
	
	public final void setInlayDiamond5x5(final double inlayDiamond5x5) {
		this.inlayDiamond5x5Property().set(inlayDiamond5x5);
	}
	
	public final DoubleProperty inlayDiamond12x12Property() {
		return this.inlayDiamond12x12;
	}
	
	public final double getInlayDiamond12x12() {
		return this.inlayDiamond12x12Property().get();
	}
	
	public final void setInlayDiamond12x12(final double inlayDiamond12x12) {
		this.inlayDiamond12x12Property().set(inlayDiamond12x12);
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
