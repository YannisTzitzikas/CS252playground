/**
 * 
 */
package week3_4;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class StudentCSD implements Cloneable { int AM=7; String name;
    public int hashCode() {  	return AM;  }
	public boolean equals(Object allos){
		return this.AM == ((StudentCSD)allos).AM;  // equality defined as equality of AM
	}
	public Object clone() {
		StudentCSD clonos = null;
		try {
			 clonos = (StudentCSD) super.clone(); 
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clonos;
	}
}
public class TestEquals {
  public static void main(String[] lala) {
	  Object o1 = new Object();
	  Object o2 = new Object();
	  //System.out.println(o1.equals(o2));	  System.out.println(o2.equals(o1));	  System.out.println(o1.equals(o1));	  
	  StudentCSD s1 = new StudentCSD(); s1.name="Yannis";
	  StudentCSD s2 = new StudentCSD(); s2.name="Maria";
	  System.out.println(s1.equals(s2));
	  
	  Set<StudentCSD> aristouxoi = new HashSet<StudentCSD>();
	  aristouxoi.add(s1); aristouxoi.add(s1); aristouxoi.add(s2);  
	  System.out.println(aristouxoi.size());
	  for (StudentCSD s: aristouxoi) {
		  System.out.println(s.name);
	  }
	  //Set synoloArirhmwn = new HashSet();
	  List synoloArirhmwn = new LinkedList();
	  
	  synoloArirhmwn.add(2);
	  synoloArirhmwn.add(8);
	  synoloArirhmwn.add(new Integer(18));
	  synoloArirhmwn.add("lala");
	  synoloArirhmwn.add( new TestEquals());
	  for (Object a: synoloArirhmwn) {
		  System.out.println(a + " " + a.getClass().getName());
	  }
	  
	  StudentCSD  m1 = new StudentCSD(); m1.name ="Papaapapappadopoullllos";
	  StudentCSD  m2 = (StudentCSD) m1.clone();
	  System.out.println(m2.name);
  }
}
