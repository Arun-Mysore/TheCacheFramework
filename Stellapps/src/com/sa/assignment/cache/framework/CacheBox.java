package com.sa.assignment.cache.framework;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/*
 * Implements all the exposed functions
 */
public class CacheBox implements ICacheBox{
	
	private ConcurrentHashMap<String, Object> dataMap = new ConcurrentHashMap<>(10, 1.00f, 10);
	private ConcurrentHashMap<String, Long> dataTimestampMap = new ConcurrentHashMap<String, Long>(10, 1.00f, 10);
	private Long age = 0L;
	private Set <String> cacheableMessages  = null;
	
	//constructor
	public CacheBox(Set cacheableMessaage)
	{
		CacheAgeCheckManager.startTime(this); //starts the Timer against the cache

		this.cacheableMessages = cacheableMessaage;
	}
	
	@Override
	public Object getCachedObject() {
		// TODO Auto-generated method stub
		for()
		return null;
	}

	@Override
	public void storeCacheObject() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Object> getAllCachedObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void purgeCacheContents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void purgeCacheObject(String key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CacheStatus getCacheStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isObjectCacheable(String cacheMsg) {
		
		// TODO Auto-generated method stub
		return false;
	}
	
	//has logic to remove expired objects
	public void removeAgedObjects(){
		long currentTimeStamp = System.currentTimeMillis();
		//print cache status before removing the object
		System.out.println();
		
		
		//print cache status after removing the object
		System.out.println();
	}

	@Override
	public String searchCacheObject() {
		// TODO Auto-generated method stub
		return null;
	}

}
