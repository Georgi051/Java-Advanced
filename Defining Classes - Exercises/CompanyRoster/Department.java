package DefiningClassesExercise.CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employeesList;

    public Department(String name) {
        this.name = name;
        this.employeesList = new ArrayList<>();
    }

    public List<Employee> getEmployeeList() {
        return this.employeesList;
    }

    public Double averageSum(){
        return this.employeesList.stream().mapToDouble(e -> e.getSalary()).average().getAsDouble();
    }
}
