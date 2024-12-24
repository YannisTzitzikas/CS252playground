package week10;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;



public class D_GUI 	extends JFrame implements ActionListener {
	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;// non in thread
	JButton b5; 
	
	
	public void actionPerformed(ActionEvent event){
		Object buttonPressed=event.getSource();
		if (buttonPressed == b1) {
			//((JButton)b1).setLabel("test");
			
			new Thread(new Runnable()
			{
				  public void run()
				  {
			           for (int i=1; i<100; i++) {
			        	   try {
			        	   Thread.sleep(1000);
			        	   } catch (Exception e) {
			        		   
			        	   }
			        	   b1.setText("b1: "+ i);
			           }
				  }
				}).start();
			
		} else if (buttonPressed == b2) {
			new Thread(new Runnable()
			{
				  public void run()
				  {
			           for (int i=1; i<100; i++) {
			        	   try {
			        	   Thread.sleep(50);
			        	   } catch (Exception e) {
			        		   
			        	   }
			        	   b2.setText("b2: "+ i);
			           }
				  }
				}).start();

		} else if (buttonPressed == b4) { // not in thread
			
			
			// dhmiourghse ena thread kai ksekinhse to
			//  new Runnable <......start()
			
			b4.setText("0"); 
			for (int i=1; i<100; i++) {
				try {
		        	   Thread.sleep(50);
		        } catch (Exception e) {
		        	   
		        }
				//b4.setText(" "+ i);
				System.out.println(i);
			}
			
			b4.setText(" Τέλειωσα το μέτρημα");
			
		} else {
			System.out.println(buttonPressed);
		}
	}		
		
D_GUI() {
	super("Παράθυρο");  
	setBounds(200,100,550,600);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	GridLayout layout=new GridLayout(0,1,5,5);
	setLayout(layout);
	
	b1=new JButton("Press me to start counting");
	b2=new JButton("Press me to start counting");
	b3=new JButton("Press me to start counting");
	b4=new JButton("Press me to start counting (no thread)");
	b5=new JButton("Press me");
	
	b1.addActionListener(this);
	b2.addActionListener(this);
	b4.addActionListener(this);
	add(b1);
	add(b2);
	add(b3);
	add(b4);
	add(b5);
	
	
	Font f = new Font("Dialog",1,24);
	b1.setFont(f);
	b2.setFont(f);
	b3.setFont(f);
	b4.setFont(f);
	b5.setFont(f);

	
	
	
	b3.addActionListener(
			
			new ActionListener() 
			{ 
				public void actionPerformed(ActionEvent e){
				  
					new Thread(new Runnable()
					{
						  public void run()
						  {
					           for (int i=1; i<100; i++) {
					        	   try {
					        	   Thread.sleep(50);
					        	   } catch (Exception e) {
					        		   
					        	   }
					        	   b3.setText("b3: ("+ i + ")");
					           }
					           
						  }
						}).start();
					
				}
			}
	
	);
	
	
b5.addActionListener(
			
			new ActionListener() 
			{ 
				public void actionPerformed(ActionEvent e){
					for (int i=0; i<500*1000*1000;i++)
					b5.setText("b5: Mpravo sou.");
			
				}
			});

				
	setVisible(true);	
}
 public static void main(String[] lala) {
	 System.out.println("...");
	 D_GUI g = new D_GUI();
	 
 }
}
