package lab3_task8;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Dog someDog = new Dog("sdfg");
		Labrador someLabrador = new Labrador("sdfg1");
		Cat someCat = new Cat("sdfg2");
		
		List<Dog> dogs = new ArrayList<>();
		dogs.add(new Dog("name1"));
		
		AnimalShelter shelter = new AnimalShelter();
		
		shelter.addAnimals(someDog);
		shelter.addAnimals(new Dog("dog1"));
		shelter.addAnimals(new Dog("dog2"));
		shelter.addAnimals(someLabrador);
		shelter.addAnimals(new Labrador("labrador1"));
		shelter.addAnimals(new Labrador("labrador2"));
		shelter.addAnimals(new Labrador("labrador3"));

		shelter.addAnimals(someCat);
		shelter.addAnimals(new Cat("cat1"));
		shelter.addAnimals(new Cat("cat2"));

		shelter.printAnimalSounds();
		
		shelter.addAnimals();
		
		shelter.printAnimalSounds();
	}

}
