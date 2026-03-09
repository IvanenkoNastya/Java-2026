package lab3_task6;

public class Rectangle implements Shape {
	private Double width;
	private Double height;
	
	public Rectangle(Double width, Double height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public Double getArea() {
		return width * height;
	}
}
