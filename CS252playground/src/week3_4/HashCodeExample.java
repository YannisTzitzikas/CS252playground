package week3_4;

import java.util.ArrayList;

interface IPlugin { };

class Proion implements IPlugin {
	
	 public int hashCode() {
		 return 0;
	 }
	
	  public boolean equals(Object o ) {
	 
		if (o instanceof Proion) {
			Proion o2 = (Proion) o;
			// this.name.equals(o2.name);
			return (this.name.equals(o2.name)); 
		}
		return false;
	}
	
	static int count=0;
	int price=0;
	float test = 0;
	String name = "Non available";
	String importer; 
	Proion(){
		count++;
	}
	protected void finalize(){
	       --count; 
	}
	
	String test() {
		return getClass().getName() + '@' + Integer.toHexString(hashCode());

	}
}

class HashCodeTester {
	public static void main(String[] lila) {
	/*	
		try {
			//Class test = Class.forName("java.awt.MenuContainer");
			Class test = Class.forName("lectures.Week4.Proion");
			  System.out.println(test.getDeclaredFields());
			  System.out.println(test.getDeclaredFields().length);
			  for (Object o: test.getDeclaredFields())
				  System.out.println(o);
			} catch(Exception e) {
				System.out.println("Exception: " + e);
			}
			/*
			 * 
			 */
	
	///*
	System.out.println("p1:");
	Proion p1 = new Proion();
	p1.name ="apple";
	System.out.println(p1);
	System.out.println(p1.hashCode());
	System.out.println(p1.toString());
	System.out.println(p1.test());
	//System.out.println(p1.getClass());
	
	Proion p2 = new Proion();
	p2.name = "apple";
	System.out.println(p1.equals(p2));
	
	
	Proion  p3 = new Proion() {
		public int hashCode() {
			 return -1;
		 }
	};
	Proion  p4 = new Proion() {
		public int hashCode() {
			 return -2;
		 }
	};
	System.out.println(p3.hashCode());
	System.out.println(p4.getClass());
	System.out.println(p4.getClass().getSuperclass());
	System.out.println(p4.getClass().getSuperclass().getSuperclass());
	System.out.println(p4.getClass().getSuperclass().getSuperclass().getSuperclass());
	
	for (Object o: p1.getClass().getInterfaces())	
		System.out.println("\t :"+o);
	
	
	
	
	ArrayList dynamicList = new ArrayList();
	dynamicList.add(p1);
	dynamicList.add(p2);
	dynamicList.add(new Integer(5)); // auto-boxing (twn protarxikwn typwn)
	dynamicList.add(5);
	
	
	
	
	System.out.println(dynamicList);
	for (Object o: dynamicList)	
		System.out.println(o);
	/*
	
	// p2
	System.out.println("p2:");
	Proion p2 = new Proion();
	p2.name ="ap"+"ple";
	System.out.println("------");
	System.out.println(p2);
	System.out.println(p2.toString());
	System.out.println(p2.hashCode());
	System.out.println(p2.getClass());
	
	
	System.out.println(">>" + p2.getClass().getName() 
			+ '@' + Integer.toHexString(p2.hashCode()));

	
	
	System.out.println(p1.equals(p2));
	
	//Proion p3 = (Proion) p1.clone();
	 
	*/
	//System.out.println(Proion.count);
	//p1 = null;
	//p2 = null;
	//System.out.println(Proion.count);
	
	
	}
}
