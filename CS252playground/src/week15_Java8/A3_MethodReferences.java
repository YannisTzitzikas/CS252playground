package week15_Java8;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

class Person {
	private static int counter = 0;
	private String nm = null;
	public String toString() { return "Person with number " + (++counter) + " with name: "+ nm ;}
	Person(String nm) {this.nm = nm; System.out.println(this);}
}


class TestMethodReferences {
	public static void main(String[] lala) {
		System.out.println("METHOD REFERENCES EXAMPLES");
		
		// Variable pointing to a constructor
		// https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html
		Function<String,Person>   constr = Person::new;
		
		// A list of Strings
		List<String> nl =  Arrays.asList("Yannis", "Nikos", "Maria");
		
		// Calling a constructor for each element in the list
		// 1st Method
		nl.forEach(x -> new Person(x));
		
		// 2nd Method
		nl.forEach(Person::new);
		
		// 3rd Method  (the Function was a default method apply)
		nl.forEach(constr::apply);
		
		
		Consumer =
		
		
		// CALLLING System.out.println  for each elem of a list of Strings
		
		//nl.forEach(x -> System.out.println(x));
		//nl.forEach(System.out::println);			
		//Consumer<String>  toS = System.out::println;
		//nl.forEach(toS);
	}
	
}