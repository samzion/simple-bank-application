import java.util.Scanner;
public class Eggs {
    public static void  main(String[] args) {
        Scanner stdin;
        stdin = new Scanner(System.in);
        System.out.print("Enter the number of eggs you have: ");
        int numEgg = stdin.nextInt();
        int numGross = (int) Math.floor(numEgg/144);
        int lessGross = numEgg % 144 ;
        int numDozen = (int) Math.floor(lessGross/12);
        int lessDozen = lessGross % 12 ;
        System.out.printf("\nYour number of eggs is %d gross, %d dozen, and %d",
                numGross,numDozen, lessDozen);


    }
}
