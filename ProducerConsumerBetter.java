package RiaPack;

import java.util.Vector;


public class ProducerConsumerBetter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Vector sharedQ = new Vector();
        int size=4 ;
        Thread prodThread = new Thread(new Producer1(sharedQ,size),"Producer");
        Thread consThread = new Thread(new Consumer1(sharedQ,size),"Consumer");
        prodThread.start();
        consThread.start();
	}

}

class Producer1 implements Runnable
{
	private final Vector sharedQ;
	private final int SIZE ;
	Producer1(Vector sharedQ,int size)
	{
		this.sharedQ=sharedQ;
		this.SIZE = size;
	}
	public void run()
	{
		//while(true)
		for(int i=0;i<7;i++)
		{
			System.out.println("Produced:" + i);
			try
			{
				Produce(i);
			}
			catch(InterruptedException e)
			{
				System.out.println("Interrupted Exception in Producer");
			}
		}
	}
	
	private void Produce(int i) throws InterruptedException
	{
		while(sharedQ.size()==SIZE)
		{
			synchronized(sharedQ)
			{
				System.out.println("Q is full:" + Thread.currentThread().getName()+" is waiting, size:"+sharedQ.size());
				sharedQ.wait();
			}
		}
		synchronized(sharedQ)
		{
			sharedQ.add(i);
			sharedQ.notifyAll();
			
		}
	}
}

class Consumer1 implements Runnable
{
	private final Vector sharedQ ;
	private final int SIZE;
	Consumer1(Vector sharedQ, int size)
	{
		this.sharedQ = sharedQ;
		this.SIZE = size;
	}
	
	public void run()
	{
		while(true)
		{
			try
			{
				System.out.println("Consumed:" + Consume()	);
				Thread.sleep(50);
			}
			catch(InterruptedException e)
			{
				System.out.println("Exception in consumer");
			}
		}
	}
	
	private int Consume() throws InterruptedException
	{
		while(sharedQ.isEmpty())
		{
			synchronized(sharedQ)
			{
				System.out.println("Queue is empty:" + Thread.currentThread().getName() + "is waiting ,size " + sharedQ.size());
				sharedQ.wait();
				
			}
		}
		
		synchronized(sharedQ)
		{
			sharedQ.notifyAll();
			return (Integer)sharedQ.remove(0);
		}
	}
}
