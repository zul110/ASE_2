package models;

import java.util.List;
import java.util.ListIterator;

public class TaxisListModel {
	private ListIterator<TaxiModel> taxis;
	
	public ListIterator<TaxiModel> getTaxis() {
		return taxis;
	}
	
	public void setTaxis(List<TaxiModel> taxis) {
		this.taxis = taxis.listIterator();
//		for(TaxiModel taxi : taxis) {
//			addTaxi(taxi);
//		}
	}
	
	public void addTaxi(TaxiModel taxi) {
		this.taxis.add(taxi);
	}
	
	/**
	 * Gets the next available taxi (index 0) in the collection
	 * @return Returns the first Taxi object if a taxi is available, null if the collection is empty
	 */
	public TaxiModel getNextAvailableTaxi() {
		if(taxis.hasNext()) {
			TaxiModel taxi = taxis.next();
			taxis.remove();
			return taxi;
		}
		
		return null;
	}
	
//	public void removeTaxi(TaxiModel taxi) {
//		if(taxis..contains(taxi)) {
//			taxis.remove(taxis.indexOf(taxi));
//		}
//	}
	
	public int availableTaxiCount() {
		int count = 0;
		
		while(taxis.hasNext()) {
			count++;
			
			taxis.next();
		}
		
		resetCursor();
		
		return count;
	}
	
	private void resetCursor() {
		while(taxis.hasPrevious()) {
			taxis.previous();
		}
	}

	@Override
	public String toString() {
		String s = "";
		while(taxis.hasNext()) {
			s += taxis.next().toString() + "\n";
		}
		
		resetCursor();
		
		return s;
	}
	
//	public String displayTaxisListInfo() {
//		String s = "";
//		
//		for(TaxiModel taxi : taxis) {
//			s += taxi.displayTaxiInfo();
//		}
//		
//		return s;
//	}
}
