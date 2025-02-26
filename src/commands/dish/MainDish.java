package commands.dish;

import commands.Command;
import commands.general.Exit;
import commands.menu.MainMenu;
import model.Menu;
import model.Order;
import model.Restaurant;

import static utils.ConsoleUtils.askInt;

public class MainDish implements Command {
    private Menu menu;
    private Order order;
    private Restaurant restaurant;

    public MainDish(Restaurant restaurant, Menu menu) {
        this.menu = menu;
    }

    public MainDish(Restaurant restaurant, Order order) {
        this.order = order;
    }

    @Override
    public String message() {
        return "Gestion des plats";
    }

    @Override
    public void execute() {
        Command[] commands = {
                 new AddDish(menu),
                new MainMenu(restaurant),
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
