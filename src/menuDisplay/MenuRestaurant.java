//package menuDisplay;
//
//import model.Restaurant;
//
//import static menuDisplay.MainMenu.displayMainMenu;
//import static utils.ConsoleUtils.*;
//
//
//public class MenuRestaurant {
//    public static void addRestaurant() {
//        String name = askString("Entrez le nom de votre restaurant:");
//
//        if(Restaurant.isRestaurantExist(name)){
//            System.out.println("Ce restaurant existe déjà, veuillez en choisir un autre nom ou compléter le");
//            addRestaurant();
//        }
//
//        String address = askString("Entrez l'adresse de votre restaurant:");
//
//        Restaurant restaurant = new Restaurant(name, address);
//
//        System.out.printf("Le restaurant: %s à bien été crée\n", restaurant.toString());
//        addRestaurantMenu(restaurant);
//    }
//
//    public static void addRestaurantMenu(Restaurant restaurant) {
//        printHeader("Que voulez-vous faire?");
//        String[] message = {
//                "Créé un nouveau restaurant",
//                "Gérer le dernier restaurant créé",
//                "Menu principal",
//                "Quitter"};
//
//        switch (askInt(message)) {
//            case 1:
//                addRestaurant();
//                break;
//            case 2:
//                displayRestaurantMenu(restaurant);
//                break;
//            case 3:
//                displayMainMenu();
//                break;
//
//            case 4:
//                System.exit(0);
//
//            default:
//                System.out.println("Veuillez entrer un nombre entier valide!");
//                addRestaurantMenu(restaurant);
//                break;
//        }
//    }
//
//    public static void selectRestaurant() {
//        Restaurant.displayRestaurants();
//        String message = "Entrez l'id du restaurant que vous souhaitez gérer:";
//        int id = askInt(message);
//
//        if(Restaurant.getRestaurants().stream().anyMatch( r -> r.getId() == id)){
//            displayRestaurantMenu(Restaurant.getRestaurants().stream().filter( r -> r.getId() == id).findFirst().get());
//        }else{
//            selectRestaurant();
//        }
//
//    }
//
//    public static void displayRestaurantMenu(Restaurant restaurant) {
//        System.out.println(restaurant.toString());
//        printHeader("Que voulez-vous faire?");
//        String[] message = {
//                "Gestion des employés",
//                "Gestion des menus",
//                "Gestion des commandes",
//                "Menu principale",
//                "Quitter"};
//
//        switch (askInt(message)) {
//            case 1:
//                MenuEmployee.displayEmployeeMenu(restaurant);
//                break;
//            case 2:
//                MenuMenu.displayMenuMenus(restaurant);
//                break;
//            case 3:
//                break;
//            case 4:
//                displayMainMenu();
//                break;
//            case 5:
//                System.exit(0);
//            default:
//                System.out.println("Veuillez entrer un nombre entier valide!");
//                displayMainMenu();
//                break;
//        }
//    }
//}
