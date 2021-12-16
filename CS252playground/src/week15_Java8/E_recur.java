package week15_Java8;
import java.util.Arrays;
import java.util.List;

class D {
	public static void main(String[] args){
		
		List<Double> lista = Arrays.asList(9.0,55.0,10.5);

		//Iterable<Double> ii = x -> {System.out.println(x);};
		
		lista.forEach(x -> {
			System.out.println(x);
		});
	}
}

