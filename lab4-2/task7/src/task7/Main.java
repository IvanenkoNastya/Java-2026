package task7;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Transaction> transactions = Arrays.asList(
				new Transaction(1000, "education"),
				new Transaction(3000, "education"),
				new Transaction(20, "healthcare"),
				new Transaction(400, "education"),
				new Transaction(200, "food"),
				new Transaction(400, "food"),
				new Transaction(58, "food"),
				new Transaction(5000, "healthcare"),
				new Transaction(200, "transportation"),
				new Transaction(30, "transportation"),
				new Transaction(30, "transportation"),
				new Transaction(300, "transportation")
			);
	
		// need to add lambda function !!!!!
		/*Map<String, Integer> sumByCategories = transactions.stream()
				.collect(Collectors.groupingBy(Transaction::getCategory, Collectors.summingInt(Transaction::getAmount)));
		*/
		var sumByCategories = transactions.stream()
				.collect(Collectors.groupingBy(x -> x.Category, Collectors.summingInt(x -> x.Amount)))
		;
		
		System.out.print(sumByCategories);
	}

}
