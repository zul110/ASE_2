package views;

import java.util.ListIterator;

import models.MasterModel;
import models.PassengerGroupModel;
import controllers.SimulationController;

public class Simulation implements Runnable {
	private SimulationController sim;
	
	private MasterModel model;
	private MainView view;
	
	public Simulation() {
		model = new MasterModel();
		view = new MainView();
		
		sim = new SimulationController(model, view);
		sim.initSimulation();
		
		//initThreads();
	}
	
	private void initThreads() {
		Thread t1 = new Thread(this);
		Thread t2 = new Thread(this);
		
		t1.start();
		t2.start();
	}
	
	@Override
	public void run() {
		ListIterator<PassengerGroupModel> iterator = model.getPassengerGroups().getPassengerGroups().listIterator();
		while(iterator.hasNext()) {
			sim.initSimulation();
			if(!sim.assignPassengerGroupToTaxi()) {
				break;
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
