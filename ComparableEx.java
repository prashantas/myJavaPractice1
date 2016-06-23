package RiaPack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

class Student implements Comparable {
	int rollNo;
	String name;
	int age;
	Student(int r,String n,int a){
		this.rollNo=r;
		this.age=a;
		this.name=n;
	}
	
	public int compareTo(Object obj){
		Student st=(Student)obj;
		if( age==st.age){
			return 0;
		}
		else if(age>st.age)
			return 1;
		else return -1;
	}
}
public class ComparableEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         ArrayList al = new ArrayList();
         al.add(new Student(1,"pras",34));
         al.add(new Student(1,"pra",24));
         al.add(new Student(1,"pr",44));
         
         Collections.sort(al);
         Iterator<Student> itr = al.iterator();
         while(itr.hasNext()){
        	 Student st=(Student)itr.next();
        	 System.out.println(st.rollNo+":"+st.name+":"+st.age);
         }
	}

}
