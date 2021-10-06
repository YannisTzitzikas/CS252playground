package week1;


public class FlowOfControl {
	
    static public  void ContinueAndBreak() {
	   int z = 10;
	    for(int i = 0;	// Δήλωση και αρχικοποίηση μεταβλητής ελέγχου
	   	        i < 10;	// Συνθήκη ελέγχου
	    	    i++	){	// Αύξηση κατά ένα μεταβλητής ελέγχου
	   			 
		    z--;
		    
		    if(z == 6)	{
		   	   System.out.println("CONTINUE");
		   	   continue;	// Συνέχισε στην επόμενη επανάληψη
		   	} else if(z == 3) {
		   		System.out.println("BREAK");
		   		break;	// Διέκοψε το βρόγχο 
		   	}
		   	
		    System.out.println("i=" +i + " z="+ z);
	    }
	    
   }
   public static void main(String[] a) {
	   System.out.println("Καλημέρα ");
	   ContinueAndBreak();
	   
	   //FlowOfControl antikeimeno = new FlowOfControl();
	   //antikeimeno.ContinueAndBreak();
   }
}
