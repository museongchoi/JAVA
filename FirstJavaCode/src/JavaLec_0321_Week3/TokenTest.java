package JavaLec_0321_Week3;

import java.util.Scanner;
import java.util.StringTokenizer;

public class TokenTest {
    public static void main(String[] args){

        // Lab 1
        //String data = "100, 200, 300, 400, 500";
        //StringTokenizer st = new StringTokenizer(data,","); // data를 입력을 주고 ',' 로 구분

        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        StringTokenizer st = new StringTokenizer(data,","); // data를 입력을 주고 ',' 로 구분

        while (st.hasMoreTokens())
        {
            System.out.println(st.nextToken());
        }


        // Lab 2

        String data1 = "100,200,,,300";
        System.out.println("Scanner.useDelimiter()...");
        Scanner sc1 = new Scanner(data1).useDelimiter(",");

        while(sc1.hasNext())
        {
            System.out.println(sc1.next());
        }


        // Lab 3

        String data2 = "100,200,300,400,500";

        System.out.println("String.split()...");
        String[] token = new String(data2).split(",");  // 배열 Token = [100, 200, 300 ...] 으로 들어감.

        for(String s : token) // token 배열 안에 있는 값을 하나씩 s에다 전달
        {
            System.out.println(s);
        }
    }
}
