package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Dish {
    private int id;
    private String name;
    private String description;
    private double price;
    private int calorie;
    private String category;
    private int size; //nombre de pers.
    private Date createDate;
    private boolean available;
    private ArrayList<String> ingredients;
    private String dishType;
    private int timeToPrepare;
    private double specialPrice;
    private String menuFile;

    public Dish(String name, String description, double price, int calorie, String category, int size, Date createDate, boolean available, ArrayList<String> ingredients, String dishType, int timeToPrepare, double specialPrice, Menu menu) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.calorie = calorie;
        this.category = category;
        this.size = size;
        this.createDate = createDate;
        this.available = available;
        this.ingredients = ingredients;
        this.dishType = dishType;
        this.timeToPrepare = timeToPrepare;
        this.specialPrice = specialPrice;
        this.id = nextId(menu);
        menu.addDish(this);
    }

    public Dish(int id, String name, String description, double price, int calorie, String category, int size, Date createDate, boolean available, ArrayList<String> ingredients, String dishType, int timeToPrepare, double specialPrice, String menuFile) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.calorie = calorie;
        this.category = category;
        this.size = size;
        this.createDate = createDate;
        this.available = available;
        this.ingredients = ingredients;
        this.dishType = dishType;
        this.timeToPrepare = timeToPrepare;
        this.specialPrice = specialPrice;
        this.id = id;
        this.menuFile = menuFile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Date getcreateDate() {
        return createDate;
    }

    public void setcreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getDishType() {
        return dishType;
    }

    public void setDishType(String dishType) {
        this.dishType = dishType;
    }

    public int getTimeToPrepare() {
        return timeToPrepare;
    }

    public void setTimeToPrepare(int timeToPrepare) {
        this.timeToPrepare = timeToPrepare;
    }

    public double getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(int specialPrice) {
        this.specialPrice = specialPrice;
    }

    public String toStringForText() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("id: %d\nname: %s\ndescription: %s\nprice: %d\ncalorie: %d\ncategory: %s\nsize: %s\ncreateDate: %s\navailable: %b\ndishType: %s\ntimeToPrepare: %d\nspecialPrice: %d\n",
                id, name, description, price, calorie, category, size, createDate, available, dishType, timeToPrepare, specialPrice));

        for (int i = 0; i < ingredients.size(); i++) {
            result.append(String.format("ingredient %d: %s\n", i, ingredients.get(i)));
        }

        return result.toString();
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", calorie=" + calorie +
                ", category='" + category + '\'' +
                ", size='" + size + '\'' +
                ", createDate=" + createDate +
                ", available=" + available +
                ", ingredients=" + ingredients +
                ", dishType='" + dishType + '\'' +
                ", timeToPrepare=" + timeToPrepare +
                ", specialPrice=" + specialPrice +
                '}';
    }

    public int nextId(Menu menu) {
        int maxId = 0;
        for (Dish dish : menu.getDish()) {
            if (dish.id > maxId) {
                maxId = dish.id;
            }
        }
        return maxId + 1;
    }
}
