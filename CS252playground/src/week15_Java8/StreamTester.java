package week15_Java8;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//reduction
/*
The accumulator function takes two parameters: 
a partial result of the reduction (in this example, 
the sum of all processed integers so far) and the next element of the stream 
(in this example, an integer). It returns a new partial result. In this example, 
the accumulator function is a lambda expression that adds two Integer values and returns an Integer value:
(a, b) -> a + b
*/

class StreamBuilders {
     public static void main(String[] args){
    	     	 
    	 List<String> input = Arrays.asList
    	        ("Today ", "is ", "Tuesday ", "18 ", "of ", "December ", "2018");
    	
    	   // Sequential     	
    		String output2 =  input.stream()
					  .filter(e -> {
						 System.out.println("FILTER:" + e);
						 return true;  
					  })
					  .reduce("", (s1,s2) -> 
					  { System.out.println("REDUCE: s1="+s1+", s2="+s2);
					    return   s2+s1;}) ;
	       System.out.println("\nOutput2: "+ output2);

	   	  System.out.println("==================");
	       
	   	  /*
	   	  // Parallel 
	       String output1 =  input.parallelStream()
					  .filter(e -> {
						 System.out.println("FILTER:" + e);
						 return true;  
					  })
					  .reduce("", (s1,s2) -> 
					  { System.out.println("REDUCE: s1="+s1+", s2="+s2);
					    return   s2+s1;}) ;
	       System.out.println("\nOutput1: "+ output1);
	       */
     }
}
