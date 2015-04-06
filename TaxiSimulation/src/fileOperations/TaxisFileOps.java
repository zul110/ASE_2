/**
 * Advanced Software Engineering - Stage 2 of Taxi Simulation
 * @author Sreesha Damodaran, Vidhya Krishna, Zulqarnain Mehdi
 * This class describe methods for TaxisFileOps
 */
package fileOperations;

import helpers.Constants;
import helpers.Utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import customExceptions.InvalidFormatException;
import models.TaxiModel;

public class TaxisFileOps extends FileOpsBase {
	private List<TaxiModel> taxis;
	private List<String> lines;
	
	private String lineCopy;
	private int lineNumber = 0;
	
	/**
	 * Constructor for TaxiFileOps
	 * Accepts the name of the file to read as a parameter
	 * Initializes the ArrayList of Taxis
	 * Reads lines from the file
	 * @param fileName
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws IllegalStateException
	 * @throws Exception
	 */
	public TaxisFileOps(String fileName) throws FileNotFoundException, IOException, IllegalStateException, Exception
	{
		super(fileName);
		
		taxis = new ArrayList<TaxiModel>();
		
		try {
			lines = readLinesFromFile();
		} catch(FileNotFoundException fileEx) {
			throw fileEx;
		} catch(IOException ioEx) {
			throw ioEx;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	/**
	 * "Deserializes" a List of Taxis from the List of lines read from the file
	 * @return List<Taxi>
	 * @throws InvalidFormatException
	 * @throws FileNotFoundException
	 * @throws IllegalStateException
	 * @throws IndexOutOfBoundsException
	 * @throws Exception
	 */
	public List<TaxiModel> getTaxis() throws InvalidFormatException, FileNotFoundException, IllegalStateException, IndexOutOfBoundsException, Exception {
			while(lineNumber < lines.size()) {
				String line = lines.get(lineNumber);
				lineCopy = line;
				lineNumber++;
				
				String driver = "";
				String registrationNumber = "";
				
				if(line.length() > 0) {
					String[] words = line.split(";");
					try {
						driver = words[1];
						registrationNumber = words[0];
						
						if(driver.isEmpty() || registrationNumber.isEmpty()) {
							throw new InvalidFormatException(Constants.TAXIS_FILE_NAME + ": Invalid file format.\nLine number: " + lineNumber + " (" + lineCopy + ")\nPossible cause: missing data.\n");
						}
						
						if(!Utils.isRegistrationNumberValid(registrationNumber)) {
							throw new InvalidFormatException(Constants.TAXIS_FILE_NAME + ": Invalid registration number.\nLine number: " + lineNumber + " (" + lineCopy + ")\n");
						}
						
						TaxiModel taxi = new TaxiModel(registrationNumber);
						
						taxis.add(taxi);
					} catch(IndexOutOfBoundsException indexEx) {
						Utils.println(Constants.TAXIS_FILE_NAME + ": Index out of bounds.\nLine number: " + lineNumber + " (" + lineCopy + ")\nPossible cause: missing data.\n");
					} catch(InvalidFormatException invalidEx) {
						Utils.println(invalidEx.getMessage());
					} catch(Exception ex) {
						throw new Exception("Unknown error while reading " + Constants.TAXIS_FILE_NAME + ".\nMore info: " + ex.getMessage() + "\n");
					}
				}
			}
		return taxis;
	}
}
