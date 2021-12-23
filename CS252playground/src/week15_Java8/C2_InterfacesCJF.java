/**
 * 
 */
package week15_Java8;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Yannis Tzitzikas (yannistzitzik@gmail.com)
 *
 */
public class C2_InterfacesCJF {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
				
		List  l = new LinkedList();
		l.add("2");
		l.add("12");
		
		for (Object o: l)
			System.out.println(o);
		
		Consumer cons = x -> {System.out.println("BOOM"+x);};
		
		
		l.forEach(System.out::println);
	
		l.forEach(cons);

	}

}
