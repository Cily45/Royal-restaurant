package menus;

import model.Restaurant;

import static menus.MainMenu.displayMainMenu;
import static utils.ConsoleUtils.askInt;
import static utils.ConsoleUtils.printHeader;

public class MenuOrder {
    public static void displayOrderMenu(Restaurant restaurant) {
        System.out.println(restaurant.toString());
        printHeader("Que voulez-vous faire?");
        String[] message = {
                "Afficher liste des commandes",
                "Ajouter un nouvelle commande",
                "Supprimer une commande",
                "Menu principale",
                "Quitter"};

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
