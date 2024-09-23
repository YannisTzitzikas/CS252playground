package week10;


/**
 * 
 * @author Yannis Tzitzikas (yannistzitzik@gmail.com)
 *  1. Change the sleep time and see the impact
 *  2. Uncomment Part C
 */
class MyThread_A extends Thread {
	static final int NUM=100;
	public void run() {
	  for (int i=0; i<NUM; i++) {
	 	 System.out.print(" A"+i);
		 try {   	Thread.sleep(100);    } catch (Exception e) {    }	
	  }
	}
	}

class MyThread_B   implements Runnable {
	static final int NUM=100;
	
	public void run() {
		for (int i=0; i<NUM; i++) {
			System.out.print(" B" +i);
			try { 	Thread.sleep(50);   } catch (Exception e) { }
		}
	}
}

class A_StartingExample {
	public static void main(String arg[]) {
		
		try { 	Thread.sleep(2000);   } catch (Exception e) { }
		
		System.out.println("\n-Καλημέρα !");
				
		/* Creation of the first thread */
		 MyThread_A mtA = new MyThread_A();
		 mtA.start();
		 
		 /* Creation of the second thread */
		 Thread mtB = new Thread(new MyThread_B());
		 mtB.start();
		 
		 System.out.println("\n-Καλό μεσημέρι !");
		 
		 /*
		 System.exit(1);
		 /*
		//perimene na teleiwsei to B
		 
		 try { 
			 mtA.join();
			 System.out.println("\nTέλειωσε το Α ");
			 mtB.join();
			 System.out.println("\nTέλειωσε το Β Συνεχίζω");
		 } catch (Exception e) { }
		 */
		 
		 // Part C
		 try {
		    mtA.join(); // try commenting these lines
		    //mtB.join();
		    mtB.join(1000); // wait until B finishes OR 1sec has expired
		    if (mtB.isAlive()) {
		    	System.out.println("\nΔεν σε περιμένω άλλο");
		    	mtB.stop();
		    	//mtB.destroy();
		    }
		 } catch (Exception e) { }
		
		 /*
		 new Thread(
				 new Runnable() {
					public void run() {
						for (int i=0;i<100*1000;i++)
							System.out.print(i+"-");
					}
					 
				 }
		  ).start();
		 */
		 
		 
		 
		 
		 
	}
}

