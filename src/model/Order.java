package model;

import java.util.ArrayList;

public class Order {
    private int idOrder;
    private ArrayList<Dish> dishes;
    private int cost;

    public Order(ArrayList<Dish> dishes, int idOrder) {
        this.dishes = dishes;
        this.idOrder = idOrder;
    }
}
