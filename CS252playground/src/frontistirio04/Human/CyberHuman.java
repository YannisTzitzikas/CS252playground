package csd.uoc.gr.Human;

public class CyberHuman extends Human{
	String name="CyberHumanName";
	
	String sayHello(){
		return "Hello "+name;
	}
	
	String super_name(){ 
		return super.name;
	}
	
	String super_sayHello(){ 
		return super.sayHello();
	}
	
	String humanCastName(){
		return ((Human)this).name;
	}
}
