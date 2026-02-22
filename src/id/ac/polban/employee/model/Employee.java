package id.ac.polban.employee.model;

public class Employee {

    private int id;
    private String name;
    private Department department;
    private EmploymentType type;
    private double salary;

    private static int totalEmployees = 0;

    public Employee(int id, String name, Department department, EmploymentType type, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.type = type;
        this.salary = salary;
        totalEmployees++;
    }

    public static int getTotalEmployees() {
        return totalEmployees;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public Department getDepartment() { return department; }
    public EmploymentType getType() { return type; }
    public double getSalary() { return salary; }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}