package commands.order;

import commands.Command;
import model.Restaurant;

public class AddOrder implements Command {
    private Restaurant restaurant;

    public AddOrder(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String message() {
        return "Ajouter une commande";
    }

    @Override
    public void execute() {

    }
}
