package week8_GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class WinController implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		Object dektis = e.getSource();
		
		((JButton)dektis).setText("BOOM!!!");
		
		System.out.println("BOOM");	
	}
}

class AActivity extends JFrame {
	AActivity(String title) {
	   super(title);
	   this.setVisible(true);
	   this.setSize(400, 400);
	   
	   this.setLayout(new GridLayout());
	   
	   JButton b1 = new JButton("PRESS ME");
	   this.add(b1);
	   JButton b2 = new JButton("DO NOT PRESS ME");
	   this.add(b2);
	   
	   
	   b1.addActionListener(new WinController());
	   b2.addActionListener(new WinController());
	   
	   
	}
}

class SuperActivity extends JFrame {
	SuperActivity(String title) {
		super(title);
		this.setVisible(true);
		this.setSize(400, 400);
		   
		this.setLayout(new GridLayout());
		
		int K=10;
		for (int i=0;i<K;i++) {
			JButton b1 = new JButton("PRESS ME");
			this.add(b1);
			//b1.addActionListener(this);
			b1.addActionListener(
					new ActionListener () {
						public String lala() {
							return "BOOOOOM";
						}
						public void actionPerformed(ActionEvent e) {
							Object dektis = e.getSource();
							
							((JButton)dektis).setText("BOOM!!!" + lala());
							
							System.out.println("BOOM BOOM");	
						}
					}
			);
		}	
	}
	public void actionPerformed(ActionEvent e) {
		Object dektis = e.getSource();
		
		((JButton)dektis).setText("BOOM!!!");
		
		System.out.println("BOOM");	
	}
}	

class A_AppWithGUI {

	public static void main(String[] args) {
		AActivity a1 = new AActivity("win1");
		AActivity a2 = new AActivity("win2");
		
		SuperActivity s1 = new SuperActivity("HERE I AM");

	}

}




