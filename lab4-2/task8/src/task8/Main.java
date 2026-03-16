package task8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		List<Product> products = Arrays.asList(
			new Product(Optional.of("Bread"), 24),
			new Product(Optional.of("Cheese"), 110),
			new Product(Optional.of("Yogurt"), 43),
			new Product(Optional.of("Cookie 1"), 35),
			new Product(Optional.of("Cookie 2"), 18),
			new Product(Optional.of("Orange"), 120), // here it is
			new Product(220),
			//new Product(130),
			new Product(15)
		);

		System.out.print(getSecondPricyProduct(products).orElse("couldn't find second pricy product"));
	}
	
	public static Optional<String> getSecondPricyProduct(List<Product> products) {
		Optional<String> res = products.stream()
				//.map(Optional::ofNullable)
				//.filter(value -> value.Name.isPresent())
				.sorted(Comparator.comparingInt(val -> (-1) * val.Price))
				.skip(1)
				.map(x -> x.Name.orElse("couldn't find second pricy product's name"))
				//.map(Optional::ofNullable)
				.findFirst();
		
		return res;
	}

}
