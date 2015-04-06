/**
 * Advanced Software Engineering - Stage 2 of Taxi Simulation
 * @author Vidhya Krishna
 * This class describe methods for SimulationController
 */
package controllers;

import helpers.Utils;

import java.util.ListIterator;

import observerInterfaces.Observer;
import observerInterfaces.Subject;
import fileOperations.LogFileOps;
import fileOperations.SimulationFileOps;
import views.MainView;
import models.*;

public class SimulationController extends Subject implements Observer, Runnable 
{
	private MasterModel model;
	private MainView view;
	
	private PassengerGroupListModel passengerGroups;
	private TaxisListModel taxis;
	/**
	 * Threads for  Simulation controller
	 */
	private Thread t1;
	private Thread t2;
	private Thread t3;
	
	/**
	 * Constructor of the Simulation controller
	 */
	public SimulationController(MasterModel model, MainView view) 
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
		setSimulationText(); // set the initial simulation text (the data in the lists as they are without modification)
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
		try 
		{
			Thread.sleep(10);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
		try 
		{
			Thread.sleep(10);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t3.start();
	}
	
	private void start() 
	{
		ListIterator<PassengerGroupModel> iterator = passengerGroups.getPassengerGroups().listIterator();
		
		while(iterator.hasNext()) {
			//recordSimulation();
			this.notifyObservers();  // update the view [Here view is the observer of this simulation controller]
			if(!assignPassengerGroupToTaxi()) 
			{
				setSimulationText();
				break;
			}
			setSimulationText();
			
			try 
			{
				Thread.sleep(1000);
			} 
			catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void setSimulationText() 
	{
		String simText = "";
		
		simText += "Thread:" + Thread.currentThread().getName() + "\n";
		
		simText += "Passenger Groups: " + "(" + passengerGroups.availablePassengerGroupCount() + ")" + ":\n";
		simText += passengerGroups.toString() + "\n\n";
		
		simText += "Taxis: " + "(" + taxis.availableTaxiCount() + ")" + ":\n";
		simText += taxis.toString() + "\n";
		
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
	public boolean assignPassengerGroupToTaxi() 
	{
		String logText = "";
		
		TaxiModel nextTaxi = taxis.getNextAvailableTaxi();
		PassengerGroupModel nextPassengerGroup = passengerGroups.getNextPassengerGroup();
		
		if((nextTaxi != null) && (nextPassengerGroup != null)) 
		{
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
		model.getPassengerGroups().removePassengerGroup(passengerGroup);
		model.notifyObservers(); // notify the observers that one of the lists has been changed - updates both lists [this controller is the observer of MasterModel]
	}
	
	/**
	 * Removes a taxi from the collection
	 * Only executes when the taxi has been assigned to a passenger group
	 * @param taxi
	 */
	public void removeTaxi(TaxiModel taxi) 
	{
		model.getTaxis().removeTaxi(taxi);
		model.notifyObservers(); // notify the observers that one of the lists has been changed - updates both lists [this simulation controller is the observer of MasterModel]
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
