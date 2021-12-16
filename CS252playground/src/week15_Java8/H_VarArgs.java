/**
 * 
 */
package week15_Java8;

/**
 * @author Yannis Tzitzikas (yannistzitzik@gmail.com)
 *
 */
public class H_VarArgs {
	
	public static double average(double... numbers ) {
		double total = 0.0; // initialize total
		// calculate total using the enhanced for statemen
	
		
		double[] tmp = new double[2];
		System.out.println(numbers.getClass());
		System.out.println(tmp.getClass());
		tmp = numbers;
		System.out.println("->"+ tmp[1]);
		
		for ( double d : numbers ) 
			total += d;
		return total / numbers.length;} // end method average


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(
		average(2) + " " +
		average(2,3)
		);

	}

}
