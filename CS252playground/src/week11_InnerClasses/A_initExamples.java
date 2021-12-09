package week11_InnerClasses;

class A { 
  int f=1; 
  int g=11;
}
class B { 
  int f=2;
  int g=22;
  class C extends A { 
	int g=33;
    void m() {
      System.out.println("f:" + f); // Poio f tha typwsei ? 
      						 // Ths encolosing (B) 'h ths super (A)??
      						 // Apanthsh: ths super (ara tha typwsei 1)
      System.out.println("super.f:"+ super.f); // Profanws tha typwsei ths super (i.e. 1)
      System.out.println("B.this.f:"+ B.this.f); // Tha typwsei ths enclosing, ara to 2
      System.out.println("g:"+g);
      System.out.println("B.this.g:"+B.this.g);
      System.out.println("super.g:"+super.g);
    }
  }
}


class testerClass {
	public static void main(String lala[]){
		B b = new B();
		//System.out.println(b.f);  // prints 2
		//B.C  c = new B.C(); // WRONG! no enclosing object of B
		B.C  c1 = b.new C();  // CORRECT
		c1.m();
		//System.out.println( c1.f); // Tha parw 1 (ara to f ths  klasshs A)
		
		//*
		A a = new A();
		A a1 = new A(){  void boom(){System.out.println("Boom");} };  
		
		
	}
}