package id.ac.polban.employee;

import id.ac.polban.employee.model.*;
import id.ac.polban.employee.service.*;

public class MainApp {

    public static void main(String[] args) {

        Department it = new Department("IT");
        EmploymentType fulltime = new EmploymentType("Full Time");

        Employee emp1 = new Employee(101, "Andi", it, fulltime, 8000000);
        Employee emp2 = new Employee(102, "Budi", it, fulltime, 7500000);

        EmployeeService service = new EmployeeService();
        service.addEmployee(emp1);
        service.addEmployee(emp2);

        System.out.println("Total Karyawan: " + Employee.getTotalEmployees());

        service.raiseSalary(101, 10);

        System.out.println("Gaji Andi setelah naik: " +
                service.getEmployee(101).getSalary());
    }
}