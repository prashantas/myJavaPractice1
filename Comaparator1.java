// http://www.programcreek.com/2011/12/examples-to-demonstrate-comparable-vs-comparator-in-java/
class Dog {
	int size;
 
	Dog(int s) {
		size = s;
	}
}
 
class SizeComparator implements Comparator<Dog> {
	@Override
	public int compare(Dog d1, Dog d2) {
		return d1.size - d2.size;
	}
}
 
public class ImpComparable {
	public static void main(String[] args) {
		TreeSet<Dog> d = new TreeSet<Dog>(new SizeComparator()); // pass comparator
		d.add(new Dog(1));
		d.add(new Dog(2));
		d.add(new Dog(1));
	}
}
