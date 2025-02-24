package commands.employee;

import commands.Command;
import commands.restaurant.MainRestaurant;
import model.Employee;
import model.Restaurant;

import static services.FileManager.delete;
import static utils.ConsoleUtils.askInt;
import static utils.ConsoleUtils.askString;

public class RemoveEmployee implements Command {
    private Restaurant restaurant;

    public RemoveEmployee(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String message() {
        return "Supprimer un employé";
    }

    @Override
    public void execute() {
        restaurant.displayEmployees();
        int id = askInt("Entrez l'id de l'employé que vous souhaitez supprimer");

        if(restaurant.getEmployees().stream().anyMatch(r -> r.getId() == id)){
            Employee employee = restaurant.getEmployees().stream().filter(r -> r.getId() == id).findFirst().get();
            String message = String.format("Etes vous sur de vouloir supprimer l'employé nommé %s %s O/N?", employee.getFirstName(), employee.getLastName());
            String answer = askString(message).toLowerCase();

            if(answer.equals("o")){
                delete(employee.getEmployeFile());
                restaurant.getEmployees().remove(employee);
            }

            new MainRestaurant().execute();

        }else{
            System.out.println("Restaurant inexistant");
            this.execute();
        }
    }
}
