package data;

import java.util.ArrayList;

import models.TaxiModel;

public class TaxiData {
	private static TaxiData instance = new TaxiData();
	
	private ArrayList<TaxiModel> taxis;
	
	private TaxiData() {
		taxis = new ArrayList<TaxiModel>();
	}
	
	public static TaxiData getInstance() {
		return instance;
	}
	
	public ArrayList<TaxiModel> getTaxiData() {
		taxis.add(new TaxiModel("SWISS-GE-237890"));
		taxis.add(new TaxiModel("SWISS-GE-245670"));
		taxis.add(new TaxiModel("SWISS-GE-274788"));
		taxis.add(new TaxiModel("SWISS-GE-212345"));
		taxis.add(new TaxiModel("SWISS-GE-252385"));
		
		return taxis;
	}
}
