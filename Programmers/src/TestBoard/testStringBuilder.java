package TestBoard;
import java.lang.StringBuilder;
import java.util.Scanner;

public class testStringBuilder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[6];
        int query[] = new int[3];
        for(int i = 0; i < arr.length; i++)
        {
            System.out.println("arr 입력 : ");
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i < query.length; i++) {
            System.out.println("query 입력 : ");
            query[i] = sc.nextInt();
        }


//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("문자열").append("연결");
//        String str = stringBuilder.toString();
//        System.out.println(stringBuilder);
//        System.out.println(str);
    }

}
