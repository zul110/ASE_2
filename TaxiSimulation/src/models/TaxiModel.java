package models;

public class TaxiModel {
	private String registrationNumber;
	
	public TaxiModel(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	
	@Override
	public String toString() {
		String s = "";
		s += registrationNumber;
		
		return s;
	}
	
	public String displayTaxiInfo() {
		String s = "";
		s += this.getRegistrationNumber() + "\n";
		
		return s;
	}
}
