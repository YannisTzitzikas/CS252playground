/**
 * 
 */
package week3_4;

/**
 * @author Yannis Tzitzikas (yannistzitzik@gmail.com)
 *  Testing the methods of the classs Object (Oct 2022)
 */
 
 class testObjectMethods {
	public static void main(String[] lala) throws Exception {
	   System.out.println("-[Testing the methods of the class Object]- ");		

	   Object o1 = new Object();
	   Object o2 = new Object();
	   
	   
	   // EQUALS-1
	   System.out.println(o1.equals(o1));  // o1 == o1?
	   System.out.println(o1.equals(o2));  // o1 == o2 ?
	   
	   // hashCode-1
	   System.out.println(o1.hashCode()); // each object get a new number
	   System.out.println(o2.hashCode());
	   
	   
	   // toString-1
	   System.out.println(o1.toString()); // object's class + @ + the value of hasCode in HEX
	   System.out.println(o2.toString());
	   
	   // getClass-1
	   System.out.println(o1.getClass()); // the class that created o1
	   System.out.println(o2.getClass()); // the class that created o2
	   
	   Foititis f1 = new Foititis();
	   Foititis f2 = new Foititis();
	   System.out.println(f1.getClass());
	   System.out.println(f2.getClass());
	   Object o3 = f1;
	   System.out.println("h getClass sto antikeimeno o3 epistrefei " + o3.getClass());
	   SerlockHolmes(o3);
	   
	   // notify (has to do with threads)
	   //o1.notify();
	   //o1.wait();
	   
	   
	   // EQUALS-2   // overriding ...
	   System.out.println("---");
	   System.out.println("F1 equals F2: " + f1.equals(f2));
	   Foititis f3 = new Foititis();  f3.AM=7;
	   System.out.println("F1 equals F3: " + f1.equals(f3));
	   
	   System.out.println("F1 equals o1: " + f1.equals(o1));
	   
	   // HashCode-2   // overriding ...
	   System.out.println(f1.hashCode());
	   System.out.println(f2.hashCode());
	   System.out.println(f3.hashCode());
	   
	   // What about cloning? (for creating an object with state identical to an existing one
	   // Cloning Option1: "home made" method
	   f3.email = "csd7001@csd.uoc.gr";
	   f3.birthPlace = "Athens";
	   Foititis f4 = f3.makeAclone();
	   System.out.println(f3);
	   System.out.println(f4);
	   
	 
	   // Cloning Option2: leverage the clone inherited from Object
	   System.out.println("Using the inherited clone");
	   Foititis f5 = (Foititis) f3.clone();
	   System.out.println(f3);
	   System.out.println(f5);
	   
	   
	   System.out.println("After nulling the hobbies of f5");
	   f5.hobbies = null;
	   f5.car.plates = "A111";
	   
	   System.out.println("f3:" + f3);
	   System.out.println("f5:" + f5);
	   
	   
	}
	
	// prints info about the class that created object o
	public static void SerlockHolmes(Object o ) {
		System.out.println("SH: " + o.getClass());
		Class c = o.getClass();
		System.out.println(c.getConstructors());  // reflective capabilities of Java 
	}
	
	
 }
  
 class Car { static int carNo=1; String plates; Car() {carNo++; plates = "HRK"+carNo;} public String toString() {return plates; }} 
 class Foititis implements Cloneable {
	 int AM=1;
	 String email;
	 String birthPlace;
	 String[] hobbies = {"music", "movies"};
	 Car car;
	 Foititis() {
		 car = new Car();
	 }
	 // Requirement: To return true if the argument has the same AM with this
	 public boolean equals(Object o) {
		 try {
			 //if  (o.getClass()==Class.forName("week3_4.Foititis")) {
			 if (o instanceof Foititis) {
				 Foititis allos = (Foititis)o;  // casting to this  class (if o is indeed an instance of Foititis)
				 if (this.AM==allos.AM) // logical test  (application specific)
					 return true;
			 }	 
		 } catch (Exception e) {System.out.println(e);};
		 return false;
	 }
	 public int hashCode() {
		 return 4000+AM;
		 
	 }
	 public String toString() {
		 String hs = "Hobbies: "; 
		 if (hobbies!=null) {
			 for (String h: hobbies) 
				 hs+= " " +h;
			 }
		 
		 return "Φοιτητης με ΑΜ " + AM + " και email " + email + " με τόπο γέννησης: " + birthPlace + " και ενδιαφέροντα " + hs + " οδηγεί το "+ car;
	 }
	 // home made clone
	 public Foititis makeAclone() {
		 Foititis neos = new Foititis();
		 neos.AM = this.AM;
		 neos.email = this.email;
		 return neos;
		 
	 }
	 // leverage the inherited clone 
	 public Object clone() throws CloneNotSupportedException {
		 Object neo = super.clone(); // inherited (it copies the state of the objet)
		 
		 // for home made deep copy (here for cloning also the car of the student)
		 ((Foititis)neo).car = new Car();
		 ((Foititis)neo).car.plates = this.car.plates;
		 return neo;   // the programmer of lava.lang.Object::clone(): evale kwdika tis morfis: if this.getClass().notConatins(Cloneable) .. throw exception x
	 }
 }
 
