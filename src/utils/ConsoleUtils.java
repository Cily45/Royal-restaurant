package utils;

import commands.Command;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class ConsoleUtils {
    public static String askString(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        String result = scanner.nextLine();

        if(result.isEmpty()){
            return askString(message);
        }

        return result;
    }

    public static int askInt(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        int result = 0;

        try {
            result = scanner.nextInt();
        } catch (NumberFormatException e) {
            System.out.println("Veuillez entrer un nombre valide!");
            return askInt(message);
        }

        return result;
    }

    public static int askInt(Command[] commands, String message) {
        printHeader(message);
        Scanner scanner = new Scanner(System.in);
        System.out.println("|"+ " ".repeat(98) + "|");

        for (int i = 0; i < commands.length; i++) {
            System.out.println(String.format("|%s[%d] %s%s|" ," ".repeat(10),i+1 ,commands[i].message(), " ".repeat((98 - commands[i].message().length())-14)));
        }

        System.out.println("|"+ " ".repeat(98) + "|");
        System.out.println("=".repeat(100));
        System.out.print("Veuillez choisir une option: ");
        int result = 0;

        try {
            result = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Veuillez entrer un nombre valide!");
            return askInt(commands, message);
        }

        return result-1;
    }

    public static int askInt(String[]  items, String message) {
        printHeader(message);
        Scanner scanner = new Scanner(System.in);
        System.out.println("|"+ " ".repeat(98) + "|");

        for (int i = 0; i < items.length; i++) {
            System.out.println(String.format("|%s[%d] %s%s|" ," ".repeat(10),i+1 ,items[i], " ".repeat((98 - items[i].length())-14)));
        }

        System.out.println("|"+ " ".repeat(98) + "|");
        System.out.println("=".repeat(100));
        System.out.print("Veuillez choisir une option: ");
        int result = 0;

        try {
            result = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Veuillez entrer un nombre valide!");
            return askInt(items, message);
        }

        return result-1;
    }

    public static boolean askBoolean(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        String result = scanner.nextLine();
        if(result.isEmpty()){
            return askBoolean(message);
        }

        return result.toLowerCase().equals("o");
    }

    public static double askDouble(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        double result = 0;

        try {
            result = scanner.nextDouble();
        } catch (NumberFormatException e) {
            System.out.println("Veuillez entrer un nombre valide!");
            return askInt(message);
        }

        return result;
    }

    public static Date askDate(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        String date = scanner.nextLine();

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            return dateFormat.parse(date);
        } catch (Exception e) {
            System.out.println("Veuillez entrer une date au format valide!");
            return askDate(message);
        }
    }

    public static Date dateParse(String date){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            return dateFormat.parse(date);
        } catch (Exception e) {
            System.out.println("Veuillez entrer une date au format valide!");
        }

        return null;
    }

    public static String dateToString(Date date){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date.getTime());
    }

    public static void printHeader(String mesage){
        System.out.println("\n"+ "=".repeat(100));
        System.out.println("|"+" ".repeat((98 - mesage.length())/2) + mesage.toUpperCase() + " ".repeat((int) Math.ceil( (double) (98 - mesage.length()) /2)) + "|");
        System.out.println("=".repeat(100));
    }

    private String formatString(String string){
        return String.format("|%s%10s|", " ".repeat(10), string, " ".repeat(10));
    }
}
