package week13_Reflection;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
 * On clicking a button you get information about the class of the corresponding object
 *
 */

 class ClassInformation {
   private java.io.PrintStream out = System.out;
   // used in printInfo() for labeling type names
   private static String[] 
           basic    = {"class",   "interface"},
           extended = {"extends", "implements"};
   
   private static String spaces(int depth) {
	   String retSpaces = "";
	   for (int i=0;i<depth;i++)
		   	retSpaces+="    ";
	   return retSpaces;
   }
   
   public String printInfo(Class type, int depth) {
	    // Object’s supertype is null
	    String toReturnStr="";
	    if(type == null)
	       return "";
	    // print out this type
	    toReturnStr+=spaces(depth);
	    String[] labels = (depth == 0 ? basic : extended);
	    toReturnStr+=labels[type.isInterface() ? 1 : 0] + " ";
	    toReturnStr+=type.getName()+"\n";
	    
	    // print out all fields this class implements
	    Field[] pf = type.getDeclaredFields();
	    if (pf.length>0) 
	    	toReturnStr+="\n" + spaces(depth)+"Fields:\n"+spaces(depth+1);
		for (int i=0; i<pf.length;i++){
			 toReturnStr+= " " + pf[i].getName();
		}
		if (pf.length>0) 
	    	toReturnStr+="\n";
		
		
		// /*
		// print out all methods: 
		try {
			toReturnStr+="\nMethods\n";
			Method m[] = type.getDeclaredMethods();
	        for (int i = 0; i < m.length; i++)
	        	toReturnStr+=m[i].toString()+"\n";
       } catch (Throwable e) {
              System.err.println(e);
       }
		//*/
		
	    
	    // print out all interface this class implements
	    Class[] interfaces = type.getInterfaces();
	    for(int i = 0; i < interfaces.length ; i++)
	    	toReturnStr+=printInfo(interfaces[i], depth + 1);
	    // recurse on the superclass
	    
		
	    toReturnStr+=printInfo(type.getSuperclass(), depth + 1);
	    	  
	    return toReturnStr;
	  }
       
	}


/*
 * Specialization of JButton just for holding a reference to an objecg
 *
 */
class MyJButton extends JButton {
	private Object obj;  
	Object getObject() {return obj;}
	MyJButton(Object o) {
		super(o.toString());
		this.obj = o;
		this.setBackground(Color.green);
		this.setForeground(Color.black);
		//this.setToolTipText("This button corresponds to an object associated with audio." +
		//		 "Press to hear the sound");
	}
}


 class SimpleGUICard extends JFrame implements ActionListener {

	// This is the provided function to the rest of the world
	public void add(Object o) {
		MyJButton b=new MyJButton(o);
		b.setFont(new Font("Arial", Font.PLAIN, 30));
		b.addActionListener(this);
		add(b);
	}
	
	
	
	
	public void actionPerformed(ActionEvent event){
		Object buttonPressed=event.getSource();
		
		if (buttonPressed instanceof MyJButton) {
			MyJButton ab = (MyJButton)buttonPressed;
			
			String infoAboutClassOfO =
		    		new ClassInformation().printInfo(ab.getObject().getClass(), 0);
		    
		    System.out.println(infoAboutClassOfO);
		    JOptionPane.showMessageDialog(this,
		    		infoAboutClassOfO);
		    	
		}
		
		if (buttonPressed instanceof JButton) {
			 System.out.println(((JButton)buttonPressed).getText());
		}
		
	}
	
	public SimpleGUICard() {
		super("TEST");  
		setBounds(200,100,350,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout layout=new GridLayout(0,1,5,5);
		setLayout(layout);
				
		add(new JButton("just a button"));
		setVisible(true);
	}
}

 
 class Test {
	 public static void main(String[] lala) {
		 SimpleGUICard demoCard = new SimpleGUICard();
		 demoCard.add("Hello World");
		 demoCard.add(new java.util.Date());
		 demoCard.repaint();
	 }
 }