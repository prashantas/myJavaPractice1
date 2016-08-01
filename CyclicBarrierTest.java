import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

// https://www.youtube.com/watch?v=wGiwXHB-dAg
// http://www.concretepage.com/java/example_cyclicbarrier_java
// https://books.google.co.in/books?id=SSyuJa04uv8C&pg=PA597&lpg=PA597&dq=matrix+with+cyclicbarrier&source=bl&ots=ufxEwRv-P9&sig=WIA7lhptFG7h3kXGn4OD_KDKgwY&hl=en&sa=X&ved=0ahUKEwiq3vyN2aDOAhVKRo8KHS8uDtMQ6AEIITAB#v=onepage&q=matrix%20with%20cyclicbarrier&f=false


public class CyclicBarrierTest {

	/**
	 * @param args
	 */
	 //static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		// TODO Auto-generated method stub
		CyclicBarrier cb = new CyclicBarrier(3, new Aggragator(list));
     
		new Task(cb,1,5,list);
		new Task(cb,6,10,list);
		new Task(cb,11,15,list);
		System.out.println("Main Ended");
		
	}

}

class Aggragator implements Runnable {
	List<Integer> list;
	public Aggragator(){}
	public Aggragator(List<Integer> list){
		this.list = list;
		System.out.println("ListSize:" + list.size());
	}
	public void run(){
		//int total = addListValue();
		System.out.println("Inside aggregator");
		//addListValue();
		//System.out.println("Total sum inside run ::" + total);
	}
	private int addListValue(){
		  int total=0;
		  for(int j=0;j<list.size();j++){
		  total+=list.get(j);
		  }
		  System.out.println("Total inside addListValue::" + total);
		  return total;
		  
	}
}

class Task extends Thread{
	
	CyclicBarrier syncPoint;
	int start;int end;
	List<Integer> list;
	
	public Task(CyclicBarrier syncPoint, int start, int end,List<Integer> list) {
		super();
		this.syncPoint = syncPoint;
		this.start = start;
		this.end = end;
		this.list=list;
		this.start();
	}

	public void run(){
	
		int sum = addNo(start,end);
		list.add(sum);
		System.out.println("The sum of" + Thread.currentThread().getName()+ " is " + sum);
		
		try {
			syncPoint.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private int addNo(int a,int b){
		int sum=0;
		for(int i=a;i<=b;i++){
			sum =sum + i;
		}
		return sum;
	}
}
