package commands.restaurant;

import commands.Command;
import model.Restaurant;

import static utils.ConsoleUtils.askString;

public class AddRestaurant implements Command {
    @Override
    public String message() {
        return "Ajouter un restaurant";
    }

    @Override
    public void execute() {
        String name = askString("Entrez le nom de votre restaurant:");

        if(Restaurant.isRestaurantExist(name)){
            System.out.println("Ce restaurant existe déjà, veuillez en choisir un autre nom ou compléter le");
            this.execute();
        }

        String address = askString("Entrez l'adresse de votre restaurant:");

        Restaurant restaurant = new Restaurant(name, address);

        new DisplayRestaurant().execute();
    }
}
