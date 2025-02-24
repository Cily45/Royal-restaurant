package commands.restaurant;

import commands.Command;
import commands.general.Exit;

import static utils.ConsoleUtils.askInt;
import static utils.ConsoleUtils.printHeader;

public class MainRestaurant implements Command {
    @Override
    public String message() {
        return "Gestion du restaurant";
    }

    @Override
    public void execute() {
        Command[] commands = {new DisplayRestaurant(), new AddRestaurant(), new ModifyRestaurant(), new RemoveRestaurant(), new Exit()};

        int choice = askInt(commands, this.message());

        if (choice < commands.length && choice >= 0) {
            Command command = commands[choice];

            if (command != null) {
                command.execute();
            }else{
                System.out.println("Veuillez entrer un nombre entier valide!");
                this.execute();
            }
        }
        this.execute();
    }
}
