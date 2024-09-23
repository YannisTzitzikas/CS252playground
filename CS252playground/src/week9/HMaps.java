package week9;
import java.util.*;
import java.awt.*;

class PPerson {
	
}

class HMapTests {
	public static void main (String[] arg){
		Map fc = new HashMap();
		fc.put("maria","aspro"); //   x, f(x)
		fc.put("maria","prasino");
		fc.put("maria","prasino");
		fc.put("yannis","blue");
		fc.put("nikos","white");
		fc.put("manousos","red");
		System.out.println(fc);
		
		System.out.println("Κλειδιά        : " + fc.keySet());
		//System.out.println("Κλειδιά (τξν)  : " + new TreeSet(fc.keySet()));
		System.out.println("Τιμές          : " + fc.values());
		//System.out.println("Τιμές (συν)    : " + new HashSet(fc.values()));
		//System.out.println("Τιμές (συν+τξν): " + new TreeSet(fc.values()));
	
		Map fc2 = new HashMap();
		fc2.put("Tom", "blue");
		fc2.put("Jane", "black");
		fc2.put("nikos","orange");
		System.out.println(fc2);
		
		fc.putAll(fc2); // union (with overwritting the existing keys if they exist)
		System.out.println(fc);
		
		
			
		Object o = fc.remove("nikos"); // δεν υπάρχει τέτοιο κλειδί
		System.out.println(fc);
		System.out.println(o);
		
		
		
		System.out.println("Κλειδιά        : " + fc.keySet());
		System.out.println("Κλειδιά (τξν)  : " + new TreeSet(fc.keySet()));
		System.out.println("Τιμές          : " + fc.values());
		System.out.println("Τιμές (συν)    : " + new HashSet(fc.values()));
		System.out.println("Τιμές (συν+τξν): " + new TreeSet(fc.values()));
		
		
		
		System.out.println("Printing entrySet()");
		System.out.println(fc.entrySet());
		
		System.exit(1);
		/*
		System.exit(2);
		*/
		/*
		Map favoriteColors = new HashMap();
		//Map<String,Color> favoriteColors = n
        
		
		
		//Adding an association (key-value pair)
		favoriteColors.put("Juliet", Color.pink);
		favoriteColors.put("Romeo", Color.blue);
		favoriteColors.put("Σάββας", 10);
		favoriteColors.put("Σάββας", Color.blue);
		Object[] pinakas = {"Σήμερα", "Εχθές"};
		favoriteColors.put("Σάββας", pinakas);
		favoriteColors.put("Λλαλαλαλα", 10);
		
		System.out.println("\n" +favoriteColors);
		
		
		System.out.println("===>>>" +
				Arrays.toString(((Object [])favoriteColors.get("Σάββας"))));
		
		 
		//Changing an existing association 
		favoriteColors.put("Juliet",Color.red);
		System.out.println("\n" + favoriteColors);
		
		//Getting the value associated with a key 
		Color julietsFavoriteColor = (Color) favoriteColors.get("Juliet"); 
		System.out.println("\n Juliet's favorite color is: " + julietsFavoriteColor);
		
		//Removing a key and its associated value
		favoriteColors.remove("Juliet"); 
		System.out.println("\n" + favoriteColors);
		
		
		favoriteColors.put("Tom", Color.white);
		favoriteColors.put("Mary", Color.green);
		
		//Printing key/value Pairs
		Set keySet = favoriteColors.keySet(); //get the set of keys
		//Set valueSet = favoriteColors.values(); 
	
		// iterate through the set of keys 
		Iterator iter = keySet.iterator(); 
		while (iter.hasNext()) { 
			Object key = iter.next(); 
			Object value = favoriteColors.get(key);     
			System.out.println(key + "->" + value); 
		}; 
		
		
		for (Object c: favoriteColors.keySet())
			System.out.println("\t" + c);
			
	   
		*/
  }
}