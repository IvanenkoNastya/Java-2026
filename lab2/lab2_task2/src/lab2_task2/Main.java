package lab2_task2;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) {
		
		Queue<Request> requests = new LinkedList<Request>();
		
		addRequest(requests, new Request(1, "what?"));
		addRequest(requests, new Request(2, "for what?"));
		
		workRequest(requests);
		
		addRequest(requests, new Request(3, "because of what?"));
		addRequest(requests, new Request(8, "maybe what?"));

		workRequest(requests);
		workRequest(requests);
		workRequest(requests);
		workRequest(requests);

	}	
	
	public static void addRequest(Queue<Request> list, Request item) {
		list.add(item);
		System.out.print("Created " + item.toString());
		System.out.print("\n");
	}
	
	public static void workRequest(Queue<Request> list) {
		if (!list.isEmpty()) {
			System.out.print(list.peek().work());
			list.remove();
			System.out.print("\n");
		}		
	}
	
}
