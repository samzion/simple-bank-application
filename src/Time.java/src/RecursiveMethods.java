package Time.java.src;

public class RecursiveMethods {
    static int count = 0;
    public static void main (String[] args){
        int n = 3;
        System.out.println(factorial(n));
    }
    public static long factorial(int n) {
        long result;
        if ( n == 0 || n ==1){
            return 1;
        }
        return result = n* factorial(n-1);
    }
}
