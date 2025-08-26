package Time.java.src;

public class InsertionSort {
    public static void main(String[] args){
        int[] array = {54,12,23,1,43,22,17,-265,-2,3};
        for (int j : array) {
            System.out.print(" " + j);
        }
        System.out.println();
         insertionSortArray(array);
        for (int j : array) {
            System.out.print(" " + j);
        }
    }

    public static void insertionSortArray(int[] array){
              for(int i= 1; i< array.length-1; i++){
                  int unsorted = array[i];
                  int indexTrack=0;
                  for(int j=i-1; j>=0; j--){
                      indexTrack= j;
                      if (array[j] > unsorted){
                          array[j+1] = array[j];
                          continue;
                      } else {indexTrack = j+1;}
                      break;
                  }
                  array[indexTrack] = unsorted;

              }
    }
}
