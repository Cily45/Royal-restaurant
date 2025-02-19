package model;

import java.util.ArrayList;

public class Order {
    private int id;
    private ArrayList<Dish> dishes;
    private int cost;

    public Order(Restaurant restaurant) {
        this.id = nextId(restaurant);
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    public int sumDishes() {
        int sum = 0;
        for (Dish dish : dishes) {
            sum += dish.getPrice();
        }
        return sum;
    }

    public void displayOrder(){
        for (Dish dish : dishes) {
            System.out.println(dish.toString());
        }
        System.out.println(sumDishes());
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", dishes=" + dishes +
                ", cost=" + cost +
                '}';
    }

    public int nextId(Restaurant restaurant){
        int maxId = 0;
        for(Order order : restaurant.getOrders()){
            if(order.id > maxId){
                maxId = order.id;
            }
        }
        return maxId + 1;
    }
}
