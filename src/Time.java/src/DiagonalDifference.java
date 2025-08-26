package Time.java.src;

import java.util.Arrays;
import java.util.List;

public class DiagonalDifference {
    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int sumDiagonal1 = 0;
        int sumDiagonal2 = 0;
        int j =2;
        for(int i = 0; i<arr.size(); i++){
            sumDiagonal1 += arr.get(i).get(i);
            sumDiagonal2 += arr.get(i).get(j);
            j--;
        }
        return Math.abs(sumDiagonal1-sumDiagonal2);
    }

    public static void main(String[] args){
        List<List<Integer>> list2D = Arrays.asList(
                Arrays.asList(11, 2, 4),
                Arrays.asList(4, 5, 6),
                Arrays.asList(10, 8, -12)
        );
                System.out.println(diagonalDifference(list2D));
    }
}
