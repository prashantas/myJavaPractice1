package RiaPack;
/* http://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-with-examples */
/* Also read http://javarevisited.blogspot.in/2014/05/double-checked-locking-on-singleton-in-java.html */
/* Eager initialization
 * In eager initialization, the instance of Singleton Class is created at the time of class 
 * loading, this is the easiest method to create a singleton class but it
 *  has a drawback that instance is created even though client application might not be using it.
 */
 class EagerInitialisedSingleton
{
	private static final EagerInitialisedSingleton instance = new EagerInitialisedSingleton();
	private EagerInitialisedSingleton() {} ;
	public static EagerInitialisedSingleton getInstance(){
		return instance ;
	}
	
}

public class Singleton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
