package commands.employee;

import commands.Command;
import model.Employee;
import model.Restaurant;

import static services.FileManager.reWrite;
import static services.FileManager.reloadFile;
import static utils.ConsoleUtils.*;

public class ModifyInfoEmployee implements Command {
    private Employee employee;
    private Restaurant restaurant;

    public ModifyInfoEmployee(Restaurant restaurant, Employee employee) {
        this.employee = employee;
        this.restaurant = restaurant;
    }

    @Override
    public String message() {
        return "Modification des informations d'un employé'";
    }

    @Override
    public void execute() {
        String[] itemsDisplay = {"Nom", "Prénom", "Rôle", "Salaire", "Date d'embauche"};
        String[] itemsInfo = {"firstName", "lastName", "role", "salary", "hireDate"};
        String info = String.format("modification de %s %s", employee.getFirstName(), employee.getLastName());


        int choice = askInt(itemsDisplay, info);

        if (choice > 0 && choice < itemsDisplay.length) {
            String entry = switch (itemsDisplay[choice]) {
                case "salary" ->
                        String.valueOf(askDouble(String.format("Entrez la nouvelle valeur pour %s: ", itemsDisplay[choice])));
                case "hireDate" ->
                        dateToString(askDate(String.format("Entrez la nouvelle valeur pour %s (dd/MM/yyyy): ", itemsDisplay[choice])));
                default -> askString(String.format("Entrez la nouvelle valeur pour %s: ", itemsDisplay[choice]));
            };
            reWrite(this.employee.getEmployeFile().getAbsoluteFile(), String.format("%s: %s", itemsInfo[choice], entry));
        }else if(choice == -1){
            new SelectEmployee(restaurant, "modifier").execute();
        }
        System.out.println(choice);
        reloadFile();

        this.execute();
    }
}
