package commands.menu;

import commands.Command;
import commands.dish.MainDish;
import commands.general.Exit;
import model.Menu;
import model.Restaurant;

import static utils.ConsoleUtils.askInt;

public class ModifyMenu implements Command {
    private Restaurant restaurant;
    private Menu menu;

    public ModifyMenu(Restaurant restaurant, Menu menu) {
        this.menu = menu;
        this.restaurant = restaurant;
    }

    @Override
    public String message() {
        return String.format("Modificaton de %s", menu.getName());
    }

    @Override
    public void execute() {
        Command[] commands  = {
                new ModifyInfoMenu(restaurant, menu),
                new MainDish(restaurant, menu),
                new MainMenu(restaurant),
                new Exit()
        };

        String info = String.format("modification du menu: %s", menu.getName());
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
