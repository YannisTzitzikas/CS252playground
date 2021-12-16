package week15_Java8;

interface A {
    default void foo(){
       System.out.println("A.foo() default");
    }
}

interface B {
    default void foo(){
       System.out.println("B.foo() default");
    }
}

interface C extends B {
	abstract void foo() ;
}

class  C1 implements B { }
//class  C2 implements C { }

class TESTER implements A, B {
	
	public void foo() {
		System.out.println("TESTER.foo()");
		A.super.foo() ;
		B.super.foo() ;
		
	}
	
	
	
	public static void main(String[] a) {
		System.out.println("=[Hello]=");
		
		TESTER tester = new TESTER();
		tester.foo();
	}
	
}
