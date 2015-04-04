package models;

import observerInterfaces.Subject;
import data.PassengerGroupData;
import data.TaxiData;

public class MasterModel extends Subject {
	private TaxisListModel taxis;
	private PassengerGroupListModel passengerGroupList;
	
	public MasterModel() {
		taxis = new TaxisListModel();
		taxis.setTaxis(TaxiData.getInstance().getTaxiData());
		
		passengerGroupList = new PassengerGroupListModel();
		passengerGroupList.setPassengerGroups(PassengerGroupData.getInstance().getPassengerGroupData());
	}
	
	public TaxisListModel getTaxis() {
		return taxis;
	}
	
	public PassengerGroupListModel getPassengerGroups() {
		return passengerGroupList;
	}
}
