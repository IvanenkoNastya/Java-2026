package lab1_task1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.print("Hello world\n");
		
		Scanner inputScannerObj = new Scanner(System.in);
		String inputStr = inputScannerObj.nextLine();
		inputScannerObj.close();		
		
		//char character = 'N';		
		char character = inputStr.toCharArray()[0];
		System.out.print(character + ": " + (int)character);
	}
}