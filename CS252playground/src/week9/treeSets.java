package week9;
import java.util.*;
import java.awt.*;

class TSetTests {
	public static void main (String[] arg){
		System.out.println("==Tests on TreeSets==");
		Set ts = new HashSet();
		ts.add("Yannis");
		ts.add("Yannis");
		ts.add("Yannis");
		ts.add("Nikos");
		ts.add("Yannis");
		ts.add("Ωρίων");
		ts.add("Νικολαος");
		ts.add("Νικος");
		ts.add("Γιάννης");
		ts.add("Αντώνης");
		
		System.out.println(ts.size());
		System.out.println(ts);
		
		Collection aaa = new TreeSet(ts);
		System.out.println(aaa);
		
		Collection ab = new TreeSet();
		ab.add("1");ab.add("2");ab.add("1");ab.add("2");ab.add("1");ab.add("2");
		ab.add("Γιάννης");ab.add("Αντώνης");ab.add("Γιάννης");ab.add("Αντώνης");
		System.out.println(ab);
		
		/*
		
		
		aaa.add("Ζέτα");
		aaa.add("ζέτα");
		aaa.add("Χαρά");
		aaa.add("χαρά");
		System.out.println(aaa);
		
		System.exit(1);
		
		/*
		Collection c = ts;
		System.out.println("As collection: "+ c);
		
		Object[] array = c.toArray();
		System.out.println("As array with size " + array.length + " : "+ array);
		*/
	}
}