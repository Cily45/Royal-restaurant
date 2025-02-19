package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class ConsoleUtils {
    public static String askString(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }

    public static int askInt(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        int result = 0;
        try {
            result = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Veuillez entrer un nombre valide!");
            return askInt(message);
        }
        return result;
    }

    public static double askDouble(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        double result = 0;
        try {
            result = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Veuillez entrer un nombre valide!");
            return askInt(message);
        }
        return result;
    }

    public static Calendar askDate(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        String date = scanner.nextLine();

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date1 = dateFormat.parse(date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date1);
            return calendar;
        } catch (Exception e) {
            System.out.println("Veuillez entrer une date au format valide!");
            return askDate(message);
        }
    }
}
