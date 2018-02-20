package com.sa.assignment.cache.framework;

import java.util.List;
/*
 * Class exposing the functionalities offered by the cache. 
 */

public interface ICacheBox {
	
	//search cached object
	public String searchCacheObject();
	
	//get a cached object
	public Object getCachedObject();
	
	//store an object into cache
	public void storeCacheObject();
	
	//get all the cache objects
	public List<Object> getAllCachedObject();
	
	//delete all cache objects
	public void purgeCacheContents();
	
	//delete a cache object
	public void purgeCacheObject(String key);
	
	//get cache status
	public CacheStatus getCacheStatus();
	
	//check if a message is cacheable
	public boolean isObjectCacheable();
	
	
}
