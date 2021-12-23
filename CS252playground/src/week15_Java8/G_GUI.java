package week15_Java8;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class G_GUI extends JFrame {
	G_GUI() {
		super();
		this.setVisible(true);
		this.pack();
		this.setBounds(100,100,150,150);
		JButton b1 = new JButton("Test");
		this.add(b1);
		
		  b1.addActionListener(
		 
		      new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					b1.setBackground(Color.YELLOW); 					
				}
		      }
		);
		
		b1.addActionListener(e -> { System.out.println("AAAA");
								    b1.setText(b1.getText()+ "*");
								  });
		
		b1.addActionListener( otiNanai -> { b1.setText(b1.getText()+ b1.getText()); });
											//b1.setBackground(Color.RED);   });
	}

	public static void main(String[] args) {
		G_GUI a = new G_GUI();
	}

}
