package lab3_task8;

import java.util.List;

public abstract class Animal {
	public String name;
	
	public Animal(String name) {
		this.name = name;
	}
	
	public String makeSound() {
		String sound = "hi!";
		System.out.print(sound);
		return sound;
	}
	
	// for adding one element
	public static List<Animal> addAnimals(List<Animal> listOriginal, Animal animalToAdd) {
		listOriginal.add(animalToAdd);
		return listOriginal;
	}
	
	// adding list of animals
	public List<Animal> addAnimals(List<Animal> listOriginal, List<Animal> animalsToAdd) {
		for (Animal animal : animalsToAdd) {
			listOriginal.add(animal);
		}
		return listOriginal;
	}
}
