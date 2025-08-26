import java.io.PrintStream;
import java.util.Scanner;

public class smallCalculator {
    public static  void main(String[] args){
        double firstNum;
        double secondNum;
        char[] operators = {'+', '-', '*', '/'};
        double result;
        Scanner stdin= new Scanner(System.in);
        while (true){
            //Get 1st input
            System.out.println("Enter your expression using '+' for addition, '-' for subtraction\" +\n" +
                    " '*' for multiplication or / for division or zero to stop calculator: ");
            String expression = stdin.nextLine();
            if (expression.equals("0")) {
                System.out.println("Thank you......bye>>>");
                break;
            }
            for(char operator: operators) {
                int delimiter = expression.indexOf(operator);
                if (delimiter == -1) continue;
                extractAndEvaluate(expression, delimiter);
                break;
            }
//            int delimeter = expression.indexOf('+');
//            if (delimeter == -1){
//                delimeter = expression.indexOf("-");
//                if(delimeter == -1){
//                    delimeter = expression.indexOf("*");
//                    if(delimeter == -1) {
//                        delimeter = expression.indexOf("/");
//                        if (delimeter == -1) {
//                            System.out.println("Enter a valid expression");
//                        } else {
//                            extractAndEvaluate(expression, delimeter);
//                        }
//                    } else {
//                        extractAndEvaluate(expression, delimeter);
//                    }
//                } else {
//                    extractAndEvaluate(expression, delimeter);
//                }
//            } else {
//                extractAndEvaluate(expression, delimeter);
//            }
           /* System.out.println( ");
            op = stdin.next().charAt(0); // read 1st character
                System.out.println("Enter second number: ");
                secondNum = stdin.nextDouble();
                switch (op) {
                    case ('+') : {
                        result = firstNum + secondNum;
                        System.out.printf("%f + %f = %f", firstNum, secondNum, result);
                        System.out.println();
                        //break;
                    }
                    case ('-'):  {
                        result = firstNum - secondNum;
                        System.out.printf("%f -  %f = %f", firstNum, secondNum, result);
                        System.out.println();
                        break;
                    }
                    case ('*'): {
                        result = firstNum * secondNum;
                        System.out.printf("%f x  %f = %f", firstNum, secondNum, result);
                        System.out.println();
                        break;
                    }
                    case ('/'): {
                        result = firstNum / secondNum;
                        System.out.printf("%f /  %f = %f", firstNum, secondNum, result);
                        System.out.println();
                        break;
                    }
                    default:
                        System.out.println("You did not enter a valid operator");
                        System.out.println();
                        break;
                }
*/
        }
        stdin.close();
    }
    static void extractAndEvaluate(String expression, int delimeter) {
        double secondNum;
        double result = 0;
        double firstNum;
        char operator;
        String firstNumString = expression.substring(0, delimeter);
        String secondNumString = expression.substring(delimeter + 1);
        try {
            firstNum = Double.parseDouble(firstNumString);
            secondNum = Double.parseDouble(secondNumString);
            operator = expression.charAt(delimeter);
            switch (operator) {
                case '+' -> {
                    result = firstNum + secondNum;
                    getPrintf(expression, result);
                }
                case '-' -> {
                    result = firstNum - secondNum;
                    getPrintf(expression, result);
                }
                case '*' -> {
                    result = firstNum * secondNum;
                    getPrintf(expression, result);
                }
                case '/' -> {
                    if (secondNum == 0) {
                        System.out.println("Cannot divide by zero");
                        break;
                    } else {result = firstNum / secondNum;
                        getPrintf(expression, result);
                    }

                }
                default -> System.out.println("You did not enter a valid operator");
            }

        } catch (NumberFormatException e) {
            System.out.println("Error: Cannot find vaild numbers.");
        }
    }

    private static PrintStream getPrintf(String expression, double result) {
        return System.out.printf("%s = %f\n", expression, result);
    }
}
