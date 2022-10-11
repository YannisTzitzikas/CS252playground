package week1;


/**
 * 
 * @author Yannis Tzitzikas (yannistzitzik@gmail.com)
 *  ....
 */


class Person {
	String name="Nikos";
}

class CastExamples {
	public static void main(String[] lala) {
		
		Object[] pinakas = new Object[10];
		
		pinakas[0]="Hello";
		pinakas[1]=3;
		
		for (Object c: pinakas) {
			System.out.println(c);
		}
		
		/*
		
		Person p1 = new Person();
		Person p2 = new Person(); p2.name="Maria";
		
		//Person 
		p2 = p1; 
		
		if (!s1.equals(s2)) 
		
		p1.name="Manousos";
		System.out.println(p2.name);
		
		/*
		
		byte b 	= (byte) 256;		// OK???
		int n 	= (int) .999;		// OK???
		
		System.out.println(b);
		System.out.println(n);
		
		
		 b 	= (byte) 1256;		// OK???
		 n 	= (int) 5.29;		// OK???
		
		System.out.println(b);
		System.out.println(n);
	    
		long i=100000001; // 9 digits
		float x;
		x=i;
		System.out.println("x="+x);
		
		String astr;
		
		String bstr = "abcd";
		
		astr = "ab"+"cd";
		
		System.out.println(astr==bstr);
		
		
		System.out.println(astr.equals(bstr));
		*/
		
		
	}
}