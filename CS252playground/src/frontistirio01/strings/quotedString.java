package frontistirio01.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class quotedString {
	
	public static void main(String[] Args)
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		
		System.out.println(QuotedString("Simera tha kanoume <JAVA>",'<','>'));
	
		
	}
	
	
	public static String QuotedString(String from, char start,char end)

	{
		int startPos = from.indexOf(start);
		int endPos = from.lastIndexOf(end);
		
		if(startPos == -1)  
			return null; // no start found
		else if(endPos == -1)            // no end found
			return from.substring(startPos); 

		else                      // both start and end found
			return from.substring(startPos, endPos + 1);
		
	
	}

}
