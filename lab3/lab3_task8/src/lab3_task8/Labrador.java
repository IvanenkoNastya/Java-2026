package lab3_task8;

public class Labrador extends Dog {

	public Labrador(String name) {
		super(name);
	}
	
	@Override
	public String makeSound() {
		String sound = "ruff-" + super.makeSound();
		System.out.print(sound);
		return sound;
	}

}
