package Time.java.src;

import java.awt.desktop.SystemEventListener;

public class SwapVariableTest {

    public static void main(String[] args){
        int a = 5;
        int b = 3;
        a = a+b;
        b = a - b;
        a = a - b;
        System.out.printf("a = %d, b = %d", a, b);
        int temp = a;
        a = b;
        b= temp;
        System.out.printf("\n a = %d, b = %d", a, b);
    }
}
