package JavaLec_0321_Week3;

import java.util.Scanner;

public class CalcGradeCode {
    public static void main(String[] args){
        char grade;
        int score;
        int sum = 0;
        int count = 0;
        int countA = 0, countB = 0, countC = 0, countF = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("성적을입력하세요(종료 -1) :");

        while (sc.hasNext())    // 입력 받은 것을 토큰, 하나씩 잘라서 가져온다. hasNext 는 계속 값을 받을 수 있는.
        {
            score = sc.nextInt();
            if(score == -1)
            {
                break;
            }
            if(score >= 90)
            {
                grade = 'A';
                countA++;
            }
            else if(score >= 80)
            {
                grade = 'B';
                countB++;
            }
            else if(score >= 70)
            {
                grade = 'C';
                countC++;
            }
            else
            {
                grade = 'F';
                countF++;
            }
            count++;
            sum += score;
            System.out.println("합점 :" + grade + "입니다.");
        }
        //double ss = (int)sum/count;
        //System.out.println("평균 :" + ss + "입니다");
        System.out.println("평균 :" + (double)sum/count + "입니다"); // sum만 형변환 in -> double
        System.out.println("Thanks...");
    }
}
