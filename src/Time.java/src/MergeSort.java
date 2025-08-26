package Time.java.src;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static void main(String[] args){
        int[] array = {54,12,23,1,43,22,17,-265,-2,3};

        for (int j : array) {
            System.out.print(" " + j);
        }
        System.out.println();
        mergeSortArray(array, 0, array.length-1);
        for (int j : array) {
            System.out.print(" " + j);
        }
    }

    public static void mergeSortArray(int[] array, int headIndex, int tailIndex){
        if (tailIndex > headIndex){
            int midIndex = (tailIndex + headIndex) /2;
            mergeSortArray(array, headIndex, midIndex );
            mergeSortArray(array, midIndex+1, tailIndex );
            merge(array, headIndex, midIndex, tailIndex);
        }
    }

    static void merge(int[] array, int headIndex, int midIndex, int tailIndex){
        int sizeOfLeftArray = midIndex - headIndex +1;
        int sizeOfRightArray = tailIndex - midIndex;

        int[] leftArray = new int[sizeOfLeftArray];
        int[] rightArray = new int[sizeOfRightArray];

        for(int i = 0; i<sizeOfLeftArray; ++i){
            leftArray[i] = array[headIndex+i];
        }

        for(int j = 0; j<sizeOfRightArray; ++j){
            rightArray[j] = array[midIndex+1+j];
        }

        int i=0;
        int j=0;
        int k=headIndex;
        while (i<sizeOfLeftArray && j<sizeOfRightArray){
            if(leftArray[i]<=rightArray[j]){
                array[k]=leftArray[i];
                i++;
                k++;
            } else {
                    array[k]=rightArray[j];
                    j++;
                    k++;
            }
        }

        while(i<sizeOfLeftArray){
            array[k]  = leftArray[i];
            i++;
            k++;
        }

        while(j<sizeOfRightArray){
            array[k]  = rightArray[j];
            j++;
            k++;
        }


    }
}
//Merge Sort Algorithm
//MergeSort(array, headIndex, tailIndex)

//If tailIndex > headIndex:
//
//Set midIndex = (headIndex + tailIndex) / 2
//
//Recursively call MergeSort(array, headIndex, midIndex)
//
//Recursively call MergeSort(array, midIndex + 1, tailIndex)
//
//Call Merge(array, headIndex, midIndex, tailIndex)

//
//Algorithm: Merge(array, headIndex, midIndex, tailIndex)
//Let sizeOfLeftArray = midIndex - headIndex + 1
//
//Let sizeOfRightArray = tailIndex - midIndex
//
//Create temporary arrays:
//
//leftArray[sizeOfLeftArray]
//
//rightArray[sizeOfRightArray]
//
//Copy data into temporary arrays:
//
//For i = 0 to sizeOfLeftArray - 1:
//
//leftArray[i] = array[headIndex + i]
//
//For j = 0 to sizeOfRightArray - 1:
//
//rightArray[j] = array[midIndex + 1 + j]
//
//Initialize indexes:
//
//i = 0 (index for leftArray)
//
//j = 0 (index for rightArray)
//
//k = headIndex (index for main array)
//
//While i < sizeOfLeftArray and j < sizeOfRightArray:
//
//If leftArray[i] <= rightArray[j]:
//
//array[k] = leftArray[i]
//
//Increment i
//
//Else:
//
//array[k] = rightArray[j]
//
//Increment j
//
//Increment k
//
//Copy any remaining elements from leftArray:
//
//While i < sizeOfLeftArray:
//
//array[k] = leftArray[i]
//
//Increment i and k
//
//Copy any remaining elements from rightArray:
//
//While j < sizeOfRightArray:
//
//array[k] = rightArray[j]
//
//Increment j and k
//
//🧠 Explanation in Simple Terms
//Break the array into halves until each piece has one element.
//
//Merge pieces back together in sorted order using temporary arrays.
//
//Each merge step ensures the combined array is sorted.