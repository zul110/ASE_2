package views;

import helpers.Utils;
import models.MasterModel;
import models.TaxiModel;
import models.TaxisListModel;
import controllers.SimulationController;
import data.TaxiData;

public class Main {

	public static void main(String[] args) {
		MasterModel model = new MasterModel();
		MainView view = new MainView();
		
		SimulationController sim = new SimulationController(model, view);
		sim.initSimulation();
		
//		TaxisListModel taxis = new TaxisListModel();
//		taxis.setTaxis(TaxiData.getInstance().getTaxiData());
//		DisplayTaxis(taxis);
	}

	private static void DisplayTaxis(TaxisListModel taxis) {
		String s = "";
		
		for(TaxiModel taxi : taxis.getTaxis()) {
			s += taxi.getRegistrationNumber() + "\n";
		}
		
		Utils.println(s);
	}

}
