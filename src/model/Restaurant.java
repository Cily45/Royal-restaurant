package model;

import java.io.*;
import java.util.ArrayList;

import static services.FileManager.createDir;

public class Restaurant {
    private static ArrayList<Restaurant> restaurants = new ArrayList<>();
    private int id;
    private String name;
    private String address;
    private ArrayList<Menu> menus;
    private ArrayList<Order> orders;
    private ArrayList<Employee> employees;

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
        this.orders = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.menus = new ArrayList<>();
        this.id = nextId();
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

    public ArrayList<Menu> getMenus() {
        return menus;
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

    public static void setRestaurants(ArrayList<Restaurant> restaurants) {
        Restaurant.restaurants = restaurants;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Menu> getMenu() {
        return menus;
    }

    public void addMenu(Menu menu) {
        this.menus.add(menu);
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public int nextId() {
        int maxId = 0;
        for (Restaurant restaurant : restaurants) {
            if (restaurant.id > maxId) {
                maxId = restaurant.id;
            }
        }
        return maxId + 1;
    }

    public void displayMenus() {
        for (Menu menu : menus) {
            System.out.println(menu.toString());
        }
    }

    public void removeMenu(int menu) {
        menus.remove(menu);
    }

    @Override
    public String toString() {
        return String.format("Restaurant: %s, %s", name, address);
    }
}
