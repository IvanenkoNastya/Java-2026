package com.mcnz.mzven.maven_restaurant;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Payment implements Runnable {
	public Order order;
	
	@Override
	public synchronized void run() {
		order.isPaid = true;
	}
}
