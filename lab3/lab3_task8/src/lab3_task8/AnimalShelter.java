package lab3_task8;

import java.util.ArrayList;
import java.util.List;

public class AnimalShelter {
	private List<Dog> dogs;
	private List<Animal> otherAnimals;
	
	public AnimalShelter() {
		dogs = new ArrayList<>();
		otherAnimals = new ArrayList<>();
	}
	
	public void addAnimals(Dog dog) {
		dogs.add(dog);
	}
	
	public void addAnimals(Animal animal) {
		otherAnimals.add(animal);
	}
	
	public void addAnimals() {
		for (Animal dog : dogs) {
			otherAnimals.add(dog);
		}
	}
	
	public void printAnimalSounds() {
		for (Animal animal : otherAnimals) {
			animal.makeSound();
			System.out.print(" ");
		}
		System.out.print("\n");
	}
}
