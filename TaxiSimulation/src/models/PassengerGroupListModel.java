package models;

import java.util.List;

public class PassengerGroupListModel {
	private List<PassengerGroupModel> passengerGroups;
	
	public List<PassengerGroupModel> getPassengerGroups() {
		return passengerGroups;
	}
	
	public void setPassengerGroups(List<PassengerGroupModel> passengerGroups) {
		this.passengerGroups = passengerGroups;
	}
	
	public String displayPassengerGroupListInfo() {
		String s = "";
		
		for(PassengerGroupModel passengerGroup : this.getPassengerGroups()) {
			s += passengerGroup.displayPassengerGroupInfo();
		}
		
		return s;
	}
}
