package commands.restaurant;

import commands.Command;
import commands.employee.MainEmployee;
import commands.general.Exit;
import model.Restaurant;

import static services.FileManager.delete;
import static services.FileManager.reloadFile;
import static utils.ConsoleUtils.*;

public class ModifyRestaurant implements Command {
    @Override
    public String message() {
        return "Modifier un restaurant";
    }

    @Override
    public void execute() {
        Restaurant.displayRestaurants();
        int id = askInt("Entrez l'id du restaurant que vous souhaitez modifier ([0] pour retourner à la gestion des employe):");
        Restaurant restaurant = null;

        if(Restaurant.getRestaurants().stream().anyMatch(r -> r.getId() == id)){
            restaurant = Restaurant.getRestaurants().stream().filter( r -> r.getId() == id).findFirst().get();
        }else if(id == 0){
            new MainRestaurant().execute();
        }else{
            System.out.println("Restaurant inexistant");
            this.execute();
        }

        Command[] commands = {new ModifyInfoRestaurant(restaurant), new MainEmployee(restaurant), new MainRestaurant(), new Exit()};

        String info = String.format("modification du restaurant: %s", restaurant.getName());
        int choice = askInt(commands, info);

        if (choice < commands.length && choice >= 0) {
            Command command = commands[choice];

            if (command != null) {
                command.execute();
            } else {
                System.out.println("Veuillez entrer un nombre entier valide!");
                this.execute();
            }
        }

        this.execute();
    }
}
