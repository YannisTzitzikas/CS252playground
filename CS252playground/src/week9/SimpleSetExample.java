package week9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.TreeSet;

/**
 * Basic examples related to Sets
 * @author Yannis Tzitzikas (yannistzitzik@gmail.com)
 *
 */

 class TestCollection {
	public static void main(String args[]) {
   // Create an empty set 
   //Collection collection = new ArrayList();	   // test Set and ArrayList
   //Collection collection = new HashSet();
   Collection collection = new TreeSet();
   
   //Collection set = new LinkedList();
   // Populate the set
   
   collection.add("Yannis");   
   collection.add("Nikos");
   collection.add("Yannis");
   collection.add("Maria");
   
   
   //collection.add(50);   
   //collection.add(47);
   //collection.add(48);
   //collection.add(47);
   
   
   /*
   collection.add(new Integer(47));
   //collection.add(new Double(3.14));
   collection.add(new Character('h'));
   collection.add(new Character('h'));
   collection.add('h');
   collection.add("h"); //string
   Object o  = new Object();
   collection.add(o);
   collection.add(o);
   collection.add(o);
   */
   System.out.println("Πληθυκότητα:" + collection.size());
   
  // System.exit(1);
   
   // iterate through the set of keys 
   Iterator iter = collection.iterator();
   
   /*
   System.out.println(iter.next());
   System.out.println(iter.next());
   System.out.println(iter.next());
   System.out.println(iter.next());
   System.out.println(iter.next());
   System.out.println(iter.next());
      
   System.exit(1);
   */
   
   while (iter.hasNext()) {
	   //Assume items are printed in same order 
	   //they were put in
	   Object next = iter.next();
	   System.out.println(">" + next + "\t\t of type " + next.getClass());
   } // end while
   
  } // end main
} // end TestCollection   ...
