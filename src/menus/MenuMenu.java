package menus;

import model.Menu;
import model.Restaurant;

import static menus.MainMenu.displayMainMenu;
import static utils.ConsoleUtils.askInt;
import static utils.ConsoleUtils.askString;

public class MenuMenu {
    public static void displayMenuMenus(Restaurant restaurant) {
        System.out.println(restaurant.toString());

        String message = """
                Que voulez-vous faire?
                1. Afficher liste des menus
                2. Ajouter un nouveau menu
                3. Gérer un menu
                4. Supprimer un menu
                5. Menu principale
                6. Quitter
                """;

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
        String message = """
                Que voulez-vous faire?
                1. Créé un nouveau menu
                2. Gérer le dernier menu créé
                3. Menu principale
                4. Quitter
                """;

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

        String message = """
                Que voulez-vous faire?
                1. Ajouter un plat
                2. Supprimer un plat
                3. Modifier un plat
                4. Menu principale
                5. Quitter
                """;
    }

    public static void selectMenu(Restaurant restaurant) {
        restaurant.displayMenus();
        String message = "Choisissez un menu à gérer:";
        displayMenuMenu(restaurant.getMenu().get(askInt(message)));
    }
}
