package utils;

import java.util.Scanner;

public class ConsoleUtils {
    public static String askString(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }

    public static int askInt(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        int result = 0;
        try{
            result = Integer.parseInt(scanner.nextLine());
        }catch (NumberFormatException e){
            System.out.println("Veuillez entrer un nombre valide!");
            return askInt(message);
        }
        return result;
    }
}
