public class RollingDice {
    public static void main(String[] args) {
        int x = (int)(6*Math.random()) + 1;
        int y = (int)(6*Math.random()) + 1;
        System.out.printf("\nThe first die comes up %d " +
                "\nThe second die is %d\nThe total is %d", x, y, x+y);


    }
}
