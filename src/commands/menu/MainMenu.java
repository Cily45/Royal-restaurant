package commands.menu;

import commands.Command;
import model.Restaurant;

import static utils.ConsoleUtils.askInt;

public class MainMenu implements Command {
    private Restaurant restaurant;

    public MainMenu(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String message() {
        return "Gestion des menu";
    }

    @Override
    public void execute() {
        Command[] commands = {new DisplayMenu(restaurant), new AddMenu(restaurant)};

        int choice = askInt(commands, this.message());

        if (choice < commands.length && choice >= 0) {
            commands[choice].execute();
        } else {
            System.out.println("Veuillez entrer un nombre entier valide!");
            this.execute();
        }
        this.execute();
    }
}
