package week6_Exceptions.selectedExamples;

public class ExtremeAPP {
	
	static void infiniteLoop() {
		while(1==1)
			infiniteLoop();
		
	}
	
	public static void main(String[] lala) {
		System.out.println("I AM STARTING");
		try {
			//int[] pi = new int[1000*1000*1000*1000]; // int overflow exception
			int[] pi = new int[1000*1000*1000]; // heap space
			
			//infiniteLoop(); // stackOverflow error	
			double d = 1/0;	
			//System.out.println(1/0); // arithmetic exception
		
			//throw new Error();
		} catch (Throwable e) { 
			// code to fix the problem exception
			//System.out.println("Μην ανησυχείς για το " + e);
			
		};
		System.out.println("Όλα καλά, συνέχισε έτσι!  (έχω περάσει το ΗΥ252)");
	}
}
