package commands.restaurant;

import commands.Command;
import model.Restaurant;

import static services.FileManager.delete;
import static utils.ConsoleUtils.askInt;
import static utils.ConsoleUtils.askString;

public class RemoveRestaurant implements Command {
    @Override
    public String message() {
        return "Supprimer un restaurant";
    }

    @Override
    public void execute() {
        Restaurant.displayRestaurants();
        int id = askInt("Entrez l'id du restaurant que vous souhaitez supprimer");

        if(Restaurant.getRestaurants().stream().anyMatch(r -> r.getId() == id)){
            Restaurant restaurant = Restaurant.getRestaurants().stream().filter( r -> r.getId() == id).findFirst().get();
            String message = String.format("Etes vous sur de vouloir supprimer le restaurant %s O/N?", restaurant.getName());
            String answer = askString(message).toLowerCase();
            if(answer.equals("o")){
                delete(restaurant.getRestaurantFile());
                Restaurant.getRestaurants().remove(restaurant);
            }
                new MainRestaurant().execute();

        }else{
            System.out.println("Restaurant inexistant");
            this.execute();
        }
    }
}
