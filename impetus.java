package RiaPack;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
/*class CandidateCode 
{ 
    public static String sequences(String input1)
    {
        //Write code here
    	int[]  intArray = new int[input1.length()];
    	int len = input1.length();
    	for(int i=0;i<len;i++) {
    	      
    	      intArray[i] = Integer.parseInt(String.valueOf(input1.charAt(i)));
    	    }
    	int k=len;
    	while (k!=1)
    	{
    		for(int j = 1; j<k ; j++)
    			intArray[j-1]= intArray[j]-intArray[j-1];
    		k= k -1;
    	}
    	return new Integer(intArray[0]).toString();
    }
}*/
public class impetus {

	 public static String sequences(String input1)
	    {       
		    
	    	/*int[]  intArray = new int[input1.length()];
	    	int len = input1.length();
	    	for(int i=0;i<len;i++) {	    	      
	    	      intArray[i] = Integer.parseInt(String.valueOf(input1.charAt(i)));	    	      
	    	    }
	    	
	    	int k=len;
	    	while (k!=1)
	    	{
	    		for(int j = 1; j<k ; j++)
	    			intArray[j-1]= intArray[j]-intArray[j-1];	    		
	    		
	    		k= k -1;
	    	}
	    	return new Integer(intArray[0]).toString();*/
		 
		 // if the input is comma separated string then below is the solution
		 String[] strings = input1.split(",");
		 int[] numbers = new int[strings.length];
		 for (int i = 0; i < numbers.length; i++)
		 {
		   numbers[i] = Integer.parseInt(strings[i]);
		 }
		   
		 int k=numbers.length;
	    	while (k!=1)
	    	{
	    		for(int j = 1; j<k ; j++)
	    			numbers[j-1]= numbers[j]-numbers[j-1];	    		
	    		
	    		k= k -1;
	    	}
		 return new Integer(numbers[0]).toString();
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         //String s = new String("1592356");
         String s = new String("1,5,9,2,3,5,6");
         String r = sequences(s);
         System.out.println("result:"+r);
	}

}
