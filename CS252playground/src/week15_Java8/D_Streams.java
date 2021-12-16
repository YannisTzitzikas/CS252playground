package week15_Java8;
/**
 * This file contains some examples from
 *  http://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class D_Streams {
 public static void main(String[] args) {
	 
	 System.out.println(" ////////////////////////////////////////////////////////////////////////////////////");
	 List<String> myList =
			    Arrays.asList("a1", "a2", "b1", "c2", "c1");

			myList
			    .stream()
			    .filter(s -> s.startsWith("c"))
			    .map(String::toUpperCase)
			    .sorted()
			    .forEach(System.out::println);

			// C1
			// C2
	System.out.println(" ////////////////////////////////////////////////////////////////////////////////////");	 ////////////////////////////////////////////////////////////////////////////////////
	IntStream.of(42).forEach(System.out::println);
	
	IntStream.range(1, 4)
		    .forEach(System.out::println);

		// 1
		// 2
		// 3		
	System.out.println(" ////////////////////////////////////////////////////////////////////////////////////");
	
	Arrays.stream(new int[] {1, 2, 3})
    .map(n -> 2 * n + 1)
    .average()
    .ifPresent(System.out::println);  // 5.0
	
	System.out.println(" ////////////////////////////////////////////////////////////////////////////////////");
	
	Stream.of("a1", "a2", "a3")
    .map(s -> s.substring(1))
    .mapToInt(Integer::parseInt)
    .max()
    .ifPresent(System.out::println);  // 3
	
	System.out.println(" ////////////////////////////////////////////////////////////////////////////////////");
	IntStream.range(1, 4)
    .mapToObj(i -> "a" + i)
    .forEach(System.out::println);
		
		// a1
		// a2
		// a3
	System.out.println(" ////////////////////////////////////////////////////////////////////////////////////");
	Stream.of(1.0, 2.0, 3.0)
    .mapToInt(Double::intValue)
    .mapToObj(i -> "a" + i)
    .forEach(System.out::println);
	
	// a1
	// a2
	// a3
	System.out.println(" ////////////////////////////////////////////////////////////////////////////////////");
	
	Stream.of("d2", "a2", "b1", "b3", "c")
    .filter(s -> {
        System.out.println("filter: " + s);
        return true;
    })
    .forEach(s -> System.out.println("forEach: " + s));
	/*WILL RETURN
	 * filter:  d2
		forEach: d2
		filter:  a2
		forEach: a2
		filter:  b1
		forEach: b1
		filter:  b3
		forEach: b3
		filter:  c
		forEach: c
	 */
	
	System.out.println(" ////////////////////////////////////////////////////////////////////////////////////");
	Stream.of("d2", "a2", "b1", "b3", "c")
    .map(s -> {
        System.out.println("map: " + s);
        return s.toUpperCase();
    })
    .anyMatch(s -> {
        System.out.println("anyMatch: " + s);
        return s.startsWith("A");
    });
		
		// map:      d2
		// anyMatch: D2
		// map:      a2
		// anyMatch: A2
			
	System.out.println(" ////////////////////////////////////////////////////////////////////////////////////");
	
	Stream.of("d2", "a2", "b1", "b3", "c")
    .sorted((s1, s2) -> {
        System.out.printf("sort: %s; %s\n", s1, s2);
        return s1.compareTo(s2);
    })
    .filter(s -> {
        System.out.println("filter: " + s);
        return s.startsWith("a");
    })
    .map(s -> {
        System.out.println("map: " + s);
        return s.toUpperCase();
    })
    .forEach(s -> System.out.println("forEach: " + s));
	
	
	
	String test = Stream.of("Τι", "είναι", "αυτό", ";")
	    .reduce("Έναρξη", (x1,x2)-> x2 + x1 );
	System.out.println(test);    
	
	System.out.println(" ////////////////////////////////////////////////////////////////////////////////////");
	System.out.println(" ////////////////////////////////////////////////////////////////////////////////////");
	System.out.println(" ////////////////////////////////////////////////////////////////////////////////////");
	System.out.println(" ////////////////////////////////////////////////////////////////////////////////////");
	System.out.println(" ////////////////////////////////////////////////////////////////////////////////////");
	System.out.println("TELOS");

	Stream<String> lala  = Stream.of("Τι", "είναι", "αυτό", ";");
	System.out.println(lala.reduce("===>", (x1,x2)-> x1 + " " +  x2 ));
	System.out.println(lala.reduce("===>", (x1,x2)-> x1 + " " +  x2 ));	
	
 }
}
