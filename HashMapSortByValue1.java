package RiaPack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapSortByValue1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<String, String> codenames = new HashMap<String, String>();
        
        codenames.put("JDK 1.1.4", "Sparkler");
        codenames.put("J2SE 1.2", "Playground");
        codenames.put("J2SE 1.3", "Kestrel");
        codenames.put("J2SE 1.4", "Merlin");
        codenames.put("J2SE 5.0", "Tiger");
        codenames.put("Java SE 6", "Mustang");
        codenames.put("Java SE 7", "Dolphin");
        System.out.println("HashMap before sorting, random order ");
        
        Set<Entry<String,String>> entries = codenames.entrySet();
        for(Entry<String,String> en : entries){
        	System.out.println(en.getKey()+":"+ en.getValue());
        }
        
        Comparator<Entry<String,String>> valueComp = new Comparator<Entry<String,String>>(){
        	public int compare(Entry<String,String> e1, Entry<String,String> e2){
        		String v1= e1.getValue();
        		String v2 = e2.getValue();
        		return v1.compareTo(v2);
        	}
        	
        };
        
     // Sort method needs a List, so let's first convert Set to List in java
        List<Entry<String,String>> listOfEntries = new ArrayList<Entry<String,String>>( entries);
        
     // sorting HashMap by values using comparator
        Collections.sort(listOfEntries, valueComp);
        
        LinkedHashMap<String,String> sortedByValue = new LinkedHashMap<String,String>();
     // copying entries from List to Map
        for(Entry<String, String> entry : listOfEntries){
            sortedByValue.put(entry.getKey(), entry.getValue());
        }
        
        System.out.println("HashMap after sorting entries by values ");
        Set<Entry<String, String>> entrySetSortedByValue = sortedByValue.entrySet();
        
        for(Entry<String, String> mapping : entrySetSortedByValue){
            System.out.println(mapping.getKey() + " ==> " + mapping.getValue());
        }
	} // end of main

}
