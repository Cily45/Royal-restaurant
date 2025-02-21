package services;

import model.Employee;
import model.Restaurant;

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

    public static void reloadFile(){
        File repertory = new File(System.getProperty("user.dir") + "/data");
        String[] list = repertory.list();

        if (list != null) {
            for (int i = 0; i < list.length; i++) {
                File file = new File(System.getProperty("user.dir") + "/data/" + list[i]);
                String txt = readFile(file.getAbsolutePath()+"/info.txt");
                Map<String, String> lines = getInfos(txt);

                Restaurant restaurant = new Restaurant(Integer.parseInt(lines.get("id")), lines.get("name"), lines.get("address"));

                File repertoryEmployees = new File(file.getAbsolutePath()+ "/employees");
                String[] listemployees = repertoryEmployees.list();

                if (listemployees != null) {
                    for (String listemployee : listemployees) {
                        restaurant.addEmployee(reloadEmployee(file.getAbsolutePath(), listemployee));
                    }
                }

            }
        }
    }

    public static Employee reloadEmployee(String file, String employee) {
        File fileEmployee = new File(file + "/employees/" + employee);
        String txtEmployee = readFile(fileEmployee.getAbsolutePath());
        Map<String, String> linesEmployee = getInfos(txtEmployee);

        return new Employee(Integer.parseInt(linesEmployee.get("id")), linesEmployee.get("firstName"), linesEmployee.get("lastName"), linesEmployee.get("role"), Double.parseDouble(linesEmployee.get("salary").replace(',', '.')), dateParse(linesEmployee.get("hirringDate")), file);
    }


    public static Map<String, String> getInfos(String text) {
        Map<String, String> infos = new HashMap<>();

        for (String line : text.split("\n")) {
            String[] infosLine = line.split(":");
            infos.put(infosLine[0].trim(),infosLine[1].trim());
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
