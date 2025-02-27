package model;

import java.util.HashMap;


public class Order {
    private int id;
    private HashMap<Dish, Integer> dishes;
    private int cost = 0;
    private String orderFile;

    public Order(Restaurant restaurant) {
        this.id = nextId(restaurant);
    }

    public Order(int id, String orderFile) {
        this.id = id;
        this.orderFile = orderFile;
    }

    public void addDish(Dish dish, int quantity) {
        if(dishes.get(dish) == null) {
            dishes.put(dish, quantity);
        }else{
           dishes.put(dish,(dishes.get(dish) + quantity));
        }
        dishes.put(dish, quantity);
        cost += dish.getPrice() * quantity;
    }

    public void deleteDish(Dish dish){
        dishes.remove(dish);
    }

    public void displayOrder(){
        for (Dish dish : dishes.keySet()) {
            System.out.println(dish.toString());
        }
        System.out.println(cost);
    }

    public String toStringForText(){
        StringBuilder result = new StringBuilder();
        result.append(String.format("id: %d\ncost: %d", id, cost));
        int count = 1;
        for (Dish dish : dishes.keySet()) {
            result.append(String.format("dish %d: %s\n", count, dish.toStringForText()));
            count++;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
