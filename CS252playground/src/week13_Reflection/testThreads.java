package week13_Reflection;

/**
 * Can be used (by extending it) for testing how many threads we can create
 * @author Yannis Tzitzikas (yannistzitzik@gmail.com)
 *
 */

public class testThreads {

	public static void main(String[] lala) {
		int K=1000;
		Thread[] ta = new Thread[K];
		for (int i=0; i<K; i++) {
			ta[i] = new Thread(
					new Runnable()  {

						@Override
						public void run() {
							int a = 2;
							
						}
						
					}
			);
			ta[i].start();
			
		}
	  System.out.println("TEST");
	}
}
