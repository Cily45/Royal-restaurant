package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

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
    private File restaurantFile;

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
        this.orders = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.menus = new ArrayList<>();
        this.id = nextId();
        restaurants.add(this);
        this.restaurantFile = createRestaurant(this);
        restaurants.sort(Comparator.comparing(Restaurant::getId));
    }

    public Restaurant(int id, String name, String address, File restaurantFile) {
        this.name = name;
        this.address = address;
        this.orders = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.menus = new ArrayList<>();
        this.id = id;
        this.restaurantFile = restaurantFile;
        restaurants.add(this);
        restaurants.sort(Comparator.comparing(Restaurant::getId));
    }

    public static ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }

    public static boolean isRestaurantExist(String name) {
        return restaurants.stream().anyMatch(r -> r.name.equals(name));
    }

    public static void displayRestaurants() {
        String line = "+------+--------------------+-------------------------------------+----------+----------+----------+";
        System.out.println(line);
        System.out.println("|  Id  |        Nom         |               Adresse               |  Employe |   Menu   | Commande |");
        System.out.println(line);
        for (int i = 0; i < restaurants.size(); i++) {
            System.out.printf("| %4d | %18s | %35s | %8d | %8d | %8d |\n",
                    restaurants.get(i).id,
                    restaurants.get(i).name.substring(0, Math.min(17, restaurants.get(i).name.length())),
                    restaurants.get(i).address.substring(0, Math.min(34, restaurants.get(i).address.length())),
                    restaurants.get(i).employees.size(),
                    restaurants.get(i).menus.size(),
                    restaurants.get(i).orders.size());
        }
        System.out.println(line);

    }

    public void addOrder(Order order) {
        orders.add(order);
        orders.sort(Comparator.comparing(Order::getId));
    }

    public void displayOrders() {
        for (Order order : orders) {
            System.out.println(order.toString());
        }
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        employees.sort(Comparator.comparing(Employee::getId));
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
        String line = "+------+----------------------+----------------------+---------------------+------------+----------+";
        printHeader("Liste des employés");
        System.out.println(line);
        System.out.println("|  Id  |         Nom          |        Prénom        |         Role        |   Début    | Salaire  |");
        System.out.println(line);
        for (int i = 0; i < employees.size(); i++) {
            System.out.printf("| %4d | %20s | %20s | %19s | %s |  %.2f |\n",
                    employees.get(i).getId(),
                    employees.get(i).getFirstName().substring(0, Math.min(employees.get(i).getFirstName().length(), 19)),
                    employees.get(i).getLastName().substring(0, Math.min(employees.get(i).getLastName().length(), 19)),
                    employees.get(i).getRole().substring(0, Math.min(employees.get(i).getRole().length(), 18)),
                    dateToString(employees.get(i).gethireDate()),
                    employees.get(i).getSalary());
        }
        System.out.println(line);
    }

    public void displayMenus() {
        String line =      "+------+----------------------------------+---------------------------------+--------------+-------+";
        printHeader("Liste des menus");
        System.out.println(line);
        System.out.println("|  Id  |               Nom                |              Type               |   Création   | Plats |");
        System.out.println(line);
        for (int i = 0; i < menus.size(); i++) {
            System.out.printf("| %4d | %-32s | %-31s | %12s | %5d |\n",
                    menus.get(i).getId(),
                    menus.get(i).getName().substring(0, Math.min(menus.get(i).getName().length(), 32)),
                    menus.get(i).getMenuType().substring(0, Math.min(menus.get(i).getMenuType().length(), 31)),
                    dateToString(menus.get(i).getDate()),
                    menus.get(i).getDish() == null ? 0 : menus.get(i).getDish().size());
        }
        System.out.println(line);
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

    public File getRestaurantFile() {
        return restaurantFile;
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

    public void removeMenu(int menu) {
        menus.remove(menu);
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public String toStringForText() {
        return String.format("id: %d\nname: %s\naddress: %s\n", id, name, address);
    }

    @Override
    public String toString() {
        return String.format("Restaurant: %s, adresse: %s", name, address);
    }
}
