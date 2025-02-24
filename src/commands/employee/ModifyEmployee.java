package commands.employee;

import commands.Command;
import commands.restaurant.DisplayRestaurant;
import model.Employee;
import model.Restaurant;

import static utils.ConsoleUtils.askInt;

public class ModifyEmployee implements Command {
    private Restaurant restaurant;

    public ModifyEmployee(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    @Override
    public String message() {
        return "Modifier un employé";
    }

    @Override
    public void execute() {
        restaurant.displayEmployees();
        int id = askInt("Entrez l'id de l'employé que vous souhaitez modifier ([0] pour retourner à la gestion des employe):");
        Employee employee = null;

        if(restaurant.getEmployees().stream().anyMatch(r -> r.getId() == id)){
            employee = restaurant.getEmployees().stream().filter( r -> r.getId() == id).findFirst().get();
        }else if(id == 0){
            new DisplayEmployee(restaurant);
        }
        else{
            System.out.println("Restaurant inexistant");
            this.execute();
        }
        new ModifyInfoEmployee(employee);

    }
}
