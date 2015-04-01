package models;

public class PassengerGroupModel {
	private int numberOfPassengers;
	private String destination;
	
	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}
	
	public void setNumberOfPassengers(int numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public String displayPassengerGroupInfo() {
		String s = "";
		s += this.getDestination() + "\n";
		s += this.getNumberOfPassengers() + "\n";
		
		return s;
	}
}
