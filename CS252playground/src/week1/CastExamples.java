package week1;



class CastExamples {
	public static void main(String[] lala) {
		
		byte b 	= (byte) 256;		// OK???
		int n 	= (int) .999;		// OK???
		
		System.out.println(b);
		System.out.println(n);
		
		
		 b 	= (byte) 1256;		// OK???
		 n 	= (int) 5.29;		// OK???
		
		System.out.println(b);
		System.out.println(n);
	    
		
	}
}