package DefiningClassesExercise.CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Department> departmentMap = new HashMap<>();

        while (n-- > 0) {
            String[] inputData = scanner.nextLine().split("\\s+");
            String name = inputData[0];
            double salary = Double.parseDouble(inputData[1]);
            String department = inputData[3];

            Employee employee = null;
            switch (inputData.length) {
                case 4:
                    employee = new Employee(name, salary);
                    break;
                case 5:
                    if (inputData[4].contains("@")) {
                        employee = new Employee(name, salary, inputData[4]);
                    } else {
                        employee = new Employee(name, salary, Integer.parseInt(inputData[4]));
                    }
                    break;
                case 6:
                    int age = Integer.parseInt(inputData[5]);
                    employee = new Employee(name, salary, inputData[4], age);
                    break;
            }
            departmentMap.putIfAbsent(department, new Department(department));
            departmentMap.get(department).getEmployeeList().add(employee);
        }

        departmentMap.entrySet().stream().sorted((f, s) ->
                s.getValue().averageSum().compareTo(f.getValue().averageSum())
        ).findFirst().stream().forEach(department -> {
            System.out.println(String.format("Highest Average Salary: %s", department.getKey()));
            department.getValue().getEmployeeList().stream().sorted((f, s) ->
                    Double.compare(s.getSalary(), f.getSalary()))
                    .forEach(employee -> System.out.println(employee.toString()));
        });
    }
}
