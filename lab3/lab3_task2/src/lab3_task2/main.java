package lab3_task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class main {

	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();
		strings.add("sdf");
		strings.add("sdf");
		strings.add("sdf");
		strings.add("sdf");
		strings.add("qwer");
		strings.add("qwer");
		strings.add("hello");
		
		Queue<String> queueOfUnique = getQueueOfUnique(strings);
		Map<String, Integer> mapOfUnique = getMapOfUnique(strings);
		
		printCollection(queueOfUnique);
		System.out.print("\n");	
		printMap(mapOfUnique);	
		
	}
	
	public static <T extends Comparable<T>> Queue<T> getQueueOfUnique(List<T> list) {
		Queue<T> queue = new LinkedList<>();
		for (T item : list) {
			if (!queue.contains(item)) {
				queue.add(item);
			}
		}
		return queue;
	}
	
	public static <T extends Comparable<T>> Map<T, Integer> getMapOfUnique(List<T> list) {
		Map<T, Integer> map = new HashMap<>();
		for (T item : list) {
			if (map.containsKey(item)) {
				map.replace(item, (map.get(item) + 1));
			} else {
				map.put(item, 1);
			}
		}
		return map;
	}
	
	public static <T extends Comparable<T>> void printCollection(Collection<T> collection) {
		if (collection.isEmpty()) {
			System.out.println("collection is empty");			
		}
		for (T item : collection) {
			System.out.println(item.toString());
		}
	}
	
	public static <K, V> void printMap(Map<K, V> map) {
		if (map.isEmpty()) {
			System.out.print("map is empty");			
		}
		for (K key : map.keySet()) {
			System.out.println("key: " + key + "; value: " + map.get(key).toString());
		}
	}
}
