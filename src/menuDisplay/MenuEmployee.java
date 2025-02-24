//package menuDisplay;
//
//import commands.employee.AddEmployee;
//import commands.Command;
//import commands.general.Exit;
//import commands.restaurant.AddRestaurant;
//import model.Employee;
//import model.Restaurant;
//
//import java.util.Date;
//
//import static menuDisplay.MainMenu.displayMainMenu;
//import static utils.ConsoleUtils.*;
//
//public class MenuEmployee {
//    public static void mainEmployeeCommands(Restaurant restaurant) {
//        printHeader("GESTION DES EMPLOYES");
//
//        Command[] commands = {null, new AddEmployee(restaurant), null, null, null, new Exit()};
//
//        int choice = askInt(commands);
//        Command command = commands[choice - 1];
//
//        if (command != null) {
//            command.execute();
//
//        }else{
//            System.out.println("Veuillez entrer un nombre entier valide!");
//            mainEmployeeCommands(restaurant);
//        }
//    }
//
//    public static void mainRestaurantCommands() {
//        printHeader("gestion des restaurants");
//
//        Command[] commands = {null, new AddRestaurant(), null, null, null, new Exit()};
//
//        int choice = askInt(commands);
//        Command command = commands[choice - 1];
//
//        if (command != null) {
//            command.execute();
//
//        }else{
//            System.out.println("Veuillez entrer un nombre entier valide!");
//            mainRestaurantCommands();
//        }
//    }
//
//
//
//    public static void addEmployee(Restaurant restaurant) {
//        String lastName = askString("Entrez le nom de l'employé:");
//        String firstName = askString("Entrez le prénom de l'employé:");
//        String role = askString("Entrez le role de l'employe:");
//        double salary = askDouble("Entrez le salaire de l'employe:");
//        Date hirringDate = askDate("Entrez le date de l'embauche(dd/MM/yyyy):");
//
//        Employee employee = new Employee(lastName, firstName, role, salary, hirringDate, restaurant);
//
//        System.out.printf("Le nouvel employé à bien était créé et ajouter au restaurant\n", restaurant.toString());
//        addEmployeeMenu(restaurant, employee);
//    }
//
//    private static void addEmployeeMenu(Restaurant restaurant, Employee employee) {
//        printHeader("AJOUT EMPLOYE");
//        String[] message = {
//                "Créé un nouvel employé",
//                "Gérer le dernier employé créé",
//                "Retour au menu gestion des employés",
//                "Menu principale",
//                "Quitter"};
//
//        switch (askInt(message)) {
//            case 1:
//                addEmployee(restaurant);
//                break;
//            case 2:
//                break;
//            case 3:
//                displayEmployeeMenu(restaurant);
//                break;
//            case 4:
//                displayMainMenu();
//                break;
//
//            case 5:
//                System.exit(0);
//
//            default:
//                System.out.println("Veuillez entrer un nombre entier valide!");
//                addEmployeeMenu(restaurant, employee);
//                break;
//        }
//    }
//
//    public static void editEmployeeMenu(Restaurant restaurant, Employee employee) {
//        System.out.println(employee.toString());
//        printHeader(String.format("MODIFICATION DE L'EMPLOYE %s %s", employee.getLastName(), employee.getFirstName()));
//        String[] message = {
//                "Modifier",
//                "Gérer le dernier employé créé",
//                "Retour au menu gestion des employés",
//                "Menu principale",
//                "Quitter}"};
//
//        switch (askInt(message)) {
//            case 1:
//                addEmployee(restaurant);
//                break;
//            case 2:
//                break;
//            case 3:
//                displayEmployeeMenu(restaurant);
//                break;
//            case 4:
//                displayMainMenu();
//                break;
//
//            case 5:
//                System.exit(0);
//
//            default:
//                System.out.println("Veuillez entrer un nombre entier valide!");
//                addEmployeeMenu(restaurant, employee);
//                break;
//        }
//    }
//
//    public static void selectEmployee(Restaurant restaurant) {
//        restaurant.displayEmployees();
//        String message = "Choisissez un employée à gérer:";
//        int id = askInt(message);
//
//        if (restaurant.getEmployees().stream().anyMatch(r -> r.getId() == id)) {
//            addEmployeeMenu(restaurant, restaurant.getEmployees().stream().filter(e -> e.getId() == id).findFirst().get());
//        } else {
//            selectEmployee(restaurant);
//        }
//    }
//}