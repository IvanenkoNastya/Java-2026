package task10;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Map<String, List<Integer>> citiesTemperature = new HashMap<>();
		citiesTemperature.put("Chernivtsi", Arrays.asList(12, 13, 15, 13, 10));
		citiesTemperature.put("Lviv", Arrays.asList(10, 11, 8, 4, 3, 1, 3, 2));
		citiesTemperature.put("Suceava", Arrays.asList(15, 16, 18, 22, 15, 17, 16, 22));
		//citiesTemperature.put("max", Arrays.asList(40));
		//citiesTemperature.put("min", Arrays.asList(4));
		
		Optional<String> maxAvgTemperatureCity = citiesTemperature.entrySet().stream()
				.sorted(Comparator.comparingDouble(elem -> (-1) * avg(elem.getValue())))
				.map(elem -> elem.getKey())
				.findFirst();
	
				
		System.out.print(maxAvgTemperatureCity.orElse("didn't find a city"));
	}
	
	public static Double avg(List<Integer> ints) {
		Integer res = 0;
		for (Integer val : ints) {
			res += val;
		}
		return res.doubleValue() / ints.size();
	}
	
}
