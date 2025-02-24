package commands.employee;

import commands.Command;
import model.Restaurant;

import static utils.ConsoleUtils.printHeader;

public class DisplayEmployee implements Command {
    private Restaurant restaurant;

    public DisplayEmployee(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    @Override
    public String message() {
        return "Liste des employés";
    }

    @Override
    public void execute() {
        printHeader(this.message());
        restaurant.displayEmployees();
    }
}
