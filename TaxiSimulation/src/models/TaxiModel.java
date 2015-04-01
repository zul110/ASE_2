package models;

public class TaxiModel {
	private String registrationNumber;
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	
	public String displayTaxiInfo() {
		String s = "";
		s += this.getRegistrationNumber() + "\n";
		
		return s;
	}
}
