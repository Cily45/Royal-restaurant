package royaleRestaurant;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Employee {
    private static int id = 0;
    private int idEmployee;
    private String firstName, lastName;
    private String role;
    private Calendar hirringDate;
    private double salary;

    public Employee(String firstName, String lastName, String role, double salary, Calendar hirringDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.salary = salary;
        this.hirringDate = hirringDate;
        this.idEmployee = id++;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Calendar getHirringDate() {
        return hirringDate;
    }

    public void setHirringDate(Calendar hirringDate) {
        this.hirringDate = hirringDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        Format f = new SimpleDateFormat("dd/MM/yyyy");

        return "royaleRestaurant.Dish.Employee{" +
                "idEmployee=" + idEmployee +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role='" + role + '\'' +
                ", hirringDate=" + f.format(hirringDate.getTime()) +
                ", salary=" + salary +
                '}';
    }
}
