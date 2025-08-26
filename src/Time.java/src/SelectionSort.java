package Time.java.src;

public class SelectionSort {
    public static void main(String[] args){
        int[] array = {54,12,23,1,43,22,17,-265,-2,3};
        for (int j : array) {
            System.out.print(" " + j);
        }
        System.out.println();
         selectionSortArray(array);
        for (int j : array) {
            System.out.print(" " + j);
        }
    }

    public static void selectionSortArray(int[] array){
       for(int i = 0; i< array.length-1; i++){
           int minIndex = i;
           for(int j=i; j<array.length-1; j++){
               if(array[minIndex] <= Math.min(array[j], array[j+1])){
                   continue;
               }
               if (array[j] <= array[j+1]){
                   minIndex = j;
               } else {
                   minIndex = j+1;
               }
           }
           array[i] = array[i] + array[minIndex];
           array[minIndex] = array[i] - array[minIndex];
           array[i] = array[i] - array[minIndex];
       }
    }

}
