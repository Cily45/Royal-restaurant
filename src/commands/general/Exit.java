package commands.general;

import commands.Command;

public class Exit implements Command {
    @Override
    public String message() {
        return "Quitter";
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
