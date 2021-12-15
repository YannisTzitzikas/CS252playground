package week13_Reflection;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 * 
 * @author tzitzik
 *
 * method1 shows
 *  A) how to load a class (two ways)
 *  B) how to create an instance (of a loaded class) 
 *
 */

//the next three classes to be deleted
class AAA extends ArrayList {}
class BBB extends AAA {}
class CCC extends BBB { CCC() { } CCC(AAA a) {} }

class smallTests {
	
	public void method1() {
		
		// LOADING A CLASS
		// loading a class by knowing its class file
		Class c1, c2=null;
		c1 = week13_Reflection.Tester.class; // fully qualified path
		
		// equivalent way that requires try-catch
		try {
		 c2 = Class.forName("week13_Reflection.Tester");
		} catch (Exception e){System.out.println(e);};
		
		System.out.println(c1.hashCode() + "\n" + c2.hashCode());
		
		
		// INSTATIATING A CLASS
		// instantiating  another class of the same package
		
		week13_Reflection.TesterExtra t = new week13_Reflection.TesterExtra();
		week13_Reflection.ClassInfo ci = new week13_Reflection.ClassInfo();
		// another method to instantiate a class // in trycatch
		try {
				//Tester cii = (Tester) Class.forName("lectures.Week13.Tester").newInstance();
			Object oii =  Class.forName("week13_Reflection.Tester").newInstance();
		} catch (Exception e){};
		System.out.println(ci + "\n" + ci.hashCode());
		ci.printInfo(t.getClass(), 0);
		ci.printInfo(ci.getClass(), 0);
	}
	
	/* 
	 * The difference between .TYPE and .class
	 */
	void method2() {
		//Class c1 = Integer.class; //  will print: not equal
		Class c1 = Integer.TYPE;   // will print equal
        Class c2 = int.class;
        if (c1 == c2)
           System.out.println("equal");
        else 
        	System.out.println("not equal");
	}
	
	/**
	 * Calls ClassInfo
	 *
	 */
	void method3() {
		
		ClassInfo ci = new ClassInfo(); 
		
		String args[] = {
				//"java.lang.Object", "reflection.ClassInfo", 
    			//"java.util.Vector", "java.io.Serializable", 
    			//"java.lang.Cloneable","java.lang.reflect.Array",
    			//"javax.swing.JOptionPane",
    			//"lectures.Week13.Person"};
				"week13_Reflection.CCC"};
		
    
        for(int i = 0; i < args.length; i++) {
            try {
            	System.out.println("===============================");
            	ci.printInfo(Class.forName(args[i]), 0);
            	
            	Constructor[] conss = Class.forName(args[i]).getDeclaredConstructors();
            	for (Constructor c: conss) {
            		System.out.println(c);
            	}
            	
            	
            } catch(ClassNotFoundException e) {
                System.err.println(e); // report the error
            }
        }
	}
	
	
	/**
	 * System properties
	 *
	 */
	void method4() {
		Properties ps = System.getProperties();
		ps.list(System.out);
		
	}
	
}


class TesterExtra {
	public static void main(String[] a){
		smallTests sm = new smallTests();
		
		sm.method1(); // loading a .class  and using Class.forName()
		//sm.method2(); // primitive types
		//sm.method3(); // class info printing
		//sm.method4(); // method properties
		
	}
}