package week2;

import java.util.List;

/* (I) CONSTRUCTORS (play yourselves with the following cases)
 * a/ Empty constructors
 * b/ Add param to superclass constructor
 * c/ Add param to subclass constructor
 * d/ Remove param to superclass constructor
 * e/ Use super
 * f/ ...
 * 
 * (II) SHADOWING
 * 
 * 
 * (III) OVERIDDING
 */

class Aclass {
	String name ="A";
	public String toString() { return "AAA"; }
}
class Bclass extends Aclass {
	String name = "B" ;
	public String toString() { return "BBB"; }
	public String getInheritedName() { return super.name;}
	public String getInheritedToString() { return super.toString();}
}
class TestConstructors {
	public static void main(String[] lala) {   	
		Aclass a = new Aclass();
		Bclass b = new Bclass();
		System.out.println(a.name);
		System.out.println(a.toString());
		System.out.println(b.name);
		System.out.println(b.toString());
		//System.out.println(b.getInheritedName());
		
		System.out.println(">"+ b.name);
		System.out.println(">"+ ((Aclass)b).name);
		((Aclass)b).name ="Lala";
		System.out.println(">"+ ((Aclass)b).name);
		System.out.println(">"+ b.name);
		
		System.out.println(">>" + b.toString());
		System.out.println(">>" + ((Aclass)b).toString());
		System.out.println(">>>" + b.getInheritedToString());
		
		Aclass ta = new Bclass();
		Bclass tb = new Bclass();
		Aclass tc ;
		tc = tb ;
		Bclass td;
		td = (Bclass)tc ; // the variable tc points to an object inst of Bclass
		
		
		
		
		/*
		Aclass aa = b;
		Object c = b;
		
		System.out.println(">" + aa.name); // A (shadowing)
		System.out.println(">" + aa.toString()); //  BBB (overriding)
		
		// Value of overriding 
		Object o  = new Object(); 
		prettyPrint(a);
		prettyPrint(b);
		prettyPrint(o);
		prettyPrint(
			new  Bclass() {
				 	public String toString() { 
				 		return super.toString() + " xi xi xi "; }
				
			}
		);
		*/
		
	}
	
	static void prettyPrint(Object o) {
		System.out.println("*** "  + o + " ***");
	}
}




