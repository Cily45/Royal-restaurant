package menus;

import model.Employee;
import model.Restaurant;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static menus.MainMenu.displayMainMenu;
import static utils.ConsoleUtils.*;

public class MenuEmployee {
    public static void displayEmployeeMenu(Restaurant restaurant) {
        System.out.println(restaurant.toString());
printHeader("GESTION DES EMPLOYES");
        String[] message = {"Afficher liste des employés",
                            "Ajouter un employé",
                            "Modifier un employé",
                            "Supprimer un employé",
                            "Menu principale",
                            "Quitter"};

        switch (askInt(message)) {
            case 1:
                restaurant.displayEmployees();
                displayEmployeeMenu(restaurant);
                break;
            case 2:
                addEmployee(restaurant);
                break;
            case 3:
                break;
            case 4:
                displayMainMenu();
                break;
            case 5:
                System.exit(0);
            case 6:
                displayMainMenu();
            default:
                System.out.println("Veuillez entrer un nombre entier valide!");
                displayMainMenu();
                break;
        }
    }

    public static void addEmployee(Restaurant restaurant) {
        String lastName = askString("Entrez le nom de l'employé:");
        String firstName = askString("Entrez le prénom de l'employé:");
        String role = askString("Entrez le role de l'employe:");
        double salary = askDouble("Entrez le salaire de l'employe:");
        Calendar hirringDate = askDate("Entrez le date de l'embauche(dd/MM/yyyy):");

        Employee employee = new Employee(lastName, firstName, role, salary, hirringDate, restaurant);

        System.out.printf("Le nouvel employé à bien était créé et ajouter au restaurant\n", restaurant.toString());
        addEmployeeMenu(restaurant, employee);
    }

    public static void addEmployeeMenu(Restaurant restaurant, Employee employee) {
        printHeader("AJOUT EMPLOYE");
        String[] message = {
                "Créé un nouvel employé",
                "Gérer le dernier employé créé",
                "Retour au menu gestion des employés",
                "Menu principale",
                "Quitter"};

        switch (askInt(message)) {
            case 1:
                addEmployee(restaurant);
                break;
            case 2:
                break;
            case 3:
                displayEmployeeMenu(restaurant);
                break;
            case 4:
                displayMainMenu();
                break;

            case 5:
                System.exit(0);

            default:
                System.out.println("Veuillez entrer un nombre entier valide!");
                addEmployeeMenu(restaurant, employee);
                break;
        }
    }

    public static void editEmployeeMenu(Restaurant restaurant, Employee employee) {
        System.out.println(employee.toString());
        printHeader(String.format("MODIFICATION DE L'EMPLOYE %s %s", employee.getLastName(), employee.getFirstName()) );
        String[] message = {
                "Modifier",
                "Gérer le dernier employé créé",
                "Retour au menu gestion des employés",
                "Menu principale",
                "Quitter}"};

        switch (askInt(message)) {
            case 1:
                addEmployee(restaurant);
                break;
            case 2:
                break;
            case 3:
                displayEmployeeMenu(restaurant);
                break;
            case 4:
                displayMainMenu();
                break;

            case 5:
                System.exit(0);

            default:
                System.out.println("Veuillez entrer un nombre entier valide!");
                addEmployeeMenu(restaurant, employee);
                break;
        }
    }
}