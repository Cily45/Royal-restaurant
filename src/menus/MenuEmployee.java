package menus;

import model.Restaurant;

import java.util.Scanner;

import static menus.MainMenu.displayMainMenu;
import static utils.ConsoleUtils.askInt;

public class MenuEmployee {
    public static void displayEmployeeMenu(Restaurant restaurant) {
        System.out.println(restaurant.toString());

        String message = """
                Que voulez-vous faire?
                1. Afficher liste des employés
                2. Ajouter un employé
                3. Supprimer un employé
                4. Menu principale
                5. Quitter
                """;


        switch (askInt(message)) {
            case 1:
                restaurant.displayEmployees();
                displayEmployeeMenu(restaurant);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                displayMainMenu();
                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("Veuillez entrer un nombre entier valide!");
                displayMainMenu();
                break;
        }
    }
}
