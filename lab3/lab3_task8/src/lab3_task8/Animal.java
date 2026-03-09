package lab3_task8;

import java.util.List;

public abstract class Animal {
	
	public String makeSound() {
		return "hi!";
	}
	
	/*public static List<? super Animal> addAnimals(List<? super Animal> list, Animal animal) {
		list.add(animal);
		return list;
	}*/
	
	public static List<T> addAnimals(List<T> list, Animal animal) {
		list.add(animal);
		return list;
	}
}
