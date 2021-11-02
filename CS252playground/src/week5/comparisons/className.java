package week5.comparisons;
import java.util.Vector;
import java.util.Collection;
import java.util.*;

class Name implements Comparable {
    private String first;
    private String last;
    public Name(String firstName, String lastName ) {
		first = firstName;
		last = lastName;
    }
    public String getFirst() {
    	return first;
    }
    public String getLast() {
    	return last;
    }
    
     public String toString() {
    	return first + " " + last;
     }
     
     public int compareTo( Object o ) throws      ClassCastException {
		int retval;
		Name n = ( Name ) o;
		retval = last.compareTo( n.getLast() );
		if ( retval == 0 ) // i.e. if the last names are the same;
		  retval = first.compareTo( n.getFirst() );
		return retval;
     }
     public Name() {
	}
}     

     class   classNameTest {
    		public static void main (String[] a){
    			Name n1 = new Name("Yannis","Tzitzikas");
    			Name n2 = new Name("Yannis","ATzitzikas");
    			Name n3 = new Name("AYannis","ATzitzikas");
    			//System.out.println(n1.compareTo(n2));
    			Vector v = new Vector();
    			v.add(n1); 
    			v.add(n2);
    			v.add(n3);
    			Collections.sort(v);
    			System.out.println(v);
    		}
    	}

