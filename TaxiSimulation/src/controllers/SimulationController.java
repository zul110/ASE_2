package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import fileOperations.LogFileOps;
import fileOperations.SimulationFileOps;
import views.Main;
import views.MainView;
import models.*;

public class SimulationController {
	private MasterModel model;
	private MainView view;
	
	private PassengerGroupListModel passengerGroups;
	private TaxisListModel taxis;	
	/**
	 * Constructor of the controller
	 */
	public SimulationController(MasterModel model, MainView view) {
		this.model = model;
		this.view = view;
		
		initSimulation();
	}
	
	/**
	 * Initiates the simulation
	 */
	public void initSimulation() {
		getTaxis();
		getPassengerGroups();
		
		start();
	}
	
	private void start() {
		ListIterator<PassengerGroupModel> iterator = passengerGroups.getPassengerGroups().listIterator();
		
		while(iterator.hasNext()) {
			recordSimulation();
			if(!assignPassengerGroupToTaxi()) {
				break;
			}
		}
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
			logText += "Assigned " + nextTaxi.toString() + " to " + nextPassengerGroup.toString();
			
			removeTaxi(nextTaxi);
			removePassengerGroup(nextPassengerGroup);
			
			LogFileOps.getInstance().appendTextToWrite(logText);
			LogFileOps.getInstance().invokeWriteToFile();
			
			return true;
		}
		
		return false;
	}
	
	private void recordSimulation() {
		String simText = "";
		
		simText += "Passenger Groups " + "(" + model.getPassengerGroups().availablePassengerGroupCount() + ")" + ":\n";
		simText += model.getPassengerGroups().toString() + "\n\n";
		
		simText += "Taxis " + "(" + model.getTaxis().availableTaxiCount() + ")" + ":\n";
		simText += model.getTaxis().toString() + "\n\n";
		
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
	}
	
	/**
	 * Removes a taxi from the collection
	 * Only executes when the taxi has been assigned to a passenger group
	 * @param taxi
	 */
	public void removeTaxi(TaxiModel taxi) {
		model.getTaxis().removeTaxi(taxi);
	}
}
