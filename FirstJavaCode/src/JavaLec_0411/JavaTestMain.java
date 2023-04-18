package JavaLec_0411;

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class JavaTestMain {
    public static void main(String[] args) {
//        Animal horse = new Animal();
//
//        Student choi_M_S = new Student();
//        choi_M_S.setName("최무성");
//        choi_M_S.setIdNum("201958142");
//        choi_M_S.setDept("컴퓨터공학부");
//        choi_M_S.setKor(90);
//        choi_M_S.setEng(90);
//        choi_M_S.setMath(90);
//
//        Student song_Y_M = new Student("송유민", "202212121", "컴퓨터공학부");
//
//        song_Y_M.setScore(80, 90, 90); // kor, eng, math
//
//        double avg = song_Y_M.averageScore();
//        System.out.println("평균 점수 : " + avg);
//
//        song_Y_M.printGrade();
//
//        Rectangle1 myRect = new Rectangle1();     // 직사각형
//
//        myRect.width = 10;
//        myRect.height = 20;
//
//        //myRect.getArea();
//
//        myRect.display();
//
//        Rect_3D myBox = new Rect_3D();
//
//        myBox.height = 10;
//        myBox.width = 5;
//        myBox.lenght = 3;
//
//        System.out.println("부피 : " + myBox.getVolum());


        // 예금주, 계좌번호, 잔액, 패스워드, 연락처
        KakaoBank hongKakao = new KakaoBank("홍길동", "3330-123-4567", 10, "1234");

        KakaoBank leeKakao = new KakaoBank("이순신", "3330-321-7554", 10, "4321");

        KakaoBank choiKakao = new KakaoBank("최무웅", "3331-122-8888" ,10, "5678");

        // 입금/출금 메소드
        hongKakao.deposit(100); // 입금
        hongKakao.showAccount();    // 계좌 상태 출력 메소드
        hongKakao.withdraw(50); // 출금
        hongKakao.showAccount();    // 계좌 상태 출력 메소드
        leeKakao.showAccount(); // 계좌 상태 출력 메소드

        // 송금 메소드 이용
        hongKakao.transfer(leeKakao, 20);   // hongKakao --> 20 --> leeKakao
        hongKakao.showAccount();    // 계좌 상태 출력 메소드
        leeKakao.showAccount();     // 계좌 상태 출력 메소드

        transfer2(hongKakao, leeKakao, 20); // hongKakao --> 20 --> leeKakao
        hongKakao.showAccount();    // 계좌 상태 출력 메소드
        leeKakao.showAccount();     // 계좌 상태 출력 메소드

        hongKakao.transfer(leeKakao, 30);
        transfer2(choiKakao, leeKakao, 50);
    }


    private static void transfer2(KakaoBank sender, KakaoBank holder, int i) {
        sender.withdraw(i);
//        if((sender.balance - i) >= 0)
//        {
//            sender.setBalance(sender.getBalance() - i);
//        } else {
//            System.out.println("잔액이 부족합니다");
//        }
        holder.deposit(i);
    }
}
