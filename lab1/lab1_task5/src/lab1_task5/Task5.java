package lab1_task5;

public class Task5 {

	public static void main(String[] args) {
		int[][] matrix = {
				{10, 22, 33, 44},
				{-1, -5, 40, 25},
				{11, 12, 12, 122},
				{-2, -3, -4, -2}
		};
		
		int sum = 0;
		for (int i = 0; i < matrix.length; i++) {
			sum += matrix[i][i];
			if (i != 0) {
				System.out.print(" + ");
			}
			if (matrix[i][i] < 0) {
				System.out.print("(" + matrix[i][i] + ")");	
			} else {
				System.out.print(matrix[i][i]);				
			}
		}
		System.out.print(" = ");
		System.out.print(sum);
	}
}
