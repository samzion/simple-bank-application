package date.src;

public class Date5 {
    public static void main(String[] args) {
        System.out.print("Hello!\nHow are you doing?\n");
        String day = "Wednesday";
        String date = "18";
        String month = "June";
        String year = "2025";
        System.out.print("Today's date is ");
        System.out.print(day);
        System.out.print(date);
        System.out.print(month);
        System.out.println(year);
        System.out.println(" ");

        // modifying the display format
        System.out.print("Today's date is ");
        System.out.print(day + ",");
        System.out.print(" " + month);
        System.out.print(" " + date + ",");
        System.out.println(" " + year);
        System.out.println(" ");

        // displaying in European and American format
        System.out.println("Today's date is: ");
        System.out.print("American format: ");
        System.out.print(day + ",");
        System.out.print(" " + month);
        System.out.print(" " + date + ",");
        System.out.println(" " + year);
        System.out.print("European format: ");
        System.out.print(day);
        System.out.print(" " + date);
        System.out.print(" " + month);
        System.out.println(" " + year);
    }

}

