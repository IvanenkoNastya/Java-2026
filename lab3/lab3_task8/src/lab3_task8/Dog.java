package lab3_task8;

import java.util.List;

public abstract class Dog extends Animal {
	
	@Override
	public String makeSound() {
		return "woof";
	}
	
	@Override
	public static List<Dog> addAnimals(List<Dog> list, Dog animal) {
		list.add(animal);
		return list;
	}
	
}
