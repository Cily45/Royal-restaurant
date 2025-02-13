package services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class FileManager {
    public static String createDir(String name){
        File path = new File("royaleRestaurant");
        File file = new File(path.getAbsoluteFile() + "/data/" + name);
        file.mkdir();

        return file.getAbsolutePath();
    }

    public static void createFile(File file, String data){
        try {
            File txt = new File(file.getAbsoluteFile() + "/infos.txt");
            FileWriter fileWriter = new FileWriter(txt);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data + "\n");

            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println("Erreur lors de la création du fichier "+ e.toString());;
        }
    }

    public static void writeToFile(File file, String data){

    }

    public static void reloadFile(File file){

    }
}
