package guiScreen;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DisplayWindow extends JFrame implements ActionListener
{

	JPanel overallPanel, passengerPanel,taxiPanel, displayPanel, firstWindow, secondWindow, thirdWindow;

	JTextArea passengerText,taxiText, firstWindowText, secondWindowText, thirdWindowText, displayText;

	JScrollPane passengerScroll, taxiScroll, firstWindowScroll, secondWindowScroll, thirdWindowScroll, displayScroll;
	
	public DisplayWindow()
	{
		// Sets the background for the Window
		getContentPane().setBackground(new Color(128,0,0)); 
		overallPanel = new JPanel();
		passengerPanel =  new JPanel();
		taxiPanel = new JPanel();
		firstWindow = new JPanel();
		secondWindow = new JPanel();
		thirdWindow = new JPanel();
		displayPanel = new JPanel();
		
		 // Sets the same background for the button panel
		overallPanel.setBackground(new Color(128,0,0));
		
		passengerText = new JTextArea(25,10);
		taxiText = new JTextArea(25,10);
		firstWindowText = new JTextArea(45,10);
		secondWindowText = new JTextArea(45,10);
		thirdWindowText = new JTextArea(45,10);
		displayText = new JTextArea(45,10);
		
		passengerScroll = new JScrollPane(passengerText);
		taxiScroll = new JScrollPane(taxiText);
		firstWindowScroll = new JScrollPane(firstWindowText);
		secondWindowScroll = new JScrollPane(secondWindowText);
		thirdWindowScroll = new JScrollPane(thirdWindowText);
		displayScroll = new JScrollPane(displayText);
		
		passengerText.setFont(new Font (Font.MONOSPACED, Font.PLAIN,14));
		taxiText.setFont(new Font (Font.MONOSPACED, Font.PLAIN,14));
		firstWindowText.setFont(new Font (Font.MONOSPACED, Font.PLAIN,14));
		secondWindowText.setFont(new Font (Font.MONOSPACED, Font.PLAIN,14));
		thirdWindowText.setFont(new Font (Font.MONOSPACED, Font.PLAIN,14));
		displayText.setFont(new Font (Font.MONOSPACED, Font.PLAIN,14));
		
		passengerPanel.add(passengerScroll);
		taxiPanel.add(taxiScroll);
		firstWindow.add(firstWindowScroll);
		secondWindow.add(secondWindowScroll);
		thirdWindow.add(thirdWindowScroll);
		displayPanel.add(displayScroll);
		
		// Making the button panel as a box layout so that the displayPanel come one below the other
		//use grid layout
		overallPanel.setLayout(new GridLayout(5, 1));
		displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.PAGE_AXIS));
		passengerPanel.setLayout(new BoxLayout(passengerPanel, BoxLayout.PAGE_AXIS));
		firstWindow.setLayout(new BoxLayout(firstWindow, BoxLayout.PAGE_AXIS));
		secondWindow.setLayout(new BoxLayout(secondWindow, BoxLayout.PAGE_AXIS));
		thirdWindow.setLayout(new BoxLayout(thirdWindow, BoxLayout.PAGE_AXIS));
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		getContentPane().setLayout(new FlowLayout());
		//Declared so that on closing of window the other GUI'sdo not get closed
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Simulation Window");
		
		// Creates a rigid area below the sort displayPanel for formatting reasons
		//Component rigidArea = Box.createRigidArea(new Dimension(0, 158));
		//rigidArea.setBackground(new Color(221, 160, 221));
		//displayPanel.add(rigidArea);
		
		taxiText.setEditable(true);
		passengerText.setEditable(true);
		displayText.setEditable(true);
		firstWindowText.setEditable(true);
		secondWindowText.setEditable(true);
		thirdWindowText.setEditable(true);
		
		getContentPane().add(overallPanel);
		getContentPane().add(passengerPanel);
		getContentPane().add(displayPanel);
		getContentPane().add(taxiPanel);
		getContentPane().add(firstWindow);
		getContentPane().add(secondWindow);
		getContentPane().add(thirdWindow);
		
		setVisible(true);
		pack();
	}

	public void actionPerformed(ActionEvent e) 
	{
		
	}
}
