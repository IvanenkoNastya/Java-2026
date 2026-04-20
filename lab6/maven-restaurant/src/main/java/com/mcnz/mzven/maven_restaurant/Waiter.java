package com.mcnz.mzven.maven_restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

//import lombok.NoArgsConstructor;
//import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
//@NoArgsConstructor
//@AllArgsConstructor
public class Waiter /*extends Person*/ {
	public UUID id;
	public String name;
	public boolean isFree;
	
	public static List<Waiter> allWaiters = new ArrayList<>();
	
	public Waiter(String name) {
		super();
		this.id = UUID.randomUUID();
		this.name = name;
		this.isFree = true;
		allWaiters.add(this);
	}
	
	public static Waiter getRandomWaiter() {
		int randomIndex = ThreadLocalRandom.current().nextInt(allWaiters.size()) % allWaiters.size();
		return allWaiters.get(randomIndex);
	}
}
