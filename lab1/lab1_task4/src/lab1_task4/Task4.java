package lab1_task4;

import java.util.Scanner;

public class Task4 {

	public static void main(String[] args) {
		Scanner inputScannerObj = new Scanner(System.in);
		String inputStr = inputScannerObj.nextLine();
		inputScannerObj.close();
		int targetNumber = TryParceInt(inputStr, -1);
		if (targetNumber < 1) {
			System.out.print("invalid input");
			return;
		}		
		int previousNumber = 1;
		int currentNumber = 1;
		System.out.print(previousNumber);
		while (currentNumber <= targetNumber) {
			System.out.print(", " + currentNumber);
			currentNumber = currentNumber + previousNumber;
			previousNumber = currentNumber - previousNumber;
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
