package week11_InnerClasses;
/**
 * Example of member inner class.
 * The example indicates the use of "this" and "new"
 * @author tzitzik
 *
 */
 class A_EnclosingClass {
	private int i=-2,j=-2;
	private int z=18;

		 //private or public class MemberClass {
		 public class MemberClass {
			 private int i=20;  
			 public int j=20; 
	
			  public void aMethod( int i ) {
			   int a = i;                    // Assign param to a
			   int b = this.i;               // Assign member's i to b
			   int c = A_EnclosingClass.this.i;// Assign top-level's i to c
			   int d = j;                    // Assign top-level's j to d
			   System.out.println("i="+i);
			   System.out.println("this.i="+this.i);
			   System.out.println("EnclosingClass.this.i="+A_EnclosingClass.this.i);
			   System.out.println("j="+j);
			   z=20;
			  }  
		  }

	  public void aMethod() {
	   MemberClass mem = new MemberClass();
	   mem.aMethod( 10 );
	   System.out.println("mem.i+mem.j="+ (mem.i + mem.j) );  // is this a bug?
	  }
	}

class EnclosingClassTester {
	
	public static void main(String a[]){
		
		A_EnclosingClass obj1 = new A_EnclosingClass();
		obj1.aMethod();
		
		/*
		A_EnclosingClass ec = new A_EnclosingClass();
		ec.aMethod();
		
		// creation of instances of a member class
		A_EnclosingClass.MemberClass b; // definition of the variable's type
		//b = new EnclosingClass.MemberClass(); // WILL NOT WORK (no enclosing instance)
		b = ec.new  MemberClass(); // WORKS
		b.aMethod(7);
		//A_EnclosingClass.MemberClass d = new MemberClass(); // does not work
		
		A_EnclosingClass.MemberClass test = (new A_EnclosingClass()).new MemberClass();
		*/
	}
}
