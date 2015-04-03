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
	
	/**
	 * Gets the next available passenger group (index 0) in the collection
	 * @return Returns the first PassengerGroup if a group is available, null if the collection is empty
	 */
	public PassengerGroupModel getNextPassengerGroup() {
		if(!passengerGroups.isEmpty()) {
			return passengerGroups.get(0);
		}
		
		return null;
	}
	
	public void removePassengerGroup(PassengerGroupModel passengerGroup) {
		if(passengerGroups.contains(passengerGroup)) {
			passengerGroups.remove(passengerGroup);
		}
	}
	
	public int availablePassengerGroupCount() {
		if(!passengerGroups.isEmpty()) {
			return passengerGroups.size();
		}
		
		return 0;
	}
	
	@Override
	public String toString() {
		String s = "";
		
		for(PassengerGroupModel passengerGroup : passengerGroups) {
			s += passengerGroup.toString() + "\n";
		}
		
		return s;
	}
	
	public String displayPassengerGroupListInfo() {
		String s = "";
		
		for(PassengerGroupModel passengerGroup : this.getPassengerGroups()) {
			s += passengerGroup.displayPassengerGroupInfo();
		}
		
		return s;
	}
}
