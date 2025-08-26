import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int a, b, c;

        while (true){
            System.out.print("Enter all three lengths of the triangle on a line" +
                    "separating each length with a ',': ");
            String input = stdin.nextLine();
            int firstDelimeter = input.indexOf(","); // get index of 1st delimeter
            if (firstDelimeter == -1) {
                System.out.println("Couldn't find ',' Enter length again separating each value with a ','");
                continue;

            }
            String aString =  input.substring(0,firstDelimeter);
            aString = aString.replace(" ", "");
            a = Integer.parseInt(aString);
            if (a <= 0){
                System.out.println("Oops! You did not enter positive values");
                continue;
            }
            int secondDelimeter = input.indexOf(",", firstDelimeter+1);
            if (secondDelimeter == -1) {
                System.out.println("Couldn't find ',' Enter length again separating each value with a ','");
                continue;
            }
            String bString = input.substring(firstDelimeter+1, secondDelimeter);
            bString = bString.replace(" ", "");
            b = Integer.parseInt(bString);
            if (b <= 0){
                System.out.println("Oops! You did not enter positive values");
                continue;
            }

            String cString = input.substring(secondDelimeter+1, input.length());
            cString = cString.replace(" ", "");
            c = Integer.parseInt(cString);
            if (a <= 0){
                System.out.println("Oops! You did not enter positive values");
                continue;
            }
            break;
        }

        if ((a > b+c) || (b > a+c) || (c > a+b)) {
            System.out.println("\nSorry! Lengths cannot form a triangle");
        } else {
            System.out.println("\nYes! Given gengths can form a triangle");
        }
    }
}
