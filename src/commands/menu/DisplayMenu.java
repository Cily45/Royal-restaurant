package commands.menu;

import commands.Command;
import model.Restaurant;

public class DisplayMenu implements Command {
    private Restaurant restaurant;

    public DisplayMenu(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String message() {
        return "Afficher les menus";
    }

    @Override
    public void execute() {
        restaurant.displayMenus();
    }
}
