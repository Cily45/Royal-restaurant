package commands.employee;

import commands.Command;
import commands.general.Exit;
import commands.restaurant.*;
import model.Restaurant;

import static utils.ConsoleUtils.askInt;
import static utils.ConsoleUtils.printHeader;

public class MainEmployee implements Command {
    private Restaurant restaurant;

    public MainEmployee(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String message() {
        return "Gestion des employés";
    }

    @Override
    public void execute() {
        printHeader(this.message());

        Command[] commands = {new DisplayEmployee(this.restaurant), new AddEmployee(this.restaurant), new RemoveEmployee(this.restaurant), new MainRestaurant(), new Exit()};

        int choice = askInt(commands, message());
        if (choice < commands.length && choice >= 0) {
            Command command = commands[choice];

            if (command != null) {
                command.execute();
            } else {
                System.out.println("Veuillez entrer un nombre entier valide!");
                this.execute();
            }
        }
        this.execute();
    }
}
