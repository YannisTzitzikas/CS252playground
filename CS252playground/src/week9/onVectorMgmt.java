package week9;
import java.util.Vector;
import java.util.Iterator;




class vectest {
	public static void main (String[] arg){
		
		Vector v = new Vector();
		v.addElement("Ena");
		v.addElement(2); 
		//v.addElement( new Integer(2)); // wrapper classes
		v.addElement("Tria");
		v.addElement("Tessera");
		System.out.println(v);
		System.out.println("size: " + v.size() + " capacity: "+ v.capacity());
		
		
				
		// Example of overwritting 
		v.setElementAt("X", 1); // Overwrites the reference to "Dyo"
		System.out.println(v);
	
		
		// Example of insertion
		v.insertElementAt("DyoIns", 2);
		System.out.println(v);   ///[ "Ena", "X", "DyoInd" "Tria", "Tessera"
		System.out.println("size: " + v.size());
		
	    		
		// Example of size change:  we reduce size and we loose references
		v.setSize(2);  // 
		System.out.println(v);
		System.out.println(v.capacity());
		
		//	 Example of size change:  we increase size and have null refererences
		v.setSize(12);  // 
		v.addElement("3");
		v.addElement("4");
		System.out.println(v);
		System.out.println("size="+v.size() + " capacity="+v.capacity());
		
		
		
		
		///
		// Example of the automatic doubling the capacity of a vector
		v.setSize(22);  // 
		System.out.println(v);
		System.out.println("size="+v.size() + " capacity="+v.capacity());
		
		
		
		// Example of the capacity shrink
		v.trimToSize();
		System.out.println(v);
		System.out.println("size="+v.size() + " capacity="+v.capacity());

		
		
		
		// Add/remove
		v.addElement("AAA");
		v.removeElement("AAA");
		System.out.println(v);
		System.out.println("size="+v.size() + " capacity="+v.capacity());
	
		
		
		
		
		// Svhnei ola ta nulls		
		System.out.println("Deleting Nulls");
		int i=0;
		while (i < v.size()) {
			if (v.elementAt(i)==null)
				v.removeElementAt(i);
			//i++;  // is this correct?
			else i++;
		}
		System.out.println(v);
		System.out.println("size="+v.size() + " capacity="+v.capacity());
		//System.exit(1);
		
		
		
		
		
		// Svhnei ola ta nulls			
		while (v.contains(null)) {
			v.removeElement(null);
		}
		System.out.println(v);
		System.out.println("size="+v.size() + " capacity="+v.capacity());
		
		System.exit(1);
		
	}
	
}