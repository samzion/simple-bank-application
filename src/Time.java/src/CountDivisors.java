public class CountDivisors {
    /* From Javanotes: Which integer between 1 and 1000
    has the largest number of divisors and how many divisors
    does it have?
     */
    public static void main(String[] args) {
        int[] countDivisor = new int[10001];  // Index 1 to 10000
        int maxDivisors = 0;
        int numberWithMax = 0;

        for (int i = 1; i <= 10000; i++) {

            int count = getDivisorCount(i);
            countDivisor[i] = count;

            if (count > maxDivisors) {
                maxDivisors = count;
                numberWithMax = i;
            }
        }

        // Print result
        System.out.println("Number with most divisors between 1 and 10000: " + numberWithMax);
        System.out.println("It has " + maxDivisors + " divisors.");
    }

    private static int getDivisorCount(int i) {
        int count = 0;
        for (int j = 1; j <= i; j++) {
            if (i % j == 0) {
                count++;
            }
        }
        return count;
    }
}
