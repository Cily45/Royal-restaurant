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
    public static int askInt(String[] message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("|"+ " ".repeat(70) + "|");
        for (int i = 0; i < message.length; i++) {
            System.out.println(String.format("|%s[%d] %s%s|" ," ".repeat(10),i+1,message[i], " ".repeat((70 - message[i].length())-14)));
        }
        System.out.println("|"+ " ".repeat(70) + "|");
        System.out.println("=".repeat(72));
        System.out.print("Veuillez choisir une option: ");
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

    public static Calendar dateParse(String date){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Calendar calendar = Calendar.getInstance();
        try {
            Date date1 = dateFormat.parse(date);
            calendar.setTime(date1);

        } catch (Exception e) {
            System.out.println("Veuillez entrer une date au format valide!");
        }
        return calendar;
    }

    public static String dateToString(Calendar date){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date.getTime());
    }

    public static void printHeader(String mesage){
        System.out.println("\n"+ "=".repeat(72));
        System.out.println("|"+" ".repeat((70 - mesage.length())/2) + mesage + " ".repeat((70 - mesage.length())/2) + "|");
        System.out.println("=".repeat(72));
    }
}
