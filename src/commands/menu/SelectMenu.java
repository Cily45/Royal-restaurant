package commands.menu;

import commands.Command;
import commands.dish.SelectDish;
import model.Menu;
import model.Order;
import model.Restaurant;

import static utils.ConsoleUtils.askInt;

public class SelectMenu implements Command {
    private String message;
    private Restaurant restaurant;
    private Order order;

    public SelectMenu(Restaurant restaurant, String message) {
        this.message = message;
        this.restaurant = restaurant;
    }

    public SelectMenu(Order order, String message) {
        this.message = message;
        this.order = order;
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
            Menu menu = restaurant.getMenus().stream().filter(r -> r.getId() == id).findFirst().get();
            switch (message) {
                case "modifier":
                    new ModifyMenu(this.restaurant, menu).execute();
                case "supprimer":
                    new RemoveMenu(this.restaurant, menu).execute();
                case "afficher":
                    new SelectDish(this.restaurant, menu, order, "afficher").execute();
            }
        } else if (id == 0) {
            new MainMenu(restaurant).execute();
        } else {
            System.out.println("Menu inexistant");
            this.execute();
        }
    }
}
