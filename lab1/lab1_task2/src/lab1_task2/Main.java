package lab1_task2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner inputScannerObj = new Scanner(System.in);
		String inputStr = inputScannerObj.nextLine();
		inputScannerObj.close();
		
		int number = TryParceInt(inputStr, 0);
		//int number = 23;
		System.out.print("Number " + number);		
		if (number % 2 == 0) {
			System.out.print(" is even");
		} else {
			System.out.print(" is odd");
		}
	}
	
	public static int TryParceInt(String str, int defaultVariable) {
		try {
			return Integer.parseInt(str);			
		} catch (NumberFormatException e) {			
			return defaultVariable;
		}		
	}
}
