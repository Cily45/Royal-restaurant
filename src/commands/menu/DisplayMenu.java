package commands.menu;

import commands.Command;
import commands.restaurant.MainRestaurant;
import model.Restaurant;

import static utils.ConsoleUtils.askInt;
import static utils.ConsoleUtils.printHeader;

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
        printHeader(this.message());
        restaurant.displayMenus();
        if(askInt("[0] pour retourner au menu ") == -1){
            new MainRestaurant().execute();
        }
    }
}
