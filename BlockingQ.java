package RiaPack;
/* When you extend Thread class, each of your thread creates new object and
 * associate with it.
 * But when you implements Runnable , it shares the same object to multiple threads.
 * 
 */

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Producerb implements Runnable {
	private final BlockingQueue sharedQueue;
	public Producerb(BlockingQueue sharedQueue)
	{
		this.sharedQueue = sharedQueue;
	}
	public void run()
	{
		for(int i=1;i<=10;i++)
		{
			try {
				System.out.println("Produced:"+ i);
				sharedQueue.put(i);
			}
			catch(InterruptedException e){
				System.out.println("exception in producer :" + e );
			}
		}
	}
}

class Consumerb implements Runnable {
	private final BlockingQueue sharedQueue ;	
	public Consumerb(BlockingQueue sharedQueue){
		this.sharedQueue = sharedQueue;
	}
	public void run(){
		while(true){
			try{
				System.out.println("Consumed:" + sharedQueue.take());
			}
			catch(InterruptedException e){
				System.out.println("exception occured in consumer take :" + e);
			}
			
		}
		
	}
	
}
public class BlockingQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlockingQueue sharedQueue = new LinkedBlockingQueue();   // shared object
		Thread prodThread = new Thread(new Producerb(sharedQueue));
		Thread consThread = new Thread(new Consumerb(sharedQueue));
		
		prodThread.start();
		consThread.start();

	}

}
