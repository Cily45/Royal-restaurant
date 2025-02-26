package commands.order;

import commands.Command;
import commands.restaurant.MainRestaurant;
import model.Restaurant;

import static utils.ConsoleUtils.askInt;
import static utils.ConsoleUtils.printHeader;

public class DisplayOrder implements Command {
    private Restaurant restaurant;

    public DisplayOrder(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String message() {
        return "Liste des commandes";
    }

    @Override
    public void execute() {
        printHeader(this.message());
        restaurant.displayOrders();

        if (askInt("[0] pour retourner au menu ") == -1) {
            new MainRestaurant().execute();
        }
    }
}
