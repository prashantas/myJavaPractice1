package RiaPack;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CountChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("Input String is :");
        String inputString = "Alive is awesome";
        frequencyCount(inputString);
	}
	static void frequencyCount(String inputString)
	{
		Set<Character> s = new HashSet<Character>();
		for(int i=0;i<inputString.length();i++)
		{
			s.add(inputString.charAt(i));
		}
		System.out.println("inputString lenght:"+ inputString.length());
		System.out.println("Set lenght:"+ s.size());
		int[] cnt = new int[s.size()];
		
		Iterator<Character> itr = s.iterator();
		int count=0;
		int k=0;
		while ( itr.hasNext())
		{
			char c = itr.next();
			count=0;
			for(int i = 0;i<inputString.length();i++)
			{
				if(c==inputString.charAt(i))
					count++;
			}
			cnt[k]=count;
			System.out.println("count of "+c+"::"+cnt[k]);
			k++;
		}
	}

}
