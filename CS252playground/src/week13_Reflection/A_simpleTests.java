package week13_Reflection;
import java.io.Serializable;
import java.lang.reflect.*;

/**
 * 
 * @author tzitzik
 * REFLECTION
 * A very simple example showing how from an object
 * we can get information about its class, the superclass
 * of that class, as well as the interfaces that its class implements.
 * In addition the attributes of a class
 */

interface dummyTop {}
interface dummy extends dummyTop {}

class DummySuperclass {
	int lala;
}

class Person extends DummySuperclass implements dummy, Serializable {
	  String name = "anonymous";
	  private int age ;
	  public float d1, d2, d3, d4, d5, d6;
	  static int numOfPersons;
	  public Person(){
		  System.out.println("Creation of new object");
	  }
	  public Person(String n, int a){
		  name= n;
		  age = a;
	  }
	  public String toString(){
		  return name + " " + age ;
	  }	  
}

class Student extends Person {}


/**
 * @author tzitzik
 *
 */
class Tester {
	public static void main (String[] arg){
		  Person p0 = new Person("Yannis",20);
		  Object p1 = p0; // you can access only those fields and methods defined by Object
		  
		  //-------
		  	  
		  Class c = p1.getClass();   // Person class
		  System.out.println(c);
		  
		  
		  
		  Class supc = c.getSuperclass();  // superclass of Person
		  
		  System.out.println("Class name   : " + c.getName());
		  System.out.println("Supclass name: " + supc.getName());
		  System.out.println("Supsupclass name: " +   supc.getSuperclass().getName());
		  // System.out.println("Supsupsupclass: " +   supc.getSuperclass().getSuperclass());
		  //System.out.println(supc.getSuperclass().getSuperclass().getName());
		  
		 
		  System.out.println("Interfaces   : ");
		  Class[] ci = c.getInterfaces();
		  for (int i=0; i<ci.length;i++){
			  System.out.print(ci[i].getName()+ " ");
			  //System.out.println(">>>"+ ci[i].getSuperclass().getName() + ci[i].getInterfaces().getName());
		  }
		  
		  System.out.println();
		  Field[] pf = c.getDeclaredFields();
		  System.out.println("Fields       : ");
		  for (int i=0; i<pf.length;i++){
			  System.out.println("\t\t Field : " + pf[i].getName()  
					  + " | " + pf[i].getModifiers()
					  + " | " + pf[i].toString());
		  }
		  
		  System.exit(1);
		  
		  //Class[] parameterTypes1 =   {String.class, int.class};
		  //Class[] parameterTypes2 = new Class[] {String.class};
		  
		  Class[]  pinakas = new Class[2]; pinakas[0]=int.class; pinakas[1]=char.class;
		  Class[]  pinakas2 = {int.class, char.class};
		  Object[] pinakas3 = {int.class, char.class};
		  //Class[]  pinakas4 = (Class[]) pinakas3;
		 
		  
		  
    }
}