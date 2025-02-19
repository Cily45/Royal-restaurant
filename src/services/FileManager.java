package services;

import model.Restaurant;

import java.io.*;
import java.util.*;

public class FileManager {
    public static void createRestaurant(Restaurant restaurant) {
        File file = new File(System.getProperty("user.dir") + "/data/" + restaurant.getName());
        file.mkdir();
        File employeesFile = new File(file.getAbsolutePath() + "/employees");
        employeesFile.mkdir();
        File ordesrFile = new File(file.getAbsolutePath() + "/orders");
        ordesrFile.mkdir();
        File menusFile = new File(file.getAbsolutePath() + "/menus");
        menusFile.mkdir();
        File dishesFile = new File(menusFile.getAbsolutePath() + "/dishes");
        dishesFile.mkdir();

        writeFile(file.getAbsolutePath()+"/info.txt",restaurant.toStringForText());
    }

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

    public static void test(){
        File repertory = new File(System.getProperty("user.dir") + "/data");
        String[] liste = repertory.list();

        if (liste != null) {
            for (int i = 0; i < liste.length; i++) {
                File file = new File(System.getProperty("user.dir") + "/data/" + liste[i]);
                String txt = readFile(file.getAbsolutePath()+"/info.txt");
                List<String> lines = getInfos(txt);

                Restaurant restaurant = new Restaurant(Integer.parseInt(lines.get(0)), lines.get(1), lines.get(2));
            }
        }
    }

    public static List<String> getInfos(String text) {
        List<String> infos = new ArrayList<>();
        for (String line : text.split("\n")) {
            String[] infosLine = line.split(":");
            infos.add(infosLine[1].trim());
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
            e.printStackTrace();
        }

        return content.toString();
    }
}
