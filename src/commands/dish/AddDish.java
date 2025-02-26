package commands.dish;

import commands.Command;
import model.Dish;
import model.Menu;
import model.Order;

import java.util.ArrayList;
import java.util.Date;

import static utils.ConsoleUtils.*;

public class AddDish implements Command {
    private Menu menu;

    public AddDish(Menu menu) {
        this.menu = menu;
    }

    @Override
    public String message() {
        return "Ajouter un plat";
    }

    @Override
    public void execute() {
        printHeader(this.message());
        String name = askString("Quel est le nom du plat?");
        String description = askString("Entrez la description du plat:");
        double price = askDouble("Quel est le prix du plat?");
        int calorie = askInt("Quel la quantité de calories?");
        String category = askString("Quel la categorie du plat?:");
        int size = askInt("Pour combien de personne est ce plat?");
        Date createDate = askDate("Quand à était créé ce plat?");
        boolean available = askBoolean("Est ce que ce plat est disponible (O/N)?");

        ArrayList<String> ingredients = new ArrayList<>();
        System.out.println("Entrez la liste des ingrédients du plat(entrée vide pour finir):");
        int count = 1;

        while (true) {
            String ingredient = askString("ingredient " + count + ":");

            if (ingredient.isEmpty()) {
                break;
            }

            ingredients.add(ingredient);
            count++;
        }

        String dishType = askString("Quel est le type du plat?");
        int timeToPrepare = askInt("Combien de temps faut-il pour préparer ce plat?");
        double specialPrice = askDouble("Quel est le prix spécial du plat?");

        if (this.menu == null) {
            new Dish(name, description, price, calorie, category, size, createDate, available, ingredients, dishType, timeToPrepare, specialPrice, this.order);
        } else {
            new Dish(name, description, price, calorie, category, size, createDate, available, ingredients, dishType, timeToPrepare, specialPrice, this.menu);
        }
    }
}

