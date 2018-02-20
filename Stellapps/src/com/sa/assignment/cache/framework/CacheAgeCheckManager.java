package com.sa.assignment.cache.framework;

import java.util.Timer;
import java.util.TimerTask;

public class CacheAgeCheckManager {
	
	private static final int AGE_CHECK_INTERVAL = 5000;
	 
	 public static void startTime(CacheBox cacheBox){
		 Timer timer = new Timer();
		 TimerTask task = new CacheAgeCheck(cacheBox);
		 
		 timer.schedule(task, AGE_CHECK_INTERVAL, AGE_CHECK_INTERVAL);
	 }

}
