//package menuDisplay;
//
//import static menuDisplay.MenuRestaurant.*;
//import static utils.ConsoleUtils.askInt;
//import static utils.ConsoleUtils.printHeader;
//
//public class MainMenu {
//    public static void displayMainMenu() {
//        printHeader("MENU PRINCIPAL");
//        String[] message = {"Ajouter un restaurant",
//                            "Gérer un restaurant",
//                            "Quitter"};
//
//        switch (askInt(message)) {
//            case 1:
//                addRestaurant();
//                break;
//            case 2:
//                selectRestaurant();
//                break;
//            case 3:
//                System.exit(0);
//            default:
//                System.out.println("Veuillez entrer un nombre entier valide!");
//                displayMainMenu();
//                break;
//        }
//    }
//}
