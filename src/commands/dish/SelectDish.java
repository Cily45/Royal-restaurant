package commands.dish;

import commands.Command;
import commands.employee.MainEmployee;
import commands.employee.ModifyInfoEmployee;
import commands.employee.RemoveEmployee;
import commands.order.AddOrder;
import commands.order.MainOrder;
import commands.order.ModifyOrder;
import model.*;

import static utils.ConsoleUtils.askInt;

public class SelectDish implements Command {
    private Restaurant restaurant;
    private Menu menu;
    private String message;
    private Order order;

    public SelectDish(Restaurant restaurant, Menu menu, String message) {
        this.restaurant = restaurant;
        this.menu = menu;
        this.message = message;
    }

    public SelectDish(Order order, String message) {
        this.order = order;
        this.message = message;
    }

    public SelectDish(Restaurant restaurant, Menu menu,Order order, String message) {
        this.restaurant = restaurant;
        this.menu = menu;
        this.message = message;
        this.order = order;
    }

    @Override
    public String message() {
        return String.format("Sélectionner un plat a%", message);
    }

    @Override
    public void execute() {
        menu.displayDishes();

        int id = askInt("Entrez l'id de l'employé que vous souhaitez modifier ([0] pour retourner à la gestion des restaurants):");

        if (restaurant.getEmployees().stream().anyMatch(r -> r.getId() == id)) {
            Dish dish = menu.getDish().stream().filter(r -> r.getId() == id).findFirst().get();
            switch (message) {
                case "modifier":
                 //   new ModifyDish(this.restaurant, dish).execute();
                    break;
                case "supprimer":
                    order.deleteDish(dish);
                    break;
                case "afficher":
                    int quantity = askInt(String.format("Combien de %s souhaitez vous ajouter? ",dish.getName()));
                    order.addDish(dish, quantity);
                    new ModifyOrder(restaurant, order);
                    break;
            }
        } else if (id == 0) {
            new MainEmployee(restaurant).execute();
        } else {
            System.out.println("Employé inexistant");
            this.execute();
        }
    }
}
