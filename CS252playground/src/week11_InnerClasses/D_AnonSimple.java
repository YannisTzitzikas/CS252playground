package week11_InnerClasses;


class Person {
	String name;
	public String toString() { return "My name is "+ name;}
	public Person(String nm) {name=nm;}
	public Person() {this("not specified");}
}

class PRINTER{
	void print(Object o){
		System.out.println(o.toString());
	}
}

public class D_AnonSimple {

	public static void main(String arg[]){
	
		PRINTER pr = new PRINTER();
		Person person = new Person();
		pr.print(person);
		pr.print(new Person("Yannis"));
		pr.print(new Person("Nikos"){
			
			public String toString() { 
				System.out.println(this.getClass());
				return super.toString()+ " from Crete";
				}
							}
		);
		
		
		Object oa = new Person("Aristotelis"){
			int secretKey = 1;
			public String toString() { return super.toString()+ " from Athens";}
		}; 
		
		pr.print(oa);
		
		pr.print(new Object(){
			boolean breaktoday = false; 
			public String toString() { return super.toString()+ " from 252";}
							}
		);
		
		
		Class oac = oa.getClass();
		System.out.println(oac);
		
		
		
	}
}
