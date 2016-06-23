package RiaPack;


class Q
{
	int n;
	boolean valueSet = false;
	synchronized int get()
	{
		if(!valueSet)
		{
			try
			{
				wait();
			}
			catch(InterruptedException e)
			{
				System.out.println("InterruptedException caught in get");
			}
		}
		
		System.out.println("Got: "+ n);
		valueSet = false;
		notify();
		return n ;
	}
	synchronized void put(int n)
	{
	    if(valueSet)
	    {
	    	try
	    	{
	    		wait();
	    	}
	    	catch(InterruptedException e)
	    	{
	    		System.out.println("Interrupted Exception in put");
	    	}
	    }
	    this.n =n ;
	    valueSet = true;
	    System.out.println("Put: "+ n);
	    notify();
	}
}

class Producer implements Runnable
{
	Q q;
	Producer(Q q)
	{
		this.q=q;
		new Thread(this,"producer").start();
	}
	
	public void run()
	{
		int i=0;
		while(true)
		{
			q.put(i++);
		}
	}
	
}

class Consumer implements Runnable
{
	Q q;
	Consumer(Q q)
	{
		this.q = q;
		new Thread(this, "Consumer").start();
	}
	
	public void run()
	{
		while(true)
		{
			q.get();
		}
	}
}
public class ProducerConsumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q q = new Q();
		new Producer(q);
		new Consumer(q);
		System.out.println("Press Control-C to stop."); 
	}

}
