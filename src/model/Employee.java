package model;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static services.CreateNewObject.createEmploye;
import static utils.ConsoleUtils.dateToString;

public class Employee {
    private int id;
    private String firstName, lastName;
    private String role;
    private Date hirringDate;
    private double salary;
    private String restaurantFile;

    public Employee(String firstName, String lastName, String role, double salary, Date hirringDate, Restaurant restaurant) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.salary = salary;
        this.hirringDate = hirringDate;
        this.id = nextId(restaurant);
        this.restaurantFile = String.format("%s/data/%d-%s/employees",System.getProperty("user.dir"), restaurant.getId(), restaurant.getName());
        restaurant.addEmployee(this);
        createEmploye(this, restaurant);
    }
    public Employee(int id,String firstName, String lastName, String role, double salary, Date hirringDate, String restaurantFile) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.salary = salary;
        this.hirringDate = hirringDate;
        this.id = id;
        this.restaurantFile = restaurantFile;
    }

    public int getId() {
        return id;
    }

    public void setId(int idEmployee) {
        this.id = idEmployee;
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

    public Date getHirringDate() {
        return hirringDate;
    }

    public void setHirringDate(Date hirringDate) {
        this.hirringDate = hirringDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int nextId(Restaurant restaurant) {
        int maxId = 0;
        for (Employee employee : restaurant.getEmployees()) {
            if (employee.id > maxId) {
                maxId = employee.id;
            }
        }
        return maxId + 1;
    }

    public String toStringForText() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("id: %d\nfirstName: %s\nlastName: %s\nrole: %s\nsalary: %.2f\nhirringDate: %s\n",
                id, firstName, lastName, role, salary, dateToString(hirringDate)));
        return result.toString();
    }

    @Override
    public String toString() {
        Format f = new SimpleDateFormat("dd/MM/yyyy");

        return "royaleRestaurant.Dish.Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role='" + role + '\'' +
                ", hirringDate=" + f.format(hirringDate.getTime()) +
                ", salary=" + salary +
                '}';
    }

    public String getRestaurantFile() {
        return restaurantFile;
    }

    public void setRestaurantFile(String restaurantFile) {
        this.restaurantFile = restaurantFile;
    }
}
