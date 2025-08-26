//import necessary library
import java.util.Scanner;
        //Program to convert temperature from Fahrenheit to Celcius
public class TemperatureConverter {
    public static  void main(String[] arg){
        //Declaration of variables
        double tempCelcius, tempFahrenheit;
        Scanner stdin = new Scanner(System.in);
        System.out.print("Enter a temperature in Celcius: ");
        tempCelcius = stdin.nextDouble();
        tempFahrenheit = (tempCelcius * 9.0/5.0) + 32;
        stdin.close();
        System.out.printf("%.1f C = %.1f F\n", tempCelcius, tempFahrenheit);

    }

}
