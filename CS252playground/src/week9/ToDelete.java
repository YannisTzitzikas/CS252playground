/**
 * 
 */
package week9;

import java.util.*;

/**
 * @author Yannis Tzitzikas (yannistzitzik@gmail.com)
 *
 */
class Otinanai implements Comparable {

	
	public int compareTo(Object arg0) {
		
		return -1;
	} };
public class ToDelete {

	public static void main(String[] lala) {
		
		Set s  = new TreeSet();
		s.add(2); s.add(1);
		System.out.println(s);
		
		Set s2  = new TreeSet();
		s2.add(new Otinanai());
		s2.add(new Otinanai());
		System.out.println(s2);
		
		
		
	}

}
