package fileOperations;

import helpers.Constants;

public class LogFileOps extends FileOpsBase {
	public static LogFileOps instance = new LogFileOps();
	private String textToWrite = "";
	
	private LogFileOps() {
		super(Constants.LOG_FILE_NAME);
	}
	
	public static LogFileOps getInstance() {
		return instance;
	}
	
	public void appendTextToWrite(String s) {
		textToWrite += s + "\n";
	}
	
	public void invokeWriteToFile() {
		try {
			writeToFile(Constants.LOG_FILE_NAME, textToWrite);
		} catch (Exception e) {
			
		}
	}
}
