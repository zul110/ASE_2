package views;

import helpers.Utils;

import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import models.MasterModel;
import controllers.SimulationController;

public class MainView extends JFrame implements ActionListener {
	Container container;
	
	JPanel panel;
	SpringLayout layout = new SpringLayout();
	
	JLabel taxisLabel;
	JLabel passengerGroupsLabel;
	
	JTextField taxisField;
	JTextField passengerGroupsField;
	
	JButton startSimulationButton;
	
	public MainView() {
		super("Taxi Simulation");		
		
		initContainer();
		
		initPanel();
		
		initComponents();
		
		addComponentsToPanel();
		
		container.add(panel);
		
		initMainWindow();
	}

	private void addComponentsToPanel() {
		panel.add(taxisLabel);
		panel.add(taxisField);
		
		panel.add(passengerGroupsLabel);
		panel.add(passengerGroupsField);
		
		panel.add(startSimulationButton);
	}

	private void initMainWindow() {
		int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((screenWidth / 2) - 250, (screenHeight / 2) - 200, 250,200);
		setResizable(false);
		setVisible(true);
	}

	private void initComponents() {
		taxisLabel = new JLabel("Number of taxis");
		layout.putConstraint(SpringLayout.WEST, taxisLabel, 5, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, taxisLabel, 5, SpringLayout.NORTH, container);
		
		taxisField = new JTextField(20);
		layout.putConstraint(SpringLayout.WEST, taxisField, 5, SpringLayout.EAST, container);
		layout.putConstraint(SpringLayout.NORTH, taxisField, 15, SpringLayout.NORTH, taxisLabel);
		
		passengerGroupsLabel = new JLabel("Number of passenger groups");
		layout.putConstraint(SpringLayout.WEST, passengerGroupsLabel, 5, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, passengerGroupsLabel, 30, SpringLayout.NORTH, taxisField);
		
		passengerGroupsField = new JTextField(20);
		layout.putConstraint(SpringLayout.WEST, passengerGroupsField, 5, SpringLayout.EAST, container);
		layout.putConstraint(SpringLayout.NORTH, passengerGroupsField, 15, SpringLayout.NORTH, passengerGroupsLabel);
		
		startSimulationButton = new JButton("Start simulation");
		startSimulationButton.addActionListener(this);
		layout.putConstraint(SpringLayout.WEST, startSimulationButton, 5, SpringLayout.EAST, container);
		layout.putConstraint(SpringLayout.NORTH, startSimulationButton, 30, SpringLayout.NORTH, passengerGroupsField);
	}

	private void initPanel() {
		panel = new JPanel();
		panel.setLayout(layout);
	}

	private void initContainer() {
		container = this.getContentPane();		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		int taxiLimit = 10;
		int passengerGroupLimit = 10;
		
		/** System process  invalid inputs and display 5 passenger groups and  5 taxi groups **/
		if(Utils.isInteger(taxisField.getText()) && Utils.isInteger(passengerGroupsField.getText())) {
			taxiLimit = Integer.parseInt(taxisField.getText());
			passengerGroupLimit = Integer.parseInt(passengerGroupsField.getText());
			
			/** System limits taxi groups and passenger groups**/
			if (taxiLimit>45 || passengerGroupLimit>45)
			{
				JOptionPane.showMessageDialog(this,
					    "The maximum number of taxis and passenger groups that can be added to the simulation is 45.",
					    "Information",
					    JOptionPane.WARNING_MESSAGE);
			}
			else
			{
				this.setEnabled(false);
				SimulationView simView = new SimulationView(taxiLimit, passengerGroupLimit, this);
			}
			
		} else {
			JOptionPane.showMessageDialog(this,
				    "Invalid input detected. Please insert numeric values (between 1 and 45) for the fields.",
				    "Information",
				    JOptionPane.WARNING_MESSAGE);
		}
	}
}
