package com.sa.assignment.cache.framework;

import java.util.TimerTask;

public class CacheAgeCheck extends TimerTask  {
	private CacheBox cacheBox = null;
	
	public CacheAgeCheck(CacheBox cacheBox){
		this.cacheBox=cacheBox;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		cacheBox.removeAgedObjects();
	}
	
	
}
