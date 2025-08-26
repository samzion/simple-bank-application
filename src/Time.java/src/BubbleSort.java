package Time.java.src;

public class BubbleSort {
    public static void main(String[] args){
        int[] array = {54,12,23,1,43,22,17,-265,-2,3};
        for (int j : array) {
            System.out.print(" " + j);
        }
        System.out.println();
         bubbleSortArray(array);
        for (int j : array) {
            System.out.print(" " + j);
        }
    }

    public static void bubbleSortArray(int[] array){
        for (int i=0; i<array.length-1; i++){
            for(int j=0; j<array.length-i-1; j++){
                if (array[j] > array[j+1]){
                    array[j] = array[j] + array[j+1];
                    array[j+1] = array[j] - array[j+1];
                    array[j] = array[j] - array[j+1];
                }
            }
        }
    }
}
