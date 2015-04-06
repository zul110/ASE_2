/**
 * Advanced Software Engineering - Stage 2 of Taxi Simulation
 * @author Sreesha Damodaran, Vidhya Krishna, Zulqarnain Mehdi
 * This class describe methods for PassengerGroupData
 */
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
		passengerGroups.add(new PassengerGroupModel(5, "Zuerich,Wollishofen"));
		passengerGroups.add(new PassengerGroupModel(3, "Zuerich,Wallisellen"));
		passengerGroups.add(new PassengerGroupModel(4, "Zuerich,Mattenbach"));
		passengerGroups.add(new PassengerGroupModel(2, "Geneva,LeJetdEau"));
		passengerGroups.add(new PassengerGroupModel(3, "Genevaaaa,LeJetdEau"));
		passengerGroups.add(new PassengerGroupModel(5, "Genevabbb,LeJetdEau"));
		
		return passengerGroups;
	}
}
