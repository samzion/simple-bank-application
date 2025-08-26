public class NumOfRollsBeforeSnakeEyes {
    public  static  void main (String[] args){
        //This program computes the number of rolls made before snake eyes come up
        // i.e. when the two dice both show a value of 1
        int die1;
        int die2;
        int numRoll = 0;
        while (true) {
            die1 = (int) (Math.random() * 6) + 1;
            die2 = (int) (Math.random() * 6) + 1;
            numRoll++;
            if (die1 == 1 && die2 == 1) {
                System.out.println("The number of rolls made before snake" +
                        " eyes showed up is " + numRoll);
                break;
            }
        }
    }
}
