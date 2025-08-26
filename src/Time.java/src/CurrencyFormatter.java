import java.util.*;
import java.text.*;

public class CurrencyFormatter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        // Write your code here.
        Locale indiaLocale = new Locale("en", "IN"); //contruct locale for india
        Locale nigeriaLocale = new Locale("en", "NG"); //contruct locale for ngeria
        NumberFormat usCurrencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat indiaCurrencyFormat = NumberFormat.getCurrencyInstance(indiaLocale);
        NumberFormat chinaCurrencyFormat = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat franceCurrencyFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        NumberFormat nigeriaCurrencyFormat = NumberFormat.getCurrencyInstance(nigeriaLocale);

        //After getting instance, store format in a string variable
        String us = usCurrencyFormat.format(payment);
        String india = indiaCurrencyFormat.format(payment);
        String china = chinaCurrencyFormat.format(payment);
        String france = franceCurrencyFormat.format(payment);
        String nigeria = nigeriaCurrencyFormat.format(payment);

        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
        System.out.println("Nigeria: " + nigeria);
    }
}