package commands.menu;

import commands.Command;
import model.Menu;
import model.Restaurant;

public class RemoveMenu implements Command {
    private Restaurant restaurant;
    private Menu menu;

    public RemoveMenu(Restaurant restaurant, Menu menu) {
        this.restaurant = restaurant;
        this.menu = menu;
    }

    @Override
    public String message() {
        return "";
    }

    @Override
    public void execute() {

    }
}
