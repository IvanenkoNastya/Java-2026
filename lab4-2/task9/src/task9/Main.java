package task9;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		Map<Integer, Optional<String>> products = new HashMap<>();
		products.put(1, Optional.empty());
		products.put(2, Optional.of("Bread"));
		products.put(3, Optional.of("Cheese"));
		products.put(4, Optional.of("Cookie"));
		products.put(5, Optional.empty());
		
		//System.out.println(products);
		System.out.println(getProductsUppercase(products));
	}
	
	public static List<String> getProductsUppercase(Map<Integer, Optional<String>> products) {
		List<String> res = products.entrySet().stream()
				.map(elem -> elem.getValue())
				.map(Optional::ofNullable)
				//.filter(value -> value.isPresent())
				.map(elem -> elem.orElse(Optional.empty()))
				.filter(value -> value.isPresent())
				//.map(elem -> elem.orElse(""))
				.map(elem -> elem.get())
				.map(elem -> elem.toUpperCase())
				.toList();
		
		return res;
	}

}
