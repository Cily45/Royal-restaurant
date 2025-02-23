package menus;

import model.Menu;
import model.Restaurant;

import static menus.MainMenu.displayMainMenu;
import static utils.ConsoleUtils.*;

public class MenuMenu {
    public static void displayMenuMenus(Restaurant restaurant) {
        System.out.println(restaurant.toString());
        printHeader("GESTION DES MENUS");
        String[] message = {
                "Afficher liste des menus",
                "Ajouter un nouveau menu",
                "Gérer un menu",
                "Supprimer un menu",
                "Menu principal",
                "Quitter"};

        switch (askInt(message)) {
            case 1:
                restaurant.displayMenus();
                break;
            case 2:
                addMenu(restaurant);
                break;
            case 3:

                break;
            case 4:
                removeMenu(restaurant);
                break;
            case 5:
                displayMainMenu();
                break;
            case 6:
                System.exit(0);
            default:
                System.out.println("Veuillez entrer un nombre entier valide!");
                displayMainMenu();
                break;
        }
    }

    public static void removeMenu(Restaurant restaurant) {
        restaurant.displayMenus();
        int menu = askInt("Quel menu souhaitez vous supprimer?");
        restaurant.removeMenu(menu);
    }

    public static void addMenu(Restaurant restaurant) {
        String name = askString("Entrez le nom de votre menu:");
        String address = askString("Entrez le type de menu:");

        Menu menu = new Menu(name, address, restaurant);

        System.out.printf("Le menu: %s à bien été crée\n", name);
        addMenuMenu(menu);
    }

    public static void addMenuMenu(Menu menu) {
        printHeader("AJOUT DE MENU");
        String[] message = {
                "Créé un nouveau menu",
                "Gérer le dernier menu créé",
                "Menu principale",
                "Quitter"};

        switch (askInt(message)) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                displayMainMenu();
                break;

            case 4:
                System.exit(0);

            default:
                System.out.println("Veuillez entrer un nombre entier valide!");
                addMenuMenu(menu);
                break;
        }
    }

    public static void displayMenuMenu(Menu menu) {
        System.out.println(menu.getName());
        printHeader("MODIFICATION DU MENU");
        String[] message = {
                "Ajouter un plat",
                "Supprimer un plat",
                "Modifier un plat",
                "Menu principale",
                "Quitter"};
    }

    public static void selectMenu(Restaurant restaurant) {
        restaurant.displayMenus();
        String message = "Choisissez un menu à gérer:";
        displayMenuMenu(restaurant.getMenu().get(askInt(message)));
    }
}
