package week9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Basic examples related to Sets
 * @author Yannis Tzitzikas (yannistzitzik@gmail.com)
 *
 */

 class TestCollection {
	public static void main(String args[]) {
   // Create an empty set 
   Collection set = new HashSet();	   
   //Collection set = new LinkedList();
   // Populate the set
   set.add(47);
   set.add(new Integer(47));
   set.add(new Double(3.14));
   set.add(new Character('h'));
   set.add(new Character('h'));
   set.add('h');
   set.add("h");
   Object o  = new Object();
   set.add(o);
   set.add(o);
   set.add(o);
   
   System.out.println("Πληθυκότητα:" + set.size());
   // iterate through the set of keys 
   Iterator iter = set.iterator();
   /*
   System.out.println(iter.next());
   System.out.println(iter.next());
   System.out.println(iter.next());
   System.out.println(iter.next());
   System.out.println(iter.next());
   //System.out.println(iter.next());
   */
   
   //System.exit(1);
    
   
   while (iter.hasNext()) {
   //Assume items are printed in same order 
   //they were put in
	System.out.println(">>>>" + iter.next());
   } // end while
   
  } // end main
} // end TestCollection
