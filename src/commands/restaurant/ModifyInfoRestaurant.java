package commands.restaurant;

import commands.Command;
import model.Restaurant;

import static services.FileManager.reWrite;
import static services.FileManager.reloadFile;
import static utils.ConsoleUtils.askInt;
import static utils.ConsoleUtils.askString;

public class ModifyInfoRestaurant implements Command {
    private Restaurant restaurant;

    public ModifyInfoRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String message() {
        return "Modification des informations du restaurant";
    }

    @Override
    public void execute() {
        String[] itemsDisplay = {"Nom", "Adresse"};
        String[] itemsInfo = {"name", "address"};

        int choice = askInt(itemsDisplay, this.message());

        if (choice >= 0 && choice < itemsDisplay.length) {
            String entry = askString(String.format("Entrez la nouvelle valeur pour %s: ", itemsDisplay[choice]));
            reWrite(restaurant.getRestaurantFile().getAbsoluteFile() +"/info.txt", String.format("%s: %s", itemsInfo[choice], entry));
        }

        reloadFile();
    }
}
