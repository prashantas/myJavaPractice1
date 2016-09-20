import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 Variable arguments:: 
  http://javarevisited.blogspot.in/2011/09/variable-argument-in-java5-varargs.html
 Rules for varargs:
While using the varargs, you must follow some rules otherwise program code won't compile.
 The rules are as follows:

	1.There can be only one variable argument in the method.
	2.Variable argument (varargs) must be the last argument.
	
	void method(String... a, int... b){}//Compile time error  
	void method(int... a, String b){}//Compile time error  
 
    class VarargsExample3{  
   
 		static void display(int num, String... values){  
  		System.out.println("number is "+num);  
  		for(String s:values){  
   			System.out.println(s);  
  		}  
 	}  
  
 	public static void main(String args[]){  
  
 		display(500,"hello");//one argument   
 		display(1000,"my","name","is","varargs");//four arguments  
 	}   
 	
 }  //  end of class	
 	Output:number is 500
       hello
       number is 1000
       my
       name
       is 
       varargs
       
   IMP  POINT:::::
   Important points related to variable argument or varargs methods:


1) Every call to varargs method require an anonymous array to be created and initialized which
 could affect performance in time critical application. There is an alternative of varargs method 
 to achieve better performance. suppose you have a variable argument method sum(int... num) and
  its called with 2 parameters on 90% of time. In order to avoid array creation and initialization
  you can use method overloading in Java to provide two versions of sum() which accept int instead 
  of varargs. here is an example of better performance alternative of varargs for 90% of time

public int sum(int a);
public int sum(int a, int b);
public int sum(int... num);

Now 90% of time method without varargs will be invoked and 10% of time method with variable 
argument will be invoked.

 ***********
Read more: http://javarevisited.blogspot.com/2011/09/variable-argument-in-java5-varargs.html#ixzz4KnD8deym

An example of variable argument method from JDK is Arrays.asList(T... args) which was used to 
convert array to ArrayList before JDK 1.5 but retrofitted to support variable argument in JDK 1.5.
 Now you can also invoke this method by just passing as many Strings or object as you want and 
 creating a List representation on the fly. Its one of the quickest way to convert Strings into 
 List e.g.

List listOfString = Arrays.asList("Red", "White", "Blue");

Read more: http://javarevisited.blogspot.com/2011/09/variable-argument-in-java5-varargs.html#ixzz4KnDvB2ez
 */
// #########################################################################################
//############################################################################################
//############################################################################################

// Sorting a list by multiple attributes example
// http://www.codejava.net/java-core/collections/sorting-a-list-by-multiple-attributes-example

// The Model Class
class Employee {
    private String name;
    private String jobTitle;
    private int age;
    private int salary;
 
    public Employee(String name, String jobTitle, int age, int salary) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.age = age;
        this.salary = salary;
    } 
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
    public String toString() {
        return String.format("%s\t%s\t%d\t%d", name, jobTitle, age, salary);
    }
}

//*******************************************************************************************
//Using a chained Comparator
//Create the EmployeeChainedComparator class looks like as follows:
class EmployeeChainedComparator implements Comparator<Employee>{

	private List<Comparator<Employee>> listComparators;
	
	public EmployeeChainedComparator(Comparator<Employee>... comparators){
		this.listComparators = Arrays.asList(comparators);
	}
	@Override
	public int compare(Employee emp1, Employee emp2) {
		for(Comparator<Employee> comparator:listComparators){
			int result = comparator.compare(emp1, emp2);
			if(result!=0){
				return result;
			}
		}
		return 0;
	}
	
}
//The key points here are this comparator takes a list of comparators passed via its constructor;
//and the compare() method iterates over this comparators list to compare two Employee objects by 
//each individual comparator. Now, we create separate comparators for each field by which we want 
//to sort: job title, age and salary.
//**************************************************************************************
/**
 * This comparator compares two employees by their job titles. 
 */
class EmployeeJobTitleComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getJobTitle().compareTo(o2.getJobTitle());
	}
	
}
//******************************************************************************************
class EmployeeAgeComparator implements Comparator<Employee> {
	 
    @Override
    public int compare(Employee emp1, Employee emp2) {
        return emp1.getAge() - emp2.getAge();
    }
}
//*********************************************************************************************
class EmployeeSalaryComparator implements Comparator<Employee> {
	 
    @Override
    public int compare(Employee emp1, Employee emp2) {
        return emp1.getSalary() - emp2.getSalary();
    }
}
//*******************************************************************************************
public class SortingMultipleAttriButeExample {
	
	public static void main(String[] args) {
		System.out.println("===== SORTING BY MULTIPLE ATTRIBUTES =====");
		 
        List<Employee> listEmployees = new ArrayList<Employee>();
 
        listEmployees.add(new Employee("Tom", "Developer", 45, 80000));
        listEmployees.add(new Employee("Sam", "Designer", 30, 75000));
        listEmployees.add(new Employee("Bob", "Designer", 45, 134000));
        listEmployees.add(new Employee("Peter", "Programmer", 25, 60000));
        listEmployees.add(new Employee("Tim", "Designer", 45, 130000));
        listEmployees.add(new Employee("Craig", "Programmer", 30, 52000));
        listEmployees.add(new Employee("Anne", "Programmer", 25, 51000));
        listEmployees.add(new Employee("Alex", "Designer", 30, 120000));
        listEmployees.add(new Employee("Bill", "Programmer", 22, 30000));
        listEmployees.add(new Employee("Samuel", "Developer", 28, 80000));
        listEmployees.add(new Employee("John", "Developer", 35, 67000));
        listEmployees.add(new Employee("Patrick", "Developer", 35, 140000));
        listEmployees.add(new Employee("Alice", "Programmer", 35, 80000));
        listEmployees.add(new Employee("David", "Developer", 35, 99000));
        listEmployees.add(new Employee("Jane", "Designer", 30, 82000));
 
        System.out.println("*** Before sorting:");
 
        for (Employee emp : listEmployees) {
            System.out.println(emp);
        }
 
        Collections.sort(listEmployees, new EmployeeChainedComparator(
                new EmployeeJobTitleComparator(),
                new EmployeeAgeComparator(),
                new EmployeeSalaryComparator())
        );
 
        System.out.println("\n*** After sorting:");
 
        for (Employee emp : listEmployees) {
            System.out.println(emp);
        }

	}

}
/*********************OUTPUT*******************************
*** Before sorting:
Tom	Developer	45	80000
Sam	Designer	30	75000
Bob	Designer	45	134000
Peter	Programmer	25	60000
Tim	Designer	45	130000
Craig	Programmer	30	52000
Anne	Programmer	25	51000
Alex	Designer	30	120000
Bill	Programmer	22	30000
Samuel	Developer	28	80000
John	Developer	35	67000
Patrick	Developer	35	140000
Alice	Programmer	35	80000
David	Developer	35	99000
Jane	Designer	30	82000

*** After sorting:
Sam	Designer	30	75000
Jane	Designer	30	82000
Alex	Designer	30	120000
Tim	Designer	45	130000
Bob	Designer	45	134000
Samuel	Developer	28	80000
John	Developer	35	67000
David	Developer	35	99000
Patrick	Developer	35	140000
Tom	Developer	45	80000
Bill	Programmer	22	30000
Anne	Programmer	25	51000
Peter	Programmer	25	60000
Craig	Programmer	30	52000
Alice	Programmer	35	80000
********************************************************************************/
// This Question was asked in Cisco interview : https://www.youtube.com/watch?v=-iggRLFANVg
