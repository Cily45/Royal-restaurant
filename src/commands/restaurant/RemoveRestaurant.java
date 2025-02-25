package commands.restaurant;

import commands.Command;
import model.Restaurant;

import static services.FileManager.delete;
import static utils.ConsoleUtils.askInt;
import static utils.ConsoleUtils.askString;

public class RemoveRestaurant implements Command {
    private Restaurant restaurant;

    public RemoveRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String message() {
        return "Supprimer un restaurant";
    }

    @Override
    public void execute() {
        String message = String.format("Etes vous sur de vouloir supprimer le restaurant %s O/N?", restaurant.getName());
        String answer = askString(message).toLowerCase();

        if (answer.equals("o")) {
            delete(restaurant.getRestaurantFile());
            Restaurant.getRestaurants().remove(restaurant);
            System.out.println("Le restaurant à bien été supprimer");
        }

        new MainRestaurant().execute();
    }
}
