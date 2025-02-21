import menus.MainMenu;
import model.Restaurant;

import static services.FileManager.reloadFile;

public class Main {
    public static void main(String[] args) {
        reloadFile();
        MainMenu.displayMainMenu();
    }
}