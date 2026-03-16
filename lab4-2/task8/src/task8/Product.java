package task8;

import java.util.Optional;

public class Product {
	public Optional<String> Name;
	public Integer Price;
	
	public Product(Integer price) {
		Name = Optional.empty();
		Price = price;
	}
	
	public Product(Optional<String> name, Integer price) {
		Name = name;
		Price = price;
	}

}
