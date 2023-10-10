/**
 * @author Yannis Tzitzikas
 */
package week2;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

import org.jfugue.Player;

class MyButton extends JButton implements ActionListener {
	int v =0;
	public void actionPerformed (java.awt.event.ActionEvent e) {
		Player pl = new Player();
		
		//pl.play("["+v+"]"); // single thread (one execution flow)
		
		
		Thread t = new Thread(new Runnable() {public void run() {pl.play("["+v+"]"); } });
		t.start();
		
		
     }			
	MyButton(String t, int v) {
		super(t);
		this.v = v;
		setBackground(Color.GREEN);
	}
}

class ControlButton extends MyButton   {
	ControlButton(String t, int v) {
		super(t,v);
		this.setBackground(Color.green);
	}
}

class MyCard extends JFrame  {
	int k;
	int base;
	void doit() {
		for (int i=0;i<k;i++) {
			MyButton b1 = new MyButton("Note " + (base+i+1), base+i);
			add(b1);  b1.addActionListener(b1);
		}
		JButton b2 = new JButton("Higher");
		add(b2);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed (java.awt.event.ActionEvent e) {
				MyCard c = new MyCard(k, base+12);
		     }	
		  }
		);
		
		
		JButton b3 = new JButton("Lower");
		add(b3);
		b3.addActionListener(new ActionListener() {
			public void actionPerformed (java.awt.event.ActionEvent e) {
				MyCard c = new MyCard(k, base-12);
		     }	
		  }
		);
		/*
		JButton b4 = new ControlButton("DOKIMASTIKO", 100);
		add(b4);
		*/
		setVisible(true);
	}
	MyCard(int k, int base) {
		this.k = k;
		this.base = base;
		setBounds(100,100,900,200);  //x,  y,  width,  height)
		setLayout(new GridLayout(2,12)); // rows, columns
		setVisible(true);
		setTitle("MUSIC");
		doit();
	}
	public  static void main(String[] args){
		MyCard mc = new MyCard(12,40);
	}
}


