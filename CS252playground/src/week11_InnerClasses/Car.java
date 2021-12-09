package week11_InnerClasses;


public class Car extends Thread {
	  Runnable x = new Thread() { public void run() {System.out.println("AAA");} };
	  public void run() { x.run();}
	  
	  //A: static {
	  //static public  class Engine {
	  //B: Non static {
	    protected class Engine {
	    int cc ;
	  }
  String plates;
  void doService() { }
}


class Tester {
	public static void main(String[] lala) {
		System.out.println("NESTED CLASSES");
		
		Car c = new Car();
		//c.x.start();
		//new Thread(c.x).start();
		//new Thread(c).start();
		c.start();
		
		// A. Static Version:
		//Car.Engine myEng = new Car.Engine();
		
		// B. Non Static; 
	
		//Car c = new Car();
	
		//Car.Engine myEng = c.new Engine();
		
		//A:
		//Car.Engine myEng2 =  new c.Engine();
		
		//B
		//Car.Engine myEng2 =  new Car.Engine();
				
		
		
		//Car.Engine myEng3 =  (new Car()).new Engine();
		
		//System.out.println(myEng);
		
	}
}