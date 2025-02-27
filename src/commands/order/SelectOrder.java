package commands.order;

import commands.Command;
import commands.restaurant.MainRestaurant;
import model.Order;
import model.Restaurant;

import static utils.ConsoleUtils.askInt;

public class SelectOrder implements Command {
    private Restaurant restaurant;
    private String message;

    public SelectOrder(Restaurant restaurant, String message) {
        this.restaurant = restaurant;
        this.message = message;
    }

    @Override
    public String message() {
        return String.format("Sélectionner un restaurant à %s", this.message);
    }

    @Override
    public void execute() {
        restaurant.displayOrders();
        int id = askInt("Entrez l'id du restaurant que vous souhaitez modifier ([0] pour retourner à la gestion des restaurants):");

        if (Restaurant.getRestaurants().stream().anyMatch(r -> r.getId() == id)) {
            Order order = restaurant.getOrders().stream().filter(r -> r.getId() == id).findFirst().get();

            switch (message) {
                case "modifier":
                    new ModifyOrder(restaurant, order).execute();
                    break;
                case "supprimer":
                    new RemoveOrder(restaurant, order).execute();
                    break;
            }
        } else if (id == 0) {
            new MainRestaurant().execute();
        } else {
            System.out.println("Restaurant inexistant");
            this.execute();
        }
    }
}
