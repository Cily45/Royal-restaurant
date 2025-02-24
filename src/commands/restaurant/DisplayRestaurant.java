package commands.restaurant;

import commands.Command;
import model.Restaurant;

import static utils.ConsoleUtils.printHeader;

public class DisplayRestaurant implements Command
{
    @Override
    public String message() {
        return "Liste des restaurants";
    }

    @Override
    public void execute() {
        printHeader(this.message());
        Restaurant.displayRestaurants();
    }
}
