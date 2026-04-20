package com.mcnz.mzven.maven_restaurant;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main( String[] args ) {
        System.out.println( "-- start --" );
        
        Waiter waiter1 = new Waiter("Adam");
        Waiter waiter2 = new Waiter("Sophia");
        Waiter waiter3 = new Waiter("Petro");

        Customer customer1 = new Customer("Kate");
        Customer customer2 = new Customer("Jane");
        Customer customer3 = new Customer("Person Human");
        Customer customer4 = new Customer("Other customer");
        Customer customer5 = new Customer("No order customer Name");
        
        Dish pasta = new Dish("Great pasta", new String[] {
    		"flour",
    		"eggs",
    		"olive oil",
    		"salt"
        });
        Dish salad1 = new Dish("Garlic salad", new String[] {
    		"green garlic heads",
    		"spring of thyme",
    		"bay leaf",
    		"wild garlic leaves",
    		"eggs",
    		"maldon sea salt"
		});
        Dish salad2 = new Dish("Garlic salad", new String[] {
    		"salt",
    		"pepper",
    		"tomatoes",
    		"salad leaves",
    		"oil",
    		"seeds"
		});
        
        //List<Order> orders = new ArrayList<>();
        
        //System.out.println(waiter1.toString());
        //System.out.println(waiter2.toString());
        //System.out.println(customer1.toString());
        //System.out.println(customer2.toString());
        //System.out.println(pasta.toString());
        //System.out.println(salad1.toString());
        
        //System.out.println(Waiter.allWaiters);
        
        customer1.performOrder(new Dish[] { pasta, salad1 });
        customer2.performOrder(new Dish[] { pasta });
        customer3.performOrder(new Dish[] { pasta, salad2 });
        customer4.performOrder(new Dish[] { salad2, salad1, salad1 });
        
        /*Thread orderAttemptThread1 = new Thread(new Order(customer1, new Dish[] { pasta, salad1 }));
        Thread orderAttemptThread2 = new Thread(new Order(customer2, new Dish[] { pasta }));
        Thread orderAttemptThread3 = new Thread(new Order(customer3, new Dish[] { pasta, salad2 }));
        Thread orderAttemptThread4 = new Thread(new Order(customer4, new Dish[] { salad2, salad1 }));
        
        orderAttemptThread1.start();
        orderAttemptThread2.start();
        orderAttemptThread3.start();*/
        
        customer1.pay();
        
        Thread leaving1 = new Thread(new CustomerLeavingTask(customer1));
        Thread leaving2 = new Thread(new CustomerLeavingTask(customer2));
        Thread leaving5 = new Thread(new CustomerLeavingTask(customer5));
        leaving1.start();
        leaving2.start();
        leaving5.start();
        
        /*customer1.tryLeave();
        customer2.tryLeave();
        customer3.tryLeave();
        customer4.tryLeave();*/
        
        System.out.println( "-- the end --" );
    }
}
