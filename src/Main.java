import menus.MainMenu;
import model.Restaurant;

import static services.FileManager.test;

public class Main {
    public static void main(String[] args) {
        test();
        System.out.println(Restaurant.getRestaurants());
        MainMenu.displayMainMenu();
    }
}