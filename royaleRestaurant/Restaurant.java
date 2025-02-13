package royaleRestaurant;

import java.util.ArrayList;

public class Restaurant {
    private static int id = 0;
    private int idRestaurant;
    private String name;
    private String address;
    private Menu menu;
    private ArrayList<Order> orders;
    private ArrayList<Employee> employees;

    public Restaurant(String name, String address, Menu menu) {
        this.name = name;
        this.address = address;
        this.menu = menu;
        this.orders = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.idRestaurant = id++;
    }

    public void addOrder(Order order){
        orders.add(order);
    }

    public void displayOrders(){
        for(Order order : orders){
            System.out.println(order.toString());
        }
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public void removeEmployee(Employee employee){
        employees.remove(employee);
    }

    public void searchEmployeesRole(){

    }
}
