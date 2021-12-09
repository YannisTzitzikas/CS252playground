package week11_InnerClasses;


import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

import  javax.swing.*;

/**
 * Based on slides for inner classes
 * @author tzitzik
 *
 */



class SomeGUI extends JFrame  implements ActionListener
{ 
	protected JButton button1 ;
	protected JButton button2;
	protected JButton button3;
	protected JButton button4;
	
	
	// Implementation of ActionListener
	public void actionPerformed(ActionEvent e) {
		 if (e.getSource()==button1) {
			 System.out.println("Button1 pressed");
		 }
		 if (e.getSource()==button2) {
			 System.out.println("Button2 pressed");
		 }
		 if (e.getSource()==button3) {
			 System.out.println("Button3 pressed");
		 }
		 if (e.getSource()==button4) {
			 System.out.println("Button4 pressed");
		 }
		 //System.out.println("Κάτι έγινε");
	}

	SomeGUI() {
		GridLayout layout=new GridLayout(0,1,5,5);
		setLayout(layout);
		
		button1 = new JButton("Κουμπί 1"); button1.setFont(new Font("Arial", Font.PLAIN, 40));
		button2 = new JButton("Κουμπί 2"); button2.setFont(new Font("Arial", Font.PLAIN, 40));
		button3 = new JButton("Κουμπί 3"); button3.setFont(new Font("Arial", Font.PLAIN, 40));
		button4 = new JButton("Κουμπί 4"); button4.setFont(new Font("Arial", Font.PLAIN, 40));
		JButton[] allButtons = {button1, button2, button3, button4};
		
		// for reducing the code that I have to write
		for (JButton b: allButtons) {
			add(b);  // addition of button to the current frame
			b.addActionListener(this); // setting up the behavior
		}
		
		// verbose version:
		/*
		add(button1); // adds the button to this current frame
		add(button2);
		add(button3);
		add(button4);
		
		
		// symperifora
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		*/
		
		// Below I will create one anonymous class and one instance of that class 
		// for responding to the events related to this button.
		// Inside that class another anonymous class that impements Runnable
		button4.addActionListener(
				new  ActionListener() {
					public void actionPerformed(ActionEvent e) {
						 button1.setLabel("Χα χα χα");
						 System.out.println("MPAM");
						 new Thread(
								 new  Runnable() {
									public void run() {
										for (int i=0;i<100; i++) {
											try {
												Thread.sleep(300);
												button1.setLabel("Χα " + i);
											} catch (Exception e) {}
										}
										// will create another window with the same behaviour:
										SomeGUI gui = new SomeGUI();
										gui.setSize(800, 400);
										gui.setVisible(true);
									}
								 }
								 
						 ).start();
						 
					}
				}
        );
		
	}
	
	

	public  static void main (String a[]){
		SomeGUI gui = new SomeGUI();
		gui.setSize(800, 400);
		gui.setVisible(true);
		
		
		//extreme: checking that the anonymous classes created could be used
		try {
			Class c = Class.forName("week11_InnerClasses.SomeGUI$1$1");
			System.out.println(c.getName());
		} catch (ClassNotFoundException e) {}
		
	}
}
	
