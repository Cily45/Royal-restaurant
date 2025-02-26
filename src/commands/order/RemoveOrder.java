package commands.order;

import commands.Command;
import model.Order;
import model.Restaurant;

public class RemoveOrder implements Command {
    private Restaurant restaurant;
    private Order order;

    public RemoveOrder(Restaurant restaurant, Order order) {
        this.restaurant = restaurant;
        this.order = order;
    }

    @Override
    public String message() {
        return "";
    }

    @Override
    public void execute() {

    }
}
