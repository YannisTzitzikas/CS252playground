package week6_Exceptions.selectedExamples;

class Exception1 extends Exception {}
class Exception2 extends Exception {}
class Exception3 extends Exception {}

 class C1{
	 public void method1() throws Exception1, Exception2{
	  try{
	   System.out.println("m1_1");
	   //some code here that will randomly throw Exception1,2,or3
	   if (Math.random()<=0.3)
		   throw new Exception1();
	   if (Math.random()<0.6)  
		   throw new Exception2();
	   if (Math.random()<0.9)  
		   throw new Exception3();
	      
		
	   System.out.println("m1_2");
	  }catch(Exception3 e3){
	   System.out.println("m1_3");
	  }
	  System.out.println("m1_4");
	}
	public void method2() throws Exception1{
	 try{
	   method1();
	   System.out.println("m2_1");
	 }catch(Exception2 e2){
	   System.out.println("m2_2");
	 }
	 System.out.println("m2_3");
	}

	public void method3(){
	 try{
	   method2();
	   System.out.println("m3_1");
	 }catch(Exception1 e1){
	   System.out.println("m3_2");
	 }
	 System.out.println("m3_3");
	}
 }
 
	 class Tester {
	  public static void main(String[] a){
	    C1 c = new C1();
	    c.method3();
	  }
}
