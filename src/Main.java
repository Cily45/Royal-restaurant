import commands.restaurant.MainRestaurant;

import static services.FileManager.reloadFile;

public class Main {
    public static void main(String[] args) {
        reloadFile();
        new MainRestaurant().execute();
    }
}