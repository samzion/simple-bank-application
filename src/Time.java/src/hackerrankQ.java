import java.io.*;
import java.util.*;

public class hackerrankQ {

        public static void main(String[] args) {

            Scanner sc=new Scanner(System.in);
            String A=sc.next();
            String B=sc.next();
            /* Enter your code here. Print output to STDOUT. */
            System.out.println(A.length() + B.length());
            System.out.println(isLexicographicallyGreater(A,B));
            System.out.println(capitaliseFirstLetter(A) + " "+ capitaliseFirstLetter(B));
            sc.close();
        }
        public static String isLexicographicallyGreater(String stringOne, String stringTwo) {
            //Check which string is longer
            int lengthStringOne = stringOne.length();
            int lengthStringTwo = stringTwo.length();
            String isAGreaterThanB = "";
            if (lengthStringOne > lengthStringTwo) {
                for (int i = 0; i < lengthStringTwo; i++) {
                    if (stringOne.charAt(i) > stringTwo.charAt(i)) {
                        isAGreaterThanB = "Yes";
                        break;
                    } else {
                        isAGreaterThanB = "Yes";
                    }
                }
            } else if (lengthStringOne < lengthStringTwo) {
                for (int i = 0; i < lengthStringOne; i++) {
                    if (stringOne.charAt(i) > stringTwo.charAt(i)) {
                        isAGreaterThanB = "Yes";
                        break;
                    } else {
                        isAGreaterThanB = "No";
                    }
                }
            } else {
                for (int i = 0; i < lengthStringOne; i++) {
                    if (stringOne.charAt(i) > stringTwo.charAt(i)) {
                        isAGreaterThanB = "Yes";
                        break;
                    } else {
                        isAGreaterThanB = "No";
                    }
                }
            }
            return isAGreaterThanB;
        }
        public static String capitaliseFirstLetter(String anyWord){
            String firstLetter = anyWord.toLowerCase().substring(0,1).toUpperCase();
            return firstLetter+anyWord.substring(1);
        }
    }


