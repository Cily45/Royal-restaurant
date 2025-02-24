package model;

import java.util.ArrayList;


public class Order {
    private int id;
    private ArrayList<Dish> dishes;
    private int cost = 0;
    private String restaurantFile;

    public Order(Restaurant restaurant) {
        this.id = nextId(restaurant);
    }

    public Order(int id, String restaurantFile) {
        this.id = id;
        this.restaurantFile = restaurantFile;
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
        cost = sumDishes();
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

    public String toStringForText(){
        StringBuilder result = new StringBuilder();
        result.append(String.format("id: %d\ncost: %d", id, cost));

        for (int i = 0; i < dishes.size(); i++) {
            result.append(String.format("dish %d: %s\n", i, dishes.get(i).toStringForText()));
        }

        return result.toString();
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
