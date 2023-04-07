package JavaLec_0314_Week2;

import java.util.Scanner;

public class InPutOutPut
{
    public static void main(String[] args)
    {
        //학번 이름 나이

        String nb;
        String name;
        int age;

        Scanner sc = new Scanner(System.in);    // new 새로운 객체 생성

        System.out.println("학번을 입력하세요: ");
        nb = sc.nextLine();
        System.out.println("입력 결과는: " + nb);

        //name = sc.next();
        System.out.println("이름을 입력하세요: ");
        name = sc.nextLine();
        System.out.println("입력 결과는: " + name);

        System.out.println("나이를 입력하세요: ");
        age = sc.nextInt();
        System.out.println("입력 결과는: " + age);


//        System.out.println("학번 이름 나이를 입력하세요: ");
//        nb = sc.nextLine();
//        name = sc.nextLine();
//        age = sc.nextInt();
//
//        System.out.println("입력 결과" + "\n" + "학번: " + nb + "\n" + "이름: " + name + "\n" + "나이: " + age);
    }
}
