package week10;

class  A {
	 /* just calls "wait" but this does not make sense
	    because the method is not synchronized */
	  void Methodos1() {
		try {
			this.wait(1000);
		} catch(Exception e ) {
			System.out.println(e);
		}
	   }
	
	  /* just calls "wait".
	   * It makes  sense
	    because the method is  synchronized */
	  synchronized void Methodos2() {
		try {
			this.wait(1000);
		} catch(Exception e ) {
			System.out.println(e);
		}
	   }
}

 class C_StepByStep {
   public static void main(String[] lala) {
	   System.out.println("==BEGIN==");
	   
	   A a = new A();
	   //a.Methodos1(); // exception epeidh den einai synchronized
	   
	   a.Methodos2(); // tha doulepsei ok
		
	   //a.notifyAll(); // illegalMonitorException
	   
	   System.out.println("===END===");
   }
}
