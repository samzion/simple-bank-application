public class ThinkJavaEx63 {
    /***
     * One way to evaluate exp(−x
     * 2
     * ) is to use the infinite series
     * expansion:
     * exp(−x2) = 1 − x^2 + x^4/2 − x^6/6 + . . .
     * The ith term in this series is (−1)ix
     * 2i/i!. Write a method named gauss that
     */
    public static void main(String[] args){
        int x=2, n=2;
        System.out.println(gauss(x,n));
    }
    public static long gauss( int x, int n){
        long sumOfFirstNTerms = 0;
        for (int i = 0; i<n; i++){
            sumOfFirstNTerms = sumOfFirstNTerms + (power(-1,i)*power(x,2*i))/factorial(i);
        }

        return sumOfFirstNTerms;
    }
    public static long power (int a, int b){
        long result = 1;
        if (b==0) {
            result = 1;
        } else {
            for (int i=1; i <= b; i++ ){
                result *= a;
            }
        }
        return result;
    }
    public static long factorial (int b) {
        long result = 1;
        if (b==0) {
        } else {
            for (int i=1; i <= b; i++ ){
                result *= i;
            }
        }
        return result;
    }
}
