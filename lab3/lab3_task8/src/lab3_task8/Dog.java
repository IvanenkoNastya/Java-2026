package lab3_task8;

import java.util.List;

public class Dog extends Animal {
	
	public Dog(String name) {
		super(name);
	}
	
	@Override
	public String makeSound() {
		String sound = "woof";
		System.out.print(sound);
		return sound;
	}
	
	/*@Override
	public static List<Dog> addAnimals(List<Dog> list, Dog animal) {
		list.add(animal);
		return list;
	}*/
	
}
