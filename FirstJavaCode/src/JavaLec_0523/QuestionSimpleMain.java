package JavaLec_0523;

import JavaLec_0509.MyInterFace;
import JavaLec_0509.Person;

import java.util.Scanner;

public class QuestionSimpleMain {
    static int correctAnswerCount = 0;

    public static void main(String[] args) {

        String[][] question = {{"주관식", "김민재 소속팀은? ", "나폴리", "5"},
                {"주관식", "이강인 소속팀은? ", "마요르가", "5"},
                {"객관식", "문제의 주제는? ", "1.토트넘, 2.맨유, 3.첼시, 4.아스날", "5", "1"}};

        //Problem q1     // 배열로 변환 가능
        Problem[] qn = new Problem[question.length];

        // 츌제 과정
        make(question, qn);

        // 시험 실시
        start(question, qn);

        // 정답을 출력
        report(question);
    }

    private static void report(String[][] question) {
        double correctRate = (double) QuestionSimpleMain.correctAnswerCount / question.length *100;  // float, double 로 캐스팅 해야한다.
        System.out.println("정답율은 " + correctRate + "% 입니다.");
    }

    private static void start(String[][] question, Problem[] qn) {
        Scanner scan = new Scanner(System.in);
        // 문제지 출력
        for(int i = 0; i < question.length; i++)
        {
            qn[i].showProblem();
            String inputValue = scan.next();
            if(qn[i] instanceof shortProblem) {
                shortProblem sp = (shortProblem) qn[i]; // down casting
                if(sp.correct(inputValue)) {
                    System.out.println("정답입니다.");
                    QuestionSimpleMain.correctAnswerCount++;
                }
                else {
                    System.out.println("오답입니다!!! 정답은 " + sp.problem[1] + " 입니다.");
                }
            } else if (qn[i] instanceof multipleProblem) {
                multipleProblem mp = (multipleProblem) qn[i]; // down casting
                if(mp.correct(inputValue)) {
                    System.out.println("정답입니다.");
                    QuestionSimpleMain.correctAnswerCount++;
                }
                else {
                    System.out.println("오답입니다!!! 정답은 " + mp.correctAnswer() + " 입니다.");
                }
            }

        }
    }

    private static void make(String[][] question, Problem[] qn) {
        for(int i = 0; i < question.length; i++)
        {
            if(question[i][0].equals("주관식"))
            {
                // 객체 배열일때는 new 를 두번 해야함 (생성자 두번)
                qn[i] = new shortProblem(); // qn이라고 하는 Problem에 up casting을 한다
                qn[i].makeProblem(question[i][1], question[i][2], question[i][3]);
            }
            else if(question[i][0].equals("객관식")) {
                qn[i] = new multipleProblem();
                qn[i].makeProblem(question[i][1], question[i][2], question[i][3], question[i][4]);
            }
        }

        // 객체, 문자열이든 모든 변환 시키는 것. 원하는 형태로
        System.out.println(qn[0].toString());   // 오브젝트에 대한 설명이 나온다 = JavaLec_0523.shortProblem@6d311334
        System.out.println(qn[2].toString());   // 오브젝트에 대한 설명이 나온다 = JavaLec_0523.multipleProblem@682a0b20
        System.out.println(Integer.lowestOneBit(10));   // 하위 1비트만 출력한다. 필요할때만 사용.
        System.out.println(Integer.toBinaryString(10));

    }
}
