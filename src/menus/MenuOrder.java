package menus;

import model.Restaurant;

import static menus.MainMenu.displayMainMenu;
import static utils.ConsoleUtils.askInt;

public class MenuOrder {
    public static void displayOrderMenu(Restaurant restaurant) {
        System.out.println(restaurant.toString());

        String message = """
                Que voulez-vous faire?
                1. Afficher liste des commandes
                2. Ajouter un nouvelle commande
                3. Supprimer une commande
                4. Menu principale
                5. Quitter
                """;

        switch (askInt(message)) {
            case 1:
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
