package week15_Java8;
import java.util.List;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Arrays;

public class B_LambasFirst {
 public static void main(String[] args) {
	 
	 System.out.println("============lambda with one statement==============");
	 ArrayList<Integer> al = new ArrayList();
	 al.add(1);
	 al.add(2);
	 al.add(30);
	 al.add(77);
	 
	 al.forEach(x -> System.out.println("Το τεγράγωνο του "+x + " είναι " + x*x));
	
	 System.out.println("========lambda with a block of statements===========");
	List<Double> lf = Arrays.asList(9.0,55.0,10.5);
	lf.forEach(x -> {
		double riza = Math.sqrt(x);
		System.out.print(riza);
		for (int j=0; j< riza; j++)
			System.out.print(".");
		System.out.println();
	}); 
	
	
	System.out.println("========lambda with variable capture===========");

	String author = "Yannis";
	
	lf.forEach(x -> {
		System.out.println(author + x);
	}); 
	//author = "Yannis2";  // not ok
	
	
	System.out.println("========lambda with NOT OKvariable capture===========");
	
	for (int j=100; j<102; j++)
		lf.forEach(x -> {
			//System.out.println(j + x); // J is not final or effectively finail
		}); 
	
	
	System.out.println("========Streams example===========");
	
	al.forEach(x -> System.out.print(x+","));
	
	int sum = al.stream().map(x -> x*x).reduce((x,y) -> x + y).get();
    
	System.out.println(" the sum of their squares is: " + sum);
	
	
	System.out.println("========Streams parallel===========");
	
	
	System.out.print("\nSequential printing:");
	al.stream().forEach(x -> System.out.print(x+","));
		
	System.out.print("\nParallel   printing:");
	al.stream().parallel().forEach(x -> System.out.print(x+","));
	
	//System.out.println();
	//al.stream().parallel().forEach(x -> System.out.print(x+","));
	
	//=================================================
	/*
	System.out.println();
	String test = Stream.of("a", "b", "c", "d")
		    .reduce(">", (x1,x2)-> {
		    								System.out.println("x1="+x1+" x2="+x2 + " cur="+x2+x1);
		    								return x2 + x1;
		    							 } );
		System.out.println(test);    
	*/	
 }
}
