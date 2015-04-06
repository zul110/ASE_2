/**
 * Advanced Software Engineering - Stage 2 of Taxi Simulation
 * @author Sreesha Damodaran, Vidhya Krishna, Zulqarnain Mehdi
 * This class describe methods for Main
 */
package views;

import helpers.Utils;
import models.MasterModel;
import models.TaxiModel;
import models.TaxisListModel;
import controllers.SimulationController;
import guiScreen.MainWindow;

public class Main {
	
	
	public static void main(String[] args) {
		Simulation sim = new Simulation();
		MainWindow mw = new MainWindow();
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
