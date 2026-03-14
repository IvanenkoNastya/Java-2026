package lab3_task8;

public class Cat extends Animal {
	
	public Cat(String name) {
		super(name);
	}

	@Override
	public String makeSound() {
		String sound = "meow";
		System.out.print(sound);
		return sound;
	}

}
