import java.util.Scanner;
public class TestScanner{
    public static void main(String[] args) {
        Scanner stdin = new Scanner( System.in ); // Create the Scanner.
        double yourNum;
        System.out.print("Input your number %n ");
        yourNum = stdin.nextDouble();
        double next = (yourNum % 2 == 0) ? (yourNum/2) : (3*yourNum+1);
        System.out.printf("After testing your input %1.2f is your result %n", next);
    } // end of main()
} // end of class Interest2WithScanner