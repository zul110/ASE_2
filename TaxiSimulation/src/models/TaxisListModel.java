package models;

import java.util.List;

public class TaxisListModel {
	private List<TaxiModel> taxis;
	
	public List<TaxiModel> getTaxis() {
		return taxis;
	}
	
	public void setTaxis(List<TaxiModel> taxis) {
		this.taxis = taxis;
	}
	
	public void addTaxi(TaxiModel taxi) {
		this.taxis.add(taxi);
	}
	
	/**
	 * Gets the next available taxi (index 0) in the collection
	 * @return Returns the first Taxi object if a taxi is available, null if the collection is empty
	 */
	public TaxiModel getNextAvailableTaxi() {
		if(!taxis.isEmpty()) {
			return taxis.get(0);
		}
		
		return null;
	}
	
	public void removeTaxi(TaxiModel taxi) {
		if(taxis.contains(taxi)) {
			taxis.remove(taxis.indexOf(taxi));
		}
	}
	
	public int availableTaxiCount() {
		if(!taxis.isEmpty()) {
			return taxis.size();
		}
		
		return 0;
	}
	
	@Override
	public String toString() {
		String s = "";
		for(TaxiModel taxi : taxis) {
			s += taxi.toString() + "\n";
		}
		
		return s;
	}
	
	public String displayTaxisListInfo() {
		String s = "";
		
		for(TaxiModel taxi : taxis) {
			s += taxi.displayTaxiInfo();
		}
		
		return s;
	}
}
