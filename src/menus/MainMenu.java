package menus;

import java.util.Scanner;

import static menus.RestaurantMenu.*;
import static utils.ConsoleUtils.askInt;

public class MainMenu {
    public static void displayMainMenu() {
        String message = """
                Que voulez-vous faire?
                1. Ajouter un restaurant
                2. Gérer un restaurant
                3. Quitter
                """;

        switch (askInt(message)) {
            case 1:
                addRestaurant();
                break;
            case 2:
                selectRestaurant();
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("Veuillez entrer un nombre entier valide!");
                displayMainMenu();
                break;
        }
    }
}
