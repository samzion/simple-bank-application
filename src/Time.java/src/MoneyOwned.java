import java.util.Scanner;
public class MoneyOwned {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        System.out.print("\nHow many quarters have you? Enter a figure: ");
        int numQ = stdin.nextInt();
        System.out.print("\nHow many dimes have you? Enter a figure: ");
        int numD = stdin.nextInt();
        System.out.print("\nHow many nickels have you? Enter a figure: ");
        int numN = stdin.nextInt();
        System.out.println("\nHow many pennies have you? Enter a figure: ");
        int numP = stdin.nextInt();
        final int q = 25, d = 10, n = 5, p = 1;
        int qInCent = q * numQ;
        int dInCent= d * numD;
        int nInCent =  n * numN;
        int pInCent = p * numP;

        double changeInDollar = (double)(qInCent + dInCent + nInCent + pInCent)/100;
        stdin.close();
        //System.out.printf("\nYour change is %f cents \n", changeIncent);
        System.out.printf("\nYour change is $%1.2f", changeInDollar);


    }
}
