package commands.restaurant;

import commands.Command;
import commands.employee.MainEmployee;
import commands.general.Exit;
import commands.menu.MainMenu;
import commands.order.MainOrder;
import model.Restaurant;

import static utils.ConsoleUtils.*;

public class ModifyRestaurant implements Command {
    private Restaurant restaurant;

    public ModifyRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String message() {
        return "Modifier un restaurant";
    }

    @Override
    public void execute() {
        Command[] commands = {
                new ModifyInfoRestaurant(restaurant),
                new MainEmployee(restaurant),
                new MainMenu(restaurant),
                new MainOrder(restaurant),
                new MainRestaurant(),
                new Exit()};

        String info = String.format("modification du restaurant: %s", restaurant.getName());
        int choice = askInt(commands, info);

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
