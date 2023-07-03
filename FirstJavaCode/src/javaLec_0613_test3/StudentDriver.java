package javaLec_0613_test3;

import java.util.Scanner;

public class StudentDriver {
    public static void main(String[] args)
    {
        Student[] roster;
        Scanner scan = new Scanner(System.in);
        final int maxnumber = 20;
        String flag = "예";
        int number = 0;
        String name;
        int score;
        int level;

        roster = new Student[maxnumber];
        do {
            System.out.print("학생의 수준을 입력하세요 (학부생=1, 대학원생=2): ");
            level = scan.nextInt();
            System.out.print("학생의 이름을 입력하세요: ");
            name = scan.next();

            if(level == 1)
            {
                roster[number] = new UnderStudent(name);
            }else {
                roster[number] = new GradStudent(name);
            }

            System.out.print("학생의 점수를 입력하세요: ");
            score = scan.nextInt();

            roster[number].setScore(score);
            roster[number].computeGrade();
            number++;

            System.out.print("처리할 학생들이 더 있습니까?(예 혹은 아니오): ");
            flag = scan.next();



        }while (flag.equals("예") && number < maxnumber);

        System.out.println("\n\t학생 성적\n");
        System.out.println("소속\t 이름\t점수\t학점");

        for(int i = 0; i < number; i++){
            if(roster[i] instanceof UnderStudent){
                System.out.println((UnderStudent) roster[i]);
            } else {
                System.out.println((GradStudent) roster[i]);
            }
        }
    }
}
