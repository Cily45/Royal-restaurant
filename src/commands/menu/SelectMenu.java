package commands.menu;

import commands.Command;
import model.Menu;
import model.Restaurant;

import static utils.ConsoleUtils.askInt;

public class SelectMenu implements Command {
    private String message;
    private Restaurant restaurant;

    public SelectMenu( Restaurant restaurant, String message) {
        this.message = message;
        this.restaurant = restaurant;
    }

    @Override
    public String message() {

        return String.format("Sélectionner un menu à %s", this.message);
    }

    @Override
    public void execute() {
        restaurant.displayMenus();

        int id = askInt("Entrez l'id du menu que vous souhaitez modifier ([0] pour retourner à la gestion des restaurants):");

        if (restaurant.getMenus().stream().anyMatch(r -> r.getId() == id)) {
            Menu menu= restaurant.getMenus().stream().filter(r -> r.getId() == id).findFirst().get();
            switch (message) {
                case "modifier":
                    new ModifyMenu(this.restaurant, menu).execute();
                case "supprimer":
                    new RemoveMenu(this.restaurant, menu).execute();
            }
        } else if (id == 0) {
            new MainMenu(restaurant).execute();
        } else {
            System.out.println("Menu inexistant");
            this.execute();
        }
    }
}
