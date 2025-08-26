import java.util.Scanner;
public class GuessMyNumber {
    public static void main(String [] arg){
        // Declaration of variables
        Scanner stdin = new Scanner(System.in);
        int myThought, yourGuess, difference;

        //Assignment to variables onwards
        myThought =  (int)(Math.random()*100) + 1 ;

        //prompt user what you want from him or her and assign to yourGuess
        System.out.println("I'm thinking of a number between 1 and 100\n" +
                "(including both). Can you guess what it is?");
        System.out.print("Type a number: ");
        int y = 3; // for maximum number attempts for user input
        //yourGuess = 0;

        // Allowing user to make 3 attempts
        while (y>0) {
            //check for format
            if ( !stdin.hasNextInt()) {
                String word = stdin.next();
                System.err.println(word + " is not a number. Try again next time");
                return;
            }
            yourGuess = stdin.nextInt();

            // validate input is between 1 and 100
            boolean x;
            x = (yourGuess >= 1) && (yourGuess <=100);

            if (x ) {
                //compute difference between computer guess and user guess
                difference = Math.abs(myThought - yourGuess);

                //output result
                System.out.printf("Your guess is: %d\n", yourGuess);
                //System.out.printf("The number I was thinking of is: %d\n", myThought);
                if (yourGuess < myThought){
                    //System.out.printf("You were off by: %d\n", difference);
                    if (y !=1) {
                        System.out.print("Incorrect! Your guess is less than my thought. Please, " +
                                "try again. Take another guess: ");
                    }

                } else if (yourGuess > myThought){
                    if (y!=1) {
                        System.out.print("Incorrect! Your guess is higher than my thought. Please, " +
                                "try again. Take another guess: ");
                    }

                } else {
                    System.out.printf("Correct! the number I was thinking is: %d", myThought);
                    System.out.println();
                    return;
                }
                y --;

            }  else {

                System.out.print("Your guess is too high or too low. " +
                        "Please Enter another number between 1 and 100 (including both): ");
            }

        }
        System.out.printf("The number I was thinking is %d\n", myThought);
        System.out.println("\nSorry, try again next time.");
        stdin.close();




    }

}
