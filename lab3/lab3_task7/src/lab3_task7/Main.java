package lab3_task7;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Integer> ints = new ArrayList<>();
		ints.add(1);
		ints.add(2);
		ints.add(3);
		ints.add(4);
		
		List<Number> numbers = new ArrayList<>();
		numbers.add(23.4);
		numbers.add(23);
		numbers.add(23.8);
		numbers.add(23.02);
		
		System.out.print("ints: \n");
		showList(ints);
		addToList(ints);
		showList(ints);

		System.out.print("numbers: \n");
		showList(numbers);
		addToList(numbers);
		showList(numbers);
	}
	
	public static List<? super Integer> addToList(List<? super Integer> list) {
		for (Integer i = 0; i < 10; i++) {
			list.add(i);
		}
		return list;
	}
	
	public static void showList(List<? super Integer> list) {
		for (Object obj : list) {
			System.out.print(obj + ", ");
		}
		System.out.print("\n");
	}

}
