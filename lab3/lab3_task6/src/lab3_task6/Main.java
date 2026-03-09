package lab3_task6;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Circle> circles = new ArrayList<>();
		circles.add(new Circle(4.0));
		circles.add(new Circle(0.3));
		circles.add(new Circle(2.5));
		circles.add(new Circle(1.0));
		
		List<Rectangle> rectangles = new ArrayList<>();
		rectangles.add(new Rectangle(1.3, 2.0));
		rectangles.add(new Rectangle(2.0, 2.0));
		rectangles.add(new Rectangle(10.0, 2.0));
		rectangles.add(new Rectangle(2.5, 2.0));
		
		System.out.println("Circles total area: " + calculateTotalArea(circles));
		System.out.println("Rectangles total area: " + calculateTotalArea(rectangles));
	}
	
	public static Double calculateTotalArea(List<? extends Shape> list) {
		Double res = 0.0;
		for (Shape shape : list) {
			res += shape.getArea();
		}
		return res;
	}
}
