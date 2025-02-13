package model;

import java.io.*;
import java.util.ArrayList;

import static services.FileManager.createDir;

public class Restaurant {
    private static int currentId = 0;
    private static ArrayList<Restaurant> restaurants = new ArrayList<>();
    private int id;
    private String name;
    private String address;
    private Menu menu;
    private ArrayList<Order> orders;
    private ArrayList<Employee> employees;

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
        this.orders = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.id = currentId++;
        restaurants.add(this);
    }

    public static ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }

    public static void displayRestaurants() {
        for (int i = 0; i < restaurants.size(); i++) {
            System.out.printf("%d. %s\n", i, restaurants.get(i).name);
        }
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void displayOrders() {
        for (Order order : orders) {
            System.out.println(order.toString());
        }
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public void searchEmployeesRole(String role) {
        for (Employee employee : employees.stream().filter(e -> e.getRole().equals(role)).toList()) {
            System.out.println(employee.toString());
        }
    }

    public void displayEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    public void saveOrders(String filename) {
        try {
            File file = new File(filename);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Order order : orders) {
                bufferedWriter.write(order.toString());
            }
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sumSalaryEmployees() {
        long count = 0L;
        for (Employee employee : employees) {
            count += (long) employee.getSalary();
        }
        System.out.println(count);
    }

    public void recoverOrders(String filename) {
        try {
            File file = new File(filename);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }



}
