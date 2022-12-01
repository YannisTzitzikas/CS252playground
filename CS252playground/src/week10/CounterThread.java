package week10;

import java.applet.*;
import java.awt.*;

public class CounterThread extends Applet implements Runnable
{	
	Thread t;	
	int Count;
	int doesRun=1; // tmp 

	public void init()	
	{	
		Count=0;
		t=new Thread(this);
		t.start();
	}

	public boolean mouseDown(Event e,int x, int y)
	{	
		//t.stop(); // would stop the thread
		
		if (doesRun==1) {
			//t.stop();
			t.suspend();  // suspends
			doesRun=0;
		} else {
			t.resume();   // resume
			doesRun=1;
		}
		
		
		return true;
	}

	public void run()
	{
		while(true)
		{
			Count++;
			repaint();
			try {
				t.sleep(10);
			} catch (InterruptedException e) {}
		}
	}

	public void paint(Graphics g)
	{
		g.drawString(Integer.toString(Count),10,10);
		System.out.println("Count= "+Count);
	}

	public void stop()
	{
		t.stop();
	}
}

