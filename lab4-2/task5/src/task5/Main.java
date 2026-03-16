package task5;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Integer> ints = Arrays.asList(3, -3, 8, 5, 8, 90, 10);
		
		Integer multiplicationOfOdd = ints.stream()
				.filter(val -> val % 2 != 0)
				.reduce(1, (a, b) -> a * b);

		System.out.print(multiplicationOfOdd);
	}

}
