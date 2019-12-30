package DefiningClassesExercise.CompanyRoster;

public class Employee {
    private String name;
    private double salary;
    private String email;
    private int age;

    public Employee(String name,double salary){
        this.name = name;
        this.salary = salary;
        this.email = "n/a";
        this.age = -1;
    }

    public Employee(String name,double salary,String email){
        this(name,salary);
        this.email = email;
    }

    public Employee(String name,double salary,int age){
        this(name,salary);
        this.age = age;
    }

    public Employee(String name,double salary,String email,int age){
        this(name,salary);
        this.email = email;
        this.age = age;
    }

    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d",this.name,this.salary,
                this.email,this.age);
    }
}
