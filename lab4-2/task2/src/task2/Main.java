package task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Integer> ints = Arrays.asList(1, -3, 5, null, 8, 9, null, 1);
		System.out.println(getNoNullList(ints));
	}
	
	public static List<Integer> getNoNullList(List<Integer> ints) {
		List<Integer> skippedNullInts = ints.stream()
			.map(Optional::ofNullable)
			.filter(val -> val.isPresent())
			.map(val -> val.get())
			.toList();
		return skippedNullInts;
	}

}
