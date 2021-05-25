package com.kurshit.leetcode.googletagged;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class VariableWindowRateLimitor {
	
	private static Map<String, LogRate> rateMap;
	private static final int fixCounter = 5;
	
	public static void main(String[] args) throws InterruptedException {
		
		/*
		LocalDateTime currentDatAndTime = LocalDateTime.now();
		System.out.println(currentDatAndTime);
		
		Date cuTime = Calendar.getInstance().getTime();
				
		System.out.println(cuTime);
		System.out.println(cuTime.getTime());
		
		Date cuTime1 = Calendar.getInstance().getTime();
		
		System.out.println(cuTime1.getTime());
		
		Calendar.getInstance().
		
		*/
		
		rateMap = new HashMap<>();
		for(int i=0; i < 200; i++) {
			
			Date currentDateTime = Calendar.getInstance().getTime();
			System.out.println("First: " + currentDateTime);
			System.out.println(add("Kurshit", currentDateTime));
			Thread.sleep(3000);
		
		}

	}
	
	public static boolean add(String userId, Date currentDateTime) {
		
		if(!rateMap.containsKey(userId)) {
			
			LogRate logRate = new LogRate(currentDateTime, fixCounter - 1);			
			rateMap.put(userId, logRate);
		} else {
			
			LogRate logRate = rateMap.get(userId);
			
			Date lastTime = logRate.getDateAndTime();
			
			long diff = currentDateTime.getTime() - lastTime.getTime();
			
			long minDiff = TimeUnit.MILLISECONDS.toMinutes(diff);
			System.out.println("Second : " + minDiff);
			if(minDiff >= 2 ) {
				logRate.setCounter(fixCounter - 1);
				logRate.setDateAndTime(currentDateTime);
				System.out.println("Third : ");
			} else {
				System.out.println("Fourth: " + logRate.getCounter());
				if(logRate.getCounter() == 0) {
					return false;
				} else {
					logRate.setCounter(logRate.getCounter() - 1);
				}
			}
			
						
		}
		
		return true;				
	}

}

class LogRate {
	
	private Date dateAndTime;
	private int counter;
	
	public LogRate(Date dateAndTime, int counter) {
		this.dateAndTime = dateAndTime;
		this.counter = counter;
	}

	public Date getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}	
		
}
