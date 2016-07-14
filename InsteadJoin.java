// Problem: To execute the threads in sequential order. 
// Here I have tried executing 25 threads sequentially.
package prashanta.practise;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Task implements Runnable {
	/*CountDownLatch countLatch = null;
	public Task(CountDownLatch countDown) {
		countLatch = countDown;
	}*/
    private Lock lock;
    public Task(Lock lock) {
		this.lock=lock;
	}
	public Task() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void run() {		
		    try{
		    	lock.lock();
		    	
		    		System.out.println("ThreadNo:" + Thread.currentThread().getName());
		    		try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	
		   
		    } finally{
		    	lock.unlock();
		    }
				
		
		//After the process is complete, decrement the countDown
		//countLatch.countDown();
	}

}

public class InsteadJoin{
	private final static ReentrantLock lock = new ReentrantLock(true);
	public static void main(String[] args) throws Exception{

		//Create a countdown latch for 1 thread. (We just need to wait for 1 thread to complete)
		//CountDownLatch countDown = new CountDownLatch(1);
		
		//CountDownLatch countDown1 = new CountDownLatch(1);
		//CountDownLatch countDown2 = new CountDownLatch(1);

		for(int i=1;i<25;i++){
			Thread t = new Thread(new Task(lock));
			t.setName(""+ i);
			t.start();
		}
		/*Thread firstThread = new Thread(new Task(lock));
		Thread secondThread = new Thread(new Task(lock));
		Thread thirdThread = new Thread(new Task(lock));
		//Set their names
		firstThread.setName("JobOne");
		secondThread.setName("JobTwo");
		thirdThread.setName("JobThree");
		//Start first thread
		firstThread.start();
		//countDown.await();
		secondThread.start();
		//Wait for countdown to decrease
		//countDown1.await();
		thirdThread.start();*/
		//Start second thread
		//secondThread.start();
		
	}
}
