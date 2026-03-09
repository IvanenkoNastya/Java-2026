package lab3_task1;

import java.util.Objects;
import java.util.HashMap;
import java.util.Map;

public class Student {
	String name;
	String faculty;
	Integer degree;
	
	public Student(String name, String faculty, Integer degree) {
		this.name = name;
		this.faculty = faculty;
		this.degree = degree;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", faculty=" + faculty + ", degree=" + degree + "]";
	}

	@Override
	public int hashCode() {
		//return Objects.hash(degree, faculty, name);		
		int result = 17;
		result = 31 * result + (faculty != null ? faculty.hashCode() : 0);
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + degree;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;			
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Student other = (Student)obj;
		return Objects.equals(degree, other.degree) 
				&& Objects.equals(faculty, other.faculty)
				&& Objects.equals(name, other.name);
	}
	
	public static void addStudentToMap(Map<Integer, Student> map, Student student) {
		map.put(student.hashCode(), student);
		return;
	}
	
	public static void removeStudentFromMap(Map<Integer, Student> map, Integer key) {
		map.remove(key);
		return;
	}
	
	public static String tryFindStudentFromMap(Map<Integer, Student> map, Integer key) {
		Student res = map.get(key);
		if (res == null) {
			return "Couldn't find a student by the key: " + key;
		}
		return res.toString();
	}
	
	public static void showAllElements(Map<Integer, Student> map) {
		for (Integer key : map.keySet()) {
			System.out.println(map.get(key) + "\n");
		}
		return;
	}
	
}
