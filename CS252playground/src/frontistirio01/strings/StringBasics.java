package frontistirio01.strings;

import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;


public class StringBasics {

	/**
	 * @param args
	 */
	
	private static String s7; //uninitialized string
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/* Constructing three objects (s1, s2, s3) of the class String */

		String s1 = new String();                  //constructor 1, empty string	
		System.out.println("The object s1 is: " + s1);
		
		String s2 = new String("hello"); //constructor 2
		s2 += " students";
		System.out.println("The object s2 is: " + s2);
		
		char[] letters = {'J', 'a', 'v', 'a'};
		String s3 = new String(letters);        //constructor 3, array of chars
		System.out.println("The object s3 is: " + s3);
		
		System.out.println("------------------------");
		
		/*   Basic operations on strings */
		
		System.out.println(s2.length());
		System.out.println(s2.charAt(10));  // what if s2.charAt(14) ?
		
		/*for(int i = 0; i < s2.length(); i++){
			System.out.println(s2.charAt(i));
		}
		*/
		//recall: s2 = "hello students"
		
		int firstPos = s2.indexOf("l");
		System.out.println("The index of the first occurence of 'l' is " + firstPos);
		int lastPos = s2.lastIndexOf("l");
		System.out.println("The index of the last occurence of 'l' is " + lastPos);
		System.out.println("The distance between the first and the last occurence of the letter 'l' is "+ (lastPos - firstPos));
		
		
		int firstPos2  = s2.indexOf("students");
		System.out.println("The position of the word 'students' is " + firstPos2);  //what if the seeking word does not exist in the string?
		
		
		/* Literal Strings*/
		/*
		String s4 = "Hello java";      //no constructors
		String s5 = "";                 //empty string
		s5 = "Hello java"; 
		*/
		
		/* Literal strings vs object strings*/
 
		//System.out.println(s4 == s5);       //compares whether the references to the objects are equal
		//System.out.println(s4.equals(s5));  //compares the values of the string objects 
		
		//String s6 = new String("hello students");
	//	System.out.println(s2 == s6);            //compares whether the references to the objects are equal
		//System.out.println(s2.equals(s6));       //compares the values of the string objects 
	
	
		/* Uninitialized String */
		
		//System.out.println(s7);   // null
		
		
		
		
		 
	
	}
	
	

}
