package prashanta.practice;
// http://stackoverflow.com/questions/16689449/printing-even-and-odd-using-two-threads-in-java
public class PrintEvenOdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Printer print = new Printer();
		Thread t1 = new Thread(new TaskEvenOdd(10,print,false));
		Thread t2 = new Thread(new TaskEvenOdd(10,print,true));
		t1.start();
		t2.start();
	}

}

class TaskEvenOdd implements Runnable{
	private int max;
	private Printer print;
	private boolean isEven;
	//private int number=0;
	public TaskEvenOdd(int max, Printer print, boolean isEven) {
		super();
		this.max = max;
		this.print = print;
		this.isEven = isEven;
	}
	
	public void run(){
	    int number = (isEven==true? 2:1);
		while(number<=max){
			if(isEven){
				print.printEven(number);
			}
			else{
				print.printOdd(number);
			}
			number+=2;
		}
		//number+=2;
	}
}

// http://stackoverflow.com/questions/16689449/printing-even-and-odd-using-two-threads-in-java
class Printer {
	private boolean isOdd = false;  // means it is turn to print odd
	public synchronized void printEven(int number){
		while(isOdd==true){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Even:"+number);
		isOdd=true;
		notifyAll();
	}
	
	public synchronized void printOdd(int number){
		while(isOdd==false){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Odd:"+number);
			isOdd=false;
			notifyAll();
		}
	}

}
