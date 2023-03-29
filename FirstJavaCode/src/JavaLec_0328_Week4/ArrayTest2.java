package JavaLec_0328_Week4;

import java.util.Random;
import java.util.Scanner;

public class ArrayTest2 {
    public static void main(String[] args) {
        char[] randChar = new char[10];

        int aVal = 97;
        System.out.println((char)aVal);

        Random ra = new Random();
        for(int i = 0; i < randChar.length; i++)
        {
            randChar[i] = (char) (ra.nextInt(74) + 48);
        }
        for(int i = 0; i < randChar.length; i++)
        {
            System.out.print(randChar[i]);
        }

        //System.out.println((char) (ra.nextInt(75)+48)); // 75 = 0~74 이고 + 48 을 하게되면 48~122

    }
}
