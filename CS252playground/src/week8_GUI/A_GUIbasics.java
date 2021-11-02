package week8_GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;



class WinA extends JFrame implements ActionListener {
	JButton b1, b2;
	WinA() {
		GridLayout layout=new GridLayout(0,1);
		setLayout(layout);
		
		b1 = new JButton("Press me");
		add(b1);
		b2 = new JButton("Do not press me");
		add(b2);
		
		b1.addActionListener(this);
		b2.addActionListener(new Controller());
		
		setBounds(200,100,350,600);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event){
		Object buttonPressed=event.getSource();
		((JButton)buttonPressed).setText("I was pressed");
		//if (buttonPressed == b1) {
		//	((JButton)b1).setText("I was pressed");
		//	
	    //}
	}
}


public class A_GUIbasics {
    public static void main(String[] args){
		WinA  wa = new WinA();
	}
}



class Controller implements ActionListener {
	public void actionPerformed(ActionEvent event){
		Object buttonPressed=event.getSource();
		((JButton)buttonPressed).setText(":)");
	}
}
