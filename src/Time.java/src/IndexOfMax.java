import java.util.Scanner;

public class IndexOfMax {
    public static int indexOfMAx(int[] arrayOfIntegers){
        int max = 0;
        int indexMaxInteger = 0;
        for (int i=0; i<arrayOfIntegers.length; i++){
            if (max < arrayOfIntegers[i]){
                max = arrayOfIntegers[i];
                indexMaxInteger = i;
            }
        }
        return indexMaxInteger;
    }

    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        int[] arrayOfIntegers = new int[5];
        for(int i= 0; i<5; i++){
            arrayOfIntegers[i] = in.nextInt();
        }
        System.out.printf("The index of the maximum integer is: %d", indexOfMAx(arrayOfIntegers));
    }
}
