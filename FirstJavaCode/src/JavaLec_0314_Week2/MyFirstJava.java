package JavaLec_0314_Week2;

public class MyFirstJava {

    private static int c;   // 타입 선언

    public static void main(String[] args)
    {
        short aShort;

        int a = 10;
        int A = 10;
        int b = 20;
        int sum = 0;
        int result = 0;
        int result1 = 0;

        long along;

        float f = 2.5f;
        double d = 2.5;
        char ch = 'c';

        String st = "홍길동!!!";

        c = 20;

        System.out.println("choi moo sung!!!");
        System.out.println(st);
        System.out.print(st);
        System.out.print(a);

        add(a, b);  // 함수 ---->> 메소드...!!!
        sum = addNew(a,b);

        result = multi(a,b);
        printResult(result);

        result = sub(a,b);
        printResult(result);

        System.out.println(sum);
    }

    private static void printResult(int result) {
        System.out.println("결과값" + result + "입니다.");
    }

    private static int sub(int a, int b) {
        return a-b;
    }

    private static int multi(int a, int b) {
        return a*b;
    }

    public static int addNew(int x, int y)
    {
        return x+y;
    }

    public static void add(int x, int y)
    {
        System.out.println(x+y);
    }
}
