package week10;


/**
 * 
 * @author Yannis Tzitzikas (yannistzitzik@gmail.com)
 *  1. Change the sleep time and see the impact
 *  2. Uncomment Part C
 */
class MyThreadAA extends Thread {
	static final int NUM=50;
	public void run() {
	  for (int i=0; i<NUM; i++) {
	 	 System.out.print(" A"+i);
		 try {   	Thread.sleep(30);    } catch (Exception e) {    }	
	  }
	}
	}

class MyThreadBB   implements Runnable {
	static final int NUM=50;
	
	public void run() {
		for (int i=0; i<NUM; i++) {
			System.out.print(" B" +i);
			try { 	Thread.sleep(30);   } catch (Exception e) { }
		}
	}
}

class A_StartingExample0 {
	public static void main(String arg[]) {
		
				
		/* Creation of the first thread */
		 MyThreadAA mtA = new MyThreadAA();
		 mtA.start();
		 
		 /* Creation of the second thread */
		 Thread mtB = new Thread(new MyThreadBB());
		 mtB.start();
		 
		 
		 System.out.println("\n-End of main: Καλημέρα !");
		 
	}
}

