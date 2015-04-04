package controllers;

import helpers.Utils;

import java.util.ListIterator;

import observerInterfaces.Observer;
import observerInterfaces.Subject;
import fileOperations.LogFileOps;
import fileOperations.SimulationFileOps;
import views.MainView;
import models.*;

public class SimulationController extends Subject implements Observer, Runnable {
	private MasterModel model;
	private MainView view;
	
	private PassengerGroupListModel passengerGroups;
	private TaxisListModel taxis;
	
	private Thread t1;
	private Thread t2;
	
	/**
	 * Constructor of the controller
	 */
	public SimulationController(MasterModel model, MainView view) {
		this.model = model;
		this.view = view;
		
		this.registerObserver(view);
		model.registerObserver(this);
	}
	
	/**
	 * Initiates the simulation
	 */
	public void initSimulation() {
		model.notifyObservers();
		
		setSimulationText(); // set the initial simulation text (the data in the lists as they are without modification)
		
		initThreads();
	}
	
	private void initThreads() {
		t1 = new Thread(this);
		t1.setName("t1");
		t2 = new Thread(this);
		t2.setName("t2");
		t1.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
	}
	
	private void start() {
		ListIterator<PassengerGroupModel> iterator = passengerGroups.getPassengerGroups().listIterator();
		
		while(iterator.hasNext()) {
			//recordSimulation();
			this.notifyObservers();  // update the view [the view is the observer of this controller]
			if(!assignPassengerGroupToTaxi()) {
				setSimulationText();
				break;
			}
			setSimulationText();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void setSimulationText() {
		String simText = "";
		
		simText += "Thread:" + Thread.currentThread().getName() + "\n";
		
		simText += "Passenger Groups " + "(" + passengerGroups.availablePassengerGroupCount() + ")" + ":\n";
		simText += passengerGroups.toString() + "\n\n";
		
		simText += "Taxis " + "(" + taxis.availableTaxiCount() + ")" + ":\n";
		simText += taxis.toString() + "\n";
		
		view.setSimulationText(simText);
	}

	/**
	 * Gets the passenger groups from the model
	 * Stores them into a private collection
	 */
	public void getPassengerGroups() {
		this.passengerGroups = model.getPassengerGroups();
	}
	
	/**
	 * Gets the taxis from the model
	 * Stores them into a private collection
	 */
	public void getTaxis() {
		this.taxis = model.getTaxis();
	}
	
	/**
	 * Attempts to assign a passenger group to a taxi
	 * @param passengerGroup
	 * @param taxi
	 * @return Returns true if successfully assigns a group to a taxi (depending on a given condition), false if fails
	 */
	public boolean assignPassengerGroupToTaxi() {
		String logText = "";
		
		TaxiModel nextTaxi = taxis.getNextAvailableTaxi();
		PassengerGroupModel nextPassengerGroup = passengerGroups.getNextPassengerGroup();
		
		if((nextTaxi != null) && (nextPassengerGroup != null)) {
			logText += "Assigned " + nextTaxi.toString() + " to " + nextPassengerGroup.toString() +  " (" + Thread.currentThread().getName() +")" +"\n";
			
			removeTaxi(nextTaxi);
			removePassengerGroup(nextPassengerGroup);
			
			Utils.println(logText);
			
			LogFileOps.getInstance().appendTextToWrite(logText);
			LogFileOps.getInstance().invokeWriteToFile();
			
			return true;
		}
		
		return false;
	}
	
	private void recordSimulation() {
		String simText = "";
		
		simText += "Passenger Groups " + "(" + passengerGroups.availablePassengerGroupCount() + ")" + ":\n";
		simText += passengerGroups.toString() + "\n\n";
		
		simText += "Taxis " + "(" + taxis.availableTaxiCount() + ")" + ":\n";
		simText += taxis.toString() + "\n\n";
		
		SimulationFileOps.getInstance().appendTextToWrite(simText);
		SimulationFileOps.getInstance().invokeWriteToFile();
	}

	/**
	 * Removes a passenger group from the collection
	 * Only executes when the group has been assigned to a taxi
	 * @param passengerGroup
	 */
	public void removePassengerGroup(PassengerGroupModel passengerGroup) {
		model.getPassengerGroups().removePassengerGroup(passengerGroup);
		model.notifyObservers(); // notify the observers that one of the lists has been changed - updates both lists [this controller is the observer of MasterModel]
	}
	
	/**
	 * Removes a taxi from the collection
	 * Only executes when the taxi has been assigned to a passenger group
	 * @param taxi
	 */
	public void removeTaxi(TaxiModel taxi) {
		model.getTaxis().removeTaxi(taxi);
		model.notifyObservers(); // notify the observers that one of the lists has been changed - updates both lists [this controller is the observer of MasterModel]
	}

	@Override
	public void update() {
		getPassengerGroups();
		getTaxis();
	}

	@Override
	public void run() {
		start();
	}
}
