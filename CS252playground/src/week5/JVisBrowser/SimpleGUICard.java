package week5.JVisBrowser;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//import lectures.Week5.WithAudio;

/**
 * 
 * @author tzitzik
 * Class that offers a method to add objects.
 * Each objects becomes a button.
 * The label of the button is the toString() of the object
 * On click it calls a toSound() method.
 */


/*
 * Eksideikeuesei tou JButton pou krataei anafora se ena antikeimeno
 *
 */
class AudioJButton extends JButton {
	private Object obj;  // anti gia object eprepe na yparxei ena interface
	Object getObject() {return obj;}
	AudioJButton(Object o) {
		super(o.toString());
		this.obj = o;
		this.setBackground(Color.green);
		this.setForeground(Color.black);
		this.setToolTipText("This button corresponds to an object associated with audio." +
				 "Press to hear the sound");
	}
}


public class SimpleGUICard extends JFrame implements ActionListener {

	// This is the provided function to the rest of the world
	public void add(Object o) {
		AudioJButton b=new AudioJButton(o);
		b.addActionListener(this);
		add(b);
	}
	
	
	public void actionPerformed(ActionEvent event){
		Object buttonPressed=event.getSource();
		if (buttonPressed instanceof AudioJButton) {
			AudioJButton ab = (AudioJButton)buttonPressed;
			//WithAudio  associatedObject = (WithAudio)ab.getObject();
			//associatedObject.playSound();
			
			
		
			
			/*
			 * Milestones
			 * 1. Call a static method returning all reflectively collected info about this and
			 * show in a different window
			 * 2. Creata a new card like this 
			 * and add as objects all reflective got elements of this. 
			 */
			
			// 1. Start  (Shows only info about the class of the object )
					
			ReflectiveClassInfo info = new ReflectiveClassInfo();
			//info.printInfo(Class.forName(args[i]), 0);
			//info.printInfo(associatedObject);
			info.printInfo(new String());
			
			//info.printInfo(associatedObject.getClass(),0);
			  
			System.out.println(((JButton)buttonPressed).getText());
		} 
		if (buttonPressed instanceof JButton) {
			 System.out.println(((JButton)buttonPressed).getText());
		}
		
	}
	
	public SimpleGUICard() {
		super("SimpleGuiCard");  
		setBounds(200,100,350,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout layout=new GridLayout(0,1,5,5);
		setLayout(layout);
		setVisible(true);		
	}
}

class TEST {
	public static void main(String[] lala) {
		SimpleGUICard s = new SimpleGUICard();
		s.add(new String("test"));
		s.add(new B());
		
	}
}

class A {}
class B extends A {}