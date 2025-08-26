
public class PrintAmerican {
    public static void printAmerican(String day, String month, int  date, int year){
        System.out.printf("%s, %s %d, %d\n", day, month, date, year);
    }
    public static  void main(String[] arg){
        printAmerican("Monday", "July", 22, 2019);

    }
}
