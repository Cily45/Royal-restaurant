package services;

import model.Employee;
import model.Restaurant;


import java.io.File;

import static services.FileManager.writeFile;

public class CreateNewObject {
    public static void createRestaurant(Restaurant restaurant) {
        String path = String.format("%s/data/%d", System.getProperty("user.dir"),restaurant.getId());
        File file = new File(path);
        file.mkdir();
        File employeesFile = new File(file.getAbsolutePath() + "/employees");
        employeesFile.mkdir();
        File ordesrFile = new File(file.getAbsolutePath() + "/orders");
        ordesrFile.mkdir();
        File menusFile = new File(file.getAbsolutePath() + "/menus");
        menusFile.mkdir();

        writeFile(file.getAbsolutePath()+"/info.txt",restaurant.toStringForText());

    }

    public static void createEmploye(Employee employee, Restaurant restaurant) {
        String path = String.format("%s/data/%d/employees/%d", System.getProperty("user.dir"),restaurant.getId(), employee.getId());
        writeFile(path,employee.toStringForText());
    }
}
