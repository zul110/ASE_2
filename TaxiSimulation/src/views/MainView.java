package views;

import helpers.Utils;

import javax.swing.JFrame;

import observerInterfaces.Observer;

public class MainView extends JFrame implements Observer {
	private String simulationText = "";
	
	public MainView() {
		
	}
	
	public String getSimulationText() {
		return simulationText;
	}
	
	public void setSimulationText(String simulationText) {
		this.simulationText = simulationText;
	}

	@Override
	public void update() {
		Utils.println(simulationText);
	}
}
