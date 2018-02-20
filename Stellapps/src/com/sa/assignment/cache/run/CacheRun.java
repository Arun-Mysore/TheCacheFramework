package com.sa.assignment.cache.run;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.sa.assignment.cache.framework.ICacheBox;

public class CacheRun {
	
	
	private static MessageAccessProxy messageAccessProxy = null;
	public static void main(String[] args) {
		
		messageAccessProxy = MessageAccessProxy.getInstance();
		
		//several calls for different msgs, DB calls and txt file parsing
		messageAccessProxy.getDBResults();
		// TODO Auto-generated method stub
		//pizzBuzz();
		//readFile();

	}
	
	public static void pizzBuzz()
	{
		int a [] = {1,2,2,3,4,5,10,9,15,30,12};
		
		int pos  =0;
		for(int i=0;i<a.length;i++){
			if(a[i]%3==0 && a[i]%5==0)
			{
				pos=i+1;
				System.out.println(pos+"FizzBuzz");
			}
			else if(a[i]%3==0)
			{
				pos=i+1;
				System.out.println(pos+"Fizz");
			}
			else if(a[i]%5==0)
			{
				pos=i+1;
				System.out.println(pos+"Buzz");
			}
			else{
				pos=i+1;
				System.out.println(pos+"-"+a[i]);
				
			}
			
		}
	}
	public static void readFile()
	{
		String FILENAME = "D:\\Aruns\\New1.txt";
		Map <Integer, String>fileMap = new  HashMap<Integer,String>();
		long startTime = System.currentTimeMillis();
		
		StringBuffer sb = new StringBuffer();
		System.out.println(startTime);
		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
			//Object ob = br;
			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				sb.append(sCurrentLine);
				//System.out.println(sCurrentLine);
			}
			long endTime = System.currentTimeMillis();
			System.out.println(endTime+" - "+(endTime-startTime));
			
			startTime = System.currentTimeMillis();
			String s = new String (sb);
			fileMap.put(1, s);
			System.out.println(s);
			endTime = System.currentTimeMillis();
			System.out.println(endTime+" - "+(endTime-startTime));
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}

}
