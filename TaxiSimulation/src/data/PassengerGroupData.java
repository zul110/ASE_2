package data;

import java.util.ArrayList;

import models.PassengerGroupModel;

public class PassengerGroupData {
	public static PassengerGroupData instance = new PassengerGroupData();
	
	private ArrayList<PassengerGroupModel> passengerGroups;
	
	private PassengerGroupData() {
		passengerGroups = new ArrayList<PassengerGroupModel>();
	}
	
	public static PassengerGroupData getInstance() {
		return instance;
	}
	
	public ArrayList<PassengerGroupModel> getPassengerGroupData() {
		passengerGroups.add(new PassengerGroupModel(1, "Zuerich,Kreis 11"));
		passengerGroups.add(new PassengerGroupModel(1, "Zuerich,Wollishofen"));
		passengerGroups.add(new PassengerGroupModel(1, "Zuerich,Wallisellen"));
		passengerGroups.add(new PassengerGroupModel(1, "Zuerich,Mattenbach"));
		passengerGroups.add(new PassengerGroupModel(1, "Geneva,LeJetdEau"));
		
		return passengerGroups;
	}
}
