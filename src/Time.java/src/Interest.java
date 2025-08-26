import java.util.Scanner;
/**
 * This class implements a simple program that will compute the amount of
 * interest that is earned on an investment over a period of 5 years. The
 * initial amount of the investment and the interest rate are input by the
 * user. The value of the investment at the end of each year is output.
 */
public class Interest {
    public static void main (String[] arg){
        double principal;
        double rate;
        Scanner stdin = new Scanner(System.in);
        /* Get the initial investment and interest from the user */
        System.out.print("Enter the initial investment: ");
        principal = stdin.nextDouble();
        System.out.println();
        System.out.print("Enter the annual interest rate.");
        rate = stdin.nextDouble();
        System.out.println();

        int years;
        years = 0;
        while (years < 5) {
            double interest;
            interest = principal * rate;
            principal = principal + interest;
            years ++;
            if (years > 1) {
                System.out.print("The value of the investment after ");
                System.out.print(years);
                System.out.print(" years is $");
            }
            else {
                System.out.print("The value of the investment after 1 year is $");
            }
            System.out.printf("%1.2f \n", principal);

        }
    }
}
