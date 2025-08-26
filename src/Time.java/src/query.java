import java.util.*;
import java.io.*;

public class query {

        public static void main(String []argh){
            Scanner in = new Scanner(System.in);
            System.out.println("Enter number of queries: ");
            int t=in.nextInt();
            for(int i=0;i<t;i++){
                System.out.println("Enter value for a:  ");
                int a = in.nextInt();
                System.out.println("Enter value for b:  ");
                int b = in.nextInt();
                System.out.println("Enter value for n:  ");
                int n = in.nextInt();
                int term = a + b;
                int numOfTerm = 1;
                System.out.print(term + " ");
                while (numOfTerm < n-1) {
                    term = term + (int) Math.pow(2, numOfTerm) * b;
                    System.out.print(term + " ");
                    numOfTerm++;

                }
                term = term + (int) Math.pow(2, n-1) * b;
                System.out.println(term);
            }
            in.close();
        }

}
