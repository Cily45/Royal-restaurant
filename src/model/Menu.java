package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Menu {
    private int id;
    private String name;
    private Calendar date;
    private String menuType;
    private ArrayList<Dish> dishes;

    public Menu(String name, String menuType, Restaurant restaurant) {
        this.name = name;
        this.menuType = menuType;
        this.id = nextId(restaurant);
    }

    public int nextId(Restaurant restaurant) {
        int maxId = 0;
        for (Menu menu : restaurant.getMenu()) {
            if (menu.id > maxId) {
                maxId = menu.id;
            }
        }
        return maxId + 1;
    }

    public void addDish(Dish dish) {
        this.dishes.add(dish);
    }

    public void removeDish(Dish dish) {
        this.dishes.remove(dish);
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

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public ArrayList<Dish> getDish() {
        return dishes;
    }

    public void setDish(ArrayList<Dish> dish) {
        this.dishes = dish;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public void displayDishes() {
        for (Dish dish : dishes) {
            System.out.print(dish.toString());
        }
    }

    public void findDish(String dishName) {
        dishes.stream().filter(dish -> dish.getName().equals(dishName))
                .findFirst()
                .ifPresent(dish -> System.out.println(dish.toString()));
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", menuType='" + menuType + '\'' +
                ", dishes=" + dishes +
                '}';
    }
}
