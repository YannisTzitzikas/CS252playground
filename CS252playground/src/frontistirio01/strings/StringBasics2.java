public class StringBasics2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		String s2 = new String("hello students"); 
	
		/*   More Operations on Strings  */
	
		String s7 = s2.substring(0, 5);     //returns the substring of chars in positions from 0 to 5
		System.out.println(s7);
		
		String s8 = s2.substring(6);     //returns the substring of chars from the position 6 to the end
	    System.out.println(s8);
		
		
		String s9 = s7.concat(s8);                //first way to concatenate 
		String s10 = s7 + s8;                     //second way to concatenate
		System.out.println(s9 + " -" + s10);
		int v1 = 3;                        
		s9 += v1;  // s9 = s9 + v1
		//System.out.println(s9);
		
		
		String s11 = "Maria";
		String s12 = "maria";       
		System.out.println(s11.equals(s12));              
		System.out.println(s11.equalsIgnoreCase(s12));    
		String s13 = "Oxford";
		System.out.println(s13.compareTo(s11));    // 2 
		System.out.println(s11.compareTo(s13));    // -2
		System.out.println(s11.compareTo(s12));    // -32 
		System.out.println("Maria".compareTo("Mariam"));  // -1
		
		System.out.println("the hash is " +s11.hashCode());  // a hash function is applied on the string
		
		
		System.out.println(s11.toLowerCase());  
		System.out.println("Hello brothers! ".trim());
		
		String word1 = "father";
		String word2 = word1.replace('f', 'm').replace('a','o');
		System.out.println("from '" + word1 + "' we created '" + word2 + "'");
		
		
		/* String Conversions */
		
		int v2 = 5;
		int v3 = 8;
		String s14 = String.valueOf(v2);  //converting an int to String
		//String s14 = "" + v2;
		int v4  = v3 + Integer.parseInt(s14); 
		System.out.println(v4);
		
		System.out.println(" ------------------ ");
		
		
		
	    /* char */
		/*
		String s15 = "java";
		char a = 'a';       // char
		System.out.println(Character.isDigit(a));  //checks if a char is a digit
		System.out.println(Character.isLetter(a));  //checks if a char is a letter
		
		*/
       //squeeze out of the string the occurrences of a char
		/*
		char[] chars = s15.toCharArray();    // convert a string to array of chars
		int len = chars.length;              //returns the length of an array
		    for(int i = 0; i < len; i++) 
		        if(chars[i] == a) {
		            --len;
		            System.arraycopy(chars, i+1, chars, len-i, 1);
		            --i;  // reexamine this spot
		        }
		System.out.println(new String(chars,0,len));

		System.out.println("-------------------");
		*/

	}

}