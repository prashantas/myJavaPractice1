import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ThreadId {
	private int id;
	public ThreadId(){}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
class Printer implements Runnable {
        private final int actualThreadId;
        private final int nextThreadId;
       // private final int nThread;
        private final Lock lock;
        private final Condition condition;
        private final ThreadId threadId;

        public Printer(Lock lock, Condition condition,int actualThreadId, int nextThreadId,ThreadId threadId) {
            
            
            this.lock = lock;
            this.condition = condition;
            this.actualThreadId=actualThreadId;
            this.nextThreadId=nextThreadId;
            this.threadId=threadId;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                while (true) {
                    //if (integer.get() % nThread != id) {
                    if (threadId.getId() != actualThreadId) {	
                        condition.await();
                    } else {
                        //System.out.println("Thread[" + id + "]--> " + integer.getAndIncrement());
                        System.out.println("Thread[" + threadId.getId() + "]--> " + actualThreadId);
                        threadId.setId(nextThreadId);
                        condition.signalAll();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
}

public class NThreadsPrint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        //MyPrinterApp more = new MyPrinterApp();
        ThreadId threadId = new ThreadId();
        threadId.setId(1);
        int nThreads = 3;
        ExecutorService service = Executors.newFixedThreadPool(nThreads);
        for (int i = 0; i < nThreads; i++) {
        	if(i!=2)
        		service.submit(new Thread(new Printer(lock, condition,i+1,i+2,threadId)));
        	else
        		service.submit(new Thread(new Printer(lock, condition,i+1,1,threadId)));
        }
        service.shutdown();

	}

}
/*
OutPut:::
Thread[1]--> 1
Thread[2]--> 2
Thread[3]--> 3
Thread[1]--> 1
Thread[2]--> 2
Thread[3]--> 3
Thread[1]--> 1
Thread[2]--> 2
Thread[3]--> 3
Thread[1]--> 1
Thread[2]--> 2
Thread[3]--> 3
Thread[1]--> 1
Thread[2]--> 2
Thread[3]--> 3
Thread[1]--> 1
Thread[2]--> 2
Thread[3]--> 3
Thread[1]--> 1

*/
