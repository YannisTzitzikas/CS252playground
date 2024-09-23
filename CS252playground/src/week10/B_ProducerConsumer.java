package week10;
import java.util.*;

/**
 * Example of Producer and Consumer
 * @author tzitzik
 *
 * point S: Try using one of the two versions of HoldInteger (the synchronized and the unsynchronized)
 * point A: Note that it will work ok even if the  try/catch block that follows is in comments.
 * point B: Try to see what will happen if we put in comments the notify
 */


// not synchronized way to communicate
class HoldInteger
{
	protected int sharedInt = -1;
	private boolean moreData = true;
	
	public void setSharedInt(int val) { sharedInt = val; }
	public int getSharedInt() { return sharedInt; }
	public void setMoreData(boolean b) { moreData = b; }
	public boolean hasMoreData() { return moreData; }
}

/*
 * The following class allows synchronized communication.
 * It extends HoldInteger with one attribute "writable"
 * and overrides setSharedInt and  getSharedInt
 */

class HoldIntegerS extends HoldInteger {
	//private int sharedInt = -1;
	//private boolean moreData = true;
	 private boolean writeable = true; // new field
	 
	// Nov 24, 2016: 
	synchronized public void setMoreData(boolean b) { super.setMoreData(b); }
	synchronized public boolean hasMoreData() { return super.hasMoreData(); }

	public synchronized void setSharedInt(int val)	{
		
		if  (!writeable) {
		//while (!writeable) {
		
			// point A:
			
			try	{
				wait(); System.out.print("sg...");
			} catch(InterruptedException e){
				System.err.println(e);
			}
			
		
		}
		sharedInt = val;
		
		writeable = false;
		notifyAll();  // if in comments: ..
	}

	public synchronized int getSharedInt()
	{
		//while (writeable) {
		if (writeable) {
			try	{
				wait(); System.out.print("wg...");
			} catch(InterruptedException e) {
				System.err.println(e);
			}
		}
		writeable = true;
		//System.out.println("GOT "+sharedInt); // FOR DEBUG PURPOSES ONLY
		
		int toreturn = sharedInt;
		// point B: 
		notifyAll();
		return toreturn;
	}
	
}


class ProduceInteger extends Thread
{
	Vector producedValues = new Vector(); // to evala gia na kratei ti exei paraksei	
	private HoldInteger hold;
	
	public ProduceInteger(HoldInteger h){hold = h; this.setName("Producer");	}
	
	public void run()	{
		for (int count = 0; count < 10; count++){
			///*
			 try	{
				
				 Thread.sleep((int)(250)); // 250
			} catch(InterruptedException e) {
				System.err.println(e);
			}
			//*/
			hold.setSharedInt(count);
			producedValues.add(count);
			System.out.println("Producer set sharedInt to " + count);
		}
		hold.setMoreData(false);
		
		System.out.println("Producer produced "+ producedValues);
		//Thread.yield();
	} //run
} // produceInteger



class ConsumeInteger extends Thread
{
	private HoldInteger hold;
	Vector consumedValues = new Vector(); // to evala gia na kratei ti exei katanalwsei
	
	public ConsumeInteger(HoldInteger h){hold = h; this.setName("Consumer");}
	public void run(){
		int val;
		while (hold.hasMoreData())	{
			System.out.println("HAS MORE DATA");
			try	{
				Thread.sleep((int)(700));
			}
			catch(InterruptedException e)	{
				System.err.println(e.toString());
			}
			val = hold.getSharedInt();
			consumedValues.add(val);
			System.out.println("Consumer retrieved " + val);
			//System.out.println("Read " + val + "...");
		} // while
		System.out.println("Consumer consumed " + consumedValues);
	} //run
} // ConsumeInteger





class B_ProducerConsumer
{
public static void main(String[ ] args)
{
	
	//Point S:
	//HoldInteger h = new HoldInteger(); // not synchronized communication
	HoldInteger h = new HoldIntegerS(); // synchronized communication
	ProduceInteger p = new ProduceInteger(h);
	ConsumeInteger c = new ConsumeInteger(h);
	
	p.start();
	c.start();
	
	try {
		p.join();
		c.join();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	System.out.println("Έκλεισε το Bar");
	
}
}
