package menus;

import model.Restaurant;

import static menus.MainMenu.displayMainMenu;
import static utils.ConsoleUtils.*;


public class MenuRestaurant {
    public static void addRestaurant() {
        String name = askString("Entrez le nom de votre restaurant:");

        if(Restaurant.isRestaurantExist(name)){
            System.out.println("Ce restaurant existe déjà, veuillez en choisir un autre nom ou compléter le");
            addRestaurant();
        }

        String address = askString("Entrez l'adresse de votre restaurant:");

        Restaurant restaurant = new Restaurant(name, address);

        System.out.printf("Le restaurant: %s à bien été crée\n", restaurant.toString());
        addRestaurantMenu(restaurant);
    }

    public static void addRestaurantMenu(Restaurant restaurant) {
        String message = """
                Que voulez-vous faire?
                1. Créé un nouveau restaurant
                2. Gérer le dernier restaurant créé
                3. Menu principale
                4. Quitter
                """;

        switch (askInt(message)) {
            case 1:
                addRestaurant();
                break;
            case 2:
                displayRestaurantMenu(restaurant);
                break;
            case 3:
                displayMainMenu();
                break;

            case 4:
                System.exit(0);

            default:
                System.out.println("Veuillez entrer un nombre entier valide!");
                addRestaurantMenu(restaurant);
                break;
        }
    }

    public static void selectRestaurant() {
        Restaurant.displayRestaurants();
        String message = "Choisissez un restaurant à gérer:";
        displayRestaurantMenu(Restaurant.getRestaurants().get(askInt(message)));
    }

    public static void displayRestaurantMenu(Restaurant restaurant) {
        System.out.println(restaurant.toString());

        String message = """
                Que voulez-vous faire?
                1. Gestion des employés
                2. Gestion du menu
                3. Gestion des commandes
                4. Menu principale
                5. Quitter
                """;

        switch (askInt(message)) {
            case 1:
                MenuEmployee.displayEmployeeMenu(restaurant);
                break;
            case 2:
                MenuMenu.displayMenuMenus(restaurant);
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
