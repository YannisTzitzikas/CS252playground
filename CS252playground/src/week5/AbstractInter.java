package week5;

interface MaterialObject {
	int getYourMass();  // abstract kai PUBLIC
}

interface LivingBeing extends MaterialObject   {
    abstract public String whatsYourName();
    
}

abstract class Forologoumenos implements  LivingBeing{
	int test() {return 1 + 1 ;}
	abstract int getAMKA(); // {return 0;}
	public int getYourMass() {return 0;}
	
}
class Person extends Forologoumenos implements LivingBeing, MaterialObject {
	int getAMKA() { return  2/0; }
	public String whatsYourName() { return ""; }
}

class Student extends Person {
	
}

class Organismos extends Forologoumenos {
	int getAMKA() { return  2+1; }
	public String whatsYourName() { return "UoC"; }
}

class Foo {
	void bar(){
		MaterialObject mo = new Organismos();
		LivingBeing  lb = (Organismos) mo;
		lb.whatsYourName();
	}
	
	void foo() {
		LivingBeing l1 = new Student();
		LivingBeing l2 = new Person();
		l2.whatsYourName();
		Person p = (Person) l2;
	    p.getAMKA();
	}
	
}