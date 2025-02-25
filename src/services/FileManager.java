package services;

import model.*;

import java.io.*;
import java.util.*;

import static utils.ConsoleUtils.dateParse;

public class FileManager {


    public static void writeFile(String filePath, String content) {
        try {
            FileWriter fileReader = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileReader);
            bufferedWriter.write(content);
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void reloadFile() {
        File repertory = new File(System.getProperty("user.dir") + "/data");
        String[] list = repertory.list();
        Restaurant.getRestaurants().removeAll(Restaurant.getRestaurants());
        if (list != null) {
            for (int i = 0; i < list.length; i++) {
                File file = new File(System.getProperty("user.dir") + "/data/" + list[i]);
                String txt = readFile(file.getAbsolutePath() + "/info.txt");
                Map<String, String> lines = getInfos(txt);

                Restaurant restaurant = new Restaurant(Integer.parseInt(lines.get("id")), lines.get("name"), lines.get("address"), file);

                File repertoryEmployees = new File(file.getAbsolutePath() + "/employees");
                String[] listEmployees = repertoryEmployees.list();

                if (listEmployees != null) {
                    for (String employee : listEmployees) {
                        restaurant.addEmployee(reloadEmployee(file.getAbsolutePath(), employee));
                    }
                }

                File repertoryMenus = new File(file.getAbsolutePath() + "/menus");
                String[] listMenus = repertoryMenus.list();
                if (listMenus != null) {
                    for (String menu : listMenus) {

                        Menu menu1 = reloadMenu(file.getAbsolutePath(), menu);
                        restaurant.addMenu(menu1);

                        File repertoryDish = new File(file.getAbsolutePath() + "/menus" + "/" + menu);
                        String[] listDish = repertoryDish.list();

                        if (listDish != null) {
                            for (String dish : listDish) {
                                if(!dish.equals("info.txt")){
                                Dish dish1 = reloadDish(repertoryDish.getAbsolutePath(), dish);
                            }}
                        }
                    }
                }

                File repertoryOrder = new File(file.getAbsolutePath()+ "/order");
                String[] listOrder = repertoryOrder.list();

                if (listOrder != null) {
                    for (String order : listOrder) {
                        restaurant.addOrder(reloadOrder(file.getAbsolutePath(), order));
                    }
                }

            }
        }
    }

    public static void reWrite(File file, String content){
        String txt = readFile(file.getAbsolutePath());
        Map<String, String> lines = getInfos(txt);
        lines.putAll(getInfos(content));
        StringBuilder stringBuilder = new StringBuilder();

        for(String key : lines.keySet()){
            stringBuilder.append(key).append(": ").append(lines.get(key)).append("\n");
        }

        writeFile(file.getAbsolutePath(), stringBuilder.toString());
    }

    public static void reWrite(String file, String content){
        File file1 = new File(file);
        String txtEmployee = readFile(file1.getAbsolutePath());
        Map<String, String> lines = getInfos(txtEmployee);
        lines.putAll(getInfos(content));
        StringBuilder stringBuilder = new StringBuilder();

        for(String key : lines.keySet()){
            stringBuilder.append(key).append(": ").append(lines.get(key)).append("\n");
        }

        writeFile(file1.getAbsolutePath(), stringBuilder.toString());
    }

    public static Order reloadOrder(String file, String order) {
        File fileOrder = new File(file + "/order/" + order + "/info.txt");
        String txtOrder = readFile(fileOrder.getAbsolutePath());
        Map<String, String> linesOrder = getInfos(txtOrder);

        return new Order(Integer.parseInt(linesOrder.get("id")),
                file
        );
    }

    public static Employee reloadEmployee(String file, String employee) {
        File fileEmployee = new File(file + "/employees/" + employee);
        String txtEmployee = readFile(fileEmployee.getAbsolutePath());
        Map<String, String> linesEmployee = getInfos(txtEmployee);

        return new Employee(Integer.parseInt(linesEmployee.get("id")),
                linesEmployee.get("firstName"),
                linesEmployee.get("lastName"),
                linesEmployee.get("role"),
                Double.parseDouble(linesEmployee.get("salary").replace(',', '.')),
                dateParse(linesEmployee.get("hireDate")),
                fileEmployee);
    }
    
    public static Menu reloadMenu(String file, String menu) {
        File fileMenu = new File(file + "/menus/" + menu + "/info.txt");
        String txtMenu = readFile(fileMenu.getAbsolutePath());
        Map<String, String> linesMenu = getInfos(txtMenu);

        return new Menu(Integer.parseInt(linesMenu.get("id")),
                linesMenu.get("name"),
                linesMenu.get("menuType"),
                dateParse(linesMenu.get("createDate")),
                file
        );
    }
    
    public static Dish reloadDish(String file, String dish){
        File fileDish = new File(String.format("%s/%s", file, dish));
        String txtMenu = readFile(fileDish.getAbsolutePath());
        Map<String, String> linesDish = getInfos(txtMenu);
        String ingredients = linesDish.get("ingredients").substring(1, linesDish.get("ingredients").length() - 2);
        ArrayList<String> list = (ArrayList<String>) Arrays.asList(ingredients.split(", "));
        return new Dish(Integer.parseInt(linesDish.get("id")),
                linesDish.get("name"),
                linesDish.get("description"),
                Double.parseDouble(linesDish.get("price")),
                Integer.parseInt(linesDish.get("calorie")),
                linesDish.get("category"),
                Integer.parseInt(linesDish.get("size")),
                dateParse(linesDish.get("createDate")),
                linesDish.get("available").equals("true"),
                list,
                linesDish.get("dishType"),
                Integer.parseInt(linesDish.get("timeToPrepare")),
                Double.parseDouble(linesDish.get("specialPrice")),
                file
        );
        
    }


    public static Map<String, String> getInfos(String text) {
        Map<String, String> infos = new HashMap<>();

        for (String line : text.split("\n")) {
            String[] infosLine = line.split(":");
            infos.put(infosLine[0].trim(), infosLine[1].trim());
        }

        return infos;
    }

    public static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la lecture du fichier " + filePath);
            e.printStackTrace();
        }

        return content.toString();
    }

    public static boolean delete(File directory){
        if(directory.isDirectory()){
            File[] files = directory.listFiles();
            if(files!=null){
                for(File f: files){
                    if(!delete(f)){
                        return false;
                    }
                }
            }
        }
        return directory.delete();
    }
}
