package prashanta.equalsAndHashCode;
// // http://www.javaranch.com/journal/2002/10/equalhash.html
class TestExtends extends Test
{
	
}

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		Object t1 = new Test();
		Object t2 = t1;
		Object t3 = new TestExtends();
		if(t1==t2)
			System.out.println("t1 is equls to t2");
			
         System.out.println(t1 instanceof Test);
         System.out.println(t1 instanceof TestExtends);
         
         System.out.println(" Now for t3 object .....");
         
         
         System.out.println(t3 instanceof Test);
         System.out.println(t3 instanceof TestExtends);
         
         System.out.println(t1.getClass() +" ::::&&&&&::::" + t2.getClass() +" ::::&&&&&::::"+ t3.getClass());
         System.out.println("t1.getClass().equals(t2.getClass())::" +t1.getClass().equals(t2.getClass()));
         System.out.println("t1.getClass().equals(t3.getClass())::" +t1.getClass().equals(t3.getClass()));
         System.out.println("t1.getClass().equals(Test.class)::" +t1.getClass().equals(Test.class));
	}

}

// http://www.javaranch.com/journal/2002/10/equalhash.html

 class Test {
	private int num;
	private String data;
	
	public boolean equals(Object obj)
	{
		if(this==obj) return true;
		if(obj==null || (obj.getClass()!= this.getClass())) return false;
		Test test = (Test) obj;
		return num == test.num && 
		(data==test.data || (data!=null && data.equals(test.data)));
	}
	
	public int hashCode()
	{
		int hash =7;
		hash = 31* hash + num;
		hash = 31* hash + ( null==data ? 0: data.hashCode());
		return hash;
	}

}
 
 
//  http://www.javaworld.com/article/2074996/hashcode-and-equals-method-in-java-object---a-pragmatic-concept.html
