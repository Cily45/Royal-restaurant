package commands.order;

import commands.Command;
import commands.general.Exit;
import commands.restaurant.MainRestaurant;
import model.Restaurant;

import static utils.ConsoleUtils.askInt;

public class MainOrder implements Command {
    private Restaurant restaurant;

    public MainOrder(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String message() {
        return "Gestion des commandes";
    }

    @Override
    public void execute() {
        Command[] commands = {
                new DisplayOrder(restaurant),
                new AddOrder(restaurant),
                new SelectOrder(restaurant, "modifier"),
                new SelectOrder(restaurant, "supprimer"),
                new MainRestaurant(),
                new Exit()
        };

        int choice = askInt(commands, this.message());

        if (choice < commands.length && choice >= 0) {
            commands[choice].execute();
        } else {
            System.out.println("Veuillez entrer un nombre entier valide!");
            this.execute();
        }
    }
}
