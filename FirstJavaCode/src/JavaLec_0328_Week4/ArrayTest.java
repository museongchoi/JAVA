package JavaLec_0328_Week4;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayTest {
    public static void main(String[] args) {
        // Math 라이브러리 사용
        // ads : 절대값
        // random : 0~0.99999999 사이의 값을 넘겨주는

        Scanner sc = new Scanner(System.in);
        System.out.println("생성하고자 하는 배열 크기 입력 : ");
        int size = sc.nextInt();    // next로 받으면 문자열을 말함

        int arraySIZE = size;
        //double[] randArray = new double[arraySIZE];
        int[] randArray = new int[arraySIZE];

        MakeArray(randArray);   // 난수 배열 생성
        printArray(randArray);  // 배열 출력

        System.out.println();   // 줄바꿈

        // 중복 제거, ArrayList 의 타입은 randArray와 같은 타입인 Integer를 <> 안에 맞춰준다.
        ArrayList<Integer> aList = new ArrayList<Integer>();
        // randArray 안에 있는 값을 가져와서 aList 안에 없으면 값을 aList 안에 넣는다
        for (int value : randArray) {
            //if(!aList.contains(value))
            //{
            aList.add(value);   // 조건이 없어지면 중복 값도 다 들어간다
            //}
        }

        aList.sort(null);
        for (int value : aList) {
            System.out.print(value + " ");
        }

        System.out.println("\nMin :" + aList.get(0));
        System.out.println("Max :" + aList.get(aList.size() - 1));
    }

    private static void printArray(int[] randArray) {
        for (int i = 0; i < randArray.length; i++) {
            System.out.print(randArray[i] + " ");
        }
    }

    private static void MakeArray(int[] randArray) {
        for (int i = 0; i < randArray.length; i++) {
            randArray[i] = (int) (Math.random() * 45 + 1);  // *10을 하여 랜덤된 복권 번호를 추출, 강제 형변환(곱하기만 해주면 그대로 8byte이기 떄문), +1은 10까지 나오게 하기 위함.
            for (int j = 0; j < i; j++) {
                if (randArray[j] == randArray[i]) {
                    i=i;
                    break;
                }
            }
        }
    }
}
