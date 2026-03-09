package lab3_task6;

public class Circle implements Shape {
	private Double radius;

	public Circle(Double radius) {
		this.radius = radius;
	}

	@Override
	public Double getArea() {
		return Math.PI * radius * radius;
	}
}
