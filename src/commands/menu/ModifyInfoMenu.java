package commands.menu;

import commands.Command;
import commands.employee.SelectEmployee;
import model.Menu;
import model.Restaurant;

import static services.FileManager.reWrite;
import static services.FileManager.reloadFile;
import static utils.ConsoleUtils.*;

public class ModifyInfoMenu implements Command{
    private Restaurant restaurant;
    private Menu menu;

    public ModifyInfoMenu(Restaurant restaurant, Menu menu) {
        this.menu = menu;
        this.restaurant = restaurant;
    }

    @Override
    public String message() {
        return "Modifier des informations d'un menu ";
    }

    @Override
    public void execute() {
        String[] itemsDisplay = {"Nom", "Type", "Date de création"};
        String[] itemsInfo = {"name", "menuType", "createDate"};

        String info = String.format("Modification du menu '%s'", menu.getName());

        int choice = askInt(itemsDisplay, info);

        if (choice >= 0 && choice < itemsInfo.length) {
            String entry = switch (itemsInfo[choice]) {
                case "createDate" ->
                        dateToString(askDate(String.format("Entrez la nouvelle valeur pour %s (dd/MM/yyyy): ", itemsDisplay[choice])));
                default -> askString(String.format("Entrez la nouvelle valeur pour %s: ", itemsDisplay[choice]));
            };
            reWrite(this.menu.getMenuFile().getAbsoluteFile(), String.format("%s: %s", itemsInfo[choice], entry));
        }else if(choice == -1){
            new SelectMenu(restaurant, "modifier").execute();
        }
        System.out.println(choice);
        reloadFile();

        this.execute();
    }
}
