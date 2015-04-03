package fileOperations;

import helpers.Constants;

public class SimulationFileOps extends FileOpsBase {
	public static SimulationFileOps instance = new SimulationFileOps();
	private String textToWrite = "";
	
	private SimulationFileOps() {
		super(Constants.SIM_FILE_NAME);
	}
	
	public static SimulationFileOps getInstance() {
		return instance;
	}
	
	public void appendTextToWrite(String s) {
		textToWrite += s + "\n";
	}
	
	public void invokeWriteToFile() {
		try {
			writeToFile(Constants.SIM_FILE_NAME, textToWrite);
		} catch (Exception e) {
			
		}
	}
}
