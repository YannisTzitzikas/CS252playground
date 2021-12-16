package week15_Java8;

interface AAAA {  
 default void foo(){System.out.println("A.foo() default");     } }
interface BBBB {     
  default void foo(){System.out.println("B.foo() default");     } }

interface CCCC extends AAAA, BBBB {
  //abstract void foo() ;  // it makes it again abstract
  default void foo()  {
	  AAAA.super.foo();
	  BBBB.super.foo();
  };  
}
