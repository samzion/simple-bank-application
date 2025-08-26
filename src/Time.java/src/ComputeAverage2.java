import java.util.Scanner;

public class ComputeAverage2 {
    public static void main(String[] args) {
        Scanner stdin;
        String str; // The user’s input.
        double number; // The input converted into a number.
        double total; // The total of all numbers entered.
        double avg; // The average of the numbers.
        int count; // The number of numbers entered.
        stdin = new Scanner(System.in);
        total = 0;
        count = 0;
        System.out.println("Enter your numbers, press return to end.");
        while (true) {
            System.out.print("? ");
            str = stdin.nextLine();
            if (str.equals("")) {
                break; // Exit the loop, since the input line was blank.
            }
            try {
                number = Double.parseDouble(str);
// If an error occurs, the next 2 lines are skipped!
                total = total + number;
                count = count + 1;
            }
            catch (NumberFormatException e) {
                System.out.println("Not a legal number! Try again.");
            }
        }
        avg = total/count;
        System.out.printf("The average of %d numbers is %1.6g%n", count, avg);
    }

}
