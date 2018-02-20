package com.sa.assignment.cache.run;

import java.util.HashSet;
import java.util.Set;

import com.sa.assignment.cache.framework.CacheBox;
import com.sa.assignment.cache.framework.ICacheBox;

public class MessageAccessProxy {
	private static final int CACHE_SIZE = 5;
	
	private static final Set <String> CACHEABLE_MESSAGES = new HashSet<String>();
	private static final Long cacheExpiry = 5000L;
	private static ICacheBox cacheBox = null;
	private static CacheRun cacheRun = null;
	
	private static MessageAccessProxy messageAccessProxy = null;
	
	//private constructor 
	private MessageAccessProxy() {
		CACHEABLE_MESSAGES.add("InsuredDetails"); //dbResult
		CACHEABLE_MESSAGES.add("PolicyData");
		CACHEABLE_MESSAGES.add("History");
		
		cacheBox  = new CacheBox(CACHEABLE_MESSAGES);
	}
	
	//singleton design
	public static MessageAccessProxy getInstance()
	{
		if(messageAccessProxy == null) messageAccessProxy  = new MessageAccessProxy();
		
		return messageAccessProxy;
	}
	
	//several functions to request for msgs, DB results and the txt file parsing
	
	public void getDBResults()
	{
		//InsuredDetails
		if(cacheBox.isObjectCacheable())
		{
			if(cacheBox.searchCacheObject()!= null) //check if the data available in the cache. First check in the dataTimestampMap cache 
			{
				//get from the dataCache based on the key
				cacheBox.getCachedObject();
				//update the timestamp in the dataTimestampMap. Just store the ey and the current timestamp again in the dataTimestampMap
				cacheBox.storeCacheObject();
			}
			else{
				GetDBResu
				//request for data from respective services
				cacheBox.storeCacheObject();
			}
		}
		else
		{
			//request for data from respective services
		}
		
	}
	
}
