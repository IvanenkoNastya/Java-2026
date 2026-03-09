package lab3_task1;

import java.util.HashMap;
import java.util.Map;

public class main {

	public static void main(String[] args) {	
		Map<Integer, Student> mapOfStudents = new HashMap<>();
		
		Student student1 = new Student("Albert", "Physics", 2);
		Student student2 = new Student("to be found", "Physics", 4);
		
		Student.addStudentToMap(mapOfStudents, student1);
		Student.addStudentToMap(mapOfStudents, student2);
		Student.addStudentToMap(mapOfStudents, new Student("Albert", "Physics", 2));
		Student.addStudentToMap(mapOfStudents, new Student("Pythagoras", "Mathematics", 1));
		Student.addStudentToMap(mapOfStudents, new Student("Marie Curi", "Physics", 3));
		Student.addStudentToMap(mapOfStudents, new Student("Kant", "Philosophy", 1));
		Student.addStudentToMap(mapOfStudents, new Student("Socrates", "Philosophy", 1));
		Student.addStudentToMap(mapOfStudents, new Student("Plato", "Philosophy", 1));
		
		Student.removeStudentFromMap(mapOfStudents, student1.hashCode());	
		
		Student.showAllElements(mapOfStudents);
		
		printFormated("search: " + Student.tryFindStudentFromMap(mapOfStudents, student2.hashCode()));
	}
	
	public static void printFormated(String message) {
		System.out.print(message + "\n");
		return;
	}
}
