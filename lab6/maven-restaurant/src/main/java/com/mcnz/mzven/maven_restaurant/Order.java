package com.mcnz.mzven.maven_restaurant;

import java.util.UUID;

import lombok.ToString;

@ToString
public class Order implements Runnable {
	public UUID id;
	public Dish[] dishes;
	public boolean isPaid;
	public Customer customer;
	public Waiter waiter;
	
	public Order(Customer customer, Dish[] dishes) {
		super();
		this.id = UUID.randomUUID();
		this.dishes = dishes;
		this.isPaid = false;
		this.customer = customer;
		this.waiter = Waiter.getRandomWaiter();
	}

	@Override
	public void run() {
		try {
			boolean flag = true;
			while(true) {
				if (waiter.isFree) {
					synchronized (customer) {
						synchronized (waiter) {
							waiter.isFree = false;
							Thread.sleep(2000);
							waiter.isFree = true;
							//System.out.println("Order " + id + " is taken (" + customer.name + " ordered something)");
							System.out.println("Order " + id + " is taken.");
							System.out.println("\t - customer " + customer.name + " ordered something");
							System.out.println("\t - waiter: " + waiter.name);
							return;
						}
					}
				} else {
					if (flag == true) {
						synchronized (waiter) {
							Waiter newWaiter = Waiter.getRandomWaiter();
							System.out.println("Waiter changed for the order " + this.id);
							System.out.println("\t - ( " + waiter.name + " -> " + newWaiter.name + ")");
							waiter = newWaiter;
							flag = false;
						}
					} else {
						synchronized (waiter) {
							Thread.sleep(1000);
							flag = true;
						}

					}
				}
			}
		} catch (InterruptedException e) {
			System.out.println("Order " + id + " failed");
			e.printStackTrace();
		}
	}
	
	
	
}
