package lab3_task4;

public class main {

	public static void main(String[] args) {		
		Integer[] integerArray = {1, 2, 3, 4, 7, 6};
		Double[] doubleArray = {1., 2.78, 3.1, 44.4, 7.0};
		Character[] charArray = {'H', 'e', 'l', 'l', 'o', '&', '\n'};
		String[] strArray = {"abc", "b", "kkkkk", "y", "a"};
		
		printFormated(findMax(integerArray).toString());
		printFormated(findMax(doubleArray).toString());
		printFormated(findMax(charArray).toString());
		printFormated(findMax(strArray));		
	}
	
	public static <T extends Comparable<T>> T findMax(T[] items) {
		T maxElement = items[0];		
		for (int i = 0; i < items.length; i++) {
			T current = items[i];
			if (current.compareTo(maxElement) > 0) {
				maxElement = current;
			}
		}		
		return maxElement;
	}
	
	public static void printFormated(String message) {
		System.out.print("max element: " + message + "\n");
		return;
	}
}
