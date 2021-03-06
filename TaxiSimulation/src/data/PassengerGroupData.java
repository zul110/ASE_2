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
	private int passengerGroupLimit = 5;
	
	private ArrayList<PassengerGroupModel> passengerGroups;
	
	private PassengerGroupData() {
		passengerGroups = new ArrayList<PassengerGroupModel>();
	}
	
	public static PassengerGroupData getInstance() {
		return instance;
	}
	
	public void setPassengerGroupLimit(int passengerGroupLimit) {
		this.passengerGroupLimit = passengerGroupLimit;
	}
	
	public ArrayList<PassengerGroupModel> getPassengerGroupData() {
		if(!passengerGroups.isEmpty()) {
			passengerGroups.clear();
		}
		
		passengerGroups.add(new PassengerGroupModel(2, "Geneva,LeJetdEau"));
		passengerGroups.add(new PassengerGroupModel(5, "Genevaaaa,LeJetdEau"));
		passengerGroups.add(new PassengerGroupModel(5, "Genevabbb,LeJetdEau"));
		passengerGroups.add(new PassengerGroupModel(5, "Zuerich,Kreis 11"));
		passengerGroups.add(new PassengerGroupModel(4, "Zuerich,Wollishofen"));
		passengerGroups.add(new PassengerGroupModel(2, "Zuerich,Wallisellen"));
		passengerGroups.add(new PassengerGroupModel(1, "Zuerich,Mattenbach"));
		passengerGroups.add(new PassengerGroupModel(3, "Geneva,LeJetdEau"));
		passengerGroups.add(new PassengerGroupModel(4, "Genevaaaa,LeJetdEau"));
		passengerGroups.add(new PassengerGroupModel(1, "Genevabbb,LeJetdEau"));
		passengerGroups.add(new PassengerGroupModel(1, "Zuerich,Kreis 11"));
		passengerGroups.add(new PassengerGroupModel(5, "Zuerich,Wollishofen"));
		passengerGroups.add(new PassengerGroupModel(3, "Zuerich,Wallisellen"));
		passengerGroups.add(new PassengerGroupModel(4, "Zuerich,Mattenbach"));
		passengerGroups.add(new PassengerGroupModel(2, "Geneva,LeJetdEau"));
		passengerGroups.add(new PassengerGroupModel(3, "Genevaaaa,LeJetdEau"));
		passengerGroups.add(new PassengerGroupModel(5, "Genevabbb,LeJetdEau"));
		passengerGroups.add(new PassengerGroupModel(1, "Zuerich,Kreis 11"));
		passengerGroups.add(new PassengerGroupModel(5, "Zuerich,Wollishofen"));
		passengerGroups.add(new PassengerGroupModel(3, "Zuerich,Wallisellen"));
		passengerGroups.add(new PassengerGroupModel(4, "Zuerich,Mattenbach"));
		passengerGroups.add(new PassengerGroupModel(2, "Geneva,LeJetdEau"));
		passengerGroups.add(new PassengerGroupModel(3, "Genevaaaa,LeJetdEau"));
		passengerGroups.add(new PassengerGroupModel(5, "Genevabbb,LeJetdEau"));
		passengerGroups.add(new PassengerGroupModel(1, "Zuerich,Kreis 11"));
		passengerGroups.add(new PassengerGroupModel(5, "Zuerich,Wollishofen"));
		passengerGroups.add(new PassengerGroupModel(3, "Zuerich,Wallisellen"));
		passengerGroups.add(new PassengerGroupModel(4, "Zuerich,Mattenbach"));
		passengerGroups.add(new PassengerGroupModel(2, "Geneva,LeJetdEau"));
		passengerGroups.add(new PassengerGroupModel(3, "Genevaaaa,LeJetdEau"));
		passengerGroups.add(new PassengerGroupModel(5, "Genevabbb,LeJetdEau"));
		passengerGroups.add(new PassengerGroupModel(1, "Zuerich,Kreis 11"));
		passengerGroups.add(new PassengerGroupModel(5, "Zuerich,Wollishofen"));
		passengerGroups.add(new PassengerGroupModel(3, "Zuerich,Wallisellen"));
		passengerGroups.add(new PassengerGroupModel(4, "Zuerich,Mattenbach"));
		passengerGroups.add(new PassengerGroupModel(2, "Geneva,LeJetdEau"));
		passengerGroups.add(new PassengerGroupModel(3, "Genevaaaa,LeJetdEau"));
		passengerGroups.add(new PassengerGroupModel(5, "Genevabbb,LeJetdEau"));
		passengerGroups.add(new PassengerGroupModel(4, "Zuerich,Mattenbach"));
		passengerGroups.add(new PassengerGroupModel(2, "Geneva,LeJetdEau"));
		passengerGroups.add(new PassengerGroupModel(3, "Genevaaaa,LeJetdEau"));
		passengerGroups.add(new PassengerGroupModel(5, "Genevabbb,LeJetdEau"));
		passengerGroups.add(new PassengerGroupModel(1, "Zuerich,Kreis 11"));
		passengerGroups.add(new PassengerGroupModel(5, "Zuerich,Wollishofen"));
		passengerGroups.add(new PassengerGroupModel(3, "Zuerich,Wallisellen"));
		
		if(passengerGroupLimit > passengerGroups.size() || passengerGroupLimit < 1) {
			passengerGroupLimit = passengerGroups.size();
		}
		
		return new ArrayList<PassengerGroupModel>(passengerGroups.subList(0, passengerGroupLimit));
	}
}
