package commands.restaurant;

import commands.Command;
import model.Restaurant;

import static utils.ConsoleUtils.askInt;

public class SelectRestaurant implements Command {
    private String message;

    public SelectRestaurant(String message) {
        this.message = message;
    }

    @Override
    public String message() {
        return String.format("Sélectionner un restaurant à %s", this.message);
    }

    @Override
    public void execute() {
        Restaurant.displayRestaurants();
        int id = askInt("Entrez l'id du restaurant que vous souhaitez modifier ([0] pour retourner à la gestion des restaurants):");

        if (Restaurant.getRestaurants().stream().anyMatch(r -> r.getId() == id)) {
            Restaurant restaurant = Restaurant.getRestaurants().stream().filter(r -> r.getId() == id).findFirst().get();
            switch (message) {
                case "modifier":
                    new ModifyRestaurant(restaurant).execute();
                    break;
                case "supprimer":
                    new RemoveRestaurant(restaurant).execute();
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
