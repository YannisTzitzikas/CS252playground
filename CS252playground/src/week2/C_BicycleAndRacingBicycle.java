package week2;

/* 
 * Author: Yannis Tzitzikas, Oct 9, 2014
 * 
 * This extends the Bicycle.java for showing:
 * a/ encapsulation
 * b/ demonstrates the use of inheritance
 * 
 * ACTIONS FOR ENCAPSULATION (in brief)
1. Turn private the class members (instance variable, "internal" methods)
2. Define SET/GET methods for the private members 
    (put in that code
   whatever check or side-effect is required)

IN FUTURE WE WILL ALSO SEE (about inheritance)
3. Design of Exceptions
4. Specification of Pre and Post Conditions
5. JavaDocs
*/
class Bicycle {
   private static int numOfBicyclesCreated =0; // it is static
   private int numOfGears=1;
   private int weight=1;
   
   void  setWeight(int varos) { weight=varos;}
   int  getWeight() { return weight;}
   void setNumOfGears(int taxitites) {   numOfGears = taxitites;  }
   int getNumOfGears() { return numOfGears; }   
   
   static int getNumberOfBicycles() {
	   return numOfBicyclesCreated;
   }
   public String toString() {
	   return "I am a bicycle with " + numOfGears + 
			   " gears having weight equal to " +  
			   getWeight()   ;
   }
    
   Bicycle() {
	   System.out.println("BICYCLE CREATION!");
	   numOfBicyclesCreated++;
   }
   
   Bicycle(int g) {
	   numOfGears = g;
   }
}

class RacingBicycle extends Bicycle {
    private int numOfGears=18; // field with same name but different initial value
	int getNumOfGears() { return numOfGears; }
	  
	public String toString() {
		   return "I am a racing bicycle with " + getNumOfGears() + 
				   " gears having weight equal to " + 
				   getWeight();
	   }
	
	RacingBicycle() {
		//super();   // try uncommenting each of these two calls
		//super(14);
		System.out.println("RACING CREATION");
	}
}



class TopSellerApplication {
	public static  void main(String[] denExeiShmasia) {
					
		Bicycle b1 = new Bicycle();
		b1.setNumOfGears(-12);
					
		Bicycle b2 = new Bicycle();
		b2.setNumOfGears(7);
		
		RacingBicycle rb1 = new RacingBicycle();
		
		System.out.println("Number of Bicycles: " + Bicycle.getNumberOfBicycles());
		
		System.out.println(b1.toString());
		System.out.println(b2);
		System.out.println(rb1);
		System.out.println(">>>>" + rb1.getNumOfGears());
		Bicycle strange = rb1;
		System.out.println(">>" + strange.getNumOfGears());
		
	}   
}