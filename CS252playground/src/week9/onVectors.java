package week9;
import java.util.Vector;
import java.util.Iterator;

/**
 * A few basic examples of using Vectors 
 * @author Yannis Tzitzikas (yannistzitzik@gmail.com)
 *
 */
class Person {
	  static private int count =0;
	  String name;
	  public Person(){  count++; name = "Anon#"+ count;}
	  public String toString() {return name + " (is person)";}
}
class Student extends Person {
	public String toString() {return super.toString() + " (is student too)";}
}


class Tester {
	public static void main (String[] arg){
		Person  p1 = new Person();
		Student s1 = new Student();
		
		// PLAIN VECTORS
		System.out.println("PLAIN VECTORS");
		Vector v = new Vector();
		v.addElement(p1);
		v.addElement(s1);
		v.addElement(p1);
		v.addElement(s1);
		System.out.println(v);
		
		
		
		for (int i=0; i < v.size(); i++)
			System.out.println("Position[" +i+ "] = " + v.elementAt(i));
		
		System.out.println(v.lastIndexOf(p1));
		
		
		
		// Alt method of traversal
		for (Object o: v) {
			System.out.println("->" + o);
		}

		

		// Example of Iterators
		System.out.println("Example of Using an Iterator");
		for (Iterator i = v.iterator(); i.hasNext(); )
		   System.out.println(i.next());
		
		
		/*
		
		
		// GENERICS
		System.out.println("GENERIFIED VECTORS");
		Vector<Person> vg = new Vector<Person>();
		vg.addElement(p1);
		vg.addElement(s1);
		vg.addElement(p1);
		vg.addElement(s1);
		System.out.println(vg.toString());
		for (int i=0; i < vg.size(); i++)
			System.out.println(vg.elementAt(i));

		
		// Alt method of traversal
		for (Person o: vg) {
			System.out.println("->" + o);
		}
		*/
		/*
		// Example of Iterators
		System.out.println("Example of Using an Iterator");
		for (Iterator i = vg.iterator(); i.hasNext(); )
		   System.out.println(i.next());
		*/
	}
}