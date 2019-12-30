package DefiningClassesExercise.Google;

public class Company {
    private String company;
    private String department;
    private double salary;

    public Company(String companyName, String department, double salary) {
        this.company = companyName;
        this.department = department;
        this.salary = salary;
    }

    public String getCompany() {
        return company;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }
}
