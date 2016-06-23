package RiaPack;


import java.util.Set;
import java.util.TreeSet;

class Emp implements Comparable {
	 int id;
	 String name;
	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	 public String toString(){
		 
		 return id+ " "+name;
	 }
	@Override
	public int compareTo(Object o) {
		Emp emp=(Emp)o;
		if( id==emp.id){
			return 0;
		}
		else if(id>emp.id)
			return 1;
		else return -1;
	}
}

public class myTreeSet {

	
	public static void main(String[] args) {
	
		Set<Emp>hs =new TreeSet<Emp>();
		hs.add(new Emp(10,"Surajit"));
		hs.add(new Emp(9,"Prashanta"));
		hs.add(new Emp(15,"Anil"));
		hs.add(new Emp(27,"Bijit"));
		hs.add(new Emp(8,"Raju"));
		System.out.println(hs);
		for(Object o:hs)
		{
			System.out.println();
		}
		
		
	}

}
