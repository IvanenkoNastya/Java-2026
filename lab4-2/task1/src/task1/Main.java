package task1;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		List<String> strings = Arrays.asList("Hello",
			"Hi",
			"asdf",
			"this is string",
			"another string",
			"Xs",
			//"X is a letter",
			//"X is a letter 2",
			"x is a letter too"
		);

		Optional<String> firstStrStartingWithX = strings.stream()
				.filter(val -> val.charAt(0) == 'X')
				.filter(val -> val.length() > 5)
				//.map(Optional::ofNullable)
				//.map(optional -> optional.orElse("Default"))
				.findFirst();
		
				
		System.out.println(firstStrStartingWithX.orElse("Default"));
		//System.out.println(firstStrStartingWithX);
	}
}
