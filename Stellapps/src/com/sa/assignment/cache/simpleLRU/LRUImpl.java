package com.sa.assignment.cache.simpleLRU;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUImpl extends LinkedHashMap<Integer, String>{
	
	public static Map <Integer, String> mapLRU = new LinkedHashMap <Integer, String>();
	public static  final int size = 3;
	
	public void putdata(Integer i, String s){
		if(mapLRU.size()>=3){
			this.remove();
		}
		else
			mapLRU.put(i, s);
		
	}
	public String getData(int key){
		
		return mapLRU.get(key);
	}
	
	public void remove(){
		//super.removeEldestEntry(Map.Entry eldest);
	}
	
	public void printMap(){
		
		for(Map.Entry<Integer, String> m : mapLRU.entrySet())
		{
		System.out.println(m.getKey()+ " - "+m.getValue());
		}
	}

}
