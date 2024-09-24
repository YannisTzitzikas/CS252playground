package week1;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;

class WinController implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		Object dektis = e.getSource();
		String msg = "Μπάμ μπαμ!";
		((JButton)dektis).setText(msg);
		System.out.println(msg);	
	}
}

class Parathyro extends JFrame {
	Parathyro(String title) {
	   super(title);
	   this.setVisible(true);
	   this.setSize(400, 400);
	   
	   this.setLayout(new GridLayout());
	   
	   JButton b1 = new JButton("PRESS ME");
	   b1.setBackground(Color.green);
	   this.add(b1);
	   JButton b2 = new JButton("DO NOT PRESS ME");
	   b2.setBackground(Color.red);
	   this.add(b2);
	   
	   b1.addActionListener(new WinController());
	   b2.addActionListener(new WinController());
	   
	   
	}
}

class ParathyroSpecial extends JFrame {
	int numOfButtons;
	ParathyroSpecial(String title, int numOfButtons) {
		super(title);
		this.setVisible(true);
		this.setSize(600, 600);
		this.numOfButtons=numOfButtons;  
		this.setLayout(new GridLayout(0,7));
		
		for (int i=0;i<numOfButtons;i++) {
			JButton b1 = new JButton("Κομβίο " + (i+1));
			this.add(b1);
			if (i%2==0) 
				b1.setBackground(Color.WHITE);
			else 
				b1.setBackground(Color.cyan);
			
			
			//b1.addActionListener(this);
			b1.addActionListener(
					new ActionListener () {
						public void actionPerformed(ActionEvent e) {
							Object dektis = e.getSource();
							String msg="Boom BOOM ";
							((JButton)dektis).setText(msg);
							System.out.println(msg);	
						}
					}
			);
		}	
	}
	public void actionPerformed(ActionEvent e) {
		Object dektis = e.getSource();
		((JButton)dektis).setText("Μπαμ");
		System.out.println("Μπαμ");	
	}
}	

class GUIexample {

	public static void main(String[] args) {
		// Parathyro p1 = new Parathyro("Παράθυρο 1");
		//Parathyro p2 = new Parathyro("Παράθυρο 2");
		
		 
		 System.out.print("Πόσα κουμπιά θα ήθελες: ");
		 Scanner in = new Scanner(System.in);
		 int a = in.nextInt();
		 System.out.println("You typed " + a);
		 
		
		ParathyroSpecial s1 = new ParathyroSpecial("lala",a);
		
	}

}




