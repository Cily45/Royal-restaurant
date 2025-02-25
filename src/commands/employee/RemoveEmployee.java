package commands.employee;

import commands.Command;
import commands.restaurant.MainRestaurant;
import model.Employee;
import model.Restaurant;

import static services.FileManager.delete;
import static utils.ConsoleUtils.askInt;
import static utils.ConsoleUtils.askString;

public class RemoveEmployee implements Command {
    private Restaurant restaurant;
    private Employee employee;

    public RemoveEmployee(Restaurant restaurant, Employee employee) {
        this.restaurant = restaurant;
        this.employee = employee;
    }

    @Override
    public String message() {
        return "Supprimer un employé";
    }

    @Override
    public void execute() {
        String message = String.format("Etes vous sur de vouloir supprimer l'employé nommé %s %s O/N?", employee.getFirstName(), employee.getLastName());
        String answer = askString(message).toLowerCase();

        if (answer.equals("o")) {
            delete(employee.getEmployeFile());
            restaurant.getEmployees().remove(employee);
            System.out.println("L'employé a bien été supprimer");
        }

        new MainEmployee(restaurant).execute();
    }
}
