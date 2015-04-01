package models;

import java.util.List;

public class TaxisListModel {
	private List<TaxiModel> Taxis;
	
	public List<TaxiModel> getTaxis() {
		return Taxis;
	}
	
	public void setTaxis(List<TaxiModel> Taxis) {
		this.Taxis = Taxis;
	}
}
