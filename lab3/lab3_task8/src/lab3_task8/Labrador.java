package lab3_task8;

public class Labrador extends Dog {

	@Override
	public String makeSound() {
		return "ruff-" + super.makeSound();
	}

}
