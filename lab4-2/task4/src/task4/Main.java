package task4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(
				new Employee("Low1", 1000),
				new Employee("Avg1", 4400),
				new Employee("Low2", 2900),
				new Employee("Avg2", 3500),
				new Employee("High1", 8000)
			);
		
		Map<String, List<Employee>> employeesBySalary = employees.stream()
				.collect(Collectors.groupingBy(Employee::getSalaryCategory));
		
		Map<String, Optional<Employee>> employeesWithTheHighestSalaryInEchGroup = employees.stream()
				.collect(Collectors.groupingBy(Employee::getSalaryCategory,
						Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)))
						);
		
		System.out.println("All employees grouped by salary:");
		System.out.println(employeesBySalary);
		System.out.println();
		System.out.println("Employees with the hightst salary in each group:");
		System.out.println(employeesWithTheHighestSalaryInEchGroup);
	}

}
