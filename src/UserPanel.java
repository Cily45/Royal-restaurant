import model.Restaurant;

import java.util.Scanner;

public class UserPanel {

    public static void displayMainMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Que voulez-vous faire?
                1. Ajouter un restaurant
                2. Gérer un restaurant
                3. Quitter
                """);

        switch (scanner.nextLine()) {
            case "1":
                addRestaurant();
                break;
            case "2":
                selectRestaurant();
                break;
            case "3":
                System.exit(0);
        }
    }

    public static void addRestaurant() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez le nom de votre restaurant:");
        String name = scanner.nextLine();

        System.out.println("Entrez l'adresse de votre restaurant:");
        String address = scanner.nextLine();

        Restaurant restaurant = new Restaurant(name, address);

        System.out.printf("Le restaurant: %s à bien été crée\n", restaurant.toString());
        System.out.println("Souhaitez-vous revenir au menu principal (1) ou créé un nouveau restaurant (2)?");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                displayMainMenu();
                break;
            case "2":
                addRestaurant();
                break;
        }
    }

    public static void selectRestaurant() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choisissez un restaurant:");
        Restaurant.displayRestaurants();

        String choice = scanner.nextLine();
        displayRestaurantMenu(Restaurant.getRestaurants().get(Integer.parseInt(choice)));
    }

    public static void displayRestaurantMenu(Restaurant restaurant) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(restaurant.toString());
        System.out.println("""
                Que voulez-vous faire?
                1. Gestion des employés
                2. Gestion du menu
                3. Gestion des commandes
                4. Menu principale
                5. Quitter
                """);

        String choice = scanner.nextLine();
        switch (Integer.parseInt(choice)) {
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
        }
    }

    public static void displayEmployeeMenu(Restaurant restaurant){
        Scanner scanner = new Scanner(System.in);

        System.out.println(restaurant.toString());
        System.out.println("""
                Que voulez-vous faire?
                1. Afficher liste des employés
                2. Ajouter un employé
                3. Supprimer un employé
                4. Menu principale
                5. Quitter
                """);

        String choice = scanner.nextLine();
        switch (Integer.parseInt(choice)) {
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
        }
    }
}


