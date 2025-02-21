package model;

import java.io.*;
import java.util.ArrayList;

import static services.CreateNewObject.createRestaurant;
import static utils.ConsoleUtils.dateToString;
import static utils.ConsoleUtils.printHeader;


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
        createRestaurant(this);
    }

    public Restaurant(int id, String name, String address) {
        this.name = name;
        this.address = address;
        this.orders = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.menus = new ArrayList<>();
        this.id =id;
        restaurants.add(this);
    }

    public static ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }

    public static boolean isRestaurantExist(String name){
        return restaurants.stream().anyMatch(r -> r.name.equals(name));
    }

    public static void displayRestaurants() {
        String line =       "+------+-------------+---------------------+---------+------+----------+";
        printHeader("Liste des restaurants");
        System.out.println(line);
        System.out.println( "|  Id  |    Nom      |      Adresse        | Employe | Menu | Commande |" );
        System.out.println(line);
        for (int i = 0; i < restaurants.size(); i++) {
            System.out.printf("| %4d | %11s | %19s | %7d | %4d | %8d |\n", restaurants.get(i).id, restaurants.get(i).name, restaurants.get(i).address, restaurants.get(i).employees.size(), restaurants.get(i).menus.size(), restaurants.get(i).orders.size());
        }
        System.out.println(line);

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
        String line =       "+------+-------------+---------------------+---------+------+----------+";
        printHeader("Liste des employés");
        System.out.println(line);
        System.out.println( "|  Id  |    Nom    |    Prénom    |    Role    |    Début    | Salaire |" );
        System.out.println(line);
        for (int i = 0; i < employees.size(); i++) {
            System.out.printf("| %4d | %9s | %10s | %10s |  %s | %s |\n", employees.get(i).getId(), employees.get(i).getFirstName(), employees.get(i).getLastName(), employees.get(i).getRole(), dateToString(employees.get(i).getHirringDate()), employees.get(i).getSalary());
        }
        System.out.println(line);
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

    public String toStringForText(){
        return String.format("id: %d\nname: %s\naddress: %s\n", id, name, address);
    }

    @Override
    public String toString() {
        return String.format("Restaurant: %s, adresse: %s", name, address);
    }
}
