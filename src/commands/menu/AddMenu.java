package commands.menu;

import commands.Command;
import model.Menu;
import model.Restaurant;

import java.util.Date;

import static utils.ConsoleUtils.askDate;
import static utils.ConsoleUtils.askString;

public class AddMenu implements Command {
    private Restaurant restaurant;

    public AddMenu(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String message() {
        return "Ajouter un menu";
    }

    @Override
    public void execute() {
        String name = askString("Entrez le nom de votre menu:");
        String address = askString("Entrez le type de menu:");
        Date dateCreate = askDate("Entrez la date de la créatio du menu(dd/MM/yyyy):");

        new Menu(name, address, this.restaurant, dateCreate);

        System.out.printf("Le menu: %s à bien été crée\n", name);
    }
}
