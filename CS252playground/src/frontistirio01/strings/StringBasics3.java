
public class StringBasics3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* Construction of StringBuffers */
		
		StringBuffer buf1 = new StringBuffer();         //empty, default capacity 16 characters
		StringBuffer buf2 = new StringBuffer(10);       //empty, initial capacity 10 characters
		StringBuffer buf3 = new StringBuffer("hello");  // with a string and capacity length(string) + 16

		System.out.println(buf1.capacity());
		System.out.println(buf2.capacity());
		System.out.println(buf3.capacity());
		
		System.out.println(buf3);
		buf3.setLength(4);
		System.out.println(buf3);
		buf3.setLength(10);
		System.out.println(buf3);
		buf3.setLength(4);
		
		//String s = buf3.append(buf3).append("!").toString();  //converting 
		//System.out.println(s);
	
		buf3.insert(4, "o students");
		System.out.println(buf3);
		
		System.out.println("----------------");
		
		/* StringBuffer VS String  */
		
		System.out.println("Compare the times!");
		
		long start1 = System.nanoTime();
		String str = new String ("string  ");
		for (byte i=1;i<100;i++){
		    str += i;
		}
		long end1 = System.nanoTime();
		System.out.println("To built the String object and append it 100 times needs: " + (end1-start1) + " ns");
		
		
		long start2 = System.nanoTime();
		 StringBuffer strBuff = new StringBuffer ("StringBuffer ");
		for (byte i=1;i<100;i++){
		     strBuff.append(i);
		}
		long end2 = System.nanoTime();
		System.out.println("To built the StringBuffer object and append it 100 times needs: " + (end2-start2) + " ns");

		
	
	
	   /* StringTokenizer */
		/*
		String s16 = "Hello boys and girls";
		String s17 = "13-43242-232";
		StringTokenizer st1 = new StringTokenizer(s16); // constructor 1, uses a default delimiter of “ \n\t\r”
		StringTokenizer st2 = new StringTokenizer(s17, "-"); // constructor 2
		
		while(st1.hasMoreTokens())
		{
		System.out.println(st1.nextToken());
		}
		
		while(st2.hasMoreTokens())
		{
		System.out.println(st2.nextToken());
		}

		*/

	}

}




