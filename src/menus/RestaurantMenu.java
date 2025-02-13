package menus;

import model.Restaurant;

import static menus.MainMenu.displayMainMenu;
import static utils.ConsoleUtils.*;


public class RestaurantMenu {
    public static void addRestaurant() {
        String name = askString("Entrez le nom de votre restaurant:");
        String address = askString("Entrez l'adresse de votre restaurant:");

        Restaurant restaurant = new Restaurant(name, address);

        System.out.printf("Le restaurant: %s à bien été crée\n", restaurant.toString());

        String message = "Souhaitez-vous revenir au menu principal (1) ou créé un nouveau restaurant (2)?";

        switch (askInt(message)) {
            case 1:
                displayMainMenu();
                break;
            case 2:
                addRestaurant();
                break;
            default:
                System.out.println("Veuillez entrer un nombre entier valide!");
                displayMainMenu();
                break;
        }
    }

    public static void selectRestaurant() {
        Restaurant.displayRestaurants();
        String message = "Choisissez un restaurant:";
        displayRestaurantMenu(Restaurant.getRestaurants().get(askInt(message)));
    }

    public static void displayRestaurantMenu(Restaurant restaurant) {
        System.out.println(restaurant.toString());

        String message ="""
                            Que voulez-vous faire?
                            1. Gestion des employés
                            2. Gestion du menu
                            3. Gestion des commandes
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
