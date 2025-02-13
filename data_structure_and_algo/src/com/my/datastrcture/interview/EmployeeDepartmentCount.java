package com.my.datastrcture.interview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
    String id;
    String name;
    int salary;
    Department department;

    public Employee(String id, String name, int salary, Department department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }
}

class Department {
    String id;
    String name; // unique

    public Department(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class EmployeeDepartmentCount {
    public static void main(String[] args) {
        Department d1 = new Department("1", "IT");
        Department d2 = new Department("2", "HR");

        List<Employee> employees = Arrays.asList(
                new Employee("E1", "Alice", 50000, d1),
                new Employee("E2", "Bob", 60000, d1),
                new Employee("E3", "Charlie", 70000, d2),
                new Employee("E4", "David", 55000, d1)
        );

        // Counting employees in each department
        Map<String, Long> departmentCount = employees.stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment().getName(), Collectors.counting()));

        // Output
        System.out.println(departmentCount);
    }
}

