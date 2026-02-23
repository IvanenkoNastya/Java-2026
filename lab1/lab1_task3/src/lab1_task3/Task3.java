package lab1_task3;

import java.util.Scanner;

public class Task3 {

	public static void main(String[] args) {
		Scanner inputScannerObj = new Scanner(System.in);
		String inputStr = inputScannerObj.nextLine();
		inputScannerObj.close();
		int mark = TryParceInt(inputStr, -1);

		//int mark = 4;		
		String theAnswer = new String();
	    theAnswer = "no info";
	    switch (mark) {
	    case 1:
	    	theAnswer = "F, Fail";
	    	break;
	    case 2:
	    	theAnswer = "E, Satistifactory";
	    	break;
	    case 3:
            theAnswer = "C, Good";
            break;
	    case 4:
            theAnswer = "B, Good";
	    	break;
	    case 5:
            theAnswer = "A, Exellent";
	    	break;
    	default:
            theAnswer = "not defined mark";
	    	break;
	    }
	    	    
	    System.out.print(mark + " is " + theAnswer);		
	}
	
	public static int TryParceInt(String str, int defaultVariable) {
		try {
			return Integer.parseInt(str);			
		} catch (NumberFormatException e) {			
			return defaultVariable;
		}		
	}

}
