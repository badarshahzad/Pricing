package com.granitetransformations.Pricing.Model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Opts1 {
	private IntegerProperty id;
	private BooleanProperty prepBoard; 						private DoubleProperty prepBoardM;
	private BooleanProperty removeExistingBacksplash; 		private DoubleProperty removeExistingBacksplashM;
	private BooleanProperty removeCTLaminate;				private DoubleProperty removeCTLaminateM;
	private BooleanProperty removeCTTile;					private DoubleProperty removeCTTileM;
	private BooleanProperty installNewCt;					private DoubleProperty installNewCtM;
	private BooleanProperty ironBarless36in6;				private DoubleProperty ironbarless36in6M;
	private BooleanProperty ironBarmore36in7;				private DoubleProperty ironBarmore36in7M;
	private BooleanProperty bendTrendStoneApron;			private DoubleProperty bendTrendStoneApronM;
	private BooleanProperty clippedCorners;					private DoubleProperty clippedCornersM;
	private BooleanProperty other1;							private DoubleProperty other1M;
	private BooleanProperty other2;							private DoubleProperty  other2M;
	private BooleanProperty filler;							private DoubleProperty fillerM;
	private BooleanProperty other3;							private DoubleProperty other3M;
	private BooleanProperty other4;							private DoubleProperty other4M;
	private BooleanProperty rsg;							private DoubleProperty rsgM;
	private BooleanProperty strainer;						private DoubleProperty strainerM;
	private BooleanProperty sinkRemoval;					private DoubleProperty sinkRemovalM;
	private BooleanProperty cooktopRemoveReinstall;			private DoubleProperty cooktopRemoveReinstallM;
	
	private DoubleProperty plumbing;
	private DoubleProperty sinksAcc;
	private DoubleProperty switchPlates;
	
	private DoubleProperty toeKick;
	private IntegerProperty orderId;
	private IntegerProperty employeeId;
	private IntegerProperty customerId;
	private IntegerProperty salesPersonId;
	
	
	public Opts1(){
		this(0, true, 0.00, false, 0.00, false, 0, false, 0, false, 0.00, false, 0, false, 0, false, 0, 
				false, 0, false, 0, false, 0, false, 0, false, 0, false, 0, false, 0, false, 0, false, 0, false, 0, 0, 0.00, 0.00, 0.00, 0, 0, 0, 0);
	}
	public Opts1(int id, boolean prepBoard, double prepBoardM, boolean removeExistingBacksplash, double removeExistingBacksplashM,
				boolean removeCTLaminate, double removeCTLaminateM, boolean removeCTTile, double removeCTTileM, boolean installNewCt, double installNewCtM, boolean ironBarless36in6,
				double ironBarless36in6M, boolean ironBarmore36in7, double ironBarmore36in7M, boolean bendTrendStoneApron, double bendTrendStoneApronM, 
				boolean clippedCorners, double clippedCornersM, boolean other1, double other1M, boolean other2, double other2M, boolean filler, double fillerM, boolean other3, double other3M,
				boolean other4, double other4M, boolean rsg, double rsgM, boolean strainer, double strainerM, boolean sinkRemoval, double sinkRemovalM, boolean cooktopRemoveReinstall, double cooktopRemoveReinstallM,
				double plumbing, double sinksAcc, double switchPlates, double toeKick, int orderId, int employeeId, int customerId, int salesPersonId)
			 {
		this.id = new SimpleIntegerProperty(id);
		this.prepBoard = new SimpleBooleanProperty(prepBoard);
		this.prepBoardM = new SimpleDoubleProperty(prepBoardM);
		this.removeExistingBacksplash = new SimpleBooleanProperty(removeExistingBacksplash);
		this.removeExistingBacksplashM = new SimpleDoubleProperty(removeExistingBacksplashM);
		this.removeCTLaminate = new SimpleBooleanProperty(removeCTLaminate);
		this.removeCTLaminateM = new SimpleDoubleProperty(removeCTLaminateM);
		this.removeCTTile = new SimpleBooleanProperty(removeCTTile);
		this.removeCTTileM = new SimpleDoubleProperty(removeCTTileM);
		this.installNewCt = new SimpleBooleanProperty(installNewCt);
		this.installNewCtM = new SimpleDoubleProperty(installNewCtM);
		this.ironBarless36in6 = new SimpleBooleanProperty(ironBarless36in6);
		this.ironbarless36in6M = new SimpleDoubleProperty(ironBarless36in6M);
		this.ironBarmore36in7 = new SimpleBooleanProperty(ironBarmore36in7);
		this.ironBarmore36in7M = new SimpleDoubleProperty(ironBarmore36in7M);
		this.bendTrendStoneApron = new SimpleBooleanProperty(bendTrendStoneApron);
		this.bendTrendStoneApronM = new SimpleDoubleProperty(bendTrendStoneApronM);
		this.clippedCorners = new SimpleBooleanProperty(clippedCorners);
		this.clippedCornersM = new SimpleDoubleProperty(clippedCornersM);
		this.other1 = new SimpleBooleanProperty(other1);
		this.other1M = new SimpleDoubleProperty(other1M);
		this.other2 = new SimpleBooleanProperty(other2);
		this.other2M = new SimpleDoubleProperty(other2M);
		this.filler = new SimpleBooleanProperty(filler);
		this.fillerM = new SimpleDoubleProperty(fillerM);
		this.other3 = new SimpleBooleanProperty(other3);
		this.other3M = new SimpleDoubleProperty(other3M);
		this.other4 = new SimpleBooleanProperty(other4);
		this.other4M = new SimpleDoubleProperty(other4M);
		this.rsg = new SimpleBooleanProperty(rsg);
		this.rsgM = new SimpleDoubleProperty(rsgM);
		this.strainer = new SimpleBooleanProperty(strainer);
		this.strainerM = new SimpleDoubleProperty(strainerM);
		this.sinkRemoval = new SimpleBooleanProperty(sinkRemoval);
		this.sinkRemovalM = new SimpleDoubleProperty(sinkRemovalM);
		this.cooktopRemoveReinstall = new SimpleBooleanProperty(cooktopRemoveReinstall);
		this.cooktopRemoveReinstallM = new SimpleDoubleProperty(cooktopRemoveReinstallM);
		this.plumbing = new SimpleDoubleProperty(plumbing);
		this.sinksAcc = new SimpleDoubleProperty(sinksAcc);
		this.switchPlates = new SimpleDoubleProperty(switchPlates);
		this.toeKick = new SimpleDoubleProperty(toeKick);
		this.orderId = new SimpleIntegerProperty(orderId);
		this.employeeId = new SimpleIntegerProperty(employeeId);
		this.customerId = new SimpleIntegerProperty(customerId);
		this.salesPersonId = new SimpleIntegerProperty(salesPersonId);
		
	}
	
	public final BooleanProperty prepBoardProperty() {
		return this.prepBoard;
	}
	
	public final boolean isPrepBoard() {
		return this.prepBoardProperty().get();
	}
	
	public final void setPrepBoard(final boolean prepBoard) {
		this.prepBoardProperty().set(prepBoard);
	}
	
	public final DoubleProperty prepBoardMProperty() {
		return this.prepBoardM;
	}
	
	public final double getPrepBoardM() {
		return this.prepBoardMProperty().get();
	}
	
	public final void setPrepBoardM(final double prepBoardM) {
		this.prepBoardMProperty().set(prepBoardM);
	}
	public final BooleanProperty removeExistingBacksplashProperty() {
		return this.removeExistingBacksplash;
	}
	
	public final boolean isRemoveExistingBacksplash() {
		return this.removeExistingBacksplashProperty().get();
	}
	
	public final void setRemoveExistingBacksplash(final boolean removeExistingBacksplash) {
		this.removeExistingBacksplashProperty().set(removeExistingBacksplash);
	}
	
	public final DoubleProperty removeExistingBacksplashMProperty() {
		return this.removeExistingBacksplashM;
	}
	
	public final double getRemoveExistingBacksplashM() {
		return this.removeExistingBacksplashMProperty().get();
	}
	
	public final void setRemoveExistingBacksplashM(final double removeExistingBacksplashM) {
		this.removeExistingBacksplashMProperty().set(removeExistingBacksplashM);
	}
	public final BooleanProperty removeCTLaminateProperty() {
		return this.removeCTLaminate;
	}
	
	public final boolean isRemoveCTLaminate() {
		return this.removeCTLaminateProperty().get();
	}
	
	public final void setRemoveCTLaminate(final boolean removeCTLaminate) {
		this.removeCTLaminateProperty().set(removeCTLaminate);
	}
	
	public final BooleanProperty removeCTTileProperty() {
		return this.removeCTTile;
	}
	
	public final boolean isRemoveCTTile() {
		return this.removeCTTileProperty().get();
	}
	
	public final void setRemoveCTTile(final boolean removeCTTile) {
		this.removeCTTileProperty().set(removeCTTile);
	}
	public final BooleanProperty installNewCtProperty() {
		return this.installNewCt;
	}
	
	public final boolean isInstallNewCt() {
		return this.installNewCtProperty().get();
	}
	
	public final void setInstallNewCt(final boolean installNewCt) {
		this.installNewCtProperty().set(installNewCt);
	}
	
	public final DoubleProperty installNewCtMProperty() {
		return this.installNewCtM;
	}
	
	public final double getInstallNewCtM() {
		return this.installNewCtMProperty().get();
	}
	
	public final void setInstallNewCtM(final double installNewCtM) {
		this.installNewCtMProperty().set(installNewCtM);
	}
	
	public final BooleanProperty ironBarless36in6Property() {
		return this.ironBarless36in6;
	}
	
	public final boolean isIronBarless36in6() {
		return this.ironBarless36in6Property().get();
	}
	
	public final void setIronBarless36in6(final boolean ironBarless36in6) {
		this.ironBarless36in6Property().set(ironBarless36in6);
	}
	
	public final BooleanProperty ironBarmore36in7Property() {
		return this.ironBarmore36in7;
	}
	
	public final boolean isIronBarmore36in7() {
		return this.ironBarmore36in7Property().get();
	}
	
	public final void setIronBarmore36in7(final boolean ironBarmore36in7) {
		this.ironBarmore36in7Property().set(ironBarmore36in7);
	}
	public final BooleanProperty bendTrendStoneApronProperty() {
		return this.bendTrendStoneApron;
	}
	
	public final boolean isBendTrendStoneApron() {
		return this.bendTrendStoneApronProperty().get();
	}
	
	public final void setBendTrendStoneApron(final boolean bendTrendStoneApron) {
		this.bendTrendStoneApronProperty().set(bendTrendStoneApron);
	}
	
	public final DoubleProperty bendTrendStoneApronMProperty() {
		return this.bendTrendStoneApronM;
	}
	
	public final double getBendTrendStoneApronM() {
		return this.bendTrendStoneApronMProperty().get();
	}
	
	public final void setBendTrendStoneApronM(final double bendTrendStoneApronM) {
		this.bendTrendStoneApronMProperty().set(bendTrendStoneApronM);
	}


	

	public final BooleanProperty clippedCornersProperty() {
		return this.clippedCorners;
	}
	
	public final boolean isClippedCorners() {
		return this.clippedCornersProperty().get();
	}
	
	public final void setClippedCorners(final boolean clippedCorners) {
		this.clippedCornersProperty().set(clippedCorners);
	}
	
	public final BooleanProperty other1Property() {
		return this.other1;
	}
	
	public final boolean isOther1() {
		return this.other1Property().get();
	}
	
	public final void setOther1(final boolean other1) {
		this.other1Property().set(other1);
	}
	
	public final BooleanProperty other2Property() {
		return this.other2;
	}
	
	public final boolean isOther2() {
		return this.other2Property().get();
	}
	
	public final void setOther2(final boolean other2) {
		this.other2Property().set(other2);
	}
	
	public final BooleanProperty fillerProperty() {
		return this.filler;
	}
	
	public final boolean isFiller() {
		return this.fillerProperty().get();
	}
	
	public final void setFiller(final boolean filler) {
		this.fillerProperty().set(filler);
	}
	
	public final BooleanProperty other3Property() {
		return this.other3;
	}
	
	public final boolean isOther3() {
		return this.other3Property().get();
	}
	
	public final void setOther3(final boolean other3) {
		this.other3Property().set(other3);
	}
	
	public final BooleanProperty other4Property() {
		return this.other4;
	}
	
	public final boolean isOther4() {
		return this.other4Property().get();
	}
	
	public final void setOther4(final boolean other4) {
		this.other4Property().set(other4);
	}
	public final BooleanProperty rsgProperty() {
		return this.rsg;
	}
	
	public final boolean isRsg() {
		return this.rsgProperty().get();
	}
	
	public final void setRsg(final boolean rsg) {
		this.rsgProperty().set(rsg);
	}
	
	public final BooleanProperty strainerProperty() {
		return this.strainer;
	}
	
	public final boolean isStrainer() {
		return this.strainerProperty().get();
	}
	
	public final void setStrainer(final boolean strainer) {
		this.strainerProperty().set(strainer);
	}
	
	public final BooleanProperty sinkRemovalProperty() {
		return this.sinkRemoval;
	}
	
	public final boolean isSinkRemoval() {
		return this.sinkRemovalProperty().get();
	}
	
	public final void setSinkRemoval(final boolean sinkRemoval) {
		this.sinkRemovalProperty().set(sinkRemoval);
	}
	
	public final BooleanProperty cooktopRemoveReinstallProperty() {
		return this.cooktopRemoveReinstall;
	}
	
	public final boolean isCooktopRemoveReinstall() {
		return this.cooktopRemoveReinstallProperty().get();
	}
	
	public final void setCooktopRemoveReinstall(final boolean cooktopRemoveReinstall) {
		this.cooktopRemoveReinstallProperty().set(cooktopRemoveReinstall);
	}
	public final DoubleProperty plumbingProperty() {
		return this.plumbing;
	}
	
	public final double getPlumbing() {
		return this.plumbingProperty().get();
	}
	
	public final void setPlumbing(final double plumbing) {
		this.plumbingProperty().set(plumbing);
	}
	
	public final DoubleProperty sinksAccProperty() {
		return this.sinksAcc;
	}
	
	public final double getSinksAcc() {
		return this.sinksAccProperty().get();
	}
	
	public final void setSinksAcc(final double sinksAcc) {
		this.sinksAccProperty().set(sinksAcc);
	}
	
	public final DoubleProperty switchPlatesProperty() {
		return this.switchPlates;
	}
	
	public final double getSwitchPlates() {
		return this.switchPlatesProperty().get();
	}
	
	public final void setSwitchPlates(final double switchPlates) {
		this.switchPlatesProperty().set(switchPlates);
	}
	
	public final DoubleProperty toeKickProperty() {
		return this.toeKick;
	}
	
	public final double getToeKick() {
		return this.toeKickProperty().get();
	}
	
	public final void setToeKick(final double toeKick) {
		this.toeKickProperty().set(toeKick);
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

	public final DoubleProperty removeCTLaminateMProperty() {
		return this.removeCTLaminateM;
	}
	
	public final double getRemoveCTLaminateM() {
		return this.removeCTLaminateMProperty().get();
	}
	
	public final void setRemoveCTLaminateM(final double removeCTLaminateM) {
		this.removeCTLaminateMProperty().set(removeCTLaminateM);
	}
	
	public final DoubleProperty removeCTTileMProperty() {
		return this.removeCTTileM;
	}
	
	public final double getRemoveCTTileM() {
		return this.removeCTTileMProperty().get();
	}
	
	public final void setRemoveCTTileM(final double removeCTTileM) {
		this.removeCTTileMProperty().set(removeCTTileM);
	}
	
	public final DoubleProperty ironbarless36in6MProperty() {
		return this.ironbarless36in6M;
	}
	
	public final double getIronbarless36in6M() {
		return this.ironbarless36in6MProperty().get();
	}
	
	public final void setIronbarless36in6M(final double ironbarless36in6M) {
		this.ironbarless36in6MProperty().set(ironbarless36in6M);
	}
	
	public final DoubleProperty ironBarmore36in7MProperty() {
		return this.ironBarmore36in7M;
	}
	
	public final double getIronBarmore36in7M() {
		return this.ironBarmore36in7MProperty().get();
	}
	
	public final void setIronBarmore36in7M(final double ironBarmore36in7M) {
		this.ironBarmore36in7MProperty().set(ironBarmore36in7M);
	}
	
	public final DoubleProperty clippedCornersMProperty() {
		return this.clippedCornersM;
	}
	
	public final double getClippedCornersM() {
		return this.clippedCornersMProperty().get();
	}
	
	public final void setClippedCornersM(final double clippedCornersM) {
		this.clippedCornersMProperty().set(clippedCornersM);
	}
	
	public final DoubleProperty other1MProperty() {
		return this.other1M;
	}
	
	public final double getOther1M() {
		return this.other1MProperty().get();
	}
	
	public final void setOther1M(final double other1M) {
		this.other1MProperty().set(other1M);
	}
	
	public final DoubleProperty other2MProperty() {
		return this.other2M;
	}
	
	public final double getOther2M() {
		return this.other2MProperty().get();
	}
	
	public final void setOther2M(final double other2M) {
		this.other2MProperty().set(other2M);
	}
	
	public final DoubleProperty fillerMProperty() {
		return this.fillerM;
	}
	
	public final double getFillerM() {
		return this.fillerMProperty().get();
	}
	
	public final void setFillerM(final double fillerM) {
		this.fillerMProperty().set(fillerM);
	}
	
	public final DoubleProperty other3MProperty() {
		return this.other3M;
	}
	
	public final double getOther3M() {
		return this.other3MProperty().get();
	}
	
	public final void setOther3M(final double other3M) {
		this.other3MProperty().set(other3M);
	}
	
	public final DoubleProperty other4MProperty() {
		return this.other4M;
	}
	
	public final double getOther4M() {
		return this.other4MProperty().get();
	}
	
	public final void setOther4M(final double other4M) {
		this.other4MProperty().set(other4M);
	}
	
	public final DoubleProperty rsgMProperty() {
		return this.rsgM;
	}
	
	public final double getRsgM() {
		return this.rsgMProperty().get();
	}
	
	public final void setRsgM(final double rsgM) {
		this.rsgMProperty().set(rsgM);
	}
	
	public final DoubleProperty strainerMProperty() {
		return this.strainerM;
	}
	
	public final double getStrainerM() {
		return this.strainerMProperty().get();
	}
	
	public final void setStrainerM(final double strainerM) {
		this.strainerMProperty().set(strainerM);
	}
	
	public final DoubleProperty sinkRemovalMProperty() {
		return this.sinkRemovalM;
	}
	
	public final double getSinkRemovalM() {
		return this.sinkRemovalMProperty().get();
	}
	
	public final void setSinkRemovalM(final double sinkRemovalM) {
		this.sinkRemovalMProperty().set(sinkRemovalM);
	}
	
	public final DoubleProperty cooktopRemoveReinstallMProperty() {
		return this.cooktopRemoveReinstallM;
	}
	
	public final double getCooktopRemoveReinstallM() {
		return this.cooktopRemoveReinstallMProperty().get();
	}
	
	public final void setCooktopRemoveReinstallM(final double cooktopRemoveReinstallM) {
		this.cooktopRemoveReinstallMProperty().set(cooktopRemoveReinstallM);
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
	@Override
	public String toString() {
		return "Opts1 [id=" + id + ", prepBoard=" + prepBoard + ", prepBoardM=" + prepBoardM
				+ ", removeExistingBacksplash=" + removeExistingBacksplash + ", removeExistingBacksplashM="
				+ removeExistingBacksplashM + ", removeCTLaminate=" + removeCTLaminate + ", removeCTLaminateM="
				+ removeCTLaminateM + ", removeCTTile=" + removeCTTile + ", removeCTTileM=" + removeCTTileM
				+ ", installNewCt=" + installNewCt + ", installNewCtM=" + installNewCtM + ", ironBarless36in6="
				+ ironBarless36in6 + ", ironbarless36in6M=" + ironbarless36in6M + ", ironBarmore36in7="
				+ ironBarmore36in7 + ", ironBarmore36in7M=" + ironBarmore36in7M + ", bendTrendStoneApron="
				+ bendTrendStoneApron + ", bendTrendStoneApronM=" + bendTrendStoneApronM + ", clippedCorners="
				+ clippedCorners + ", clippedCornersM=" + clippedCornersM + ", other1=" + other1 + ", other1M="
				+ other1M + ", other2=" + other2 + ", other2M=" + other2M + ", filler=" + filler + ", fillerM="
				+ fillerM + ", other3=" + other3 + ", other3M=" + other3M + ", other4=" + other4 + ", other4M="
				+ other4M + ", rsg=" + rsg + ", rsgM=" + rsgM + ", strainer=" + strainer + ", strainerM=" + strainerM
				+ ", sinkRemoval=" + sinkRemoval + ", sinkRemovalM=" + sinkRemovalM + ", cooktopRemoveReinstall="
				+ cooktopRemoveReinstall + ", cooktopRemoveReinstallM=" + cooktopRemoveReinstallM + ", plumbing="
				+ plumbing + ", sinksAcc=" + sinksAcc + ", switchPlates=" + switchPlates + ", toeKick=" + toeKick
				+ ", orderId=" + orderId + ", employeeId=" + employeeId + ", customerId=" + customerId
				+ ", salesPersonId=" + salesPersonId + "]";
	}
	
	
	
	

	
	
}
