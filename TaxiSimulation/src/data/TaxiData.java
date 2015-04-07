/**
 * Advanced Software Engineering - Stage 2 of Taxi Simulation
 * @author Sreesha Damodaran, Vidhya Krishna, Zulqarnain Mehdi
 * This class describe methods for TaxiData
 */
package data;

import helpers.Utils;

import java.util.ArrayList;

import models.TaxiModel;

public class TaxiData {
	private static TaxiData instance = new TaxiData();
	private int taxiLimit = 5;
	
	private ArrayList<TaxiModel> taxis;
	
	private TaxiData() {
		taxis = new ArrayList<TaxiModel>();
	}
	
	public static TaxiData getInstance() {
		return instance;
	}
	
	public void setTaxiLimit(int taxiLimit) {
		this.taxiLimit = taxiLimit;
	}
	
	public ArrayList<TaxiModel> getTaxiData() {
		if(!taxis.isEmpty()) {
			taxis.clear();
		}
		
		taxis.add(new TaxiModel("SWISS-GE-237890"));
		taxis.add(new TaxiModel("SWISS-GE-245670"));
		taxis.add(new TaxiModel("SWISS-GE-274788"));
		taxis.add(new TaxiModel("SWISS-GE-212345"));
		taxis.add(new TaxiModel("SWISS-GE-252385"));
		taxis.add(new TaxiModel("SWISS-GE-237890"));
		taxis.add(new TaxiModel("SWISS-GE-245670"));
		taxis.add(new TaxiModel("SWISS-GE-274788"));
		taxis.add(new TaxiModel("SWISS-GE-212345"));
		taxis.add(new TaxiModel("SWISS-GE-252385"));
		taxis.add(new TaxiModel("SWISS-GE-237890"));
		taxis.add(new TaxiModel("SWISS-GE-245670"));
		taxis.add(new TaxiModel("SWISS-GE-274788"));
		taxis.add(new TaxiModel("SWISS-GE-212345"));
		taxis.add(new TaxiModel("SWISS-GE-252385"));
		taxis.add(new TaxiModel("SWISS-GE-237890"));
		taxis.add(new TaxiModel("SWISS-GE-245670"));
		taxis.add(new TaxiModel("SWISS-GE-274788"));
		taxis.add(new TaxiModel("SWISS-GE-212345"));
		taxis.add(new TaxiModel("SWISS-GE-252385"));
		taxis.add(new TaxiModel("SWISS-GE-237890"));
		taxis.add(new TaxiModel("SWISS-GE-245670"));
		taxis.add(new TaxiModel("SWISS-GE-274788"));
		taxis.add(new TaxiModel("SWISS-GE-212345"));
		taxis.add(new TaxiModel("SWISS-GE-252385"));
		taxis.add(new TaxiModel("SWISS-GE-237890"));
		taxis.add(new TaxiModel("SWISS-GE-245670"));
		taxis.add(new TaxiModel("SWISS-GE-274788"));
		taxis.add(new TaxiModel("SWISS-GE-212345"));
		taxis.add(new TaxiModel("SWISS-GE-252385"));
		taxis.add(new TaxiModel("SWISS-GE-237890"));
		taxis.add(new TaxiModel("SWISS-GE-245670"));
		taxis.add(new TaxiModel("SWISS-GE-274788"));
		taxis.add(new TaxiModel("SWISS-GE-212345"));
		taxis.add(new TaxiModel("SWISS-GE-252385"));
		taxis.add(new TaxiModel("SWISS-GE-237890"));
		taxis.add(new TaxiModel("SWISS-GE-245670"));
		taxis.add(new TaxiModel("SWISS-GE-274788"));
		taxis.add(new TaxiModel("SWISS-GE-212345"));
		taxis.add(new TaxiModel("SWISS-GE-252385"));
		taxis.add(new TaxiModel("SWISS-GE-237890"));
		taxis.add(new TaxiModel("SWISS-GE-245670"));
		taxis.add(new TaxiModel("SWISS-GE-274788"));
		taxis.add(new TaxiModel("SWISS-GE-212345"));
		taxis.add(new TaxiModel("SWISS-GE-252385"));
		
		if(taxiLimit > taxis.size() || taxiLimit < 1) {
			taxiLimit = taxis.size();
		}
		
		return new ArrayList<TaxiModel>(taxis.subList(0, taxiLimit));
	}

	private void dislayTaxiList() {
		String s = "";
		s += "------------------------------------------------------------\n";
		
		for(TaxiModel taxi : taxis.subList(0, taxiLimit)) {
			s += taxi.toString() + "\n";
		}
		
		s += "------------------------------------------------------------\n";
		
		Utils.println(s);
	}
}
