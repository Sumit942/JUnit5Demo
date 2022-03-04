package com.example.demo;

import com.example.demo.employee.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	//1. Simple JUnit test
	@Test
	void removeAFromFirstPositionTest() {
		StringHelper helper = new StringHelper();
		assertEquals("CD",helper.removeAFromFirstPosition("AACD"));
	}

	//3. 1.Employee without hashCode & equals
	@Test
	void employeeWithoutHashCodeAndEqualsTest() {
		Set<Employee> empSet = new HashSet<>();
		empSet.add(new Employee(1, "Sumit", "Paswan"));
		empSet.add(new Employee(1, "Sumit", "Paswan"));

		EmployeeService empService = new EmployeeService();
		assertEquals(empService.getSizeOfEmpSet(empSet), empSet.size());
	}

	//3. 2.Employee with hashCode
	@Test
	void employeeWithHashCodeTest() {
		Set<Employee_withHash> empSet = new HashSet<>();
		empSet.add(new Employee_withHash(1, "Sumit", "Paswan"));
		empSet.add(new Employee_withHash(1, "Sumit", "Paswan"));

		EmployeeService empService = new EmployeeService();
		assertEquals(empService.getSizeOfEmpWithHashSet(empSet), empSet.size());
	}

	//3. 3.Employee with equals
	@Test
	void employeeWithEqualsTest() {
		Set<Employee_withEq> empSet = new HashSet<>();
		empSet.add(new Employee_withEq(1, "Sumit", "Paswan"));
		empSet.add(new Employee_withEq(1, "Sumit", "Paswan"));

		EmployeeService empService = new EmployeeService();
		assertEquals(empService.getSizeOfEmpWithEqualsSet(empSet), empSet.size());
	}

	//3. 4.Employee with hashCode and equals
	@Test
	void employeeWithHashCodeAndEqualsTest() {
		Set<Employee_withEqAndHash> empSet = new HashSet<>();
		empSet.add(new Employee_withEqAndHash(1, "Sumit", "Paswan"));
		empSet.add(new Employee_withEqAndHash(1, "Sumit", "Paswan"));

		EmployeeService empService = new EmployeeService();
		assertEquals(empService.getSizeOfEmpWithHashAndEquals(empSet), empSet.size());
	}

	//4. 1.adding emp in TreeSet and check default sorting
	@Test
	void employeeTreeSetDefaultSortingTest() {
		String expectedStringEmpList = "[Employee{id=1, firstName='Sumit', lastName='Paswan'}, " +
				"Employee{id=2, firstName='Priyanka', lastName='Shinde'}, " +
				"Employee{id=3, firstName='Rahul', lastName='Yadav'}]";

		Set<Employee_withEqAndHash> empTSet = new TreeSet<>();
		empTSet.add(new Employee_withEqAndHash(1,"Sumit","Paswan"));
		empTSet.add(new Employee_withEqAndHash(2,"Priyanka","Shinde"));
		empTSet.add(new Employee_withEqAndHash(3,"Rahul","Yadav"));

		assertEquals(empTSet.toString(), expectedStringEmpList);
	}

	//4. 2.adding emp in TreeSet and check custom sorting with firstName only.
	@Test
	void employeeTreeSetCustomSortingWithFirstNameTest() {
		String expectedStringEmpList = "[Employee{id=2, firstName='Priyanka', lastName='Shinde'}, " +
				"Employee{id=3, firstName='Rahul', lastName='Yadav'}, " +
				"Employee{id=1, firstName='Sumit', lastName='Paswan'}]";

		//adding comparator for sorting on the basis of first name
		Set<Employee_withEqAndHash> empTSet =
				new TreeSet<>(Comparator.comparing(Employee_withEqAndHash::getFirstName));
		empTSet.add(new Employee_withEqAndHash(1,"Sumit","Paswan"));
		empTSet.add(new Employee_withEqAndHash(2,"Priyanka","Shinde"));
		empTSet.add(new Employee_withEqAndHash(3,"Rahul","Yadav"));

		assertEquals(empTSet.toString(), expectedStringEmpList);
	}

	//5. square of each number using stream from numbers list
	@Test
	void squareOfNumbersFromListUsingStreamTest() {

		String expectedValue = "[4, 25, 9, 36, 9, 36]";

		Function<Integer, Integer> sqrFunc = n -> n * n;

		String actualValue = Arrays.asList(2,5,3,6,3,6)
				.stream()
				.map(sqrFunc)
				.collect(Collectors.toList())
				.toString();

		assertEquals(actualValue, expectedValue);
	}

	//6. find square of all even numbers using streams from numbers list
	@Test
	void squareOfAllEvenNumbersFromListUsingStreamTest() {

		String expectedValue = "[4, 36, 36]";

		Function<Integer, Integer> sqrFunc = n -> n * n;

		Predicate<Integer> evenPred = n -> n % 2 == 0;

		String actualValue = Arrays.asList(2,5,3,6,3,6)
				.stream()
				.filter(evenPred)
				.map(sqrFunc)
				.collect(Collectors.toList())
				.toString();

		assertEquals(actualValue, expectedValue);
	}

	//7. Try with resource, check if the resource has closed after execution
	@Test
	void tryWithResourceCheckIfResourceIsClosedTest() {

		Scanner tempScanner;
		try (Scanner sc = new Scanner(System.in)) {
			tempScanner = sc;
		}

		String expectedErr = "Scanner closed";
		String actaulErr = null;
		try {
			tempScanner.nextLine();
		} catch (Exception e) {
			actaulErr = e.getLocalizedMessage();	// Storing errMsg in String
		}

		assertEquals(expectedErr, actaulErr);
	}
}
