package commands.dish;

import commands.Command;
import model.Menu;
import model.Order;
import model.Restaurant;

import static utils.ConsoleUtils.askInt;
import static utils.ConsoleUtils.printHeader;

public class DisplayDish implements Command {
    private Order order;
    private Menu menu;
    private Restaurant restaurant;

    public DisplayDish(Restaurant restaurant, Order order) {
        this.order = order;
    }

    public DisplayDish(Restaurant restaurant,Menu menu) {
        this.menu = menu;
    }

    @Override
    public String message() {
        return "Liste des plats";
    }

    @Override
    public void execute() {
        printHeader(this.message());

        if(order == null){
            menu.displayDishes();
        }else{
            order.displayOrder();
        }

        if (askInt("[0] pour retourner au menu ") == -1) {
            if(order == null){
                new MainDish(restaurant, menu).execute();
            }else{
                new MainDish(restaurant, order).execute();
            }
        }
    }
}
