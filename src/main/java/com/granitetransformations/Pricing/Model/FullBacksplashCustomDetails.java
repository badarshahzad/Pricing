package com.granitetransformations.Pricing.Model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class FullBacksplashCustomDetails {
	private IntegerProperty customId;
	private DoubleProperty cutOuts;
	private DoubleProperty stripeTrendstone7Tiles;
	private DoubleProperty stripeCustomMosaic7Tiles;
	private BooleanProperty trendStoneSelection;
	private BooleanProperty mosaicSelection;
	private DoubleProperty inlaysDiamond5x5;
	private DoubleProperty inlaysDiamond12x12;
	private IntegerProperty orderId;
	private IntegerProperty customerId;
	private IntegerProperty employeeId;
	private IntegerProperty salesPersonId;
	
	public FullBacksplashCustomDetails(int customId, double cutOuts, double stripeTrendstone7Tiles,
			double stripeCustomMosaic7Tiles, boolean trendStoneSelection, boolean mosaicSelection, double inlaysDiamond5x5, double inlaysDiamond12x12, int orderId, int customerId, int employeeId, int salesPersonId) {
		this.customId = new SimpleIntegerProperty(customId);
		this.cutOuts = new SimpleDoubleProperty(cutOuts);
		this.stripeTrendstone7Tiles =  new SimpleDoubleProperty(stripeTrendstone7Tiles);
		this.stripeCustomMosaic7Tiles =  new SimpleDoubleProperty(stripeCustomMosaic7Tiles);
		this.trendStoneSelection = new SimpleBooleanProperty(trendStoneSelection);
		this.mosaicSelection = new SimpleBooleanProperty(mosaicSelection);
		this.inlaysDiamond5x5 =  new SimpleDoubleProperty(inlaysDiamond5x5);
		this.inlaysDiamond12x12 =  new SimpleDoubleProperty(inlaysDiamond12x12);
		this.orderId = new SimpleIntegerProperty(orderId);
		this.customerId = new SimpleIntegerProperty(customerId);
		this.employeeId = new SimpleIntegerProperty(employeeId);
		this.salesPersonId = new SimpleIntegerProperty(salesPersonId);
		
	}
		
	
	public FullBacksplashCustomDetails() {
		this(0,0,0,0,false, false, 0,0,0,0,0,0);
		
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
	
	public final DoubleProperty stripeTrendstone7TilesProperty() {
		return this.stripeTrendstone7Tiles;
	}
	
	public final double getStripeTrendstone7Tiles() {
		return this.stripeTrendstone7TilesProperty().get();
	}
	
	public final void setStripeTrendstone7Tiles(final double stripeTrendstone7Tiles) {
		this.stripeTrendstone7TilesProperty().set(stripeTrendstone7Tiles);
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
	
	public final DoubleProperty inlaysDiamond5x5Property() {
		return this.inlaysDiamond5x5;
	}
	
	public final double getInlaysDiamond5x5() {
		return this.inlaysDiamond5x5Property().get();
	}
	
	public final void setInlaysDiamond5x5(final double inlaysDiamond5x5) {
		this.inlaysDiamond5x5Property().set(inlaysDiamond5x5);
	}
	
	public final DoubleProperty inlaysDiamond12x12Property() {
		return this.inlaysDiamond12x12;
	}
	
	public final double getInlaysDiamond12x12() {
		return this.inlaysDiamond12x12Property().get();
	}
	
	public final void setInlaysDiamond12x12(final double inlaysDiamond12x12) {
		this.inlaysDiamond12x12Property().set(inlaysDiamond12x12);
	}
	public final IntegerProperty customIdProperty() {
		return this.customId;
	}
	
	public final int getCustomId() {
		return this.customIdProperty().get();
	}
	
	public final void setCustomId(final int customId) {
		this.customIdProperty().set(customId);
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


	public final BooleanProperty trendStoneSelectionProperty() {
		return this.trendStoneSelection;
	}
	


	public final boolean isTrendStoneSelection() {
		return this.trendStoneSelectionProperty().get();
	}
	


	public final void setTrendStoneSelection(final boolean trendStoneSelection) {
		this.trendStoneSelectionProperty().set(trendStoneSelection);
	}
	


	public final BooleanProperty mosaicSelectionProperty() {
		return this.mosaicSelection;
	}
	


	public final boolean isMosaicSelection() {
		return this.mosaicSelectionProperty().get();
	}
	


	public final void setMosaicSelection(final boolean mosaicSelection) {
		this.mosaicSelectionProperty().set(mosaicSelection);
	}


	@Override
	public String toString() {
		return "FullBacksplashCustomDetails [customId=" + customId + ", cutOuts=" + cutOuts
				+ ", stripeTrendstone7Tiles=" + stripeTrendstone7Tiles + ", stripeCustomMosaic7Tiles="
				+ stripeCustomMosaic7Tiles + ", trendStoneSelection=" + trendStoneSelection + ", mosaicSelection="
				+ mosaicSelection + ", inlaysDiamond5x5=" + inlaysDiamond5x5 + ", inlaysDiamond12x12="
				+ inlaysDiamond12x12 + ", orderId=" + orderId + ", customerId=" + customerId + ", employeeId="
				+ employeeId + ", salesPersonId=" + salesPersonId + "]";
	}
	


	
	
	
	

}
