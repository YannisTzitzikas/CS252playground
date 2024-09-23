package week13_Reflection;

import java.util.TreeSet;
/**
 * Uses the SimpleGUICard. It just add some arbitrary objects to that
 * 
 * @author Yannis Tzitzikas (yannistzitzik@gmail.com)
 *
 */

public class GraphicalObjects_Client {
	
  public static void main(String[] args) {
	  
	  int[] pinakas={2,3,4,5};
	  
	  SimpleGUICard sc = new SimpleGUICard();
	  
	  sc.add("This is a test");
	  sc.add(5);
	  sc.add(new week13_Reflection.CCC());
	  sc.add("test2");
	  //sc.add(new Person());
	  sc.add(new Runnable() {
		  public void run() {
			  
		  }
	  });
	    
	  
	  sc.add(new Person() {
		  public String toString() {
			  return super.toString() + super.toString();
		  }
	  });
	  
	  /*
	  
	  sc.add(3);
	  sc.add(pinakas);
	  sc.add(new Person());
	  sc.add(new Person() { public String toString() {
		  return super.toString() + " αλλά με λένε Γιάννη";
		  
	  } } );
	  sc.add(new  Runnable(){ public void run() {;}});
	  sc.add(new  Runnable(){ public void run() {;}});
	  sc.add(new TreeSet());
	  
	  sc.add(new Class[]{});
	  sc.add(sc); // to check
	  */
  }
}
