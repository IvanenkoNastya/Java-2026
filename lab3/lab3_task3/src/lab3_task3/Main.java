package lab3_task3;

public class Main {

	public static void main(String[] args) {
		Box<Integer> ints = new Box<Integer>();
		ints.setItem(9);
		ints.setItem(8);
		ints.setItem(7);
		ints.setItem(6);
		ints.setItem(5);
		ints.setItem(4);
		ints.setItem(3);
		ints.setItem(2);
		System.out.println("randomly taken element out of the box: " + ints.pullItem());		
		ints.print();
		
		System.out.println("\n");

		Box<String> strings = new Box<>();
		strings.setItem("hi");
		strings.setItem("hello");
		strings.setItem("good morning");
		strings.setItem("maybe");
		strings.setItem("obvious");
		strings.setItem("string");
		System.out.println("randomly taken element out of the box: " + strings.pullItem());		
		System.out.println("randomly taken element out of the box: " + strings.pullItem());		
		strings.print();
	}

}
