package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Dish {
    private int id;
    private String name;
    private String description;
    private int price;
    private int calorie;
    private String category;
    private String size; //nombre de pers.
    private Calendar addDate;
    private boolean available;
    private ArrayList<String> ingredients;
    private String dishType;
    private int timeToPrepare;
    private int specialPrice;

    public Dish(String name, String description, int price, int calorie, String category, String size, Calendar addDate, boolean available, ArrayList<String> ingredients, String dishType, int timeToPrepare, int specialPrice, Menu menu) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.calorie = calorie;
        this.category = category;
        this.size = size;
        this.addDate = addDate;
        this.available = available;
        this.ingredients = ingredients;
        this.dishType = dishType;
        this.timeToPrepare = timeToPrepare;
        this.specialPrice = specialPrice;
        this.id = nextId(menu);
        menu.addDish(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Calendar getAddDate() {
        return addDate;
    }

    public void setAddDate(Calendar addDate) {
        this.addDate = addDate;
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

    public int getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(int specialPrice) {
        this.specialPrice = specialPrice;
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
                ", addDate=" + addDate +
                ", available=" + available +
                ", ingredients=" + ingredients +
                ", dishType='" + dishType + '\'' +
                ", timeToPrepare=" + timeToPrepare +
                ", specialPrice=" + specialPrice +
                '}';
    }

    public int nextId(Menu menu){
        int maxId = 0;
        for(Dish dish : menu.getDish()){
            if(dish.id > maxId){
                maxId = dish.id;
            }
        }
        return maxId + 1;
    }
}
