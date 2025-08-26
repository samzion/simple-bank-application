
import java.util.Scanner;
public class UserInput {
    public static void main(String[] args) {
        // create a object stdin of class Scanner
        Scanner stdin = new Scanner(System.in);
        String username;
        // ask user for firstName
        System.out.print("\nEnter your first name: ");
        username= stdin.next();
        username = username.toUpperCase();
        System.out.printf("\nHello, %s, nice to meet you!", username);
        // remove the \n which includes empty string in buffers
        stdin.nextLine();
        System.out.println("\nPlease enter your first name and last name, separated by a space.");
        String fullName = stdin.nextLine();
        fullName = fullName.toLowerCase();
        int n;
        n = fullName.indexOf(" ");
        String firstName = (fullName.substring(0,1)).toUpperCase() + fullName.substring(1,n);
        int firstLen = firstName.length();
        String lastName = (fullName.substring(n+1,n+2)).toUpperCase() + fullName.substring(n+2);
        int lastLen = lastName.length();
        String initials = (firstName.substring(0,1) + lastName.substring(0,1)).toUpperCase();
        System.out.printf("\nYour first name is %s, which has %d characters", firstName, firstLen);
        System.out.printf("\nYour last name is %s, which has %d characters", lastName, lastLen);
        System.out.println("\nYour initials are " + initials );

    }

}
