/**
 * Advanced Software Engineering - Stage 2 of Taxi Simulation
 * @author Sreesha Damodaran, Vidhya Krishna, Zulqarnain Mehdi
 * This class describe methods for Utils
 */
package helpers;

import java.util.HashSet;

public class Utils {
	/**
	 * Method to print output
	 * @param s
	 */
	public static void println(String s) 
	{
		System.out.println(s);
	}
	
	/**
	 * Method to test double data type validation
	 * @param string
	 * @return true - boolean
	 * In case of a number format exception, 
	 * function returns false
	 */
	public static boolean isDouble(String string) {
		try {
			double d = Double.parseDouble(string);
		} catch(NumberFormatException numEx) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Method to test integer number validation 
	 * @param string
	 * @return true - boolean
	 * In case of a number format exception, 
	 * function returns false
	 */
	public static boolean isInteger(String string) {
		try {
			double d = Integer.parseInt(string);
		} catch(NumberFormatException numEx) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Method to test taxi registration number format validation 
	 * @param registrationNumber
	 * @return true - if number format is valid 
	 * else return false
	 */
	public static boolean isRegistrationNumberValid(String registrationNumber) {
		String[] reg = registrationNumber.split("-");
		if(reg.length == 3) {
			if(reg[0].toUpperCase().equals("SWISS")
					&& getCodes().contains(reg[1].toUpperCase())
					&& reg[2].length() == 6
					&& isInteger(reg[2])) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Method to store Canton Codes in hash table
	 * HashSet called codes is defined 
	 * And Canton codes are added to it
	 * @return codes
	 */
	public static HashSet<String> getCodes() {
		HashSet<String> codes = new HashSet<String>();
		codes.add("AG");
		codes.add("AI");
		codes.add("AR");
		codes.add("BE");
		codes.add("BL");
		codes.add("BS");
		codes.add("FR");
		codes.add("GE");
		codes.add("GL");
		codes.add("GR");
		codes.add("JU");
		codes.add("LU");
		codes.add("NE");
		codes.add("NW");
		codes.add("OW");
		codes.add("SG");
		codes.add("SH");
		codes.add("SO");
		codes.add("SZ");
		codes.add("TG");
		codes.add("TI");
		codes.add("UR");
		codes.add("VD");
		codes.add("VS");
		codes.add("ZG");
		codes.add("ZH");
		
		return codes;
	}
}
