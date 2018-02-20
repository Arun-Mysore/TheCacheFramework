package com.sa.assignment.cache.simpleLRU;

import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class LRU {

	public static Map <Integer,String> map1 = new ConcurrentHashMap<Integer, String>(3,0.75f,3);
	public static void main(String[] args) {
	/*	LRUImpl lru  = new LRUImpl();
		lru.putdata(1, "a");
		lru.putdata(2, "a2");
		lru.putdata(3, "a3");
		
		lru.printMap();
		
		lru.putdata(4, "a4"); 
		
		lru.printMap();
		
		lru.putdata(5, "a5");lru.printMap();lru.putdata(1, "a");lru.printMap();*/
		
		map1.put(1, "a");
		map1.put(2, "b");
		map1.put(3, "c");
		print(map1);
		map1.put(4,"d");
		print(map1);
		
	}
	public static void print(Map <Integer, String>map1){
		for(Map.Entry<Integer,String> m : map1.entrySet()){
			System.out.println(m.getKey()+" - "+m.getValue());
		}
	}
}
