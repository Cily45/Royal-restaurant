package model;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static services.CreateNewObject.createMenu;
import static utils.ConsoleUtils.dateToString;

public class Menu {
    private int id;
    private String name;
    private Date createDate;
    private String menuType;
    private ArrayList<Dish> dishes;
    private File menuFile;


    public Menu(String name, String menuType, Restaurant restaurant, Date createDate) {
        this.name = name;
        this.menuType = menuType;
        this.id = nextId(restaurant);
        this.createDate = createDate;
        this.dishes = new ArrayList<>();
        this.menuFile = createMenu( this, restaurant);
        restaurant.addMenu(this);

    }

    public Menu(int id, String name, String menuType, Date createDate, File menuFile) {
        this.name = name;
        this.menuType = menuType;
        this.id = id;
        this.createDate = createDate;
        this.menuFile = menuFile;
    }

    public int nextId(Restaurant restaurant) {
        int maxId = 0;
        for (Menu menu : restaurant.getMenus()) {
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

    public Date getDate() {
        return createDate;
    }

    public void setDate(Date date) {
        this.createDate = date;
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

    public String toStringForText() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("id: %d\nname: %s\nmenuType: %s\ncreateDate: %s\n", id, name, menuType, dateToString(createDate)));

        for (int i = 0; i < dishes.size(); i++) {
            result.append(String.format("dish %d: %s\n", i, dishes.get(i).toStringForText()));
        }

        return result.toString();
    }

    public File getMenuFile() {
        return menuFile;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", nom='" + name + '\'' +
                ", create date=" + createDate +
                ", menuType='" + menuType + '\'' +
                ", dishes=" + dishes +
                '}';
    }
}
