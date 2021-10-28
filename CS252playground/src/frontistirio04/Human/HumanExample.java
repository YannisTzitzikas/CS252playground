package frontistirio04.Human;

public class HumanExample {
	public static void main(String args[]){
		CyberHuman ch = new CyberHuman();
		
		//System.out.println(ch.name);
		
		//System.out.println(ch.sayHello());
		
		//System.out.println(ch.super_sayHello()); 
		
		//System.out.println(ch.super_name()); 
		
		//System.out.println(ch.humanCastName()); 
		
		Human h = (Human)ch;
		
		//System.out.println(h.name); 
		
		//System.out.println(h.sayHello()); 
	}
}
