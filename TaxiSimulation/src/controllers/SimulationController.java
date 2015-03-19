package controllers;

import java.util.ArrayList;

import models.*;

public class SimulationController {
	private ArrayList<PassengerGroupModel> passengerGroups;
	private ArrayList<TaxiModel> taxis;
	
	/**
	 * Constructor of the controller
	 */
	public SimulationController() {
		
	}
	
	/**
	 * Initiates the simulation
	 */
	public void initSimulation() {
		
	}
	
	/**
	 * Gets the passenger groups from the model
	 * Stores them into a private collection
	 */
	public void getPassengerGroups() {
		
	}
	
	/**
	 * Gets the taxis from the model
	 * Stores them into a private collection
	 */
	public void getTaxis() {
		
	}
	
	
	/**
	 * Gets the next available passenger group (index 0) in the collection
	 * @return Returns true if a group is available, false if the collection is empty
	 */
	public PassengerGroupModel getNextAvailablePassengerGroup() {
		return null;
	}
	
	/**
	 * Gets the next available taxi (index 0) in the collection
	 * @return Returns true if a taxi is available, false if the collection is empty
	 */
	public TaxiModel getNextAvailableTaxi() {
		return null;
	}
	
	/**
	 * Attempts to assign a passenger group to a taxi
	 * @param passengerGroup
	 * @param taxi
	 * @return Returns true if successfully assigns a group to a taxi (depending on a given condition), false if fails
	 */
	public boolean assignPassengerGroupToTaxi(PassengerGroupModel passengerGroup, TaxiModel taxi) { 
		return true;
	}
	
	/**
	 * Attempts to remove a passenger group from the collection
	 * Only executes when the group has been assigned to a taxi
	 * @param passengerGroup
	 * @return Returns true if successfully removes the group, false if fails
	 */
	public boolean removePassengerGroup(PassengerGroupModel passengerGroup) {
		return true;
	}
	
	/**
	 * Attempts to remove a taxi from the collection
	 * Only executes when the taxi has been assigned to a passenger group
	 * @param taxi
	 * @return Returns true if successfully removes the taxi, false if fails
	 */
	public boolean removeTaxi(TaxiModel taxi) {
		return true;
	}
}
