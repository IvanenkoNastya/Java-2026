package task4;

public class Employee implements Comparable {
	public String Name;
	public Integer Salary;
	
	public Employee(String name, Integer salary) {
		Name = name;
		Salary = salary;
	}
	
	@Override
	public String toString() {
		return Name + " (" + Salary + ")";
	}

	public String getSalaryCategory() {
		if (Salary < 3000) {
			return "less than 3000";
		} else if (Salary > 5000) {
			return "more than 5000";
		} else {
			return "between 3000 and 5000";
		}
	}
	
	public Integer getSalary() {
        return Salary;
    }
	
	@Override
	public int compareTo(Object o) {
		if (o == this) {
			return 1;
		}
		return 0;
	}
}
