/**
 * Advanced Software Engineering - Stage 2 of Taxi Simulation
 * @author Vidhya Krishna
 * This class describe methods for SimulationController
 */
package controllers;

import helpers.Utils;

import java.util.ListIterator;
import java.util.Random;

import observerInterfaces.Observer;
import observerInterfaces.Subject;
import fileOperations.LogFileOps;
import fileOperations.SimulationFileOps;
import views.MainView;
import views.SimulationView;
import models.*;

public class SimulationController extends Subject implements Observer, Runnable 
{
	private MasterModel model;
	private SimulationView view;
	
	private PassengerGroupListModel passengerGroups;
	private TaxisListModel taxis;
	/**
	 * Threads for  Simulation controller
	 */
	private Thread t1;
	private Thread t2;
	private Thread t3;
	
	private int minSpeed = 200;
	private int maxSpeed = 800;
	private int speed = minSpeed;
	
	/**
	 * Constructor of the Simulation controller
	 */
	public SimulationController(MasterModel model, SimulationView view) 
	{
		this.model = model;
		this.view = view;
		
		this.registerObserver(view);
		model.registerObserver(this);
	}
	
	/**
	 * Initiates the simulation process
	 */
	public void initSimulation() 
	{
		model.notifyObservers();
		//setSimulationText(); // set the initial simulation text (the data in the lists as they are without modification)
		initThreads(); // Call Initialize threads
	}
	
	/**
	 * Initiates the simulation process
	 */
	private void initThreads() 
	{
		t1 = new Thread(this);
		t1.setName("t1");
		
		t2 = new Thread(this);
		t2.setName("t2");
		
		t3 = new Thread(this);
		t3.setName("t3");
		
		t1.start();
		
		t2.start();
		
		t3.start();
	}

	private void setSimulationText(String s) 
	{
		String simText = s;
		
		view.setSimulationText(simText);
	}

	/**
	 * Gets the passenger groups from the model
	 * Stores them into a private collection
	 */
	public void getPassengerGroups() 
	{
		this.passengerGroups = model.getPassengerGroups();
	}
	
	/**
	 * Gets the taxis from the model
	 * Stores them into a private collection
	 */
	public void getTaxis() 
	{
		this.taxis = model.getTaxis();
	}
	
	/**
	 * Attempts to assign a passenger group to a taxi
	 * @parameter passengerGroup
	 * @parameter taxi
	 * @return Returns true if successfully assigns a group to a taxi (depends on a given condition), false if fails
	 */
	public synchronized void assignPassengerGroupToTaxi() 
	{
		try {
			String logText = "";
			
			TaxiModel nextTaxi;
			PassengerGroupModel nextPassengerGroup;
			
			nextTaxi = taxis.getNextAvailableTaxi();
			nextPassengerGroup = passengerGroups.getNextPassengerGroup();
			
			logText += "Taxi: " + nextTaxi.toString() + "\n";
			logText += "Destination: " + nextPassengerGroup.getDestination() + "\n";
			logText += "Number of passengers: " + nextPassengerGroup.getNumberOfPassengers() + "\n\n";
			
			setSimulationText(logText);
			
			String window = Thread.currentThread().getName().replace("t", "Window ");
			logText = "Assigned " + nextTaxi.toString() + " to " + nextPassengerGroup.toString() +  " (" + window +")";	
			LogAssignment(logText);
	
			speed = randInt(minSpeed, maxSpeed);
			
			view.setTaxis(taxis);
			view.setPassengerGroups(passengerGroups);
			view.setThread(Thread.currentThread().getName());
			
			this.notifyObservers();  // update the view [Here view is the observer of this simulation controller]
		} catch(Exception ex) {
			// do nothing
		}
	}
	
	public static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	private void LogAssignment(String logText) {
		LogFileOps.getInstance().appendTextToWrite(logText);
		LogFileOps.getInstance().invokeWriteToFile();
	}

	/**
	 * Record Simulation -Passenger group count and Taxi count
	 */
	private void recordSimulation() 
	{
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
	 * @parameter passengerGroup
	 */
	public void removePassengerGroup(PassengerGroupModel passengerGroup) 
	{
		if(passengerGroups.getPassengerGroups().hasNext()) {
			passengerGroups.getNextPassengerGroup();
			
			model.notifyObservers(); // notify the observers that one of the lists has been changed - updates both lists [this controller is the observer of MasterModel]
		}
//		model.getPassengerGroups().removePassengerGroup(passengerGroup);
	}
	
	/**
	 * Removes a taxi from the collection
	 * Only executes when the taxi has been assigned to a passenger group
	 * @param taxi
	 */
	public void removeTaxi(TaxiModel taxi) 
	{
		if(taxis.getTaxis().hasNext()) {
			taxis.getNextAvailableTaxi();
			
			model.notifyObservers(); // notify the observers that one of the lists has been changed - updates both lists [this simulation controller is the observer of MasterModel]
		}
	}

	@Override
	public void update() {
		getPassengerGroups();
		getTaxis();
	}

	@Override
	public void run() {
		while(passengerGroups.getPassengerGroups().hasNext()) {
			assignPassengerGroupToTaxi();
			
			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
