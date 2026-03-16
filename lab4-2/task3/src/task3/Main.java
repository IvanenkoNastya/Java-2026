package task3;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		List<String> strings = Arrays.asList(
				"Name1",
				"Name33333"
			);
		System.out.println(getTheLongestName(strings, "asdf"));
	}
	
	public static Optional<String> getTheLongestName(List<String> names, String defaultName) {
		if (names.isEmpty()) {
			return Optional.ofNullable(defaultName);
		}
		
		Optional<Integer> maxLengthOptional = names.stream()
				.map(val -> val.length())
				.max(Integer::compareTo);
		
		Integer maxLength = maxLengthOptional.orElse(0);
		
		//System.out.println(maxLength);

		Optional<String> theLongestNameOptional = names.stream()
				.filter(val -> val.length() == maxLength)
				.findFirst();
		
		return theLongestNameOptional;
	}

}
