package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.border.Border;

import models.MasterModel;
import models.PassengerGroupListModel;
import models.PassengerGroupModel;
import models.TaxiModel;
import models.TaxisListModel;
import controllers.SimulationController;
import observerInterfaces.Observer;
import helpers.Utils;

public class SimulationView extends JFrame implements Observer {
	private MainView mainView;
	
	private String simulationText = "";
	
	private String windowOneValue = "";
	private String windowTwoValue = "";
	private String windowThreeValue = "";
	
	private String thread = "t1";
	
	private TaxisListModel taxis;
	private PassengerGroupListModel passengerGroups;
	
	private Container container;
	private JPanel panel;
	private GridLayout layout;
	
	private JLabel taxiListLabel;
	private JLabel passengerGroupsListLabel;
	
	private JLabel windowOneLabel;
	private JLabel windowTwoLabel;
	private JLabel windowThreeLabel;
	
	private JTextArea taxiListArea;
	private JTextArea passengerGroupListArea;
	
	private JTextArea windowOne;
	private JTextArea windowTwo;
	private JTextArea windowThree;
	
	private MasterModel model;
	private SimulationController sim;
	
	public SimulationView(int taxiLimit, int passengerGroupLimit, MainView mainView) {
		super("Taxi Simulation");
		
		this.mainView = mainView;
		
		initSimulationWindow();
		
		initComponents();
		
		initPanel();
		
		initContainer();
		
		initSimulation(taxiLimit, passengerGroupLimit);
	}

	private void initSimulation(int taxiLimit, int passengerGroupLimit) {
		model = new MasterModel(taxiLimit, passengerGroupLimit);
		
		sim = new SimulationController(model, this);
		sim.initSimulation();
	}

	private void initComponents() {
		taxiListLabel = new JLabel("Available Taxis:");
		passengerGroupsListLabel = new JLabel("Remaining Passenger Groups:");
		
		windowOneLabel = new JLabel("Window 1:");
		windowTwoLabel = new JLabel("Window 2:");
		windowThreeLabel = new JLabel("Window 3:");
		
		taxiListArea = new JTextArea();
		taxiListArea.setEditable(false);
		
		passengerGroupListArea = new JTextArea();
		passengerGroupListArea.setEditable(false);
		
		windowOne = new JTextArea();
		windowOne.setEditable(false);
		
		windowTwo = new JTextArea();
		windowTwo.setEditable(false);
		
		windowThree = new JTextArea();
		windowThree.setEditable(false);
	}

	private void initSimulationWindow() {
		int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, screenWidth, screenHeight);
		setResizable(false);
		setVisible(true);
	}
	
	private void initPanel() {
		layout = new GridLayout(0, 5);
		
		panel = new JPanel();
		panel.setLayout(layout);
		
		panel.add(getNestedPanel(taxiListLabel, taxiListArea));
		
		panel.add(getNestedPanel(windowOneLabel, windowOne));
		panel.add(getNestedPanel(windowTwoLabel, windowTwo));
		panel.add(getNestedPanel(windowThreeLabel, windowThree));
		
		panel.add(getNestedPanel(passengerGroupsListLabel, passengerGroupListArea));
	}

	private Component getNestedPanel(JLabel label, JTextArea contentArea) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		JScrollPane scrollPane = new JScrollPane(contentArea);
		
		panel.add(label);
		panel.add(scrollPane);
		
		return panel;
	}

	private void initContainer() {
		container = this.getContentPane();
		
		container.add(panel);
	}

	public PassengerGroupListModel getPassengerGroups() {
		return passengerGroups;
	}
	
	public TaxisListModel getTaxis() {
		return taxis;
	}
	
	public void setPassengerGroups(PassengerGroupListModel passengerGroups) {
		this.passengerGroups = passengerGroups;
	}
	
	public void setTaxis(TaxisListModel taxis) {
		this.taxis = taxis;
	}
	
	public String getSimulationText() {
		return simulationText;
	}
	
	public void setSimulationText(String simulationText) {
		this.simulationText = simulationText;
	}
	
	public void setThread(String thread) {
		this.thread = thread;
	}
	
	public String getThread() {
		return thread;
	}

	@Override
	public void update() {
		updateAvailableTaxisList();
		
		updateRemainingPassengerGroupsList();
		
		updateWindows();
		
		if(passengerGroups.availablePassengerGroupCount() <= 0 || taxis.availableTaxiCount() <= 0) {
			RestartOrClose();
		}
	}

	private void RestartOrClose() {
		Object[] options = { "Restart", "Close" };
		
		int option = JOptionPane.showOptionDialog(
				this,
				"Would you like to restart the simulation, or do you want to close the app?",
				"Restart?",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				options,
				options[0]);
		
		if(option == 0) {
			if(mainView != null) {
				mainView.setEnabled(true);
			} else {
				MainView newMainView = new MainView();
			}
			dispose();
		} else {
			System.exit(0);
		}
	}

	private void updateWindows() {
		switch(thread) {
		case "t1":
			updateWindowOne();
			break;
		case "t2":
			updateWindowTwo();
			break;
		case "t3":
			updateWindowThree();
			break;
			default:
				updateWindowOne();
		}
	}

	private void updateAvailableTaxisList() {
		taxiListArea.setText(taxis.toString());
	}

	private void updateRemainingPassengerGroupsList() {
		passengerGroupListArea.setText(passengerGroups.toString());
	}

	private void updateWindowOne() {
		windowOneValue += simulationText;
		windowOne.setText(windowOneValue);
	}

	private void updateWindowTwo() {
		windowTwoValue += simulationText;
		windowTwo.setText(windowTwoValue);
		
	}

	private void updateWindowThree() {
		windowThreeValue += simulationText;
		windowThree.setText(windowThreeValue);
	}
}
