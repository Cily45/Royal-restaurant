package commands.employee;

import commands.Command;
import model.Employee;
import model.Restaurant;

import static utils.ConsoleUtils.askInt;

public class SelectEmployee implements Command {
    private Restaurant restaurant;
    private String message;

    public SelectEmployee(Restaurant restaurant, String message) {
        this.restaurant = restaurant;
        this.message = message;
    }

    @Override
    public String message() {
        return String.format("Sélectionner un employé à %s", this.message);
    }

    @Override
    public void execute() {
        restaurant.displayEmployees();

        int id = askInt("Entrez l'id de l'employé que vous souhaitez modifier ([0] pour retourner à la gestion des restaurants):");

        if (restaurant.getEmployees().stream().anyMatch(r -> r.getId() == id)) {
            Employee employee = restaurant.getEmployees().stream().filter(r -> r.getId() == id).findFirst().get();
            switch (message) {
                case "modifier":
                    new ModifyInfoEmployee(this.restaurant, employee).execute();
                case "supprimer":
                    new RemoveEmployee(this.restaurant, employee).execute();
            }
        } else if (id == 0) {
            new MainEmployee(restaurant).execute();
        } else {
            System.out.println("Restaurant inexistant");
            this.execute();
        }
    }
}
