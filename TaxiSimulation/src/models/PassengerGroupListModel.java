package models;

import java.util.List;
import java.util.ListIterator;

public class PassengerGroupListModel {
	private ListIterator<PassengerGroupModel> passengerGroups;
	
	public ListIterator<PassengerGroupModel> getPassengerGroups() {
		return passengerGroups;
	}
	
	public void setPassengerGroups(List<PassengerGroupModel> passengerGroups) {
		this.passengerGroups = passengerGroups.listIterator();
	}
	
	/**
	 * Gets the next available passenger group (index 0) in the collection
	 * @return Returns the first PassengerGroup if a group is available, null if the collection is empty
	 */
	public  PassengerGroupModel getNextPassengerGroup() {
		if(passengerGroups.hasNext()) {
			PassengerGroupModel passengerGroup = passengerGroups.next();
			passengerGroups.remove();
			return passengerGroup;
		}
		
		return null;
	}
	
	public  int availablePassengerGroupCount() {
		int count = 0;
		while(passengerGroups.hasNext()) {
			count++;
			
			passengerGroups.next();
		}
		
		resetCursor();
		
		return count;
	}
	
	private void resetCursor() {
		while(passengerGroups.hasPrevious()) {
			passengerGroups.previous();
		}
	}

	@Override
	public String toString() {
		String s = "";
		
		while(passengerGroups.hasNext()) {
			s += passengerGroups.next().toString() + "\n";
		}
		
		resetCursor();
		
		return s;
	}
	
	public String displayPassengerGroupListInfo() {
		String s = "";
		
		while(passengerGroups.hasNext()) {
			s += passengerGroups.next().toString();
		}
		
		resetCursor();
		
		return s;
	}
}
