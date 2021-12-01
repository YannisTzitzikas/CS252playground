package frontistirio0608Grafika;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TestGui {

	public static void main(String[] args) {
		//new frame
		JFrame newFrame=new JFrame("Chat example");
		newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Frame size and location
		newFrame.setBounds(100,100,400,400);
		newFrame.setLayout(new BorderLayout());
		//Menu
		JMenuBar newMenu= new JMenuBar();
		JMenu m=new JMenu("File");
		
		JMenuItem j1=new JMenuItem("Open");
		
		m.add(j1);
		newMenu.add(m);
		newFrame.setJMenuBar(newMenu);
		
		//center text area
		JTextArea t=new JTextArea("",6,35);
		t.setText("Frontistirio 252");
		newFrame.add(t,BorderLayout.CENTER);
		
		//panel bottom
		JPanel panel = new JPanel();
		
		JLabel label = new JLabel("Enter Text");
        JTextField tf = new JTextField(10); // accepts upto 10 characters
        JButton send = new JButton("Send");
        JButton reset = new JButton("Reset");
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(send);
        panel.add(reset);
        
        newFrame.getContentPane().add(BorderLayout.SOUTH, panel);
        newFrame.getContentPane().add(BorderLayout.NORTH, newMenu);
		
		
		newFrame.setVisible(true);

	}

}
