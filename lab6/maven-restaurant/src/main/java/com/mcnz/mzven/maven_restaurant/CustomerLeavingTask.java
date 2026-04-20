package com.mcnz.mzven.maven_restaurant;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomerLeavingTask implements Runnable {
	public Customer customer;
	//public Dish[] dishes;
	
	@Override
	public synchronized void run() {
		try {
			Thread.sleep(5000);
			customer.tryLeave();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
