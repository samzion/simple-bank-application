package Time.java.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class binarySearch {
    //get an array dataStructure and get the item to search
   // List<Integer> arrayList =  new ArrayList<>();

    public static void main ( String[] args){
        List<Integer> arrayList =  new ArrayList<>();
        arrayList.add(12);
        arrayList.add(16);
        arrayList.add(19);
        arrayList.add(60);
        arrayList.add(100);
        arrayList.add(110);
        arrayList.add(230);
        arrayList.add(260);
        arrayList.add(1000);
        System.out.println(searchItemIndex(arrayList, 5000));
    }

    // define a method to search that will take in this two parameters
    public static boolean searchItemRecursion(List<Integer> arrayList, int item) {
        if (arrayList.isEmpty()) {
            return false;
        }

        int size = arrayList.size();


        if (size == 1) {
            return arrayList.get(0) == item;
        }

        int head = arrayList.get(0);
        int tail = arrayList.get(size - 1);
        if (item < head || item > tail) {
            return false;
        }

        // Split the list
        int midIndex = size / 2;
        int midValue = arrayList.get(midIndex);

        if (midValue == item) {
            return true;
        } else if (item < midValue) {
            return searchItemRecursion(arrayList.subList(0, midIndex), item);
        } else {
            return searchItemRecursion(arrayList.subList(midIndex + 1, size), item);
        }
    }

    public static int searchItemIndex(List<Integer> arrayList, int item ){
        int headIndex = 0;
        int tailIndex = arrayList.size()-1;

        while (headIndex <= tailIndex){
            int midIndex = (headIndex + tailIndex)/2;
            if(item == arrayList.get(midIndex)) {
                return midIndex;
            }
            if (item < arrayList.get(midIndex)){
                tailIndex = midIndex-1;
            } else{
                headIndex = midIndex +1;
            }
        }
        return -1;
    }

}
        // 1.since array is sorted get the size of array
        // 2. head of array equals first index 0, tail of array equals size of array-1
        // 3. is item greater or equal to item at head or less or equal to item at tail
                //4. if NO return false i.e. item is not in array
                //5. else YES divide array size into two using
                    //6. first array is between 0 and rounddown size/2 and 2nd array is between size/2 + 1 and size-1
                    //7. on first array is item to search greater or equal to head or less or equal to tail
                        //8. if yes tracking head and tail equals to head and tail of this particular array. Note the other array is discarded
                        //9. else check if on second array is item to search greater or equal to head or less or equal to tail
                            //tracking head and tail is on this array
                            //Yes? repeat 5. until size of array = 1 and item is @ head = tail Then return true

                        //10. else return false.




