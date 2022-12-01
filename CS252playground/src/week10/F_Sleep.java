package week10;


class SleepMessages {
  public static void main(String args[]) throws InterruptedException { 
	
	System.out.println("BEGIN");
	  
	  String importantInfo[] = {
		"Message 1", 
		"Message 2", 
		"Message 3", 
		"Message 4" 
	}; 
	
	
	
	new Thread(new Runnable()
	{
		  public void run()
		  {
	        for (int i=0;i<20;i++) {
	        	System.out.println("A");
	        }
		  }
		}).start();

	new Thread(new Runnable()
	{
		  public void run()
		  {
	        for (int i=0;i<20;i++) {
	        	System.out.println("B");
	        }
		  }
		}).start();


	
	
	for (int i = 0; i < importantInfo.length; i++) {
		Thread.sleep(1000); 		      //Pause for 4 seconds 
		System.out.println(importantInfo[i]);    //Print a message
		} 
	 
   System.out.println("END");
   }
}
