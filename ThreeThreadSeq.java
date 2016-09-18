//  http://www.java67.com/2015/07/how-to-join-two-threads-in-java-example.html
class ThreadOrder implements Runnable {
	Thread waitOn;
	public ThreadOrder(Thread waitOn) {
	this.waitOn = waitOn;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " started");
		/*for (int i = 1; i <= 4; i++) {
			try {
					Thread.sleep(500);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ": " + i);
		}*/
		if (waitOn != null) {
			try {
				waitOn.join();
				//System.out.println(Thread.currentThread().getName());
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " complete");
	}
}


//Read more: http://javarevisited.blogspot.com/2013/02/how-to-join-multiple-threads-in-java-example-tutorial.html#ixzz4KLczCbat

public class ThreeThreadSeq {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws InterruptedException {

		System.out.println(Thread.currentThread().getName() + " started");

		Thread t1 = new Thread(new ThreadOrder(null), "one");
		Thread t2 = new Thread(new ThreadOrder(t1), "two");
		Thread t3 = new Thread(new ThreadOrder(t2), "three");

		t1.start();
		t2.start();
		t3.start();

		/*for (int i = 1; i <= 4; i++) {

		Thread.sleep(500);

		System.out.println(Thread.currentThread().getName() + ": " + i);
		}*/

		t3.join();

		System.out.println("main complete");

		}

		//Read more: http://javarevisited.blogspot.com/2013/02/how-to-join-multiple-threads-in-java-example-tutorial.html#ixzz4KLdot1kA

}
