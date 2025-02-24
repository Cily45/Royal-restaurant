package commands.employee;

import commands.Command;
import model.Employee;
import model.Restaurant;

import java.util.Date;

import static utils.ConsoleUtils.*;

public class AddEmployee implements Command {
    private Restaurant restaurant;

    public AddEmployee(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String message() {
        return "Ajouter un employé";
    }

    @Override
    public void execute() {
        String lastName = askString("Entrez le nom de l'employé:");
        String firstName = askString("Entrez le prénom de l'employé:");
        String role = askString("Entrez le role de l'employe:");
        double salary = askDouble("Entrez le salaire de l'employe:");
        Date hirringDate = askDate("Entrez le date de l'embauche(dd/MM/yyyy):");

        new Employee(lastName, firstName, role, salary, hirringDate, restaurant);

        System.out.printf("Le nouvel employé à bien était créé et ajouter au restaurant\n");
    }
}
