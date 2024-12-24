package week15_Java8;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Examples with method references
 * @author Yannis Tzitzikas (yannistzitzik@gmail.com)
 *
 */
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
		Function<String,Person>   kataskeuastisProswpwn = Person::new;  // f: A -> B, edw: f: String -> Person
			
		// A list of Strings
		List<String> nameList =  Arrays.asList("Yannis", "Nikos", "Maria");
		// We want to create one object for each of the above strings
		// and that string to the constructor
		
		// without Java 8 features
		for (String n: nameList) 
			new Person(n);
		
		// Calling a constructor for each element in the list
		// 1st Method
		nameList.forEach(x -> new Person(x));
		
		// 2nd Method
		nameList.forEach(Person::new);
		
		// 3rd Method  (the Function was a default method apply)
		nameList.forEach(kataskeuastisProswpwn::apply);
		
		
		//Consumer =
		
		
		// CALLLING System.out.println  for each elem of a list of Strings
		
		//nl.forEach(x -> System.out.println(x));
		//nl.forEach(System.out::println);			
		//Consumer<String>  toS = System.out::println;
		//nl.forEach(toS);
		
		Function<Set<Set<Integer>>,List<Person>>   lala2;
		System.out.println(new Person("telos"));
		
		final int K =5;
		ArrayList al = new ArrayList();
		nameList.forEach(x -> {  
			Person p = new Person(x);
			al.add(p);
			System.out.println(K + ">>>" + al);
			//al = new ArrayList();
			} );
		
		toDelete();
		
	}

	static void toDelete() {
		Function<String,Integer> lala = x -> {  System.out.println(2);return 2; };  // f: String -> Integer, f(x) =2 
		List<String> tmp =  Arrays.asList("Yannis",  "Maria");
		tmp.forEach(lala::apply);
		
	}
}



