package task6;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Person petro = new Person("Petro");
		Person dmitro = new Person("Dmitro");
		Person kate = new Person("Kate");
		Person sophia = new Person("Sophia");
		Person ivan = new Person("Ivan");

		List<Person> friendsGroup1 = Arrays.asList(petro, ivan, kate);
		List<Person> friendsGroup2 = Arrays.asList(ivan, kate, sophia);
		
		petro.addFriends(friendsGroup1);
		petro.addFriends(friendsGroup2);
		dmitro.addFriends(friendsGroup1);
		kate.addFriends(friendsGroup2);
		
		System.out.println(petro.getFriendsUnique());
		System.out.println(dmitro.getFriendsUnique());
		System.out.println(kate.getFriendsUnique());
		System.out.println(sophia.getFriendsUnique());
		
	}
}
