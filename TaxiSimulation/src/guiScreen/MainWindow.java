package guiScreen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MainWindow extends JFrame implements ActionListener 
{

	//defining the GUI components
	Container C;
	JPanel optionPanel,viewPanel;
	JButton numberOfPassengerButton, numberOfTaxiButton, startSimulationButton, Close;			
	JTextArea viewArea;
	JScrollPane scroll;
	

	/**
	 * Creation of the panels
	 * @param list - the competitor list that has to be searched for
	 */
	public MainWindow()
	{
		 
		setTitle("TAXI SIMULATION APPLICATION");
		setSize(800,600);
        setLocationRelativeTo(null);
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		C = getContentPane();
		C.setLayout(new FlowLayout());
		C.setBackground(new Color(0,0,102)); // sets the color
		optionPanel = new JPanel();
		optionPanel.setLayout(new GridLayout(4, 1));
		
		optionPanel.setForeground(new Color(250, 128, 114));

		numberOfPassengerButton = new JButton("Enter Passenger Groups");
		numberOfTaxiButton = new JButton("Enter Taxi Groups");
		startSimulationButton = new JButton("Start Simulation");
		Close = new JButton("Close");				
		optionPanel.add(numberOfPassengerButton);
		optionPanel.add(numberOfTaxiButton);
		optionPanel.add(startSimulationButton);
		
		optionPanel.add(Close);
		
		viewPanel = new JPanel();
		viewArea = new JTextArea("\n\n                                              WELCOME TO TAXI SIMULATION APPLICATION                     " + 
				"\n\n There are two options in this application: " +
				"\n I. Start Application Simulation" + "\n II. End" +
				"\n\n Please enter the number of passenger groups and taxis to start the application simulation." +
				"\n\n Note: Maximum number of passenger groups and taxis - 25"
				, 20, 52);
		viewArea.setEditable(false);  
		viewArea.setFont(new Font (Font.SERIF, Font.BOLD,12));

		
		scroll = new JScrollPane(viewArea);
		viewPanel.add(scroll);
		C.add(optionPanel);
		C.add(viewPanel);     
		
		numberOfPassengerButton.addActionListener(this); 
		numberOfTaxiButton.addActionListener(this); 
		startSimulationButton.addActionListener(this); 
	 
		Close.addActionListener(this); 
		pack();
		setVisible(true);
	}
   
    public void actionPerformed(ActionEvent e) 
    { 
    	if(e.getSource() == numberOfPassengerButton)
		{
    		//set input dialog box 
    		String number;
			number = JOptionPane.showInputDialog(null,"Enter number of passenger groups: \n");	
		}
    	   	
		if(e.getSource() == numberOfTaxiButton) 
		{
			String number;
			number = JOptionPane.showInputDialog(null,"Enter number of taxis: \n");
			
		}
    else
    	
   		if(e.getSource() == startSimulationButton) 
   		{
   			DisplayWindow dw = new DisplayWindow();
			dw.setVisible(true);
   		}
   	else
    		if (e.getSource() == Close) 
    		{
    		JOptionPane.showMessageDialog(this, 
    				 "THANK YOU");
    		super.dispose();
    	}
    }  
}
