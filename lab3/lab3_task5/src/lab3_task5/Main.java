package lab3_task5;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Pair<Integer, String> intAndStrPair = new Pair<>(3, "hi!");
		Pair<Integer, String> intAndStrPair2 = new Pair<>(4, "hi!");
		Pair<Integer, String> intAndStrPair3 = new Pair<>(3, "hi!");
		List<Integer> ints = new ArrayList<>();
		ints.add(1);
		ints.add(4);
		ints.add(77);
		ints.add(12);
		ints.add(42);
		
		Pair<List<Integer>, String> intListAndStrPair = new Pair<>(ints, "hi!");
		

		System.out.println(intAndStrPair + "\n");
		System.out.println(intListAndStrPair + "\n");

		intAndStrPair.compareTo(intAndStrPair3);
		intAndStrPair.compareTo(intAndStrPair2);
		
	}
	
	

}
