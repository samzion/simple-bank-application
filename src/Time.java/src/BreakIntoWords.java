import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Calendar;
public class BreakIntoWords {
    public static void main(String[] args){
        //get input
        Scanner stdin = new Scanner(System.in);
        System.out.println("Enter your line of texts: ");
        String yourText = stdin.nextLine();
        String[] splitWords = yourText.split("[^a-zA-Z]+");
        for (String eachWord: splitWords){
            System.out.println(eachWord);
        }
        Calendar calender = Calendar.getInstance();
    }
}
