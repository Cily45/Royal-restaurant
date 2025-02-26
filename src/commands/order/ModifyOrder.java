package commands.order;

import commands.Command;
import commands.general.Exit;
import model.Order;
import model.Restaurant;

public class ModifyOrder implements Command {
    private Order order;
    private Restaurant restaurant;

    public ModifyOrder(Restaurant restaurant, Order order) {
        this.order = order;
        this.restaurant = restaurant;
    }

    @Override
    public String message() {
        return  String.format("Modificaton de #%s", order.getId());
    }

    @Override
    public void execute() {
        Command[] commands = {
                new MainOrder(restaurant),
                new Exit()
        };
    }
}
