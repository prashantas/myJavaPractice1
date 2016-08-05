package RiaPack;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
// https://alaindefrance.wordpress.com/2014/10/05/lru-cache-implementation/
class Node {
    int key;
    int data;
    Node previous;
    Node next;
}

class LRUCache {
	private int capacity;
	private Map<Integer, Node> data;
	private Node head;
	private Node end;
	public LRUCache(int capacity){
		this.capacity = capacity;
		this.data =  new HashMap<>();
	}
}


//**************** LRU using LinkedHashMap ***************************

class LRUCacheImpl extends LinkedHashMap<Integer,String> {
	
	private int capacity;
	public LRUCacheImpl(int capacity){
		super(capacity,0.75f, true);
		this.capacity = capacity;
		
	}
	/**
	    * removeEldestEntry() should be overridden by the user, otherwise it will not
	    * remove the oldest object from the Map.
	    * http://stackoverflow.com/questions/20772869/what-is-the-use-of-linkedhashmap-removeeldestentry
	    */
	@Override	
	protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest){
		return size()> this.capacity;
	}
}
//*******************************************************************

public class LRUCahcheTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         LRUCacheImpl lruCache = new LRUCacheImpl(4);
         lruCache.put(1, "Object1");
         lruCache.put(2, "Object2");
         lruCache.put(3, "Object3");
         lruCache.put(4, "Object4");
         System.out.println(lruCache);
         lruCache.get(1);
         System.out.println(lruCache);
         
         //System.out.println(lruCache);
         lruCache.put(5, "Object5");
         System.out.println(lruCache);
         
	}

}
