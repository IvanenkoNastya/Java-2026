package task6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Person {
	public String Name;
	public List<Person> Friends;
	
	public Person(String name) {
		Name = name;
		Friends = new ArrayList<Person>();
	}
	
	public void addFriends(List<Person> friends) {
		Friends.addAll(friends);
		if (Friends.contains(this)) {
			Friends.remove(this);
		}
	}
	
	/*public static void formFriendsGroup(List<Person> friends) {
		for (Person friend : friends) {

		}
	}*/
	
	@Override
	public String toString() {
		return Name;
	}
	
	public String getFriendsUnique() {
		String uniqueFriendsNames = Friends.stream()
				.distinct()
				.map(elem -> elem.Name.toUpperCase())
				.collect(Collectors.joining(", "));
		if (Friends.isEmpty()) {
			uniqueFriendsNames = "no friends";
		}
		//Optional<String> friends = Optional.ofNullable(uniqueFriendsNames);
		return "Friends of " + this.Name + ": " + uniqueFriendsNames;
	}
}
