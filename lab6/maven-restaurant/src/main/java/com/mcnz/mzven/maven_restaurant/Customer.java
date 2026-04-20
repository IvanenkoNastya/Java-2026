package com.mcnz.mzven.maven_restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
//@AllArgsConstructor
public class Customer {
	public UUID id;
	public String name;
	public List<Order> orders;

	public Customer(String name) {
		super();
		this.id = UUID.randomUUID();
		this.name = name;
		this.orders = new ArrayList<>();
	}
	
	public void performOrder(Dish[] dishes) {
		Order order = new Order(this, dishes);
		orders.add(order);
        Thread orderAttemptThread = new Thread(order);
        orderAttemptThread.start();
	}
	
	public boolean tryLeave() {
		for (Order order : orders) {
			if (!order.isPaid) {
				System.out.println("Alarm! Customer " + this.name + " is trying to leave without payment");
				return false;
			}
		}
		System.out.println("...customer " + this.name + " is quietly leaving the building...");
		return true;
	}
	

	public void pay() {
		for (Order order : orders) {
			Thread paying = new Thread(new Payment(order));
			paying.start();
		}
	}	
}
