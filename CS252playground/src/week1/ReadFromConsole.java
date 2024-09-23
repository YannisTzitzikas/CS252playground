/**
 * 
 */
package week1;

import java.util.Scanner;

/**
 * @author Yannis Tzitzikas (yannistzitzik@gmail.com)  
 *
 */
public class ReadFromConsole {

	 public static void main(String[] lala) {
		 System.out.println("READING FROM CONSOLE");
		 
		 
		
		 System.out.print("Give me a string: ");
		 Scanner in = new Scanner(System.in);
		 String s = in.next(); 
		 System.out.println("You typed " + s);
		 
		 
		 System.out.print("Give me an integer: ");
		 int a = in.nextInt();
		 System.out.println("You typed " + a);

		 // input checking method
		 
		 a=-1;
		 do {
		  System.out.print("Give me a positive integer integer: ");
		  s = in.next();
		  try {
	            a = Integer.parseInt(s);
	            System.out.println(s + " is a valid integer");
	        } catch (NumberFormatException e) {
	            System.out.println(s + " is not a valid integer");
	        }
		 } while (a<0); 
		 System.out.println("\nBye bye");
	 }

}
