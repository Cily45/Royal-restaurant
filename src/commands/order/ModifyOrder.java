package commands.order;

import commands.Command;
import commands.dish.DisplayDish;
import commands.dish.SelectDish;
import commands.general.Exit;
import commands.menu.SelectMenu;
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
        return String.format("Modificaton de #%s", order.getId());
    }

    @Override
    public void execute() {
        Command[] commands = {
                new DisplayDish(restaurant, order),
                new SelectMenu(restaurant, "afficher"),
                new SelectDish(order, "supprimer"),
                new MainOrder(restaurant),
                new Exit()
        };
    }
}
