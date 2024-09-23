package week10;

/**
 * @author Yannis Tzitzikas (yannistzitzik@gmail.com)
 * A simple client-server example that uses threads
 */

// simple computational task
class ComputationalTask {
	static void work(String request) {	
		System.out.println("Server: Starting working on request " + request);
		try {
			Thread.sleep(50); //The time needed to carry out the task
			System.out.println(request);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Server: Comletion of request " + request);			
	}
}

// computational task wrapped to run in a new thread
class TheadedComputationTask extends Thread {
	String request;
	TheadedComputationTask(String request) {this.request=request;}
	public void run() {
		ComputationalTask.work(request);
	}
}

class WebServer {
	static String service(String request) {
		//A: 
		//ComputationalTask.work(request);  // no thread (single instruction execution)
		
		//B:  by defining a new class that extends Thread
		//	TheadedComputationTask tct = new TheadedComputationTask(request);
		//tct.start();
		
		//C: Through inner classes
		
		new Thread( 
				new Runnable() {
					public void run() {
						ComputationalTask.work(request);
					}
				}
		).start();
		
		/*
		new Thread( () ->  {ComputationalTask.work(request);}).start();  // lamba expression of Java >=8
		*/
		return "202";
	}
	
}

class ClientBrowser {
	
	static int id=0;
	ClientBrowser() {
		id++;
		System.out.println("Client " + id + " started");
		String response = WebServer.service("Request from client " + id + " Give me www.csd.uoc.gr");
		//System.out.println(response);
	}
}



class WebTester {
	public static void main(String[] lala) {
		int K=100*1000;
		for (int i=0;i<K;i++) {
			ClientBrowser cb = new ClientBrowser();
		}
	}
}