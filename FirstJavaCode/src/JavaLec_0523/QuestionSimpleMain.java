package JavaLec_0523;

import JavaLec_0509.MyInterFace;
import JavaLec_0509.Person;

import java.util.Scanner;

public class QuestionSimpleMain {
    static int correctAnswerCount = 0;

    public static void main(String[] args) {

        String[][] question = { {"김민재 소속팀은? ", "나폴리", "3"}, {"이강인 소속팀은? ", "마요르가", "4"} };

        // question 문자열 배열만 추가하면 자동적으로 아래 부분의 수정없이 동작

        Problem q1, q2;     // 배열로 변환 가능
        //Problem[] qn = new Problem[question.length];

        q1 = new Problem();
        q1.makeProblem(question[0][0], question[0][1], question[0][2]);

        Scanner scan = new Scanner(System.in);
        q1.showProblem();
        String inputValue = scan.next();
        if(q1.correct(inputValue)) {
            System.out.println("정답입니다.");
            QuestionSimpleMain.correctAnswerCount++;    // 정답 cnt
        }
        else {
            System.out.println("오답입니다. 정답은 " + q1.problem[1] + "입니다.");
        }
    }
}
