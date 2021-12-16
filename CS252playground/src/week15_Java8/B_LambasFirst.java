package week15_Java8;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class B_LambasFirst {
 public static void main(String[] args) {
	 
	 System.out.println("============lambda with one statement==============");
	 ArrayList<Integer> al = new ArrayList();
	 al.add(4);
	 al.add(8);
	 al.add(3);
	 al.add(9);
	 
	 al.forEach(x -> System.out.println(x*x));
	
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
	
	
	al.stream().forEach(x -> System.out.print(x+","));
	
	System.out.println();
	al.stream().parallel().forEach(x -> System.out.print(x+","));
	
	//System.out.println();
	//al.stream().parallel().forEach(x -> System.out.print(x+","));
 }
}
