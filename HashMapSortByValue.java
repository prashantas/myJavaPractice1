package RiaPack;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapSortByValue {
    
	private static HashMap<Integer, String> sortByValues(HashMap<Integer, String> map){
		
		List<Entry<Integer,String>> list = new LinkedList<Entry<Integer, String>>(map.entrySet());
		Collections.sort(list,new Comparator(){
			public int compare(Object o1, Object o2){
				return ((Comparable)((Map.Entry)(o1)).getValue()).compareTo(((Map.Entry)(o1)).getValue());
			}
		});
		
		// Here I am copying the sorted list in HashMap
	       // using LinkedHashMap to preserve the insertion order
		HashMap<Integer, String> sortedHashMap = new LinkedHashMap<Integer, String>();
		for(Iterator<Entry<Integer, String>> iterator= list.iterator(); iterator.hasNext();){
			Map.Entry me = (Map.Entry) iterator.next();
			sortedHashMap.put(me.getKey(), me.getValue());
		}
		
		return sortedHashMap;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<Integer,String> hmap = new HashMap<Integer, String>();
		hmap.put(5, "A");
	      hmap.put(11, "C");
	      hmap.put(4, "Z");
	      hmap.put(77, "Y");
	      hmap.put(9, "P");
	      hmap.put(66, "Q");
	      hmap.put(0, "R");
	      System.out.println("Before sorting");
	      Set set = hmap.entrySet();
	      Iterator iterator = set.iterator();
	      while(iterator.hasNext()){
	    	  Map.Entry me = (Map.Entry) iterator.next();
	    	  System.out.print(me.getKey()+": ");
	    	  System.out.println(me.getValue());
	      }
	      
	      Map<Integer, String> map = sortByValues(hmap); 
	      System.out.println("After Sorting:");
	      Set set2 = map.entrySet();
	      Iterator iterator2 = set2.iterator();
	      while(iterator2.hasNext()) {
	           Map.Entry me2 = (Map.Entry)iterator2.next();
	           System.out.print(me2.getKey() + ": ");
	           System.out.println(me2.getValue());
	      }
	} 

}
